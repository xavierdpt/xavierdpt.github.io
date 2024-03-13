package xd.jvmspect.steps;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.basex.BaseXServer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xd.jvmspect.JSON;
import xd.jvmspect.XConstants;
import xd.jvmspect.basex.BaseXHelper;
import xd.jvmspect.basex.BaseXSession;
import xd.jvmspect.xml.XML;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Step4QueryOpcodeStats {

    public static void main(String[] args) throws IOException, InterruptedException, TransformerException {
        try (BaseXSession baseXSession = BaseXHelper.startServer()) {
            BaseXServer server = baseXSession.server();
            String port = baseXSession.port();
            File tmpDir = baseXSession.tmpDir();
            String databaseName = "javaxml";
            if (!BaseXHelper.databaseExists(server, databaseName)) {
                throw new IllegalStateException("Create javaxml database first");
            }
            doInBaseXSession(port, tmpDir, databaseName);
        }
    }

    private static void doInBaseXSession(String port, File tmpDir, String databaseName) throws IOException {
        String opCodeStatQuery = """
                <result>{
                for $node in //instructions/*
                let $name := node-name($node)
                group by $name
                order by count($node)
                return <stat name="{$name}" count="{count($node)}"/>
                }</result>""";
        ArrayNode[] jsonHolder = new ArrayNode[1];
        BaseXHelper.runQuery(port, tmpDir, databaseName, pw -> pw.println(opCodeStatQuery), fileReader -> {
            try {
                Document document = XML.readDocument(fileReader);
                NodeList childNodes = document.getDocumentElement().getChildNodes();
                ArrayNode jsonData = JSON.createArrayNode();
                for (int idx = 0; idx < childNodes.getLength(); idx++) {
                    Element item = (Element) childNodes.item(idx);
                    String name = item.getAttribute("name");
                    long count = Long.parseLong(item.getAttribute("count"));
                    ObjectNode jsonDatum = JSON.createObjectNode();
                    jsonDatum.put("name", name);
                    jsonDatum.put("value", count);
                    jsonData.add(jsonDatum);
                }
                jsonHolder[0] = jsonData;
            } catch (IOException | SAXException e) {
                throw new RuntimeException(e);
            }
        });
        generateGraph(jsonHolder[0]);
    }

    private static void generateGraph(ArrayNode jsonData) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(XConstants.PUBLISHED_DIR, "opcodeStats.html")))) {
            String strData = JSON.toString(jsonData);
            pw.print("""
                    <!DOCTYPE html>
                    <html>
                        <head>
                            <title>OpCode Stats</title>
                            <script src="https://cdnjs.cloudflare.com/ajax/libs/echarts/5.5.0/echarts.min.js" integrity="sha512-k37wQcV4v2h6jgYf5IUz1MoSKPpDs630XGSmCaCCOXxy2awgAWKHGZWr9nMyGgk3IOxA1NxdkN8r1JHgkUtMoQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
                        </head>
                        <body>
                            <div id="root" style="height:100dvh; width:100dvw;"></div>
                            <script type="application/javascript">
                                var myChart = echarts.init(document.getElementById('root'));
                                var option = {
                                    series: [ { type: 'treemap', data:""" + strData + "}]" + """
                                };
                                myChart.setOption(option);
                            </script>
                        </body>
                    </html>""");
        }
    }

}
