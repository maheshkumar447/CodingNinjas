package DataStructure.DynamicProgramming;

public class MinimumCostPath {


    // RECURSIVE
    public static int minCostPath(int[][] input) {
        //Your code goes here
        return minCostPathHelper(input,0,0);
    }

    private static int minCostPathHelper(int[][] input, int i , int j) {
        int rows = input.length;
        int cols = input[0].length;

        if(i==rows-1  && j == cols-1){
            return input[i][j];
        }

        if(i >=  rows || j >= cols){
            return Integer.MAX_VALUE; // agar i i ki value no of rows se b jyada ho gyi to ye return kr jayega (remeber case of last row) , same thing in case of column or j
        }

        int path1 = minCostPathHelper(input,i+1,j);
        int path2 = minCostPathHelper(input, i+1,j+1);
        int path3 = minCostPathHelper(input,i,j+1);

        return input[i][j] + Math.min(path1, Math.min(path2,path3));

    }








    // MEMOIZATION
    public static int minCostPathM(int[][] input) {
        //Your code goes here
        // Jo hmari storage array bnti h memoization k case me wo yahan (m * n) size ki bnegi kyunki har row k loye har column pr jayega treversal
        // sp storage array ka size (m*n) or 2D matrix bnegi na ki single dimension matrix
        // memoization isikiye kiya kyunki yahan b kaafi redundancy aa rhi thi kaafi steps repeat ho rhe the jaise ki (1,0) ek baar nikal liya to wo phir se chyiea gtha to dobara nikala
        
        int rows = input.length;
        int cols = input[0].length;
        
        int storage[][] = new int[rows][cols];
        for(int i = 0;i<rows;i++){   // puri array me -1 daal diya har index pe
            for(int j =0;j<cols;j++){
                storage[i][j] = -1;
            }
        }
        return minCostPathHelper1(input,0,0, storage);

    }

    private static int minCostPathHelper1(int[][] input, int i, int j, int[][] storage) {
        int rows = input.length;
        int cols = input[0].length;

        if(i >=rows || j >= cols){
            return Integer.MAX_VALUE;
        }

        if(i == rows-1 && j == cols-1){
            storage[rows-1][cols-1] = input[i][j];
            return storage[i][j];
        }

        if(storage[i][j] != -1){ // mtlb phle calculate ho chuke h wo
            return storage[i][j];
        }

        int path1 = minCostPathHelper1(input,i+1, j , storage);
        int path2  = minCostPathHelper1(input, i+1, j+1, storage);
        int path3 = minCostPathHelper1(input,i,j+1,storage);

       storage[i][j] =  input[i][j] + Math.min(path1,Math.min(path2,path3));
       return storage[i][j];

    }







    public static int minCostPathDP(int input[][]){
        int rows = input.length;
        int cols = input[0].length;

        int storage[][] = new int[rows][cols];

        storage[rows-1][cols-1] = input[rows-1][cols-1];

        // last row
        for(int j = cols-2;j>=0;j--){
            storage[rows-1][j] = storage[rows-1][j+1] + input[rows-1][j];
        }

        // last column
        for(int i = rows-2;i>=0;i--){
            storage[i][cols-1] = storage[i+1][cols-1] + input[i][cols-1];
        }


        // for rest elements
        for(int i = rows-2;i>=0;i--){
            for(int j = cols-2;j>=0;j--){
                storage[i][j] = input[i][j] + Math.min(storage[i][j+1] , Math.min(storage[i+1][j+1] , storage[i+1][j]));
            }
        }

        return storage[0][0];
    }



    public static void main(String[] args) {
        int arr[][] ={{1,1,1} , {4,5,2}, {7,8,9}};
        System.out.println(minCostPath(arr));


        System.out.println(minCostPathM(arr));

        System.out.println(minCostPathDP(arr));
    }
}
