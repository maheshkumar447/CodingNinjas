package DataStructure.Graphs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HasPath {
    public static void hasPath(int edges[][] , int v1, int v2, boolean visited[] ){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v1);

        int n = edges.length;

        while(!queue.isEmpty()){
            int front = queue.remove();
            visited[front] =  true;

            if(front == v2){
                System.out.println("true");
                return;
            }

            for(int  i = 0;i<n;i++){
                if(edges[front][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        System.out.println("false");

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        int edges[][] = new int[n][n];

        for(int i = 0;i<e;i++){
            int firstVertex = sc.nextInt();
            int secondVertex = sc.nextInt();

            edges[firstVertex][secondVertex] = 1;
            edges[secondVertex][firstVertex] = 1;

        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        boolean visited[] = new boolean[edges.length];

        hasPath(edges,v1,v2,visited);

    }

}
