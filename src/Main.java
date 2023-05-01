import java.util.Scanner;

public class Main {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] =  new String[ROW][COL];

    //main logic contains the logic of the program and calls to most of the methods
    public static void main (String[] args) {
        clearBoard();
        display();
        int moveCnt = 0;
        String player = "x";
        do {
            int rowMove = -1;
            int colMove = -1;
            do {
                rowMove = SafeInput.getRangedInt(new Scanner(System.in), "" + player + ", please enter the row that you want to play", 1, 3);
                colMove = SafeInput.getRangedInt(new Scanner(System.in), "" + player+ ", please enter the column that you want to play", 1, 3);
                rowMove = rowMove - 1;
                colMove = colMove - 1;
                if (!isValidMove(rowMove, colMove)) {
                    System.out.println("You cannot play there, try again.");
                }
            } while (!isValidMove(rowMove, colMove));

            board[rowMove][colMove] = player;
            moveCnt++;
            display();

            if (isWin(player)) {
                System.out.println(player + " wins.");
                if (!playAgain()) {
                    break;
                }
                clearBoard();
            }

            if (moveCnt >= 7) {
                if (isTie()) {
                    System.out.println("Tied game.");
                    if (!playAgain()) {
                        break;
                    }
                }
            }

            if(player.equalsIgnoreCase("x")){
                player = "O";
            }else {
                player = "x";
            }

        } while (true);
    }


    private static void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "";
            }
        }
    }
    //displays the board before it is played

    private static void display() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("");
        }
    }
    //displays the board as it is played

    private static boolean isValidMove(int row, int col) {
        if (row >= 0 && row <= 2 & col >= 0 && col <= 2  && board[row][col].equalsIgnoreCase("")) {
            return true;
        }
        return false;
    } //deduces if the move is possible / available

    private static boolean isWin(String player) {
        if (isColWin(player) || isRowWin(player) || isDiagnalWin(player)) {
            return true;
        }
        return false;

    }//deduces whether a player has won the game yet and returns the boolean

    private static boolean isColWin(String player) {
        if (board[0][0].equalsIgnoreCase(player) &&
                board[1][0].equalsIgnoreCase(player) &&
                board[2][0].equalsIgnoreCase(player)) {
            return true;
        } else if (board[0][1].equalsIgnoreCase(player) &&
                board[1][1].equalsIgnoreCase(player) &&
                board[2][1].equalsIgnoreCase(player)) {
            return true;
        } else if (board[0][2].equalsIgnoreCase(player) &&
                board[1][2].equalsIgnoreCase(player) &&
                board[2][2].equalsIgnoreCase(player)) {
            return true;
        }

        return false;
    }// used to check if a player has won

    private static boolean isRowWin(String player) {
        if (board[0][0].equalsIgnoreCase(player) &&
                board[0][1].equalsIgnoreCase(player) &&
                board[0][2].equalsIgnoreCase(player)) {
            return true;
        } else if (board[1][0].equalsIgnoreCase(player) &&
                board[1][1].equalsIgnoreCase(player) &&
                board[1][2].equalsIgnoreCase(player)) {
            return true;
        } else if (board[2][0].equalsIgnoreCase(player) &&
                board[2][1].equalsIgnoreCase(player) &&
                board[2][2].equalsIgnoreCase(player)) {
            return true;
        }

        return false;
    }// used again to check if a player has won

    private static boolean isDiagnalWin(String player) {
        if (board[0][0].equalsIgnoreCase(player) &&
                board[1][1].equalsIgnoreCase(player) &&
                board[2][2].equalsIgnoreCase(player)) {
            return true;
        } else if (board[0][2].equalsIgnoreCase(player) &&
                board[1][1].equalsIgnoreCase(player) &&
                board[2][0].equalsIgnoreCase(player)) {
            return true;
        }
        return false;
    } // helps deduce if there is a win yet

    private static boolean isTie() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equalsIgnoreCase("")) {
                    return false;
                }
            }
        }
        return true;
    }// checks to see if the board is full without a winning condition (tie

    private static boolean playAgain() {
        return SafeInput.getYNConfirm(new Scanner(System.in), "Would you like to play again? ");

    }

}