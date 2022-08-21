package DataStructure.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetPath_DFS {

    public static ArrayList<Integer> getPath(int edges[][], int startVertex, int endVertex, boolean visited[]) {

        ArrayList<Integer> output = new ArrayList<>();

        if (startVertex == endVertex) {
            output.add(startVertex);
            visited[startVertex] = true;
            return output;
        }
        visited[startVertex] = true;
        int n = edges.length;
        for (int i = 0; i < n; i++) {
            if (edges[startVertex][i] == 1 && !visited[i]) {
                ArrayList<Integer> ans = getPath(edges, i, endVertex, visited);
                ans.add(startVertex);
//                visited[i] = true;
                return ans;
            }
        }

        return null; // agar khin se b koi path nhi aaya to last me null return krdenge

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        int edges[][] = new int[n][n];

        for (int i = 0; i < e; i++) {
            int firstVertex = sc.nextInt();
            int secondVertex = sc.nextInt();

            edges[firstVertex][secondVertex] = 1;
            edges[secondVertex][firstVertex] = 1;
        }

        int V1 = sc.nextInt();
        int V2 = sc.nextInt();
        boolean visited[] = new boolean[edges.length];
        ArrayList<Integer> ans = getPath(edges, V1, V2, visited);
        if (ans != null) {
            for (int elem : ans) {
                System.out.print(elem + " ");
            }
        }
    }
}


