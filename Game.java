public class Game {

    private String grid;

    public Game(String grid) {
        this.grid = grid.replace("_", " ");
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

    public void analyzeGame() {

        if (this.impossibleState()) {
            System.out.println("Impossible");
        } else if (this.hasThreeXs()) {
            System.out.println("X wins");
        } else if (this.hasThreeOs()) {
            System.out.println("O wins");
        } else if (!this.hasEmptyCells() && !this.hasThreeXs() && !this.hasThreeOs()) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
    }

    public void updateGrid(int x, int y) {
        int inputX = (x - 1) * 3;
        int intputY = y - 1;
        int pos = inputX + intputY;

        StringBuilder sb = new StringBuilder(this.grid);
        sb.setCharAt(pos, 'X');

        this.grid = sb.toString();
    }

    private boolean impossibleState() {

        int countX = 0;
        int countO = 0;

        for(char c : this.grid.toCharArray()) {
            if (c == 'X') {
                countX++;
            } else if(c == 'O') {
                countO++;
            }
        }
        int difference = Math.abs(countO - countX);
        
        if(difference > 1) {
            return true;
        }

        if(this.hasThreeXs() && this.hasThreeOs()) {
            return true;
        }

        return false;
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
