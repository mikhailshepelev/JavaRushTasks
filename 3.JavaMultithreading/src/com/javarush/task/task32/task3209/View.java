package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    private Controller controller;
    private UndoManager undoManager = new UndoManager();
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoListener undoListener = new UndoListener(undoManager);

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public Controller getController() {
        return controller;
    }

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init() {
        initGui();
        FrameListener listener = new FrameListener(this);
        this.addWindowListener(listener);
        this.setVisible(true);
    }

    public void initMenuBar() {
        JMenuBar bar = new JMenuBar();
        MenuHelper.initFileMenu(this, bar);
        MenuHelper.initEditMenu(this, bar);
        MenuHelper.initStyleMenu(this, bar);
        MenuHelper.initAlignMenu(this, bar);
        MenuHelper.initColorMenu(this, bar);
        MenuHelper.initFontMenu(this, bar);
        MenuHelper.initHelpMenu(this, bar);

        this.getContentPane().add(bar, BorderLayout.NORTH);
    }

    public void initEditor() {
        this.htmlTextPane.setContentType("text/html");

        JScrollPane aPane = new JScrollPane(this.htmlTextPane);
        this.tabbedPane.addTab("HTML", aPane);

        JScrollPane bPane = new JScrollPane(this.plainTextPane);
        this.tabbedPane.addTab("Текст", bPane);

        this.tabbedPane.setPreferredSize(new Dimension(1000, 1000));

        TabbedPaneChangeListener listener = new TabbedPaneChangeListener(this);
        this.tabbedPane.addChangeListener(listener);

        this.getContentPane().add(this.tabbedPane, BorderLayout.CENTER);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void exit() {
        this.controller.exit();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        switch (command) {
            case "Новый" :
                this.controller.createNewDocument();
                break;
            case "Открыть" :
                this.controller.openDocument();
                break;
            case "Сохранить" :
                this.controller.saveDocument();
                break;
            case "Сохранить как..." :
                this.controller.saveDocumentAs();
                break;
            case "Выход" :
                this.controller.exit();
                break;
            case "О программе" :
                showAbout();
                break;
        }
    }

    public void selectedTabChanged() {
        int tabIndex = this.tabbedPane.getSelectedIndex();
        if (tabIndex == 0) {
            this.controller.setPlainText(this.plainTextPane.getText());
        } else if (tabIndex == 1) {
            this.plainTextPane.setText(this.controller.getPlainText());
        }
        resetUndo();
    }

    public boolean canUndo() {
        return this.undoManager.canUndo();
    }

    public boolean canRedo() {
        return this.undoManager.canRedo();
    }

    public void undo() {
        try {
            this.undoManager.undo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            this.undoManager.redo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo() {
        this.undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected() {
        return this.tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab() {
        this.tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        this.htmlTextPane.setDocument(this.controller.getDocument());
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(getContentPane(), "Version 1.0", "About", JOptionPane.INFORMATION_MESSAGE);
    }
}
