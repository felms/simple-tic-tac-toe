import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();
        printGrid(input);
        analyzeGame(input);

        scanner.close();
    }

    public static void printGrid(String input) {

        System.out.println("---------");
        int pos = 0;
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(input.charAt(pos) + " ");
                pos++;
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void analyzeGame(String input) {

        if (impossibleState(input)) {
            System.out.println("Impossible");
        } else if (hasThreeXs(input)) {
            System.out.println("X wins");
        } else if (hasThreeOs(input)) {
            System.out.println("O wins");
        } else if (!hasEmptyCells(input) && !hasThreeXs(input) && !hasThreeOs(input)) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
    }

    public static boolean impossibleState(String input) {

        int countX = 0;
        int countO = 0;

        for(char c : input.toCharArray()) {
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

        if(hasThreeXs(input) && hasThreeOs(input)) {
            return true;
        }

        return false;
    }

    public static boolean hasThreeXs(String input) {

        char[] c = input.toCharArray();

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

    public static boolean hasThreeOs(String input) {

        char[] c = input.toCharArray();

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

    public static boolean hasEmptyCells(String input) {
        return input.contains("_");
    }
}