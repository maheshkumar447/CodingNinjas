package Recursion;


public class CheckArray {

    public static boolean checkSorted(int arr[]){
        if(arr.length<=1){
            return true;
        }

        int smallArr[] = new int[arr.length-1];
        for(int i =1;i<arr.length;i++){
            smallArr[i-1] = arr[i];

        }

        boolean smallAns = checkSorted(smallArr);

        if(!smallAns){
            return false;
        }

        if(arr[0]<arr[1]){
            return true;
        }else{
            return false;
        }


    }

    public static boolean checkSorted1(int arr[]){
        if(arr.length<=1){
            return true;
        }
        if(arr[0]>arr[1]){
            return false;
        }
        int smallArr[] = new int[arr.length-1];
        for(int i =1;i<arr.length;i++){
            smallArr[i-1] = arr[i];

        }
        boolean smallAns = checkSorted1(smallArr);
        return smallAns;
    }

    public static boolean checkSortedBetter(int arr[],int startIndex){
        if(startIndex>=arr.length-1){
            return true;
        }
        if(arr[startIndex]>arr[startIndex+1]){
            return false;
        }

        boolean smallAns = checkSortedBetter(arr,startIndex+1);
        return smallAns;

    }

    public static void main(String[] args) {
        int input[] = {1,2,3,6,9};
//        boolean ans = checkSorted(input);
        boolean ans = checkSortedBetter(input,0);
        System.out.println(ans);
    }
}
