package DataStructure.Graphs;

public class Island {

    public static int numConnectedHelper(int [][] edges, boolean[] visited, int startVertex){
        visited[startVertex] = true;

        int n = edges.length;
        for(int i =0;i<n;i++){
            if(!visited[i] && edges[startVertex][i] ==1){
                numConnectedHelper(edges,visited,i);
            }
        }
        return 1;

    }

    public static int numConnected(int[][] edges, int n) {
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i =0;i<edges.length;i++){
            if(!visited[i]){
                count = count + numConnectedHelper(edges, visited , i);
            }
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
