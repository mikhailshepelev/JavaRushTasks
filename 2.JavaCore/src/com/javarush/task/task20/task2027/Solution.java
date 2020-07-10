package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "home", "same");
        for (Word w : list) {
            System.out.println(w.toString());
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> resultList = new ArrayList<>();
        for (String s : words) {
            for (int row = 0; row < crossword.length; row++) {
                for (int col = 0; col < crossword[row].length; col++) {
                    if ((int) s.charAt(0) == crossword[row][col]) {
                        Word word = detectWord(crossword, row, col, s);
                        if (word != null) resultList.add(word);
                    }
                }
            }
        }
        return resultList;
    }

    private static Word detectWord(int[][] crossword, int row, int col, String text) {
        Word word = new Word(text);
        word.setStartPoint(col, row);
        if (check(Direction.RIGHT, crossword, row, col, text)) {
            word.setEndPoint(col+(text.length()-1), row);
            return word;
        }
        else if (check(Direction.LEFT, crossword, row, col, text)) {
            word.setEndPoint(col-(text.length()-1), row);
            return word;
        }
        else if (check(Direction.UP, crossword, row, col, text)) {
            word.setEndPoint(col, row-(text.length()-1));
            return word;
        }
        else if (check(Direction.DOWN, crossword, row, col, text)) {
            word.setEndPoint(col, row+(text.length()-1));
            return word;
        }
        else if (check(Direction.RIGHT_UP, crossword, row, col, text)) {
            word.setEndPoint(col+(text.length()-1), row-(text.length()-1));
            return word;
        }
        else if (check(Direction.RIGHT_DOWN, crossword, row, col, text)) {
            word.setEndPoint(col+(text.length()-1), row+(text.length()-1));
            return word;
        }
        else if (check(Direction.LEFT_UP, crossword, row, col, text)) {
            word.setEndPoint(col-(text.length()-1), row-(text.length()-1));
            return word;
        }
        else if (check(Direction.LEFT_DOWN, crossword, row, col, text)) {
            word.setEndPoint(col-(text.length()-1), row+(text.length()-1));
            return word;
        }
        return null;
    }

    private static boolean check(Direction direction, int[][] crossword, int row, int col, String text) {
        try {
            for (int i = 1; i < text.length(); i++) {
                int rowIndex;
                int colIndex;

                if (direction.row == 1) rowIndex = row + i;
                else if (direction.row == -1) rowIndex = row - i;
                else rowIndex = row;

                if (direction.col == 1) colIndex = col + i;
                else if (direction.col == -1) colIndex = col - i;
                else colIndex = col;

                if ((int) text.charAt(i) != crossword[rowIndex][colIndex]) {
                    return false;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    enum Direction {
        RIGHT (0, 1),
        LEFT (0, -1),
        UP (-1, 0),
        DOWN (1, 0),
        RIGHT_UP (-1, 1),
        RIGHT_DOWN (1, 1),
        LEFT_UP (-1, -1),
        LEFT_DOWN (1, -1);

        public int row;
        public int col;

        Direction(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public Word(String text, int startX, int startY, int endX, int endY) {
            this.text = text;
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
