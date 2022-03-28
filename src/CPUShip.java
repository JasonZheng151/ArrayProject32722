public class CPUShip extends BattleShip{
    private int CPUshipLength;
    public CPUShip()
    {
        CPUshipLength=1;
    }
    public void CPUaddShips(String[][] board) //adds ship to the grid
    {
        int count=0;
        while(count<5) {
            board[(int) (Math.random() * board.length)][(int) (Math.random() * board.length)] = "S";
            count++;
        }
        printBoard(board);
    }
    public void CPUhitShip(String[][] board) //checks which coords to hit and checks for ships there
    {
        int rowHit= (int) (Math.random()*board.length);
        int colHit= (int) (Math.random()*board.length);
        while(board[rowHit][colHit].equals("X"))
        {
            rowHit= (int) (Math.random()*board.length);
            colHit= (int) (Math.random()*board.length);
        }
        if(board[rowHit][colHit].equals("S"))
        {
            board[rowHit][colHit]="X";
            System.out.println("A Ship has been hit!");
        }
        else
        {
            board[rowHit][colHit] = "Z";
            System.out.println("The Computer missed");
            System.out.println(" ");
        }
        printBoard(board);
    }
}
