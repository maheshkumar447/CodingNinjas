package GameTicTacToe;

import java.util.Scanner;

public class TicTacToe {

    private Player player1, player2;
    private Board board;

    public static void main(String[] args) {
        TicTacToe tc = new TicTacToe();
        tc.startGame();
    }

    public void startGame(){

        // players input
        Scanner sc = new Scanner(System.in);
            player1 = takePlayerInput(1);
            player2 = takePlayerInput(2);
            // abhi tk hmne ye check nhi lgaya h ki dono players k symbol alag alag hone chyiea
            // so wo check lgao   or ye check hmne while loop me isiliye dala h kyunki hum har baar check kre isko jb b wo same name daake to kyunki
        // ab manlo hum while ki jagah if lgate or phli baari me wo same naam ko pkd lega but jb wo player2 dobara naam bhrgea or usne player1 ka naam ab b bhrdiya to galat ho jayrga
        // so baar baar check ho isiliye hmne while loop lga diya... ye jb tk check hota rhega jb tk symol same aate rhenge
        while(player1.getSymbol() == player2.getSymbol()){
            System.out.println("Symbol Already taken !! Pick another symbol");
            // so ab wo dobara pick krega symbol or dobara pick krne k liye scanner chyiea to hm yahan scanner bnayenge mtlb is function me
            // so ab symbol lo
            char symbol = sc.next().charAt(0);  // le liya symbol
            player2.setSymbol(symbol);  // ab yahan usko dobara mauka mila ki wo apna symbol chnge kre
        }



        // create board
        board = new Board(player1.getSymbol(),player2.getSymbol());  // dono players k symbol get krliye or board bna diya



        // conduct the game
        int status = Board.INCOMPLETE;
        boolean player1Turn = true; // ab hme ye b check lgana h ki ek player ek time pe multiple entries try na kre
        while (status == Board.INCOMPLETE || status == Board.INVALID){ // ye while loop tb tk chlegi jb tk game complete na ho jaye or game complete hogi three conditions me
            // first condition is: player1 jeet jaye
            // secod : player2 jeet jaye
            // third: draw ho jaye
            if(player1Turn){
                // player1Turn se turn ka pta lgega ki ab kiski turn h ...agar ye true h to player1 ki or agar false hua to player2 ki

                // ab jis b player ki turn h uske pass option dekhne pdenge ki wo kahan kaha ja skta h or coordinateski help se hum ye decide krege
                System.out.println("Player 1- " + player1.getName() + "'s turn");
                System.out.println("Enter x: ");  // x coordinate liya
                int x = sc.nextInt();

                System.out.println("Enter y : ");  // y coordinate
                int y = sc.nextInt();

                // ab hmne ye to decide krliya ki kis direction me jama h but hme aage b kuch check perform krne pdenge jaise ki
                // dono index sahi ho or main ye ki us index pr kuch b hona nhi chyiea mtlb wo index khali hona chyiea
                // or ye saare kaam board dekhega i.e. Boars class so usme ek function bnaya h
                status =  board.move(player1.getSymbol(),x,y);  // symbol jo use kr rha h player or x and y are coordinates jin pr wo jana chahta h
                // ab is move function k chlne k baad kuch check lgane honge jaise ki
                // koi player jeet to nhi gya ya match to draw nhi ho gya ya phir jo move hum chlna chahte h wo sahi to h na
                // jo b move chlne k baad status rhega wo is status variable me hum store krwa denge
                // hme kuch integer variable lene honge jinme hum fix krenge ki jaise 1 ka mltb h player1 won
                // 2 ka mtlb h player2 won
                // 3 ka mtlb draw
                // 4 ka mtlb invalid move
                // 5 ka mtlb incomplete h abhi or move chlni hongi abhi
                // or ye hum fix krenge final static constants se which is in board file

                if(status != Board.INVALID){
                    player1Turn = false;
                    board.print();
                }else{
                    System.out.println("Invalid Move !! Try again");
                }
            }else{
                System.out.println("Player 2- " + player2.getName() + "'s turn");
                System.out.println("Enter x: ");  // x coordinate liya
                int x = sc.nextInt();

                System.out.println("Enter y : ");  // y coordinate
                int y = sc.nextInt();
                status =  board.move(player2.getSymbol(),x,y);
                if(status != Board.INVALID){
                    player1Turn = true;
                    board.print();
                }else{
                    System.out.println("Invalid Move !! try again");
                }

            }
        }

        // yahan while loop se bhar aake hum complete kr denge ki ya to koi player jeet gya ya phir match draw rha
        if(status == Board.PLAYER_1_WINS){
            System.out.println("Player 1- " + player1.getName() + " wins !! ");
        }else if(status == Board.PLAYER_2_WINS){
            System.out.println("Player 2- " + player2.getName() + " wins !! ");
        }else{
            System.out.println("Draw !!");
        }

    }

    
    private Player takePlayerInput(int num){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player " + num + "name: ");
        String name = sc.nextLine();

        System.out.println("Enter player " + num + "symbol: ");
        char symbol = sc.next().charAt(0);
        Player p = new Player(name, symbol);  // player class ka object bnaya h
        return p;
    }
    
    

}
