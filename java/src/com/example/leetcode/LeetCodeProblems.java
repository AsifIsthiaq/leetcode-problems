package com.example.leetcode;

import java.util.*;

public class LeetCodeProblems {
    public static void main(String[] args) {
        System.out.println("Leet Code Problems");
        // for code formatting using cmd+option+l in mac
        // cmd+shift+k to push code
        findMedianSortedArrays();
    }

    /**
     * 4. Median of Two Sorted Arrays
     */
    static void findMedianSortedArrays() {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A, B;
        if (nums2.length < nums1.length) {
            A = nums2;
            B = nums1;
        } else {
            A = nums1;
            B = nums2;
        }
        int total = A.length + B.length;
        int half = Math.floorDiv(total, 2);
        int l = 0, r = A.length - 1, i, j;
        double aLeft, aRight, bLeft, bRight;
        System.out.println("B-> " + Arrays.toString(B));
        System.out.println("A-> " + Arrays.toString(A));
        System.out.println("l=" + l + " r=" + r);
        while (true) {
            i = Math.floorDiv((l + r), 2);
            j = half - i - 2; // -2 cause of both A & B's index starts from 0
            System.out.println("i=" + i + " j=" + j);

            if (i >= 0) aLeft = A[i];
            else aLeft = Double.NEGATIVE_INFINITY;
            if (i + 1 < A.length) aRight = A[i + 1];
            else aRight = Double.POSITIVE_INFINITY;
            System.out.println("aLeft=" + aLeft + " aRight=" + aRight);

            if (j >= 0) bLeft = B[j];
            else bLeft = Double.NEGATIVE_INFINITY;
            if (j + 1 < B.length) bRight = B[j + 1];
            else bRight = Double.POSITIVE_INFINITY;
            System.out.println("bLeft=" + bLeft + " bRight=" + bRight);

            // if partition is correct
            if (aLeft <= bRight && bLeft <= aRight) {
                // odd
                if (total % 2 == 1) return Math.min(aRight, bRight);
                    // even
                else return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2;
            }
            /**
             * means has too many elements from left partition of A
             * need to reduce r and then the partition will become l to mid-1
             */
            else if (aLeft > bRight) r = i - 1;
            /**
             * means has too many elements from left partition of B
             * need to increase left partition of A
             * need to increase l and then the partition will become mid+1 to r
             */
            else if (bLeft > aRight) l = i + 1;
        }
    }

    /**
     * 1985. Find the Kth Largest Integer in the Array
     */
    static void findKthLargestInt() {
        String[] nums = new String[]{"3", "6", "7", "10"};
        System.out.println(kthLargestNumber(nums, 4));
    }

    public static String kthLargestNumber(String[] nums, int k) {
//        PriorityQueue<String> pq = new PriorityQueue<String>(new StringComparator());
        PriorityQueue<String> pq = new PriorityQueue<String>((a, b) -> {
            if (a.length() < b.length()) return 1;
            else if (a.length() == b.length()) return b.compareTo(a);
            else return -1;
        });
        for (String str : nums) pq.add(str);
        System.out.println(pq);
        int i = 1;
        while (i++ < k) pq.poll();
        return pq.peek();
    }

    static class StringComparator implements Comparator<String> {
        public int compare(String a, String b) {
            if (a.length() < b.length()) {
                System.out.println("compare-> a=" + a + " |  b=" + b + " | comapreTo-> " + b.compareTo(a));
                return 1;
            } else if (a.length() == b.length()) {
                System.out.println("compare-> a=" + a + " |  b=" + b + " | comapreTo-> " + b.compareTo(a));
                return b.compareTo(a);
            }
            // a.length() > b.length()
            else {
                System.out.println("compare-> a=" + a + " |  b=" + b + " | comapreTo-> " + b.compareTo(a));
                return -1;
            }
        }
    }

    /**
     * 215. Kth Largest Element in an Array
     */
    static void findKthLargest() {
//      int[] nums = new int[]{3, 2, 1, 5, 6, 4};
//        System.out.println(findKthLargest(nums, 2));
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 4));
    }

    public static int findKthLargest_(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length - 1;
        quickSort(nums, 0, len);
        System.out.println(Arrays.toString(nums));
        return nums[len + 1 - k];
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
    the pivot element at its correct position in sorted
    array, and places all smaller (smaller than pivot)
    to left of pivot and all greater elements to right
    of pivot */
    static int partition(int[] arr, int low, int high) {
        // pivot
        int pivot = arr[high];
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
            arr[] --> Array to be sorted,
            low --> Starting index,
            high --> Ending index
    */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * 1779. Find Nearest Point That Has the Same X or Y Coordinate
     */
    static void nearestValidPoint() {
        int[][] points = new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        System.out.println(nearestValidPoint(3, 4, points));
    }

    public static int nearestValidPoint(int x, int y, int[][] points) {
        for (int[] point : points) {
            System.out.println(Arrays.toString(point));
        }
        int i = 0, currShortestDistance = -1, nearestValidIndex = -1;
        for (int[] point : points) {
            if (point[0] == x || point[1] == y) {
                int md = Math.abs(x - point[0] + Math.abs(y - point[1]));
                System.out.println("condition 1 true md=" + md);
                if (currShortestDistance == -1 || md < currShortestDistance) {
                    currShortestDistance = md;
                    nearestValidIndex = i;
                    System.out.println("condition 2 true");
                }
            }
            i++;
        }
        return nearestValidIndex;
    }

    /**
     * problem: 973. K Closest Points to Origin
     */
    static void kClosest() {
//        int[][] points = new int[][]{
//                {1, 3}, {-2, 2}
//        };
        int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
//        int[][] points = new int[][]{
//                {0, 1}, {1, 0}
//        };
        kClosest(points, 2);
//        logList(kClosest(points, 2));
    }

    static class DistanceComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            double distance1 = Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
            double distance2 = Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2));
            System.out.println("compare-> a=" + distance1 + " |  b=" + distance2);
            return distance1 < distance2 ? 1 : -1;
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new DistanceComparator());
        for (int[] p : points) {
            System.out.println(Arrays.toString(p));
            pq.add(p);
            if (pq.size() > k) pq.poll();
        }
        int[][] closestPoints = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) {
            System.out.println(Arrays.toString(pq.peek()));
            closestPoints[i++] = pq.poll();
        }
        return closestPoints;
    }

    public static int[][] kClosest_(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int[] p : points) {
            System.out.println(Arrays.toString(p));
            maxHeap.offer(p);
            if (maxHeap.size() > K) maxHeap.poll();
        }
        int[][] ans = new int[maxHeap.size()][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            System.out.println(Arrays.toString(maxHeap.peek()));
            ans[i++] = maxHeap.poll();
        }
        System.out.println("ans:");
        for (int[] e : ans)
            System.out.println(Arrays.toString(e));
        return ans;
        /**
         * Complexity
         *
         * Time: O(NlogK), where N <= 10^4 is number of points.
         * Extra Space (don't count output as space): O(K), it's size of maxHeap.
         */
    }

    /**
     * problem: 234. Palindrome Linked List
     */
    static void createSingleLinkedList() {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();

        // Insert the values
        list = list.insert(list, 1);
        list = list.insert(list, 2);
        list = list.insert(list, 2);
        list = list.insert(list, 1);

        // Print the LinkedList
        list.printList(list);
        System.out.println(isPalindrome(list.head));
    }

    public static boolean isPalindrome(LinkedList.ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList.ListNode curr = head;
        int i = 0;
        while (curr != null) {
            map.put(i, curr.val);
            curr = curr.next;
            i++;
        }
        System.out.println(map);
        curr = reversedLinkedList(head);
        i = 0;
        while (curr != null) {
            System.out.println("curr.val " + curr.val);
            System.out.println("map.get(i) " + map.get(i));
            if (curr.val != map.get(i)) return false;
            curr = curr.next;
            i++;
        }
        return true;
    }

    static LinkedList.ListNode reversedLinkedList(LinkedList.ListNode head) {
        LinkedList.ListNode curr = head, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
//        System.out.println("\n----");
//        while (prev != null){
//            System.out.print(prev.val+" ");
//            prev = prev.next;
//        }
        return prev;
    }

    /**
     * problem: 383. Ransom Note
     */
    static void canConstruct() {
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int count = map.containsKey(c) ? map.get(c) + 1 : 1;
            map.put(c, count);
        }
        System.out.println(map);
        for (char c : ransomNote.toCharArray()) {
            int newCount = map.containsKey(c) ? map.get(c) - 1 : -1;
            if (newCount == -1) return false;
            map.put(c, newCount);
        }
        System.out.println(map);
        return true;
    }

    /**
     * problem: 412. Fizz Buzz
     */
    static void fizzBuzz() {
        System.out.println(fizzBuzz(5));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();
        int i = 1;
        while (i <= n) {
            list.add(getElement(i));
            i++;
        }
        return list;
    }

    static String getElement(int i) {
        if (i % 3 == 0 && i % 5 == 0) return "FizzBuzz";
        else if (i % 3 == 0) return "Fizz";
        else if (i % 5 == 0) return "Buzz";
        else return Integer.toString(i);
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
        int[][] mat = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
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

    static void logList(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }

    static void logList(String[] arr) {
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