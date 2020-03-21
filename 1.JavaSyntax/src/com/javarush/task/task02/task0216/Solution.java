package com.javarush.task.task02.task0216;

/* 
Минимум трёх чисел
*/
public class Solution {
    public static int min(int a, int b, int c) {
        if (a < b) { if (a <= c) { return a; } if (a > c) { return c; } }
        if (a == b) {if (a <= c) { return a; } if (a > c) { return c; }}

        if (a > b) { if (b <= c) { return b; } if (b > c) { return c; } }

        if (a < c) { if (a <= b) { return a; } if (a > b) { return b; }}
        if (a == c) { if (a <= b) { return a; } if (a > b) { return b; }}

        if (a > c) {if (c <= b) { return c; }if (c > b) { return b; }}

        if (b < c) {if (b <= a) { return b; } if (b > a) { return a;}}
        if (b == c) {if (a <= b) { return a; } if (a > b) { return b; }}

        if (b > c) {if (c <= a) { return b; } if (c > a) { return a; }}



   return a;
    }
    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));
    }
}