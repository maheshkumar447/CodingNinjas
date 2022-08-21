package DataStructure.DynamicProgramming;

public class StairCaseProblem {

    public static long staircase(int n) {
        //Your code goes here

//        if(n==0 || n==1){
//            return 1;
//        }else if(n==2){
//            return 2;
//        }else {
//            return staircase(n-1)+staircase(n-2)+staircase(n-3);
//        }

        if(n==0 || n==1){
            return 1;
        }else if(n==2) {
            return 2;
        }

        long storage[] = new long[n+1];
        storage[0] = 1;
        storage[1] = 1;
        storage[2] = 2;

        for(int i = 3;i<=n;i++){
            storage[i] = storage[i-1]+storage[i-2]+storage[i-3];
        }

        return storage[n];

    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(staircase(n));
    }

}
