package DataStructure.DynamicProgramming;

public class MinimumCountOfSquare {

    public static int minCount(int n) {
        //Your code goes here
      int storage[] = new int[n+1];
      for(int i =0;i<n+1;i++){
          storage[i]= -1;
      }

      return minCountHelper(n,storage);
    }

    private static int minCountHelper(int n, int[] storage) {
        if(n == 0){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for(int i =1;i*i<=n;i++){
            if(storage[n - (i*i) ] == -1){
                storage[n-(i*i)] = minCountHelper(n-(i*i),storage);
            }
            int currentValue = storage[n-(i*i)];
            if(currentValue < ans){
                ans = currentValue;
            }
        }
        return ans+1;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(minCount(n));
    }

}
