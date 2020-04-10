package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static List<String> listFile1;
    public static List<String> listFile2;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        listFile1 = convertFileLinesToList(fileName1);
        listFile2 = convertFileLinesToList(fileName2);

        while (true) {
            if (listFile1.size() >= 2 && listFile2.size() >=2) {
                if (listFile1.get(0).equals(listFile2.get(0))) {
                    sameOperation();
                }
                else if (listFile1.get(0).equals(listFile2.get(1))) {
                    addedOperation();
                }
                else {
                    removedOperation();
                }
            }
            else if (listFile1.size() == 1 && listFile2.size() == 2) {
                if (listFile1.get(0).equals(listFile2.get(1))) {
                    removedOperation();
                    sameOperation();
                    break;
                }
                else {
                    sameOperation();
                    addedOperation();
                    break;
                }
            }
            else {
                if (listFile1.get(1).equals(listFile2.get(0))) {
                    addedOperation();
                    sameOperation();
                    break;
                }
                else {
                    sameOperation();
                    removedOperation();
                    break;
                }
            }
        }
    }

    private static List<String> convertFileLinesToList(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        reader.close();
        return list;
    }

    private static void sameOperation() {
        lines.add(new LineItem(Type.SAME, listFile2.get(0)));
        listFile1.remove(0);
        listFile2.remove(0);
    }

    private static void addedOperation(){
        lines.add(new LineItem(Type.ADDED, listFile2.get(0)));
        listFile2.remove(0);
    }

    private static void removedOperation() {
        lines.add(new LineItem(Type.REMOVED, listFile1.get(0)));
        listFile1.remove(0);
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return "LineItem{" +
                    "type=" + type +
                    ", line='" + line + '\'' +
                    '}';
        }
    }
}
