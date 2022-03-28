import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class BattleShip {
    private int shipLength;
    Scanner scan= new Scanner(System.in);
    public BattleShip()
    {
        shipLength=1;
    }
    public String[][] makebattleShipGrid()// makes the grid without any Ships
    {
        String[][] grids= new String [5][5];
        for (int row=0; row<grids.length; row++)
        {
            for(int col=0; col< grids[0].length; col++)
            {
                grids[row][col] = "O";
            }
        }
        return grids;

    }
    public static void printBoard(String[][] board) //prints the board in it's current state
    {
        for(int i=0; i< board.length; i++)
        {
            for(int j= 0; j< board[0].length;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void hitShip(String[][] board) //checks which coords to hit and checks for ships there
    {
        System.out.println("Which row to hit?");
        int rowHit= scan.nextInt()-1;
        while(rowHit>=5)
        {
            System.out.println("Which row to hit?");
            rowHit= scan.nextInt()-1;
        }
        System.out.println("Which column to hit?");
        int colHit= scan.nextInt()-1;
        while(colHit>=5)
        {
            System.out.println("Which column to hit?");
            colHit= scan.nextInt()-1;
        }
        if(board[rowHit][colHit].equals("S"))
        {
            board[rowHit][colHit]="X";
            System.out.println("A Ship has been hit!");
            System.out.print(" ");
        }
        else
        {
            board[rowHit][colHit]="Z";
            System.out.println("You missed!");
        }
        printBoard(board);
    }
    public void addShips(String[][] board) //adds ship to the grid
    {

        int count=0;
        while (count<5) {
            System.out.println("Which row to add Ship?");
            int rowAdd = scan.nextInt() - 1;
            while (rowAdd >= 5 || rowAdd < 0) {
                System.out.println("Invalid");
                System.out.println("Which Row to Add Ship");
                rowAdd = scan.nextInt() - 1;
            }
            System.out.println("Which column to add Ship?");
            int colAdd = scan.nextInt() - 1;
            while (colAdd >= 5 || colAdd < 0) {
                System.out.println("Invalid");
                System.out.println("Which Column to Add Ship");
                colAdd = scan.nextInt() - 1;
            }
            while(board[rowAdd][colAdd].equals("S"))
            {
                System.out.println("Invalid");
                System.out.println("Which Row to Add Ship");
                rowAdd = scan.nextInt() - 1;
                System.out.println("Which Column to Add Ship");
                colAdd = scan.nextInt() - 1;
            }
            board[rowAdd][colAdd] = "S";
            printBoard(board);
            count++;
        }
        System.out.print("No more ships to add");
    }



}
