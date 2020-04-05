package com.javarush.task.task13.task1322;

/* 
Интерфейс SimpleObject
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        SimpleObject<String> stringObject = new StringObject<String>();
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    static class StringObject<S> implements SimpleObject<String>{

        @Override
        public SimpleObject<String> getInstance() {
            StringObject<S> so = new StringObject<S>();
            return so;
        }
    }

}
