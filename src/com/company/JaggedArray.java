package com.company;

public class JaggedArray {
    public static void main(String[] args) {
        int arr2[][] = new int[4][];
        System.out.println(arr2);

        for(int i =0;i<arr2.length;i++){
            arr2[i] = new int[i+2];

        }

        for(int i =0;i<arr2.length;i++){
            for(int j =0;j<arr2[i].length;j++){
                System.out.print(arr2[i][j]+" ");
            }
            System.out.println();
        }
    }
}
