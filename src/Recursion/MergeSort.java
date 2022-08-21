package Recursion;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] input) {
//        if (input.length == 1) {
//            return;
//        }
//
//        int mid = input.length / 2;
//        int[] leftArr = Arrays.copyOfRange(input, 0, mid);
//        mergeSort(leftArr);
//        int[] rightArr = Arrays.copyOfRange(input, mid, input.length);
//        mergeSort(rightArr);
//
//        merge(input, leftArr, rightArr);


        if(input.length<=1){
            return;
        }

        int mid = input.length/2;
        int part1[] = new int[mid];
        int part2[] = new int[input.length-mid];

        for(int i=0;i<mid;i++){
            part1[i] = input[i];
         }

        int k = 0;
        for(int i=mid;i< input.length;i++){
            part2[k] = input[i];
            k++;
        }

        mergeSort(part1);
        mergeSort(part2);
        merge(part1,part2,input);





    }

    public static void merge(int [] input1,int [] input2, int [] output){
        int i=0,j=0,k=0;
        while(i< input1.length && j<input2.length){
            if(input1[i]<input2[j]){
                output[k] = input1[i];
                k++;
                i++;
            }
            else{
                output[k] = input2[j];
                j++;
                k++;
            }
        }

        while(i<input1.length){
            output[k] = input1[i];
            k++;
            i++;
        }

        while(j< input2.length){
            output[k] = input2[j];
            j++;
            k++;

        }



    }
//
//    public static void merge(int[] input, int[] leftArr, int[] rightArr) {
//        int leftSize = leftArr.length;
//        int rightSize = rightArr.length;
//        int size = leftArr.length + rightArr.length;
//        int[] arr = new int[size];
//        int countR = 0;
//        int countL = 0;
//        for (int i = 0; i < size; i++) {
//            if (countR == rightSize) {
//                arr[i] = leftArr[countL];
//                countL++;
//            } else if (countL == leftSize) {
//                arr[i] = rightArr[countR];
//                countR++;
//            } else {
//                if (leftArr[countL] < rightArr[countR]) {
//                    arr[i] = leftArr[countL];
//                    countL++;
//                } else {
//                    arr[i] = rightArr[countR];
//                    countR++;
//                }
//            }
//
//
//        }
//
//        for (int i = 0; i < size; i++) {
//            input[i] = arr[i];
//        }
//    }

    public static void main(String[] args) {
        int arr[] = {2,6,8,5,4,3};
         mergeSort(arr);

    }
}
