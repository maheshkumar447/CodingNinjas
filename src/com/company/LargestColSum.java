package com.company;

public class LargestColSum {
    public static int largestColSum(int input[][]){
        int rows= input.length;
        int cols = input[0].length;
        int largest =0;
        for(int j = 0;j<cols;j++){
            int sum =0;
            for(int i =0;i<rows;i++){
                sum =sum+input[i][j];
            }
            if(sum>largest){
                largest = sum;
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int arr2[][]  ={{1,2,3},{4,5,6}};
        System.out.println(largestColSum(arr2));
    }
}
