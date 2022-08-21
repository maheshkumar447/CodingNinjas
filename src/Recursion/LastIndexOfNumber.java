package Recursion;

public class LastIndexOfNumber {

    public static int myIndex(int input[],int startIndex,int x){
       if(startIndex==input.length){
           return -1;
       }
       int index=  myIndex(input,startIndex+1,x);
       if(index==-1){
           if(x==input[startIndex]){
               return startIndex;
           }
           else{
               return -1;
           }
       }
       else{
           return index;
       }
    }

    public static int lastIndex(int input[], int x) {
        return myIndex(input,0,x);
    }
    public static void main(String[] args) {
        int arr[] = {9,8,10,8};
        int x = 8;
        int ans = lastIndex(arr,x);
        System.out.println(ans);
    }
}
