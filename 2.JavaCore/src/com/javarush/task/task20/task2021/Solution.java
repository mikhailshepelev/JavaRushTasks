package com.javarush.task.task20.task2021;

import java.io.*;

/*
Сериализация под запретом
*/
public class Solution implements Serializable {

    public static class SubSolution extends Solution {

        public SubSolution() throws NotSerializableException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        SubSolution solution = new SubSolution();


        oos.writeObject(solution);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        SubSolution b1 = (SubSolution) ois.readObject();
    }
}
