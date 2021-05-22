package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> queue = new PriorityQueue<>();
        List<String> pathsList = new ArrayList<>();
        Collections.addAll(queue, Objects.requireNonNull(new File(root).listFiles()));


        while (!queue.isEmpty()){
            File currentFile = queue.remove();
            if (currentFile.isDirectory()){
                Collections.addAll(queue, Objects.requireNonNull(currentFile.listFiles()));
            } else {
                pathsList.add(currentFile.getAbsolutePath());
            }
        }
        return pathsList;
    }

    public static void main(String[] args) {

    }
}
