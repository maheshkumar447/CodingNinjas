package DataStructure.Graphs;

public class ConnectingDots {

    public static int hasCycle(String[] graph, int fromX, int fromY, int i , int j, boolean[][] visited){
        if(visited[i][j]){
            return 1;
        }

        int X_direction[] = {-1, 0 , 0 , 1};
        int Y_direction[] = {0,-1,1,0};

        visited[i][j] = true;

        for(int a = 0; a<X_direction.length;a++){
            int x = X_direction[a] + i;
            int y = Y_direction[a] + j;

            if(x == fromX && y == fromY){
                continue;
            }

            if(x>=0 && y>=0 && x<graph.length && y< graph[0].length() && graph[x].charAt(y) == graph[i].charAt(j)){
                int ans = hasCycle(graph, i,j,x,y,visited);
                if(ans == 1){
                    return 1;
                }
            }

        }

        return 0;

    }



    int solve(String[] Graph , int N, int M)
    {
        boolean[][] visited= new boolean[N][M];
        for(int i =0;i<N;i++){
            for(int j = 0;j<M;j++){
                if(!visited[i][j]){
                    if(hasCycle(Graph,-1, -1, i , j,visited ) == 1){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {

    }
}
