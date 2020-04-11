package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {

    private FileWriter fileWriter;

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }
    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }
    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }
    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        fileWriter.flush();
        for (int i = off; i < off+len; i++) {
            System.out.print(cbuf[i]);
        }
    }
    public void write(int c) throws IOException {
        fileWriter.write(c);
        fileWriter.flush();
        System.out.print((char) c);
    }
    public void write(String str) throws IOException {
        fileWriter.write(str);
        fileWriter.flush();
        System.out.print(str);
    }
    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        fileWriter.flush();
        for (int i = off; i < off+len; i++) {
            System.out.print(str.charAt(i));
        }
    }
    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        fileWriter.flush();
        for (int i = 0; i < cbuf.length; i++) {
            System.out.print(cbuf[i]);
        }
    }
    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("C:\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1917\\File");
        char[] b = {'h', 'e', 'l', 'l', 'o'};
        int c = 100;
        String s = "Hello, world!";
        fileConsoleWriter.write(s, 0, 1);
    }

}
