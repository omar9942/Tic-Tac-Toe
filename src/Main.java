public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        game.startingPlayer();

        while(true){

            game.displayBoard();
            game.playerPlay();

            if(game.thereIsWinner()){
                game.displayBoard();
                System.out.println("----- Player [" + game.getPlayer() + "] Wins -----");
                break;
            } else if (game.draw()) {
                game.displayBoard();
                System.out.println("----- Draw -----");
                break;
            }

            game.flipPlayer();
        }

    }
}