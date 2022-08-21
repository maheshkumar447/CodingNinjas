package Recursion;

public class PairStar {

    public static String addStars(String s) {

        if(s.length()<=1){
            return s;
        }
        String smallAns = addStars(s.substring(1));
        if(s.charAt(0)==smallAns.charAt(0)){
            return s.charAt(0)+"*"+smallAns;
        }else{
            return s.charAt(0)+smallAns;
        }

    }

    public static void main(String[] args) {
        String str = "hello";
        String ans = addStars(str);
        System.out.println(ans);

    }
}
