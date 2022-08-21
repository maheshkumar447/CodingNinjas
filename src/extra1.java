import java.util.Arrays;

public class extra1 {

    public static int[] func(int n , int arr[]){
        int result[] = new int[n];
        Arrays.fill(result,-1);
        for(int i =0;i<n;i++) {
            for (int j = i + 1; j < n; j++) {
                if (sum(arr[i]) < sum(arr[j])) {
                        result[i] = arr[j];
                        break;
                }else if(sum(arr[i])==sum(arr[j])){
                    if(arr[j]<=arr[i]){
                        continue;
                    }
                    result[i]=Math.max(arr[i],arr[j]);
                    break;
                }
            }
        }
        return result;
    }
    public static int sum(int n){
        int sum=0;
        while(n!=0){
            int digit = n%10;
            sum+=digit;
            n=n/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n=5;
        int arr[] ={11,7,14,2,6};
        int arr1[] = func(n,arr);
        for(int i=0;i<n;i++){
        System.out.println(arr1[i]);
        }
    }
}
