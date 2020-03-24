package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
       ArrayList<Human> humans = new ArrayList<>();
       Human ch1 = new Human();
        ch1.name = "Nik";
        ch1.age = 13;
        ch1.sex = true;
        humans.add(ch1);

        Human ch2 = new Human();
        ch2.name = "Mikk";
        ch2.age = 15;
        ch2.sex = true;
        humans.add(ch2);

        Human ch3 = new Human();
        ch3.name = "Jared";
        ch3.age = 18;
        ch3.sex = true;
        humans.add(ch3);

        Human father = new Human();
        father.name = "Albert";
        father.age = 45;
        father.sex = true;
        father.children.add(ch1);
        father.children.add(ch2);
        father.children.add(ch3);
        humans.add(father);

        Human mother = new Human();
        mother.name = "Kattie";
        mother.age = 42;
        mother.sex = false;
        mother.children.add(ch1);
        mother.children.add(ch2);
        mother.children.add(ch3);
        humans.add(mother);

        Human grampa1 = new Human();
       grampa1.name = "Alex";
       grampa1.age = 78;
       grampa1.sex = true;
       grampa1.children.add(father);
        humans.add(grampa1);

       Human grampa2 = new Human();
        grampa2.name = "Mike";
        grampa2.age = 87;
        grampa2.sex = true;
        grampa2.children.add(mother);
        humans.add(grampa2);

        Human gramma1 = new Human();
        gramma1.name = "Ammie";
        gramma1.age = 84;
        gramma1.sex = false;
        gramma1.children.add(father);
        humans.add(gramma1);

        Human gramma2 = new Human();
        gramma2.name = "Allle";
        gramma2.age = 80;
        gramma2.sex = false;
        gramma2.children.add(mother);
        humans.add(gramma2);

        for (Human h : humans){
            System.out.println(h);
        }

    }

    public static class Human {
        public String name;
        public int age;
        public boolean sex;
        public ArrayList<Human> children = new ArrayList<>();

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
