package com.javarush.task.task36.task3602;

/*
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class c : classes){

            if (Modifier.isPrivate(c.getModifiers()) &&
                    Modifier.isStatic(c.getModifiers()) &&
                    List.class.isAssignableFrom(c))
            {
                try {
                    Constructor constructor = c.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    List list = (List) constructor.newInstance();
                    list.get(0);
                } catch (IndexOutOfBoundsException e){
                    return c;
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException ignored) {
                }
            }
        }
        return null;
    }
}
