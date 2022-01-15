import java.util.Scanner;

public class Game {

    private String grid;
    private final Scanner scanner;
    private char player;

    public Game() {
        this.grid = "         ";
        player = 'X';
        scanner = new Scanner(System.in);
    }

    public Game(String grid) {
        this.grid = grid.replace("_", " ");
        player = 'X';
        scanner = new Scanner(System.in);
    }

    public void printGrid() {

        System.out.println("---------");
        int pos = 0;
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(this.grid.charAt(pos) + " ");
                pos++;
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public void makeAMove(Game game) {

        int x;
        int y ;
        boolean updated = false;
        do {
            System.out.print("Enter the coordinates: ");

            String[] line = this.scanner.nextLine().trim().split(" ");

            if (line.length == 2) {

                boolean isNumeric = line[0].matches("[+-]?\\d*(\\.\\d+)?");
                isNumeric = isNumeric && line[1].matches("[+-]?\\d*(\\.\\d+)?");


                if (isNumeric) {
                    x = Integer.parseInt(line[0]);
                    y = Integer.parseInt(line[1]);
                    updated = game.updateGrid(x, y);
                } else {
                    System.out.println("You should enter numbers!");
                }

            } else {
                System.out.println("You should enter numbers!");
            }


        } while(!updated);

        player = player == 'X' ? 'O' : 'X';

    }

    // Retorna 'true' caso o jogo tenha terminado
    // e 'false' caso ainda não.
    public boolean gameEnded() {

        if (!this.hasEmptyCells() && !this.hasThreeXs() && !this.hasThreeOs()) {
            System.out.println("Draw");
            return true;
        } else if (this.hasThreeXs()) {
            System.out.println("X wins");
            return true;
        } else if (this.hasThreeOs()) {
            System.out.println("O wins");
            return true;
        }

        return false;
    }

    // Retorna 'true' caso consiga atualizar o estado do grid
    // e 'false' caso a operação não seja bem sucedida.
    private boolean updateGrid(int x, int y) {
        int inputX = (x - 1) * 3;
        int intputY = y - 1;
        int pos = inputX + intputY;

        if (x < 1 || x > 3 ||
                y < 1 || y > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        if (this.grid.charAt(pos) != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        StringBuilder sb = new StringBuilder(this.grid);
        sb.setCharAt(pos, player);

        this.grid = sb.toString();

        this.printGrid();

        return true;
    }

    private boolean hasThreeXs() {

        char[] c = this.grid.toCharArray();

        // Checa as linhas
        if( (c[0] == 'X' && c[0] == c[1] && c[0] == c[2]) ||
                (c[3] == 'X' && c[3] == c[4] && c[3] == c[5]) ||
                (c[6] == 'X' && c[6] == c[7] && c[6] == c[8]) ){
            return true;
        }

        // Checa as colunas
        if( (c[0] == 'X' && c[0] == c[3] && c[0] == c[6]) ||
                (c[1] == 'X' && c[1] == c[4] && c[1] == c[7]) ||
                (c[2] == 'X' && c[2] == c[5] && c[2] == c[8]) ){
            return true;
        }

        // Checa as diagonais
        if( (c[0] == 'X' && c[0] == c[4] && c[0] == c[8]) ||
                (c[2] == 'X' && c[2] == c[4] && c[2] == c[6]) ){
            return true;
        }

        return false;
    }

    private boolean hasThreeOs() {

        char[] c = this.grid.toCharArray();

        // Checa as linhas
        if( (c[0] == 'O' && c[0] == c[1] && c[0] == c[2]) ||
                (c[3] == 'O' && c[3] == c[4] && c[3] == c[5]) ||
                (c[6] == 'O' && c[6] == c[7] && c[6] == c[8]) ){
            return true;
        }

        // Checa as colunas
        if( (c[0] == 'O' && c[0] == c[3] && c[0] == c[6]) ||
                (c[1] == 'O' && c[1] == c[4] && c[1] == c[7]) ||
                (c[2] == 'O' && c[2] == c[5] && c[2] == c[8]) ){
            return true;
        }

        // Checa as diagonais
        if( (c[0] == 'O' && c[0] == c[4] && c[0] == c[8]) ||
                (c[2] == 'O' && c[2] == c[4] && c[2] == c[6]) ){
            return true;
        }

        return false;
    }

    private boolean hasEmptyCells() {

        return this.grid.contains(" ");
    }
}
