package DataStructure.DynamicProgramming;

public class LongestCommonSequence {

    // for explanation of this question and solution please refer to notebook
    public static int lcs(String s, String t) {
        if (s.length() == 0 || t.length() == 0) { // this is a base case i.e. agar kisi ki b length 0 h to final ans to 0 hee aayega kyunki common to kuch hua he nhi
            return 0;
        }

        if (s.charAt(0) == t.charAt(0)) {
            return 1 + lcs(s.substring(1), t.substring(1));  // agar phla character match kr gya to recursive call krenge har character k liye aage puri string me dono me
        } else {  // agar phla character match nhi kra to.... to wo teeno case jo notebook me describe h
            int op1 = lcs(s, t.substring(1));
            int op2 = lcs(s.substring(1), t);

            // phle is case ko uncomment krke smjho
//            int op3 = lcs(s.substring(1),t.substring(1));  // ye hmne teesra case bna diya but agar hum is case ko na b likhe to b hmara ans same aayega
            // kyunki ye case op1 or op2 me complete ho chuka h phle hee to alag se likhne ki jrurt nhi abhi hmne ye case sirf smjhne k liye likha h
//            return Math.max(op1,Math.max(op2,op3));   // op3 uncomment hoga to isko b uncomment krna pdega

            return Math.max(op1, op2);
        }
    }







    public static int lcsM(String s, String t){
            int storage[][] = new int[s.length()+1][t.length()+1];
            for(int i =0;i<s.length()+1;i++){  // yahan +1 isiliye kyunki storage array ki length +1 tk h
                for(int j =0 ;j<t.length()+1;j++){
                    storage[i][j] = -1;
                }
            }
            
            return lcsMHelper(s,t,storage);
    }

    private static int lcsMHelper(String s, String t, int[][] storage) {
        int m = s.length();
        int n = t.length();

        if(storage[m][n] != -1){
            return storage[m][n];
        }

        if(m == 0 || n == 0){
            storage[m][n] = 0;
            return storage[m][n];
        }

        if(s.charAt(0) == t.charAt(0)){
            storage[m][n] = 1 + lcsMHelper(s.substring(1), t.substring(1) , storage);
        }else{
            int op1 = lcsMHelper(s , t.substring(1),storage);
            int op2 = lcsMHelper(s.substring(1) , t, storage);

            storage[m][n] = Math.max(op1 , op2);
        }

        return storage[m][n];

    }








    public static int lcsDP(String s, String t){
        int m = s.length();
        int n = t.length();

        int storage[][] = new int[m+1][n+1];

        // base case ....i.e. first row ki saari values 0
        for(int i =0;i<m;i++){
            storage[0][i] = 0;
        }

        // base case...i.e. first column ki saari values 0
        for(int j =0;j<n;j++){
            storage[j][0] = 0;
        }

        for(int i =1;i<=m;i++){  // dhyan rhe yahan <= aayega
            for(int j = 1;j<=n;j++){ // yahan b <= aayega
                if(s.charAt(m-i) == t.charAt(n-j)){   // yahan indexing (m-i) or (n-j) isiliye aayi kyunki hum last se index check kr rhe h , hum starting se nhi kr rhe count hum last se kr rhe h
                    storage[m][n] = 1 + storage[i-1][j-1];
                }else{
                    storage[m][n] = Math.max(storage[i][j-1] , storage[i-1][j]);
                }
            }
        }

        return storage[m][n];

    }



    public static void main(String[] args) {
        String s = "abegi";
        String t = "adgei";

        System.out.println(lcs(s,t));
        System.out.println(lcsM(s,t));

    }
}
