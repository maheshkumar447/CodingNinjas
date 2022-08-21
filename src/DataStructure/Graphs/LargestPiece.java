package DataStructure.Graphs;

public class LargestPiece {
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static int dfs(String[] edge, int n) {
      boolean[][] visited = new boolean[n][n];
      int count = 0;
      for(int i =0;i<n;i++){
          for(int j = 0;j<n;j++) {
              if (!visited[i][j] && edge[i].charAt(j) == '1') {
                  int ans = helper(edge,visited,i,j,n);
                  if(ans>count){
                      count = ans;
                  }
              }
          }
      }
      return count;
    }

    public static int helper(String []edge, boolean[][]visited, int i , int j, int n){

        int count = 0;
        int X_dir[] = {0,-1,1,0};
        int y_dir[] = {1,0,0,-1};
        visited[i][j] = true;
        for(int a =0;a<X_dir.length;a++){
            int x = X_dir[a] + i;
            int y = y_dir[a] + j;

            if(x>=0 && y>= 0 && x<n && y<n && edge[x].charAt(y) == '1' && !visited[x][y]){
                int ans = helper(edge,visited,x,y,n);
                count = count + ans;
            }

        }

        return count+1;

    }

    public static void main(String[] args) {

    }
}
