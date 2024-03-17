package com.github.xavierdpt.xddbg.bytecode;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.code.Instruction;
import com.github.xavierdpt.jvmspect.input.attributes.code.OpCode;
import com.github.xavierdpt.xddbg.InstructionsWithResolver;
import com.github.xavierdpt.xddbg.XDDBG;
import com.github.xavierdpt.xddbg.utils.SwingHelper;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.util.List;

public class XBytecode extends JPanel {

    public static final String PLACEHOLDER = "---";
    private final XDDBG app;
    private final JTextArea textfield;

    public XBytecode(XDDBG app) {
        super(new BorderLayout());
        this.app = app;
        textfield = new JTextArea(PLACEHOLDER);
        add(SwingHelper.createScrollPane(textfield), BorderLayout.CENTER);
    }

    public void show(InstructionsWithResolver iwr) {
        if (iwr == null) {
            textfield.setText(PLACEHOLDER);
        } else {
            ConstantResolver constantResolver = iwr.getConstantResolver();
            StringBuilder sb = new StringBuilder();
            for (Instruction instruction : iwr.getInstructions()) {
                int codeIndex = instruction.getCodeIndex();
                OpCode opCode = instruction.getOpCode();
                String textDetails = instruction.textDetails(constantResolver);
                if (textDetails == null || "".equals(textDetails)) {
                    sb.append(codeIndex).append("\t").append(opCode.name()).append("\n");
                } else {
                    sb.append(codeIndex).append("\t").append(opCode.name()).append("\t").append(textDetails).append("\n");
                }
            }
            textfield.setText(sb.toString());
        }
    }
}
