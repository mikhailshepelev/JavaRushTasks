package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(args[0]))) {
            Set<String> files = new TreeSet<>(Arrays.asList(args).subList(1, args.length));

            List<FileInputStream> streamList = new ArrayList<>();
            for (String s : files) {
                streamList.add(new FileInputStream(s));
            }

            SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(streamList));
            ZipInputStream zipInputStream = new ZipInputStream(seqInStream);
            byte[] buf = new byte[1024 * 1024];

            while (zipInputStream.getNextEntry() != null) {
                int count;
                while ((count = zipInputStream.read(buf)) != -1) {
                    fileOutputStream.write(buf, 0, count);
                }
            }
            seqInStream.close();
            zipInputStream.close();
        } catch (IOException ignored) { }
    }
}
