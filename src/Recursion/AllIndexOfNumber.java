package Recursion;

public class AllIndexOfNumber {

    public static int[] myIndex(int input[],int startIndex,int x){
        int myArr[];
        if(startIndex==input.length){
            myArr = new int[0];
            return myArr;
        }

        int index[] = myIndex(input,startIndex+1,x);

        if(input[startIndex]==x){
            int totalIndex[] = new int[(index.length)+1];
            totalIndex[0] = startIndex;
            for(int i =0;i<index.length;i++){
                totalIndex[i+1] = index[i];
            }
            return totalIndex;
        }else{
            return index;
        }




    }

    public static int[] allIndexes(int input[], int x) {
        return myIndex(input,0,x);

    }
    public static void main(String[] args) {
        int arr[] = {9,8,10,8,8};
        int x = 8;
        int ans[] = allIndexes(arr,x);
        for(int i =0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
