public class Application {

    // int[y][x]
    // 0... empty
    // 1... X
    // 2... O
    public int[][] board;

    public void init() {
        board = new int[3][3];
    }

    public boolean validatePos(String pos) {
        if (pos == null) return false;
        if (pos.length() != 2) return false;
        if (pos.charAt(0) >= 'A' && pos.charAt(0) <= 'C') {
            return pos.charAt(1) >= '1' && pos.charAt(1) <= '3';
        }
        return false;
    }

    public int getX(String pos) {
        return switch (pos.charAt(0)) {
            case 'A' -> 0;
            case 'B' -> 1;
            case 'C' -> 2;
            default -> -1;
        };
    }

    public int getY(String pos) {
        char c = pos.charAt(1);
        return c - '1';
    }


    /*
    returns int 0... remis, 1...X Won, 2... O Won, 3... no one won
     */
    public int whoWon() {

        for (int[] ints : board) {
            int countX = 0;
            int countO = 0;
            for (int anInt : ints) {
                if (anInt == 1) {
                    countX++;
                }
                if (anInt == 2) {
                    countO++;
                }
            }
            if (countX == 3) return 1;
            if (countO == 3) return 2;

        }

        for (int x = 0; x < board[0].length; x++) {
            int countX=0;
            int countO=0;
            for (int[] ints : board) {
                if (ints[x] == 1) {
                    countX++;
                }
                if (ints[x] == 2) {
                    countO++;
                }
            }
            if (countX==3) return 1;
            if (countO==3) return 2;

        }
        int countX=0;
        int countO=0;
        for(int x=0;x<board.length;x++){
            if (board[x][x]==1){
                countX++;
            }
            if (board[x][x]==2){
                countO++;
            }
        }
        if (countX==3) return 1;
        if (countO==3) return 2;

        countX=0;
        countO=0;
        for(int x=0;x<board.length;x++){
            if (board[x][board.length-1-x]==1){
                countX++;
            }
            if (board[x][board.length-1-x]==2){
                countO++;
            }
        }
        if (countX==3) return 1;
        if (countO==3) return 2;


        boolean allFull=true;
        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    allFull = false;
                    break;
                }
            }
            if (!allFull) break;
        }
        if (allFull) return 0;

        return 3;
    }

    public boolean setPiece(int x,int y, int player){
        if (board[y][x]!=0){
            System.out.println("Hier sitzt schon wer!");
            return false;
        }
        board[y][x]=player;
        return true;
    }

    public void printWinner(int wonResult){
        if (wonResult==0){
            System.out.println("No winner!!");
        }
        if (wonResult==1){
            System.out.println("Player X won!");
        }
        if (wonResult==2){
            System.out.println("Player O won!");
        }
    }

    public void print(int[][] board) {
        System.out.println("  A B C");
        for (int y = 0; y < board.length; y++) {
            System.out.print((y+1)+"|");
            for (int x = 0; x < board[y].length; x++) {
                switch (board[y][x]) {
                    case 0 -> System.out.print(" ");
                    case 1 -> System.out.print("X");
                    case 2 -> System.out.print("O");
                    default -> System.out.print("?");
                }
                System.out.print("|");
            }
            System.out.println();
            System.out.print(" |");
            for (int x = 0; x < board[y].length; x++) {
                System.out.print("--");
            }
            System.out.println();
        }
    }
}
