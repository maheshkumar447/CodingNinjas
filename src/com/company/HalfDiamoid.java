package com.company;

import java.util.Scanner;

public class HalfDiamoid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i, j;

        // Loop to print the upper half
        // diamond pattern
        for (i = 0; i < N; i++)
        {
            for (j = 0; j < i + 1; j++)
                System.out.print("*");
            System.out.print("\n");
        }

        // Loop to print the lower half
        // diamond pattern
        for (i = 1; i < N; i++)
        {
            for (j = i; j < N; j++)
                System.out.print("*");
            System.out.print("\n");
        }
    }
}
