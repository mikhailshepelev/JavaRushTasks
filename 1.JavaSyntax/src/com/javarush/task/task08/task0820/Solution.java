package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> result = new HashSet<Cat>();
        for (int i = 0; i<4; i++) {
            Cat cat = new Cat();
            result.add(cat);
        }
        return result;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> result = new HashSet<Dog>();
        for (int i = 0; i<3; i++) {
            Dog dog = new Dog();
            result.add(dog);
        }
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
       Set <Object> set = new HashSet<>();
        for (Cat c : cats)
        {
            set.add(c);
        }
        for (Dog d : dogs)
        {
            set.add(d);
        }
        return set;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        pets.removeAll(cats);
    }

    public static void printPets(Set<Object> pets) {
        for (Object c : pets)
        {
            System.out.println(c);
        }
    }
    public static class Cat {

    }
    public static class Dog {

    }
    //напишите тут ваш код
}
