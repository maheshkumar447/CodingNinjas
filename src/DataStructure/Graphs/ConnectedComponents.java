package DataStructure.Graphs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ConnectedComponents {

    public static void connectedComponentsHelper(int [][] edges, int start, boolean[] visited, ArrayList<Integer> ans){
        visited[start] = true;
        ans.add(start);
        int n = edges.length;
        for(int i =0;i<n;i++){
            if(edges[start][i] == 1 && !visited[i]){
                connectedComponentsHelper(edges,i,visited,ans);
            }
        }

    }

    public static void connectedComponents(int[][] edges){
        boolean[] visited = new boolean[edges.length];
        for(int i =0;i<edges.length;i++){
            ArrayList<Integer> smallAns = new ArrayList<>();   // ye har component k liye baar baar array bnti rhegi
            connectedComponentsHelper(edges,i,visited,smallAns);
            Collections.sort(smallAns);

            for(int j =0;j<smallAns.size();j++){
                System.out.print(smallAns.get(j) + " ");
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // total number of edges e
        int e = sc.nextInt();
        int edges[][]=new int[n][n];
        for(int i=0;i<e;i++){
            int fisrtVertex=sc.nextInt();
            int secondVertex=sc.nextInt();
            edges[fisrtVertex][secondVertex]=1;
            edges[secondVertex][fisrtVertex]=1;
        }

    }
}
