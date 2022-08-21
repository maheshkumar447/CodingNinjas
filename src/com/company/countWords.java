package com.company;

public class countWords {

    public static int countWords(String str) {
        //Your code goes here

        int count =0;
        if(str.length()==0){
            return 0;
        }
        else{
            for(int i =0;i<str.length();i++){
                if(str.charAt(i) == ' '){
                    count++;
                }
                else{
                    continue;
                }
            }
        }
        return count+1;
    }

    public static void main(String[] args) {

    }
}
