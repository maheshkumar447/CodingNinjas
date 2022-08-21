package com.company;

public class SearchRotateInArray {

    public static int arrayRotateCheck(int[] arr){
        //Your code goes here

//
//        if(arr.length==0){
//            return 0;
//        }
//        if(arr.length == 1){
//            return 1;
//        }
        int min_Element = Integer.MAX_VALUE;
        int min_index = Integer.MAX_VALUE;

//        if(arr.length != 0 && arr.length !=1){

            for(int i =0;i<arr.length;i++){
                if(arr[i]<min_Element){
                    min_Element = arr[i];
                    min_index = i;
                }


            }
//        }
        return min_index;
    }

    public static void main(String[] args) {

    }
}
