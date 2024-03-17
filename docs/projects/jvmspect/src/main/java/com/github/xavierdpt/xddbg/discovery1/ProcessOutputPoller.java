package com.github.xavierdpt.xddbg.discovery1;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProcessOutputPoller extends JFrame {
    private volatile boolean closing;

    List<Thread> threads = new ArrayList<>();

    public ProcessOutputPoller(Process process) throws HeadlessException {
        setTitle("XDDBG Process Output Poller");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel rootPanel = new JPanel(new GridLayout(2, 1));
        rootPanel.setBorder(BorderFactory.createTitledBorder("WTF"));
        add(rootPanel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setClosing();
            }
        });
        initTextArea(rootPanel, "STDOUT", process.getInputStream());
        initTextArea(rootPanel, "STDERR", process.getErrorStream());
        pack();
        setLocation(10, 10);
        threads.forEach(Thread::start);
    }

    private void setClosing() {
        closing = true;
    }

    private void initTextArea(JPanel rootPanel, String stdout, InputStream inputStream) {
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBorder(BorderFactory.createTitledBorder(stdout));
        JTextArea textArea = new JTextArea(15, 80);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        titlePanel.add(scrollPane, BorderLayout.CENTER);
        rootPanel.add(titlePanel);
        Thread thread = new Thread(() -> {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (closing) {
                        continue;
                    }
                    textArea.append(line + "\n");
                }
            } catch (IOException e) {
                TitledBorder border = (TitledBorder) titlePanel.getBorder();
                border.setTitle(border.getTitle() + ": " + e.getClass().getSimpleName());
            }
        });
        threads.add(thread);

    }

    public static void poll(Process process) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(() -> {
            ProcessOutputPoller processOutputPoller = new ProcessOutputPoller(process);
            processOutputPoller.setVisible(true);
        });
    }

}
