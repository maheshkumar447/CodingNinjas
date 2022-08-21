package com.company;

public class secondLargest {

    public static int secondLargestElement(int[] arr) {
        //Your code goes here

        if (arr.length == 1 || arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
            if (i >= 2 && arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }


    public static void main(String[] args) {

    }
}
