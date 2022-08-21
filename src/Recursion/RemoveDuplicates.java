package Recursion;

public class RemoveDuplicates {

    public static String removeDuplicates(String s) {
        // Write your code here

        if(s.length()==1){
            return s;
        }
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)){
                return s.charAt(0)+"";
            }
            else{
                return s;
            }
        }

        String myans = removeDuplicates(s.substring(1));

        if(s.charAt(0)==myans.charAt(0)){
            String temp = myans;
            myans = temp;
        }
        else{
            String temp = s.charAt(0)+myans;
            myans = temp;
        }
        return myans;

    }

    public static void main(String[] args) {
        String str = "aabccba";
        String ans = removeDuplicates(str);
        System.out.println(ans);

    }
}
