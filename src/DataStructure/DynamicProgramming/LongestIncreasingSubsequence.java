package DataStructure.DynamicProgramming;

public class LongestIncreasingSubsequence {

    public static int lis(int arr[]) {

        int storage[] = new int[arr.length];
        storage[0] = 1;
        int ans = 1;

        for(int i =1;i<storage.length;i++){
            int temp = 1;
            for(int j =i-1;j>=0;j--){
                if(arr[j] < arr[i]){  // mtlb pichla element chota h is element se to condition true i.e. our sequence is in increasing order
                    int output = storage[j] + 1;

                    if(output > temp){
                        temp = output;
                    }
                }
            }
            storage[i] = temp;
            if(temp > ans){
                ans = temp;
            }
        }

        return ans;

    }

    public static void main(String[] args) {

    }
}
