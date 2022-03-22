package com.example.leetcode;

public class LeetCodeProblems {
    public static void main(String[] args) {
        System.out.println("Leet Code Problems");
        numberOfSteps(123);
    }

    /*
    Number Of Steps problem Starts
     */
    static void numberOfSteps(int num) {
        int steps = 0;
        System.out.println(reduceNumbers(num, steps));
    }

    static int reduceNumbers(int n, int steps) {
        if (n == 0) return steps;
        if (n % 2 == 0) {
            steps = steps + 1;
            return reduceNumbers(n / 2, steps);
        } else {
            steps = steps + 1;
            return reduceNumbers(n - 1, steps);
        }
    }
    /**
     class Solution {
     public int numberOfSteps(int num) {
     int steps = 0;
     return reduceNumbers(num, steps);
     }

     int reduceNumbers(int n, int steps) {
     if (n == 0) return steps;
     if (n % 2 == 0) {
     steps = steps + 1;
     return reduceNumbers(n / 2, steps);
     } else {
     steps = steps + 1;
     return reduceNumbers(n - 1, steps);
     }
     }
     }**/
    /*
    Number Of Steps problem Ends
     */
}
