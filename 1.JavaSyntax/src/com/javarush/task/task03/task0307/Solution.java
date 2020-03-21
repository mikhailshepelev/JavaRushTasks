package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
   Zerg zerg1 = new Zerg();
   zerg1.name = "vucinic";
   Zerg zerg2 = new Zerg();
   zerg2.name = "menez";
   Zerg zerg3 = new Zerg();
   zerg3.name = "tonetto";
   Zerg zerg4 = new Zerg();
   zerg4.name = "cassetti";
   Zerg zerg5 = new Zerg();
   zerg5.name = "totti";
   Protoss protoss1 = new Protoss();
   protoss1.name = "Jovic";
    Protoss protoss2 = new Protoss();
   protoss2.name = "Zidane";
    Protoss protoss3 = new Protoss();
   protoss3.name = "bale";
   Terran terran1 = new Terran();
   terran1.name = "milik";
   Terran terran2 = new Terran();
   terran2.name = "insighne";
   Terran terran3 = new Terran();
   terran3.name = "calhehon";
   Terran terran4 = new Terran();
   terran4.name = "allan";
   
   //напишите тут ваш код

    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
