package DataStructure.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KnapSack {


    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {

        return knapsackHelper(weights,values,maxWeight,0);

    }

    private static int knapsackHelper(int[] weights, int[] values, int maxWeight, int i) {  // yahan i wo index h jis index ki value ko hum traverse kr rhe h

        if (i == weights.length || maxWeight == 0) {  // ye hmara base case h ki agar hum array ko puri taverse kr chukr h mtlb i jo h wo last index wale element ko b cover kr chuka to return 0
            return 0;   // dusra base case i.e. maxWeight = 0 wala ki hmara bag full ho gya h ya phir ye kh skte h ki hmare bag me space nhi h ab kyunki ab uski capacity  0 ho chuki h to b return 0 krdo
        }

        if (weights[i] > maxWeight) { // agar kisi element ka weight bag k weight se bda h to wo nhi aa skta bag me to usko neglect krna pdega
            return knapsackHelper(weights, values, maxWeight, i + 1); // recursive call krdi usse agle elements k liye kyunki hme ye cnfrm ho gya ki kuch b ho jaye ith index wala element kbhi b answer me nhi aayga mtlb bag me nhi aayega
        } else {
            // agar uska weight chita h to hmare pass do option honge which is ya to hum include kre isko ya na kre

            // 1st case agar include krte h to
            int opt1 = values[i] + knapsackHelper(weights, values, maxWeight - weights[i], i + 1);
            // uper wali line ki explanantion : agar include kiya to hmare ans me ith index ki value add ho gyi so values[i] add kiya
            // maxWeight jo tha wo km ho jayega ith index k weight se kyunki utne weight ki cheex hmare bag me aa chuki hogi
            // or hum recursive call krenge i+1 index se aage k liye


            // agar include nhi kiya to
            int opt2 = knapsackHelper(weights, values, maxWeight, i + 1);
            // uper wali line ki explanation: agar include nhi kiya to add b kuch nhi hua hmare ans me or na hee maxWeight ki value km hui or hme aage traverse krna h i+1 index se


            return Math.max(opt1, opt2);  // dono options ka maximum
        }


    }



        public static int knapsacDP(int[] weight, int[] value, int n, int maxWeight) {
/*
            int storage[][] = new int[weight.length+1][maxWeight+1];
            for(int i =1;i<storage.length;i++){
                for(int j = 1;j<storage[0].length;j++){
                    if(j >= weight[i-1]){
                        int remainingMaxWeight = j- weight[i-1];
                        if(storage[i-1][remainingMaxWeight] + value[i-1] > storage[i-1][j]){
                            storage[i][j] = storage[i-1][remainingMaxWeight] + value[i-1];
                        }else{
                            storage[i][j] = storage[i-1][j];
                        }
                    }else{
                        storage[i][j] = storage[i-1][j];
                    }
                }
            }

            return storage[weight.length][maxWeight];


 */

            int[][] dp = new int[n+1][maxWeight+1];
            for (int i=n-1;i>=0;i--)
            {
                for (int w=0;w<=maxWeight;w++)
                {
                    if (weight[i]<=w)
                    {
                        int ans1=dp[i+1][w];
                        int ans2=dp[i+1][w-weight[i]] + value[i];
                        dp[i][w]=Math.max(ans1, ans2);
                    }
                    else
                    {
                        dp[i][w]=dp[i+1][w];
                    }
                }
            }
            return dp[0][maxWeight];  // yahan dp ka first index 0 isiliye h kyunki hmara ans first row k last element pr pda hoga

        }


    public static void main(String[] args) {
        int weights[] = {6,1,2,4,5};
        int values[] = {10,5,4,8,6};

        int maxWeight = 5;
        System.out.println(knapsack(weights,values,5,maxWeight));
    }
}
