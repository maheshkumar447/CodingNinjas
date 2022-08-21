package com.company;

import java.util.Scanner;

public class LargestInArray {

    public static int largest(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int[] takeInput(){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i =0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void printArray(int arr[]){
        int size = arr.length;
        for(int i =0;i<size;i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int array[]=takeInput();
        printArray(array);
        int largerNumber = largest(array);
        System.out.println("larger number is: " + largerNumber);
    }
}
