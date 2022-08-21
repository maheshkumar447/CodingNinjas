package GameTicTacToe;

public class Board {
    private char[][] board;
    private int boardSize = 3;
    private char p1Symbol, p2Symbol;
    private int count;  // no of cells of board that have been marked

    public final static int PLAYER_1_WINS = 1;
    public final static int PLAYER_2_WINS = 2;
    public final static int DRAW = 3;
    public final static int INCOMPLETE = 4;
    public final static int INVALID = 5;


    public Board(char p1Symbol, char p2Symbol){
        board = new char[boardSize][boardSize];
        for(int i =0;i<boardSize;i++){
            for (int j =0;j<boardSize;j++){
                board[i][j] = ' ';
            }
        }
        this.p1Symbol = p1Symbol;
        this.p2Symbol = p2Symbol;
    }

    public int move(char symbol, int x, int y){

        if(x < 0 || x>=boardSize || y<0 || y>=boardSize || board[x][y] != ' '){   // mtlb agar inme se koi b ek condition h to hum nhi chla skte or hme invalid return krna pdega
            return INVALID;
        }

        board[x][y] = symbol; // board k cell pe jake wo symbol rkh do
        count++; // no of cell jo marked h wo increase ho gye h ek se

        // ab chlne k baad hum check krenge ki kya hum kisi conclusion pr phunche h (conclusion mtlb player1 wins, player2 wins, draw) , agar phunche h to hme or move nhi krna chyiea
        // or conclusion hme check krna h teen directions me ... horizontal , vertical, diagonal
        // or maanlo hum horizontal le rhe h to teeno columns me ek hee symbol agar h to conclude ho skta h wo
        // aise hee baaki dono direction k liye

        if(board[x][0] == board[x][1] && board[x][0] == board[x][2]){
            // ab agar mil gye saare symbol to mtlb koi player jeeta h or hum ye kaise pta lgayege ki kosa jeeta h
            // jis symbol k  liye board k coordinates match ho rhe h us symbol k regarding konsa player h wo player return krwa denge
          return  symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;   // player 1 ka symbol h to wo jeeta else player2 jeeta
        }

        if(board[0][y] == board[1][y] && board[0][y] == board[2][y]){   // same kaam kiya h har column k liye
            return  symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
        }

        // hme diagonally b check krna chyiea
        // so diagonal k coordinates nikalo

        // first diagonal
        // yahan hmne shuru me ek condition or lgayi h kyunki aisa ho skta h ki player shuru me hee kisi non diagonal element or kuch rkhde to uper wali dono if ki condition to chlegi nhi but
        // ye diagonal wali chal jayengi kyunki shuru me saare diagonals pr space rkha h or saaro pe space h to wo equal n honge
        if(board[0][0] != ' '  && board[0][0] == board[1][1] && board[0][0] == board[2][2]){
            return  symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
        }

        // second diagonal
        if(board[0][2] != ' '  && board[0][2] == board[1][1] && board[0][2] == board[2][0]){
            return  symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
        }


        // ab agar last me koi b player nhi jeeta to ya to match draw hua h or incomplete h
        // draw kb hoga .... draw tb hoga jb hmara board bhar jayega or koi b player nhi jeeta hoga
        // or saare cells ka track kon rkh rha h ...count
        if(count  == boardSize * boardSize){
            return DRAW;
        }
        return INCOMPLETE; // agar na hee koi jeeta na hee draw hua to incomplete
    }


    public void print(){
        System.out.println("-----------------");
        for(int i =0;i<boardSize;i++){
            for (int j =0;j<boardSize;j++){
                System.out.print("| " + board[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("-----------------");
    }
}
