package com.company;

public class RowWiseSum {

    public static void rowWiseSum(int[][] mat){
        int sum = 0;
        int N = mat.length;
        int M= 0;
        if(N!=0){
            M = mat[0].length;
        }
        for(int i =0; i<N; i++){
            sum=0;
            for(int j =0; j<M; j++){
                sum =sum+mat[i][j];
            }
            System.out.println(sum+" ");
        }
    }

    public static void main(String[] args) {

    }
}
