package com.example.leetcode;

import java.util.Arrays;

public class LeetCodeProblems {
    public static void main(String[] args) {
        System.out.println("Leet Code Problems");
        // for code formatting using cmd+option+l in mac
        // numberOfSteps(123);
        int[][] mat = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        kWeakestRows(mat, 3);
    }

    /**
     * problem : 1337. The K Weakest Rows in a Matrix
     *
     * @param mat, k
     */
    static int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int[] soldiers = new int[rows];
        for (int i = 0; i < rows; i++) {
            // int numOfOnes = Arrays.stream(mat[i]).sum();
            int numOfOnes = getSum(mat[i]);
            soldiers[i] = numOfOnes * rows + i;
        }
        logList(soldiers);
        Arrays.sort(soldiers);
        logList(soldiers);
        for (int i = 0; i < rows; i++)
            soldiers[i] = soldiers[i] % rows;
        logList(soldiers);
        logList(Arrays.copyOfRange(soldiers, 0, k));
        return Arrays.copyOfRange(soldiers, 0, k);
    }

    static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }

    static void logList(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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
