package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int i;
        int count = 0;
        while((i=fileInputStream.read())!= -1){
            if ((i>64 && i<91) || (i>96 && i<123)) count++;
        }
        fileInputStream.close();
        System.out.println(count);
    }
}
