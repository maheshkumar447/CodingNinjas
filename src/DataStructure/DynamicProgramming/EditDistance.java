package DataStructure.DynamicProgramming;

public class EditDistance {


    public static int editDistance(String s1, String s2){

        if(s1.length() == 0){
            return s2.length();
        }

        if(s2.length() == 0){
            return s1.length();
        }

        if(s1.charAt(0) == s2.charAt(0)){
           return  editDistance(s1.substring(1),s2.substring(1));
        }else {
            int opt1 = editDistance(s1, s2.substring(1));  // case of insertion
            int opt2 = editDistance(s1.substring(1), s2);  // case of deletion
            int opt3 = editDistance(s1.substring(1), s2.substring(1));  // case of substitution

            return 1 + Math.min(opt1, Math.min(opt2, opt3));
        }

    }




    public static int editDistanceM(String s1, String s2){


        int m = s1.length();
        int n = s2.length();


        int storage[][] = new int[m+1][n+1];

        if(m == 0){
            storage[m][n] = n;
            return storage[m][n];
        }

        if(n == 0){
            storage[m][n]= m;
            return storage[m][n];
        }

        for(int i = 0;i<m+1;i++){
            for(int j = 0;j<n+1;j++){
                storage[i][j] = -1;
            }
        }

        if(storage[m][n] != -1){
            return storage[m][n];
        }

        if(s1.charAt(0) == s2.charAt(0)){
            storage[m][n] = editDistanceM(s1.substring(1),s2.substring(1));
        }else{
            int opt1 = editDistanceM(s1.substring(1),s2);
            int opt2 = editDistanceM(s1,s2.substring(1));
            int opt3 = editDistanceM(s1.substring(1),s2.substring(1));

            storage[m][n] = 1+ Math.min(opt1, Math.min(opt2, opt3));
        }

        return storage[m][n];

    }





    public static int editDistanceDP(String s1 , String s2){
        int m = s1.length();
        int n = s2.length();

        int storage[][] = new int[m+1][n+1];

        for(int j  = 0;j<=n;j++){
            storage[0][j] = j;
        }

        for(int i = 0;i<=m;i++){
            storage[i][0] = i;
        }

        for(int i =  1;i<=m;i++){
            for(int j =1;j<=n;j++){
                if(s1.charAt(m-i) == s2.charAt(n-j)){   // hum last se character check krenge
                    storage[i][j] = storage[i-1][j-1];
                }else{
                    storage[i][j] = 1 + Math.min(storage[i][j-1],Math.min(storage[i-1][j],storage[i-1][j-1]));
                }
            }
        }

        return storage[m][n];

    }

    public static void main(String[] args) {
        String s1 = "adefdfde";
        String s2 = "fdgbdedefd";

        System.out.println(editDistance(s1,s2));
        System.out.println(editDistanceM(s1,s2));
        System.out.println(editDistanceDP(s1,s2));
    }
}
