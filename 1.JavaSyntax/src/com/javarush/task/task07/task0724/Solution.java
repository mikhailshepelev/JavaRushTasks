package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> list = new ArrayList<>();
       Human grampa1 = new Human("Mike", false, 88); list.add(grampa1);
       Human grampa2 = new Human("Adrian", false, 87); list.add(grampa2);
       Human gramma1 = new Human("Rose", true, 78); list.add(gramma1);
       Human gramma2 = new Human("Keit", true, 76); list.add(gramma2);
       Human father = new Human("Johnny", false, 50, grampa1, gramma1); list.add(father);
       Human mother = new Human("Annie", true, 45, grampa2, gramma2); list.add(mother);
       Human child1 = new Human("Tommy", false, 20, father, mother); list.add(child1);
       Human child2 = new Human("Eva", true, 25, father, mother); list.add(child2);
       Human child3 = new Human("Lev", false, 18, father, mother); list.add(child3);
       for (Human a : list){
           System.out.println(a);
       }

    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}