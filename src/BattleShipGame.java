import java.util.Arrays;

public class BattleShipGame {
    private CPUShip cpu;
    private BattleShip player;
    boolean gameEnd = false;
    String[][] cpuboard;
    String[][] playerBoard;

    public BattleShipGame() {
        //cpu = new CPUShip();
        //String[][] cpuboard = cpu.makebattleShipGrid();
        //cpu.CPUaddShips(cpuboard);
    }
    //Creates the means to play the game, starts with creating the cpu board and then player board
    public void play() {
        cpu = new CPUShip();
        String[][] cpuboard = cpu.makebattleShipGrid();
        cpu.CPUaddShips(cpuboard);
        player = new BattleShip();
        playerBoard = player.makebattleShipGrid();
        player.addShips(playerBoard);
        int cpuCount = 0;
        int playerCount = 0;
        System.out.println(" ");
        System.out.println("------------GAME START-------------");
        while (gameEnd == false) {
            player.hitShip(cpuboard);
            for (int i = 0; i < cpuboard.length; i++) {
                for (int j = 0; j < cpuboard[0].length; j++) {
                    if (cpuboard[i][j].equals("X")) {
                        cpuCount++;
                    }
                }
            }
            if (cpuCount == 5) {
                System.out.println("You have sunk the opponents battleship");
                System.out.println("YOU WIN");
                gameEnd = true;
                break;
            }
            cpu.CPUhitShip(playerBoard);
            for (int i = 0; i < playerBoard.length; i++) {
                for (int j = 0; j < playerBoard[0].length; j++) {
                    if (playerBoard[i][j].equals("X")) {
                        playerCount++;
                    }
                }
            }
            if (playerCount == 5) {
                System.out.println("YOU LOSE");
                gameEnd = true;
                break;

            }
        }
    }
}




