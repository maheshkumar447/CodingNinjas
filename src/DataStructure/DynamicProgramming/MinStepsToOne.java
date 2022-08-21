package DataStructure.DynamicProgramming;

public class MinStepsToOne {

    public static int countMinStepsToOne(int n) {
        //Your code goes here
        if(n<=1){
            return 0;
        }
        if(n==2 || n==3){
            return 1;
        }
        int countoption1 = Integer.MAX_VALUE;
        int countoption2 = Integer.MAX_VALUE;
        int countoption3 = countMinStepsToOne(n-1);

        if(n%2 == 0){
            countoption1 = countMinStepsToOne(n/2);
        }

        if(n%3 == 0){
            countoption2 = countMinStepsToOne(n/3);
        }

        return Math.min(countoption1,Math.min(countoption2,countoption3)) + 1; // +1 isiliye kiya kyunki recursion us step ko chrd rha h jisse ki hum root se uske first child tk aayr h
    }






    public static int countMinExtraSolution(int n){
        if(n==1){
            return 0;
        }

        int op1 = countMinExtraSolution(n-1);
        int minSteps = op1;

        if(n%3 == 0){
            int op2 = countMinExtraSolution(n/3);
            if(op2<minSteps){
                minSteps= op2;
            }
        }

        if(n%2 == 0){
            int op3 = countMinExtraSolution(n/2);
            if(op3 < minSteps){
                minSteps = op3;
            }
        }

        return minSteps+1;
    }










    public static int countStepMemoization(int n){
        int storage[] = new int[n+1];
        return countStepMemoizationHelper(n,storage);
    }

    private static int countStepMemoizationHelper(int n, int[] storage) {
        if(n==1){
            storage[n] = 0;
            return storage[n];
        }

        if(storage[n] != 0){  // 0 nhi h to iska mtlb hmne calculate krliya to simple return krwado
            return storage[n];
        }

        // agar nhi kiya calculate to answer nikalo ....uper wale tarike se

        int op1 = countStepMemoizationHelper(n-1,storage);
        int minSteps = op1;

        if(n%3 == 0){
            int op2 = countStepMemoizationHelper(n/3,storage);
            if(op2<minSteps){
                minSteps= op2;
            }
        }

        if(n%2 == 0){
            int op3 = countStepMemoizationHelper(n/2,storage);
            if(op3 < minSteps){
                minSteps = op3;
            }
        }
        storage[n] = minSteps+1;
        return storage[n];
    }








    public static int countMinStepToOneDP(int n){
        if(n<=1){
            return 0;
        } else if(n==2 || n==3){
            return 1;
        }

        int storage[] = new int[n+1];
        for(int i = 0;i<n+1;i++){
            storage[i] = -1;
        }

        storage[1] = 0;
        storage[2] = 1;
        storage[3] = 1;

        for(int i = 4; i<=n;i++){
            int option1 = storage[i-1];
            int option2 = Integer.MAX_VALUE;
            int option3 = Integer.MAX_VALUE;

            if(i%2 == 0){
                option2 = storage[i/2];

            }

            if(i%3 == 0){
                option3 = storage[i/3];
            }

            storage[i] = Math.min(option1,Math.min(option2,option3))+1;
        }

        return storage[n];

    }


    public static int countStepsDp(int n){
        int storage[] = new int[n+1];
        storage[1] = 0;

        for(int i =2;i<=n;i++){
            int min = storage[i-1];
            if(i%3 == 0){
                if(min > storage[i/3]){
                    min = storage[i/3];
                }
            }
            if(i%2 == 0){
                if(min>storage[i/2]){
                    min = storage[i/2];
                }
            }
            storage[i] = min+1;
        }
        return storage[n];

    }

    public static void main(String[] args) {
        int n = 1000;
//        int n = 1000;
        System.out.println(countMinStepsToOne(n));
        System.out.println(countMinStepToOneDP(n));
        System.out.println(countMinExtraSolution(n));
        System.out.println(countStepMemoization(n));
        System.out.println(countStepsDp(n));
    }
}
