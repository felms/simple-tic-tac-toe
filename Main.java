import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();
        Game game = new Game(input);
        game.printGrid();

        int x = -1;
        int y = -1;
        boolean updated = false;
        do {
            System.out.print("Enter the coordinates: ");
            
            String[] line = scanner.nextLine().trim().split(" ");
            
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

        scanner.close();
    }
    
}
