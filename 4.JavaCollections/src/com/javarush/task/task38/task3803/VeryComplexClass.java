package com.javarush.task.task38.task3803;

/*
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        String string = (String) new Object();
    }

    public void methodThrowsNullPointerException() {
        Object object = null;
        object.equals(null);
    }

    public static void main(String[] args) {
        VeryComplexClass clazz = new VeryComplexClass();
        clazz.methodThrowsNullPointerException();
        clazz.methodThrowsClassCastException();
    }
}
