package DataStructure.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MapUse {

    public static int PairSum(int[] input, int size) {
        if (size==0)
            return 0;

        HashMap<Integer,Integer>  map = new HashMap<>();
        int ans = 0;
        for(int i : input){
            if(map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }else{
                map.put(i,1);
            }
        }

        for(Integer j: map.keySet())
        {
            if (map.containsKey(-j) && j !=0) {

                ans = ans +(map.get(j)*map.get(-j));
            }
        }

        ans = ans/2;

        if(map.containsKey(0)){
            int val = map.get(0);
            ans = ans + (val * (val-1))/2;
        }

        return ans;

    }









    public static void printIntersection(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr1){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }

        for(int j : arr2){
            if(map.containsKey(j) && map.get(j)>0){
                System.out.println(j);
                map.put(j,map.get(j)-1);

            }
        }

    }







    public static int maxFrequencyNumber(int[] arr){
       HashMap<Integer,Integer> ans = new HashMap<>();
       for(int i : arr){
           if(ans.containsKey(i)){
               ans.put(i,ans.get(i)+1);
           }else{
               ans.put(i,1);
           }
       }

       int maxFreq = 0;
       int max = Integer.MIN_VALUE;
       for(int i: arr){
           if(maxFreq<ans.get(i)){
               maxFreq = ans.get(i);
               max = i;
           }
       }
       return max;
    }










    // problem: hme ek array given hogi to usme se hmne duplicates ko remove krke jo elements bachte h wo return krwane h ek arraylist me
    public static ArrayList<Integer> removeDuplicates(int a[]){
        ArrayList<Integer> output = new ArrayList<>(); // ek arraylist li jisme hum apna answer store krwa lenge
        HashMap<Integer , Boolean> seen = new HashMap<>(); // ek hashmap bna liya jisme ki key hogi ek integer type ki or value hogi boolean type ki
        // hme pta kaise chla ki kis type ki leni h key or values to wo depend krta h hmari approach kya h
        // yahan hmari approach h ki hum hashmap me array k elements dalenge but agar wo phle hee dle hue h to loop ko hum continue kr denge us key value ko skip kr denge
        // key as an integer mtlb array me elements integer type k honge or value boolean isiliye kyunki hum check krenge ki kya ye value h hashmap me ya nhi i.e. by true or false

        for(int i =0;i<a.length;i++){
            if(seen.containsKey(a[i])){  // agar value phle se hui to continue krdo
                continue;
            }

            output.add(a[i]);  // agar phle se nhi h to add krdo
            seen.put(a[i],true);  // or sath ki sath hashmap me b insert krdo or usko mark krdo as true ki haa aa chuka h hashmap me taaki agli baar aayte to containsKey wali condition true ho ske

        }

        return output;

    }







    public static void main(String[] args) {
        /*
        HashMap<String, Integer> map =new HashMap<>();   // hashmap bnaya with key value pair as String and Integer

        //Insertion in Map
        map.put("abc",1);  //put function se inert kiya h map me or ye sara kaam O(1) me ho rha h kyunki hum hashmap use kr rhe h
        map.put("def",2);


        // size

        System.out.println("size: " + map.size());   // ye map ka size return krdega
        // agar keys repeat ho rhi h to ye unko ek baar hee consider krega mtlb agar map.put("abc",1);  ye kiya to wo usko size me consider nhi krega uska size 1 hee rhega




        // check presence
        if(map.containsKey("abc")){  // check krna ho ki koi key h hmare hashmap me ya nhi to method iske liye containsKey(), brackets me key pass krni h
            System.out.println("Has abc");
        }


        //get value

        // hme value milegi corresponding to key
        int v = map.get("abc");  // abc key k corresponding value de dega
        System.out.println(v);
        // agar hmne get function me aisi key pass kri jo h hee nhi hmare hashmap me to hmare pass error aayega i.e. null pointer exception
        // so to avoid this exception we write this as


        int a = 0;
        if(map.containsKey("abc")){ // agar ey key hogi to hee uski value print krwayega nhi to ye 0 return krdega
            a = map.get("abc");
        }
        System.out.println(a);


        // remove
       int s  =  map.remove("abc");  // key pass krte h is fuction me b
        System.out.println(s);  // delete ki hui value lake de dega


        if(map.containsValue(2)){  // ye value ko dhundega  pure hashmap me or iski time complexity O(1)  nhi hogi jbki O(n) hogi
            // dhyan rhe jo b operation value pe lgega wo O(n) ki complexity ka hoga or jo b key pr lgega wo O(1) ki ka hoga
            // so ye O(n) me kaam krega
            System.out.println("has 2 as value");

        }




        // iterate

        Set<String> keys = map.keySet(); // it returns all the keys or un keys ko Set me store krwa liya
        for(String str : keys){ // for each loop
            System.out.println(str);
        }


         */




        int a[] = {1,3,2,4,1,2,2,2,1000,3,2 };
        ArrayList<Integer> output = removeDuplicates(a);
        for(int i =0;i<output.size();i++){
            System.out.println(output.get(i));
        }




    }
}
