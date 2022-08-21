package DataStructure.DynamicProgramming;


public class BalancedBT {

    // ques: hme koi height given hogi usse hmne ye btana h ki kitne max possible balanced binary tree bn skte h
    // balanced k liye (left subhtree ki hgt-right subtree ki hgt) <=1
    // logic: hme pta h ki overall tree ki hgt H+1 hoti h to iska mtlb balanced hne k liye dono subtree me se ek ki hgt to km se km H-1 to honi hee chiyea
    // first case : suppose hme left subtree ki hgt given h H-1 to kya kya possible values hi skti h right subtree ki jisse ki wo balanced rhe
    // so first possible value is that right subtree ki b hgt H-1 ho
    // second possibility ki left subtree ki height right subtree ki height se ek choti ho so ritgh ki height H-2 b ho skti h
    // now do vice verse ... right ki height hme given h i.e. H-1 to hmare pass right k liye kya kya options hi skte h
    // right k liye hmare pass H-1 ho skta h or H-2 which is similar to prevoius case
    // but hmara in dono me ek case common aa gya which is doonki height H-1 ..ye case do baar aa gya
    // is case ko hum ek baar hee consider krenge so now we have total of three scenarios which are (H-1, H-1) (H-2,H-1) (H-1,H-2)

    // now suppose case of (H-1,H-2) then from left subtree suppose hmare pass X total balaced tree aa skte h or right se i.e. H-2 wali side se Y tree aa skte h
    // to hmare pass total tree ho jayenge X * Y .... agar X=6 and Y= 3 then total trees are 18
    // same with (H-2, H-1) .. we have total trees = Y * X
    // from case of( H-1, H-1) we have X * X
    // and now final answer or final totail is sum of all three cases so (X * Y ) + (Y * X) + (X * X)
    // = X*X + 2*X*Y


    // so for left and right subtree we apply recursion
    public static long balancedBTs(long n){


            if(n==1  || n==0){
                return 1;
            }
            int mod = (int) Math.pow(10,9)+7;  // isi no ka mod nikalna pdega or isiliye nikala taaki wo long ki rang se bhar na jaye
            long x = balancedBTs(n-1);
            long y = balancedBTs(n-2);

            long temp1 = (x*x)%mod; // ho skta h x*x hee range se bhar chla jaye to uska b mod nikala
            long temp2 = (2*x*y)%mod; // iska b mod nikala pdega

            long ans = (temp1 + temp2)  %mod;
            return ans;


    }


    // By DP
    public static int balancedBTs(int height){
        if(height == 0){
            return 1;
        }
        int arr[] = new int[height + 1];

        arr[0] = arr[1] = 1;
        int mod = (int)Math.pow(10,9)+7;
        for (int i = 2;i<=height;i++){
            long temp1 = (long)(arr[i-1]) * arr[i-1];
            temp1 = temp1 % mod;
            long temp2 =2* (long) (arr[i-1]) * arr[i-2];
            temp2 = temp2%mod;
            arr[i] = (int) (temp1 + temp2) % mod;
        }

        return arr[height];


    }



}