package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String newFileName = Paths.get(args[0]).getFileName().toString();
        String newPathInArchive = "new/" + newFileName;

        Map<String, ByteArrayOutputStream> filesInArchive = new HashMap<>();

        ZipEntry entry;
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(args[1]));
        while ((entry = zipIn.getNextEntry()) != null) {
            if (entry.getName().endsWith(newFileName)) {
                newPathInArchive = entry.getName();
            } else {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int length;
                byte[] buffer = new byte[1024];
                while ((length = zipIn.read(buffer)) != -1) {
                    baos.write(buffer, 0, length);
                }
                filesInArchive.put(entry.getName(), baos);
            }
        }
        zipIn.close();

        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(args[1]));
        zipOut.putNextEntry(new ZipEntry(newPathInArchive));
        Files.copy(Paths.get(args[0]), zipOut);
        for (Map.Entry<String, ByteArrayOutputStream> pair : filesInArchive.entrySet()) {
            zipOut.putNextEntry(new ZipEntry(pair.getKey()));
            pair.getValue().writeTo(zipOut);
        }
        zipOut.close();
    }
}
