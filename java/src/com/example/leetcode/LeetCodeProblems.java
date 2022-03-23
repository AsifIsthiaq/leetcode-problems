package com.example.leetcode;

import java.util.Arrays;

public class LeetCodeProblems {
    public static void main(String[] args) {
        System.out.println("Leet Code Problems");
        // for code formatting using cmd+option+l in mac
        // cmd+shift+k to push code
        //middleOfTheLinkList();
        createSinglyLinkedList();
    }

    /**
     * problem: 876. Middle of the Linked List
     */

    static void createSinglyLinkedList() {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();

        // Insert the values
        list = list.insert(list, 1);
        list = list.insert(list, 2);
        list = list.insert(list, 3);
        list = list.insert(list, 4);
        list = list.insert(list, 5);
        list = list.insert(list, 6);
//        list = list.insert(list, 7);
//        list = list.insert(list, 8);
//        list = list.insert(list, 9);
//        list = list.insert(list, 10);
//        list = list.insert(list, 11);
//        list = list.insert(list, 12);

        // Print the LinkedList
//        list.printList(list);
        middleOfTheLinkList(list);
    }

    static class LinkedList {
        ListNode head; // head of list

        class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
                this.next = null;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        // Method to insert a new node
        public LinkedList insert(LinkedList list, int data) {
            // Create a new node with given data
            ListNode new_node = new ListNode(data);
            new_node.next = null;

            // If the Linked List is empty,
            // then make the new node as head
            if (list.head == null) {
                list.head = new_node;
            } else {
                // Else traverse till the last node
                // and insert the new_node there
                ListNode last = list.head;
                while (last.next != null) {
                    last = last.next;
                }

                // Insert the new_node at last node
                last.next = new_node;
            }

            // Return the list by head
            return list;
        }

        // Method to print the LinkedList.
        public void printList(LinkedList list) {
            ListNode currNode = list.head;

            System.out.print("LinkedList: ");

            // Traverse through the LinkedList
            while (currNode != null) {
                // Print the data at current node
                System.out.print(currNode.val + " ");

                // Go to next node
                currNode = currNode.next;
            }
            System.out.println();
        }
    }

    static void middleOfTheLinkList(LinkedList list) {
        // Print the LinkedList
        list.printList(list);
        middleNode(list.head);
    }

    static LinkedList.ListNode middleNode(LinkedList.ListNode head) {
        LinkedList.ListNode fast = head;
        LinkedList.ListNode slow = head;
        LinkedList.ListNode middleNode = head;
        int len = getLengthOfLinkedList(head);
        int middle = 1;
        if (len > 0) {
            middle = len > 2 ? (int) Math.ceil(len * 1.001 / 2) : len;
        }
        System.out.println("linked list length-> " + len);
        System.out.println("linked list middle-> " + middle);
//        System.out.println("curr node: " + fast.val);
//        System.out.println("slow node: " + slow.val);
        // solution 1
        while (fast != null && fast.next != null) {
//            System.out.println("curr node: " + fast.val);
//            System.out.println("slow node: " + slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        // solution 2
        int i = 1;
        while (i < middle) {
            i++;
            middleNode = middleNode.next;
        }
        System.out.println("middle node: " + middleNode.val);
        return middleNode;
    }

    static int getLengthOfLinkedList(LinkedList.ListNode head) {
        LinkedList.ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    /**
     * problem : 1337. The K Weakest Rows in a Matrix
     */
    static void kWeakestRows() {
        int[][] mat = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        kWeakestRows(mat, 3);
    }

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

    /**
     * problem : Number Of Steps problem Starts
     */

    static void numberOfSteps() {
        numberOfSteps(123);
    }

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
}