package Recursion;

public class StringToInteger {

    public static int convertStrToInt(String input,int i){
        if(input.length()==0){
            return 0;
        }
        return ((int)input.charAt(0)-48)*(int)(Math.pow(10,i)) + convertStrToInt(input.substring(1),i-1);


    }

    public static int convertStringToInt(String input){
        return convertStrToInt(input,input.length()-1);

    }
    public static void main(String[] args) {
        String str = "123456";
        int ans = convertStringToInt(str);
        System.out.println(ans);

    }
}
