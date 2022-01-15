import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();
        Game game = new Game(input);
        game.printGrid();

        System.out.print("Enter the coordinates: ");
        String[] coordinates = scanner.nextLine().split(" ");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        game.updateGrid(x, y);
        game.printGrid();


        //game.analyzeGame();

        scanner.close();
    }
    
}