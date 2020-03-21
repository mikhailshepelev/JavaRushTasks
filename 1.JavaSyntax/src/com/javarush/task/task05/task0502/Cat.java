package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
        public int age;
        public int weight;
        public int strength;

        public Cat() {
        }

        public boolean fight(Cat anotherCat) {
            int i = 0;
            int k = 0;
            if (this.age > anotherCat.age) i += 1;
            else if (this.age == anotherCat.age) {
                i = i + 1;
                k = k + 1; }
            else k = k + 1;

            if (this.weight > anotherCat.weight) i +=1;
            else if (this.weight == anotherCat.weight) { i+=1; k+=1; }
            else k+=1;
            if (this.strength > anotherCat.strength) i +=1;
            else if (this.strength == anotherCat.strength) { i+=1; k+=1; }
            else k+=1;

            if (i>k) return true;
            else return false;
            
        }

        public static void main(String[] args) {
            
        }
}
