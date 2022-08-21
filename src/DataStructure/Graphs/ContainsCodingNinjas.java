package DataStructure.Graphs;

public class ContainsCodingNinjas {



    int solve(String[] Graph , int N, int M)
    {
        String ans = "";

        int startingVertex = 0;
        int edges[][] = new int[N][M];
        int n = edges.length;
        boolean[] visited = new boolean[n];
        for(int i =0;i<n;i++){
            if(!visited[i] && edges[startingVertex][i] == 1){
                ans = ans + edges[startingVertex][i];
                visited[i] = true;
            }
        }
        if(ans.equals(Graph)){
            return 1;
        }else{
            return 0;
        }

    }

    public static void main(String[] args) {

    }
}
