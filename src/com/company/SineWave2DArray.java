package com.company;

public class SineWave2DArray {

    public static void wavePrint(int mat[][]){
        int N = mat.length;
        int M = 0;
        if(N!=0){
            M=mat[0].length;
        }

        for(int j=0;j<M;j++){
            if(j%2==0 ) {
                for (int i = 0; i < N; i++) {
                    System.out.print(mat[i][j] + " ");
                }
            }
            else{
                for(int m = N-1;m>=0;m--){
                    System.out.print(mat[m][j]+" ");
                }
            }
//            for(int m = N;m>0;m--){
//
//                System.out.print(mat[m][j]+" ");
//            }


        }

    }


    public static void main(String[] args) {

        int arr2[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        wavePrint(arr2);
    }
}
