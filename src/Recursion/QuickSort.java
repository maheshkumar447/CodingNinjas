package Recursion;

public class QuickSort {

    public static int[] quickSort(int[] input){
        quickSort(input,0,input.length-1);
        return input;
    }

    public static void quickSort(int[] input, int start,int end){
        if(start>=end){
            return;
        }
        int pivotPosAns = partition(input,start,end);
        quickSort(input,start,pivotPosAns-1);
        quickSort(input,pivotPosAns+1,end);
    }

    public static int partition(int[] input, int start, int end){
        int i = start, j = end;

        int count = 0;
        for(int x = start;x<=end;x++) {
            if (input[start] > input[x]) {
                count++;
            }
        }

            int pivotPos = start+count;
            swap(input,start,pivotPos);


            // saare chote left me or saare bde right me lane k liye

            while(i<=pivotPos -1 && j>=pivotPos+1){
            while(input[i]<input[pivotPos]){
                i++;
            }
            while(input[j]>=input[pivotPos]){
                j--;
            }
            if(i>=pivotPos || j<=pivotPos){
                break;
            }else{
                swap(input,i,j);
            }

        }
        return pivotPos;
    }

    public static void swap(int[] input, int i,int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {2,6,8,5,4,3};
        quickSort(arr);
        for( int i =0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }

    }
}
