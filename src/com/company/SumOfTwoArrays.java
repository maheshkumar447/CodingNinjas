package com.company;

public class SumOfTwoArrays {

    public static void sumOfTwoArrays(int arr1[], int arr2[], int output[]) {
        //Your code goes here


        int carry = 0;
        int len3, small;

        if (arr1.length < arr2.length) {
            small = arr1.length;
        } else {
            small = arr2.length;
        }


        if (arr1.length >= arr2.length) {
            len3 = arr1.length;
        } else {
            len3 = arr2.length;
        }


        len3++;


        for (int i = 0; i < small; i++) {
            output[len3 - i - 1] = (arr1[arr1.length - i - 1] + arr2[arr2.length - i - 1] + carry) % 10;
            carry = (arr1[arr1.length - i - 1] + arr2[arr2.length - i - 1] + carry) / 10;
        }


        if (arr1.length > arr2.length) {
            for (int i = arr2.length; i < arr1.length; i++) {
                output[len3 - i - 1] = (arr1[arr1.length - i - 1] + carry) % 10;
                carry = (arr1[arr1.length - i - 1]) / 10;
            }
        } else if (arr2.length > arr1.length) {
            for (int i = arr1.length; i < arr2.length; i++) {
                output[len3 - i - 1] = (arr2[arr2.length - i - 1] + carry) % 10;
                carry = arr2[arr2.length - i - 1] / 10;
            }
        }

        output[0] += carry;
    }
    public static void main(String[] args) {

    }
}
