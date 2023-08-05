import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final String[] board;
    private String player;
    private final Scanner scanner;

    public Game(){
        this.player = "X";
        this.board = new String[]{"-", "-", "-", "-", "-", "-", "-", "-", "-"};
        this.scanner = new Scanner(System.in);
    }

    public String getPlayer() {
        return this.player;
    }

    public void startingPlayer(){
        System.out.println("Who is going to play first [X OR O]");
        String firstPlayer = scanner.nextLine().toUpperCase();
        while(!firstPlayer.equals("X") && !firstPlayer.equals("O")){
            System.out.println("YOU CAN ONLY CHOOSE X OR O");
            firstPlayer = scanner.nextLine().toUpperCase();
        }
        this.player = firstPlayer;
    }

    public void displayBoard(){
        System.out.println(this.board[0] + " | " + this.board[1] + " | " + this.board[2]);
        System.out.println(this.board[3] + " | " + this.board[4] + " | " + this.board[5]);
        System.out.println(this.board[6] + " | " + this.board[7] + " | " + this.board[8]);
    }

    public void playerPlay(){
        System.out.println("Choose a block from 1 to 9 to place [" + this.player + "]");
        String block = scanner.nextLine();

        while(!validInput(block)){
            System.out.println("try again");
            block = scanner.nextLine();
            validInput(block);
        }

        this.board[Integer.parseInt(block) - 1] = this.player;
    }

    public boolean validInput(String input){
        boolean isNumeric = input != null && input.matches("[0-9.]+");
        return isNumeric && (Integer.parseInt(input) <= 9 && Integer.parseInt(input) > 0) && this.board[Integer.parseInt(input) - 1].equals("-");
    }

    public void flipPlayer(){ // changes the player
        if(this.player.equals("X")){
            this.player = "O";
        }else{
            this.player = "X";
        }
    }

    public boolean thereIsWinner(){ // returns true if there is a linear or diagonal win

        return diagonalWin() || linearWin();
    }

    public boolean diagonalWin(){ // the possible diagonal ways to win the game

        boolean win1 = board[0].equals(this.player) && board[4].equals(this.player) && board[8].equals(this.player);
        boolean win2 = board[2].equals(this.player) && board[4].equals(this.player) && board[6].equals(this.player);

        return win1 || win2;
    }

    public boolean linearWin(){ // the possible linear ways to win the game
        boolean win1 = board[0].equals(this.player) && board[1].equals(this.player) && board[2].equals(this.player);
        boolean win2 = board[3].equals(this.player) && board[4].equals(this.player) && board[5].equals(this.player);
        boolean win3 = board[6].equals(this.player) && board[7].equals(this.player) && board[8].equals(this.player);

        boolean win4 = board[0].equals(this.player) && board[3].equals(this.player) && board[6].equals(this.player);
        boolean win5 = board[1].equals(this.player) && board[4].equals(this.player) && board[7].equals(this.player);
        boolean win6 = board[2].equals(this.player) && board[5].equals(this.player) && board[8].equals(this.player);

        return win1 || win2 || win3 || win4 || win5 || win6;
    }

    public boolean draw(){
        List<String> board = Arrays.asList(this.board);
        return !thereIsWinner() && !board.contains("-");
    }
}
