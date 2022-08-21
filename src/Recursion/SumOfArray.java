package Recursion;

public class SumOfArray {
    public static int sum(int input[]) {

        if(input.length==0){
            return 0;
        }
        int sum1 = input[0];
        int smallArr[] = new int[input.length-1];
        for(int i =1;i<input.length;i++){
            smallArr[i-1] = input[i];
        }
        sum1 =  sum1+sum(smallArr);
        return sum1;


    }
    public static void main(String[] args) {
        int arr[] = {9,8,9};
      int ans=  sum(arr);
        System.out.println(ans);
    }
}
