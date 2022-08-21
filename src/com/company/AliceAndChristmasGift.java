package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class AliceAndChristmasGift {
    public static long solve(int n, int A[], int B[]){
        int sum_a=0;
        int sum_b=0;
        ArrayList<Integer> A_odd = new ArrayList<>();
        ArrayList<Integer> A_even = new ArrayList<>();
        ArrayList<Integer> B_odd = new ArrayList<>();
        ArrayList<Integer> B_even= new ArrayList<>();
        for(int i=0;i<n;i++){
            sum_a +=A[i];
            if(A[i]%2 == 0){
                A_even.add(A[i]);
            }else{
                A_odd.add(A[i]);
            }
        }
        for(int i=0;i<n;i++){
            sum_b +=B[i];
            if(B[i]%2==0){
                B_even.add(B[i]);
            }else{
                B_odd.add(B[i]);
            }
        }
        if(A_even.size()!=B_even.size()){
            return -1;
        }
        else if(sum_a!=sum_b){
            return -1;
        }
        Collections.sort(A_odd);
        Collections.sort(A_even);
        Collections.sort(B_odd);
        Collections.sort(B_even);
        int count = 0;
        for(int i=0;i<A_odd.size();i++){
            count+=helper(A_odd.get(i),B_odd.get(i));
        }
        for(int i=0;i<A_even.size();i++){
            count+=helper(A_even.get(i),B_even.get(i));
        }
        return count/2;
    }

    public static long helper(int a, int b){
        return Math.abs(a-b)/2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A[] = new int[n];
        int B[] = new int[n];
        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            B[i] = sc.nextInt();
        }

        long ans = solve(n,A,B);
        System.out.println(ans);

    }
}
