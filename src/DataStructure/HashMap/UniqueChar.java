package DataStructure.HashMap;
import java.util.ArrayList;
import java.util.HashMap;


public class UniqueChar {
    public static String uniqueChar(String str){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        String ans = "";
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                continue;
            }else{
                ans = ans+str.charAt(i);
                map.put(str.charAt(i),1);
            }
        }
        return ans;

    }






    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();
        for(int i =0;i<arr.length;i++){
            map.put(arr[i],1);
        }

        int overAllCount = 0; // jitne b elements honge consecutive wale unka count krega ye
        int maxStart = Integer.MIN_VALUE;  // agar kai consecutive series h to unme se maxStart wala isme store krwayenge

        for(int i =0;i<arr.length;i++){
            if( !map.containsKey(arr[i]-1)){ // jp element hum traverse kr rhe h usse pichla element check kr rhe h , for example array ka element h 5 to hum 4 ko check krenge
                int currentCount  = 1;  // agar nhi hua wo element map me to currentCount =1 rhega mtlb sirf 5 hee h abhi
                int currentStart = arr[i];   // or usi 5 ko currentStart me rkh diya

                while(map.containsKey(currentStart+1)){   // yahan check kiya agle wala mtlb 6 check hoga yahan
                    currentCount++;   // agar 6 h map me to currentCount ko ek se bdha do
                    currentStart = currentStart+1;  // or start ko b ek se
                }

                if(currentCount > overAllCount){  // last me ye dekhenge ki konsa count jyada h
                    overAllCount = currentCount;
                    maxStart = arr[i]; // jis element k corresponding jyada count mila h usko hum maxStart de denge
                }
            }
        }

        output.add(maxStart);   // arraylist me add krwa diya shuru wala index
        output.add(maxStart,overAllCount-1);   // last wala index

        return output;  // arraylist return krwadi

    }







    public static int getPairsWithDifferenceK(int arr[], int k) {
        //Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        if(k!=0)
        {
            for(int i =0;i<arr.length;i++)
            {
                int p1 = arr[i]+k;
                int p2 = arr[i]-k;

                if(map.containsKey(p1))
                {
                    count+=map.get(p1);
                }
                if(map.containsKey(p2))
                {
                    count+=map.get(p2);
                }

                if(!map.containsKey(arr[i]))
                {
                    map.put(arr[i],1);
                }
                else if(map.containsKey(arr[i]))
                {
                    int value = map.get(arr[i]);
                    value++;
                    map.put(arr[i],value);
                }
            }
        }
        if(k==0)
        {
            for(int i =0;i<arr.length;i++)
            {
                if(!map.containsKey(arr[i]))
                {
                    map.put(arr[i],1);
                }
                else if(map.containsKey(arr[i]))
                {
                    int value = map.get(arr[i]);
                    value++;
                    map.put(arr[i],value);
                }

            }


            for(int i =0;i<arr.length;i++){
                int n = map.get(arr[i]);
                if(n>0){
                    count += (n*(n-1)/2);
                    map.put(arr[i],0);
                }
            }
        }

        return count;
    }







    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        // Write your code here

        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = -1;

        for(int i =0;i<arr.length;i++){
            sum = sum+arr[i];

            if(sum == 0){
                maxLen = i+1;
            }

            if(map.containsKey(sum)){

                int prevIndex = map.get(sum);
                int currentLength = i - prevIndex;

                if(currentLength > maxLen){
                    maxLen = currentLength;
                }
            }
            else{
                map.put(sum,i);
            }

        }

        return maxLen;

    }
}
