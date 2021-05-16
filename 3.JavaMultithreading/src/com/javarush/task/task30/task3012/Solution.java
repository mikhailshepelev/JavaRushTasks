package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        String balancedTernary = decimalToBalancedTernary(number);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = balancedTernary.length() - 1; i >= 0; i--) {
            int tempNum = (int) Math.pow(3, (balancedTernary.length() - (i + 1)));

            if (balancedTernary.charAt(i) == 'Z') {
                stringBuilder.append("- ").append(tempNum).append(" ");
            } else if (balancedTernary.charAt(i) == '1') {
                stringBuilder.append("+ ").append(tempNum).append(" ");
            }
        }
        System.out.printf("%d = %s", number, stringBuilder.toString());
    }

    public String decimalToBalancedTernary(int n)
    {
        String output = "";
        while (n > 0)
        {
            int rem = n % 3;
            n = n / 3;
            if (rem == 2)
            {
                rem = -1;
                n++;
            }
            output = (rem == 0 ? '0' :
                    (rem == 1) ? '1' : 'Z') + output;
        }
        return output;
    }
}