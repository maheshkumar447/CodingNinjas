package Recursion;

public class CheckNumberInArray {

    public static boolean checkNumber(int input[], int x) {
//        if(input.length==0){
//            return true;
//        }
//
//        if(input[0]==x){
//            return true;
//        }
//        if(input[0]==x){
//            return true;
//        }
//
//        int smallArr[] = new int[input.length-1];
//        for(int i =1;i<input.length;i++){
//            smallArr[i-1]= input[i];
//        }
//        if(x!=smallArr[0]){
//            return false;
//        }else{
//            return true;
//        }
////        boolean smallAns = checkNumber(smallArr,x);
//
//        return smallAns;
        return check(input, 0, x);

    }

    public static boolean check(int[] input, int startIndex, int x) {
        if (startIndex == input.length) {
            return false;
        }

        if (input[startIndex] == x) {
            return true;
        }
        return check(input, startIndex + 1, x);

    }

    public static void main(String[] args) {
        int arr[] = {9,8,10};
        int x  = 8;
        boolean ans = checkNumber(arr,x);
        System.out.println(ans);


    }
}
