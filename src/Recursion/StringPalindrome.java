package Recursion;

public class StringPalindrome {

    public static boolean isStringPalindrome(String input) {

        if(input.length()==0 || input.length()==1){
            return true;
        }

        if(input.length()==2){
            if(input.charAt(0) == input.charAt(1)){
                return true;
            }else{
                return false;
            }
        }

        if(input.charAt(0) == input.charAt(input.length()-1)){
            return isStringPalindrome(input.substring(1,input.length()-1));
        }else{
            return false;
        }

//        boolean smallAns = isStringPalindrome();




    }


    public static void main(String[] args) {
        String str = "racecar";
        boolean ans = isStringPalindrome(str);
        System.out.println(ans);
    }
}
