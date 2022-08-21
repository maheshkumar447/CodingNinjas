package com.company;

public class checkPalindrome {

    public static boolean isPermutation(String str1, String str2) {
        //Your code goes here
        boolean isPerm = true;
        int al[] = new int[256];
        int bl[] = new int[256];
        for(char c: str1.toCharArray()){
            int index = (int)c;
            al[index]++;
        }
        for(char c:str2.toCharArray()){
            int index = (int) c;
            bl[index]++;
        }

        for(int i =0;i<256;i++){
            if(al[i] != bl[i]){
                isPerm = false;
                break;

            }
        }
        return isPerm;
    }

    public static void main(String[] args) {

    }
}
