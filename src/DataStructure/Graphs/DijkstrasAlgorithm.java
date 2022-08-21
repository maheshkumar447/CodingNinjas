package DataStructure.Graphs;

import java.util.Scanner;

public class DijkstrasAlgorithm {

    public static int findMinDistanceVertex(int [] distance, boolean[] visited){
        int minVertex = -1;
        for(int i =0;i<distance.length;i++){
            if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void dijkstra(int [][]edges){
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int distance[] = new int[n];

        distance[0] = 0;

        for(int i =1;i<n;i++){
            distance[i]  = Integer.MAX_VALUE;
        }

        for(int i = 0;i<n-1;i++){
            int minVertex = findMinDistanceVertex(distance,visited);
            visited[minVertex] = true;

            for(int j = 0;j<n;j++) {
                if (!visited[j] && edges[minVertex][j] != 0 && distance[minVertex] != Integer.MAX_VALUE) {
                    int currentDistance = distance[minVertex] + edges[minVertex][j];
                    if (currentDistance < distance[j]) {
                        distance[j] = currentDistance;
                    }
                }
            }
        }
        for(int i =0;i<n;i++){
            System.out.println(i + " " + distance[i]);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        int edges[][] = new int[n][n];
        for(int i = 0;i<e;i++){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();

            edges[source][destination] = weight;
            edges[destination][source] = weight;
        }

        dijkstra(edges);
    }
}
