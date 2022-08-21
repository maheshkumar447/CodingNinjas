package Recursion;

public class ReplacePi {
    public static String replace(String input){
        if(input.length()==1){
            return input;
        }
        String r = replace(input.substring(1));
        if(input.charAt(0)=='p'){
            if(input.charAt(1)=='i'){
                return "3.14"+r.substring(1);
            }else{
                return input.charAt(0) + r;
            }
        }else{
            return input.charAt(0) +r;
        }

//        if(input.length()==2) {
//            if (input.charAt(0) == 'p' || input.charAt(1) == 'i') {
//                return "3.14";
//            }
//            else{
//                return input;
//            }
//        }
//        String smallANs = input.charAt(0) + replace(input.substring(1,input.length()-1))+input.charAt(input.length()-1);
//        return smallANs;

    }

    public static void main(String[] args) {
        String str = "xpix";
        String ans = replace(str);
        System.out.println(ans);
    }
}
