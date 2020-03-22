package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.Scanner;


/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b =11;
        if (a>9) {
        while (b>=10){
            b = a/10;
            int c = a%10;
            if (c%2 == 0) {even++;} else {odd++;}
            a = a/10;
        }
        if (a%2 == 0) {even++;} else {odd++;} }
        else if (a%2 == 0) {even++;} else {odd++;}
        System.out.print("Even: "+even+" Odd: "+odd);
        
    }}
