package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {

    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void resetDocument() {
        if (this.document != null) {
            this.document.removeUndoableEditListener(view.getUndoListener());
        }

        this.document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        this.document.addUndoableEditListener(view.getUndoListener());

        view.update();
    }

    public void setPlainText(String text) {
        resetDocument();
        StringReader sr = new StringReader(text);
        try {
            new HTMLEditorKit().read(sr, this.document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter sw = new StringWriter();
        try {
            new HTMLEditorKit().write(sw, this.document,0, this.document.getLength());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return sw.toString();
    }

    public void createNewDocument() {
        this.view.selectHtmlTab();
        resetDocument();
        this.view.setTitle("HTML редактор");
        this.currentFile = null;
    }

    public void openDocument() {
        this.view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        int returnVal = chooser.showOpenDialog(view);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.currentFile = chooser.getSelectedFile();
            resetDocument();
            this.view.setTitle(this.currentFile.getName());
            try (FileReader writer = new FileReader(currentFile)) {
                new HTMLEditorKit().read(writer, this.document,0);
                view.resetUndo();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {
        if (currentFile == null) {
            saveDocumentAs();
        } else {
            this.view.selectHtmlTab();
            try (FileWriter writer = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(writer, this.document,0, this.document.getLength());
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        this.view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        int returnVal = chooser.showSaveDialog(view);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.currentFile = chooser.getSelectedFile();
            this.view.setTitle(this.currentFile.getName());
            try (FileWriter writer = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(writer, this.document,0, this.document.getLength());
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void about() {
    }
}
