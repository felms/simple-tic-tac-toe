import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();
        printGrid(input);
    }

    public static void printGrid(String input) {

        System.out.println("---------");
        char[] grid = input.toCharArray();
        int pos = 0;
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(grid[pos] + " ");
                pos++;
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}