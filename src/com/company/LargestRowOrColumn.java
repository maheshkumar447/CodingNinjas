package com.company;

public class LargestRowOrColumn {

    public static void largestRowOrColumn(int mat[][]){
//        int N = mat.length;
//        int M = mat[0].length;
//        int largestR = Integer.MIN_VALUE;
//        int largestC = Integer.MIN_VALUE;
//        int tempR=0;
//        int tempC=0;
//        for(int i =0 ;i<N;i++){
//            int sumR = 0;
//            for(int j = 0;j<M;j++){
//                sumR = sumR+mat[i][j] ;
//            }
//            if(sumR>largestR){
//                largestR=sumR;
//            }
//            tempR=largestR;
//        }
//
//        for(int k = 0;k<M;k++){
//            int sumC=0;
//            for(int l =0;l<N;l++){
//                sumC = sumC+mat[l][k];
//            }
//            if(sumC>largestC){
//                largestC=sumC;
//            }
//            tempC=largestC;
//        }
//
//        if(tempR>tempC){
//            System.out.println(tempR);
//        }else{
//            System.out.println(tempC);
//        }



        int largestRSum = Integer.MIN_VALUE;
        int largestCSum = Integer.MIN_VALUE;
        int largestR = 0;
        int largestC =0;

        int N = mat.length;
        int M = 0;
        if(N!=0){
            M = mat[0].length;
        }

        for(int i =0;i<N;i++){
            int sumR = 0;
            for(int j =0 ;j<M;j++){
                sumR = sumR+mat[i][j];
            }
            if(sumR>largestRSum){
                largestRSum = sumR;
                largestR=i;
            }
        }

        for(int j =0;j<M;j++){
            int sumC = 0;
            for(int i =0;i<N;i++){
                sumC=sumC+mat[i][j];
            }
            if(sumC>largestCSum){
                largestCSum = sumC;
                largestC = j;
            }
        }

        if(largestRSum>=largestCSum){
            System.out.println("row"+" "+ largestR+" " +largestRSum);
        }else{
            System.out.println("column"+" "+largestC+" "+largestCSum);
        }


        }


    public static void main(String[] args) {
        int arr[][] = {{3,6,9},{1,4,7},{2,8,9}};
        largestRowOrColumn(arr);
    }
}
