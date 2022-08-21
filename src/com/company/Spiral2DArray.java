package com.company;

public class Spiral2DArray {

    public static void spiralPrint(int matrix[][]){
        int  N=  matrix.length;
        int M =0;
        if(N !=0){
            M=matrix[0].length;
        }

        int rs =0;
        int cs=0;
        int re = N-1;
        int ce = M-1;

        int count=0;

        while (count<(N*M)){
            for(int i =cs;i<=ce;i++){
                System.out.print(matrix[rs][i]+" ");
                count++;
            }
            rs++;

            for(int i=rs;i<=re;i++){
                System.out.print(matrix[i][ce]+" ");
                count++;
            }
            ce--;

            for(int i=ce;i>=cs;i--){
                System.out.print(matrix[re][i]+" ");
                count++;
            }
            re--;

            for(int i =re;i>=rs;i--){
                System.out.print(matrix[i][cs]+" ");
                count++;
            }
            cs++;
        }

    }


    public static void main(String[] args) {

        int arr2[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiralPrint(arr2);
    }
}
