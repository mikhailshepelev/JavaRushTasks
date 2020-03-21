package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        if (a>=b) { if (b>=c) System.out.println(b); else if (a>=c) System.out.println(c);
        else System.out.println(a);}
       else { if (b<=c) System.out.println(b); else if (a>=c) System.out.println(a); else System.out.println(c);}

        //напишите тут ваш код

    }
}
