package Recursion;

public class ReplaceCharacter {

    public static String replaceCharacter(String input, char c1, char c2) {



        if(input.length()==1)
        {
            if(input.charAt(0)==c1) {
                return c2+"" ;}
            else {
                return input ;}
        }
        String myans = replaceCharacter(input.substring(1), c1, c2) ;
        if(input.charAt(0)==c1)
        {
            String temp = c2 + myans ;
            myans = temp ;
        }
        else
        {
            String temp = input.charAt(0) + myans ;
            myans = temp ;
        }
        return myans ;

    }

    public static void main(String[] args) {
        String str = "vyyv";
        char c1 = 'y';
        char c2 = 'v';

        String ans= replaceCharacter(str,c1,c2);
        System.out.println(ans);
    }
}
