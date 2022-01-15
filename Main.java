import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();
        Game game = new Game(input);
        game.printGrid();
        game.analyzeGame();

        scanner.close();
    }
    
}