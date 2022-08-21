package DataStructure.Graphs;

import java.util.Scanner;

public class OthelloBoard {
    private int board[][];
    final static int player1Symbol = 1;
    final static int player2Symbol = 2;

    public OthelloBoard() {
        board = new int[8][8];
        board[3][3] = player1Symbol;
        board[3][4] = player2Symbol;
        board[4][3] = player2Symbol;
        board[4][4] = player1Symbol;
    }

    public void print() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public boolean move(int symbol, int x, int y){

        if(x < 0 || y<0 || x>=8 || y>=8 || board[x][y] != 0){
            return false;
        }

        int X_Dir[] = {0,1,1,1,0,-1,-1,-1};
        int Y_Dir[] = {1,1,0,-1,-1,-1,0,1};

        int temp = 0;

        for(int i =0 ;i<X_Dir.length;i++){
            boolean valid = true;
            int X = x + X_Dir[i];
            int Y = y + Y_Dir[i];
            int count = 0;
            while(X >= 0 && Y>=0 && X<8 && Y<8 && board[X][Y] != 0 && board[X][Y] != symbol){
                count++;
                X = X + X_Dir[i];
                Y = Y + Y_Dir[i];
            }

            if(count == 0){
                valid =  false;
            }

            if(valid && board[X][Y] == symbol){
                board[x][y] = symbol;
                X = x + X_Dir[i];
                Y = y + Y_Dir[i];

                while(X>=0 && Y>=0 && X<8 && Y<8 && board[X][Y] != 0 && board[X][Y] != symbol){
                    board[X][Y] = symbol;
                    X = X + X_Dir[i];
                    Y = Y + Y_Dir[i];
                }

                temp++;
            }

        }

        if(temp == 0){
            return false;
        }else{
            return true;
        }



    }

    public static void main(String[] args) {
        OthelloBoard b = new OthelloBoard();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean p1Turn = true;
        while(n > 0) {
            int x = s.nextInt();
            int y = s.nextInt();
            boolean ans = false;
            if(p1Turn) {
                ans = b.move(player1Symbol, x, y);
            }
            else {
                ans = b.move(player2Symbol, x, y);
            }
            if(ans) {
                b.print();
                p1Turn = !p1Turn;
                n--;
            }
            else {
                System.out.println(ans);
            }
        }
    }
}
