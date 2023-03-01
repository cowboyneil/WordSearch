import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class App {
    public static void main(String[] args) {
        //variable definition
    System.out.println("Hello User!");
    System.out.println("Welcome to the word search generator!");
    char[][] grid = new char [20][20];
    int gridSize = 20;
    Random rand = new Random();
    char userInput = 'a';
        //main while loop
    while(userInput != 'Q'){
    userInput = introduction();
    userInput = Character.toUpperCase(userInput);
    if (userInput == 'G'){
        generate(grid, gridSize, rand);
    }
    else if (userInput == 'P'){
        print(grid, gridSize);
    } 
    else if (userInput == 'S'){
        showSolution(grid , gridSize);
    }
    else{
        
    }

    }
}
    public static char introduction() {
        Scanner input = new Scanner(System.in);
        System.out.println("Generate (g)");
        System.out.println("Print (p)");
        System.out.println("Show Solution(s)");
        System.out.println("Quit (q)");
        char userInput = input.next().charAt(0);
        return userInput;
    } 
    public static char[][] generate(char[][] grid, int gridSize, Random rand){
        //for loop for generation
        for (int row = 0; row < gridSize; row++) { //grid = 9x9
            for (int col = 0; col < gridSize; col++) {
                grid[row][col] = (char) (rand.nextInt(26) + 'A');
            }
        }
        //word entry
        Scanner sc = new Scanner(System.in);
        System.out.println("How many words do you wish to generate?");
        int num = sc.nextInt();
        for(int i = 0 ; i < num ; i++){
            Scanner wordGen = new Scanner(System.in);
            System.out.println("Please enter word "+(i+1)+":");
            String userWord = wordGen.nextLine();
        //randomly generate an option of (1) = vertical
        //                               (2) = horizontal
        //                               (3) = diagonal
        //int vhd = vertical, horizontal, diagonal generation
        int vhd = rand.nextInt(3);

        if (vhd == 0){ //vertical
            int v = Math.abs(rand.nextInt(gridSize-userWord.length()));
            for(int j = 0 ; j < userWord.length() ; j++){
                char[] cArray = userWord.toCharArray();
                grid[j][v] = cArray[j]; //grid[0][j] = generation verticle on first line
            }
        }

        else if (vhd == 1){ // horizontal
            int h = Math.abs(rand.nextInt(gridSize-userWord.length()));
            for(int j = 0 ; j < userWord.length() ; j++){
                char[] cArray = userWord.toCharArray();
                grid[j][h] = cArray[j]; //grid[j][0] = generation horizontal on first line
            }
        }
        else{ //diagonal
            int d = Math.abs(rand.nextInt(gridSize-userWord.length()));
            for(int j = 0 ; j < userWord.length() ; j++){
                char[] cArray = userWord.toCharArray();
                grid[d+j][d+j] = cArray[j]; //grid[j][j] = generation diagonal from grid[0][0]
            }
        }

    } //end of outer for loop
    return grid;
    }
    public static void print(char[][] grid, int gridSize){
        for (int col = 0; col < gridSize; col++) { //grid = 9x9
            for (int row = 0; row < gridSize; row++) {
                System.out.print(Character.toUpperCase(grid[row][col]));
                if (row == gridSize-1){
                    System.out.println(grid[row][col]);
                }
            }
        } 
    }
    public static void showSolution(char[][] grid, int gridSize){  
        for (int col = 0; col < gridSize; col++) { //grid = 9x9
            for (int row = 0; row < gridSize; row++) {
                if (grid[row][col] <= 96 || grid[row][col] >= 123){
                    System.out.print("x");
                }
                else{
                    System.out.print(grid[row][col]);
                }
                if (row == gridSize-1){
                    System.out.println("");
                }
            }
        } 

    }
}
