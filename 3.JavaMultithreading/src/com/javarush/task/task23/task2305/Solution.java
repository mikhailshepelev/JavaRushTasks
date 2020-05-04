package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public Solution(){

    }

    public static Solution[] getTwoSolutions() {
        Solution aSolution = new Solution();
        InnerClass a1 = aSolution.new InnerClass();
        InnerClass a2 = aSolution.new InnerClass();
        aSolution.innerClasses[0] = a1;
        aSolution.innerClasses[1] = a2;

        Solution bSolution = new Solution();
        InnerClass b1 = bSolution.new InnerClass();
        InnerClass b2 = bSolution.new InnerClass();
        bSolution.innerClasses[0] = b1;
        bSolution.innerClasses[1] = b2;

        return new Solution[]{aSolution, bSolution};
    }

    public static void main(String[] args) {

    }
}
