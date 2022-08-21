package Recursion;

public class FirstIndexOfNumber {

    public static int firstIndex(int input[], int x) {

        return myIndex(input,0,x);
    }

    public static int myIndex(int input[],int startIndex,int x){
        if(startIndex==input.length){
            return -1;

        }
        if(input[startIndex] == x){
            return startIndex;
        }
//        int smallAns =  firstIndex(input,startIndex+1,x);
//
//        return smallAns;

        return myIndex(input,startIndex+1,x);
    }


    public static void main(String[] args) {
        int arr[] = {9,8,10,8};
        int x = 8;
        int ans = firstIndex(arr,x);
        System.out.println(ans);

    }
}
