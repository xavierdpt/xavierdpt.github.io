package com.github.xavierdpt.xddbg.bytecode;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.code.Instruction;
import com.github.xavierdpt.xddbg.InstructionsWithResolver;
import com.github.xavierdpt.xddbg.XDDBG;
import com.github.xavierdpt.xddbg.utils.SwingHelper;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Arrays;
import java.util.Optional;

public class XBytecode extends JPanel {

    public static final String[] COLUMNS = {"Code Index", "Line number", "OpCode", "Details"};
    private final XDDBG app;
    private final JTable table;

    public XBytecode(XDDBG app) {
        super(new BorderLayout());
        this.app = app;
        DefaultTableModel model = new DefaultTableModel();
        Arrays.stream(COLUMNS).forEach(model::addColumn);
        table = new JTable(model);
        table.setShowGrid(false);
        table.setFillsViewportHeight(true);
        add(SwingHelper.inScrollPane(table), BorderLayout.CENTER);
    }

    public void show(InstructionsWithResolver iwr) {
        DefaultTableModel newModel = new DefaultTableModel();
        Arrays.stream(COLUMNS).forEach(newModel::addColumn);
        ConstantResolver constantResolver = iwr.getConstantResolver();
        for (Instruction instruction : iwr.getInstructions()) {
            int codeIndex = instruction.getCodeIndex();
            String opCode = instruction.getOpCode().name();
            String lineNumber = Optional.ofNullable(iwr.getLineNumber(codeIndex)).map(String::valueOf).orElse("-");
            String textDetails = Optional.ofNullable(instruction.textDetails(constantResolver)).orElse("");
            newModel.addRow(new Object[]{codeIndex, lineNumber, opCode, textDetails});
        }
        table.setModel(newModel);
        int columnCount = table.getColumnCount();
        for (int column = 0; column < columnCount; column++) {
            if (column == columnCount - 1) {
                continue;
            }
            int width = 0;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component component = table.prepareRenderer(renderer, row, column);
                width = Math.max(width, component.getPreferredSize().width);
            }
            table.getColumnModel().getColumn(column).setPreferredWidth(width);
        }
    }
}
