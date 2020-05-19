package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1) {
                    counter++;
                    for (int k = j; k < a.length; k++) {
                        if (a[i][k] == 1) {
                            a[i][k] = 0;
                            try {
                                for (int l = i + 1; l < a.length; l++) {
                                    if (a[l][k] == 1) a[l][k] = 0;
                                    else break;
                                }
                            } catch (IndexOutOfBoundsException ignored){}
                            }
                        else break;
                    }
                }
            }
        }
        return counter;
    }
}
