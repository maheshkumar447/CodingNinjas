package com.company;

import java.util.Scanner;

public class UserArray {

    public static int[] takeInput(){
        Scanner sc = new Scanner(System.in);
        int size =  sc.nextInt();
        int arr[] = new int[size];
        for(int i = 0; i<size;i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void printArray(int arr[]){
        int size = arr.length;
        for(int i = 0; i<size;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
//        Scanner sc =  new Scanner(System.in);
//        int size = sc.nextInt();
//        int arr[] = new int[size];
//        for(int i = 0; i<size; i++){
//            arr[i] = sc.nextInt();
//        }

//        for(int i = 0; i<size; i++){
//            System.out.print(arr[i] + " ");
//        }

//        System.out.println();

        int input[] = takeInput();
        printArray(input);




    }
}
