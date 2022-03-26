package xd.mm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class M {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Xavier\\metamath\\set.mm\\set.mm";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader reader = new BufferedReader(isr);
        String line = null;
        boolean inComment = false;
        boolean readingConstant = true;
        int limit = 1000;
        Set<String> constants = new HashSet<>();
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, " \t");
            while (tokenizer.hasMoreElements()) {
                String token = (String) tokenizer.nextElement();
                if ("$(".equals(token)) {
                    inComment = true;
                } else if ("$)".equals(token)) {
                    inComment = false;
                } else {
                    if (inComment) {
                        continue;
                    } else {
                        if("$c".equals(token)) {
                            readingConstant=true;
                        } else if("$.".equals(token)) {
                            readingConstant=false;
                        } else {
                            if(readingConstant) {
//                                System.out.println("Constant : "+token);
                                constants.add(token);
                            } else {
                                --limit;
                                if(limit>0) {
                                    System.out.println(token);
                                }
                            }
                        }
                    }
                }
            }
        }
//        System.out.println("Found "+constants.size()+" constants");
    }
}
