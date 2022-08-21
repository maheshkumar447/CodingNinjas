package DataStructure.Graphs;

import java.io.IOException;
import java.util.Scanner;

public class IsConnected {

    public static void isConnectedHelper(int edges[][] , int startingVertex, boolean[] visited){
        int n = edges.length;
        visited[startingVertex] = true;

        for(int i =0;i<n;i++){
            if(edges[startingVertex][i] == 1 && !visited[i]){
                isConnectedHelper(edges,i,visited);
                visited[i] = true;
            }
        }

    }



    public static boolean isConnected(int edges[][]){
        boolean [] visited = new boolean[edges.length];
        isConnectedHelper(edges,0,visited);
        for(int i =0;i<visited.length;i++){
            if(!visited[i]){
                return false;
            }
        }

        return true;
    }



    public static void main(String[] args) throws NumberFormatException, IOException {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        int edges[][] = new int[n][n];

        for(int i = 0; i<e; i++){
            int firstVertex = sc.nextInt();
            int secondVertex = sc.nextInt();

            edges[firstVertex][secondVertex] = 1;
            edges[secondVertex][firstVertex] = 1;
        }

        if(n==0 && e==0 || (n==2 && e==1) || n==1){
            System.out.println(true);
            return;
        }
        System.out.println(isConnected(edges));


    }
}
