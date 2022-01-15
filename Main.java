public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        game.printGrid();
        while (!game.gameEnded()) {
            game.makeAMove(game);
        }
    }

}

