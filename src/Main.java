import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Application app=new Application();

        app.init();
        app.print(app.board);

        var scanner=new Scanner(System.in);
        int winresult=3;
        while (winresult==3){
            // PLayer X einlesen

            // Pos auswerten
            boolean valid=false;
            while (!valid){
                System.out.print("Player X:");
                var pos=scanner.nextLine();
                valid=app.validatePos(pos);
                if (!valid){
                    System.out.println("Falsche Eingabe!");
                    continue;
                }
                int x=app.getX(pos);
                int y=app.getY(pos);

                valid = app.setPiece(x, y, 1);
            }
            app.print(app.board);

            winresult=app.whoWon();
            app.printWinner(winresult);
            if (winresult!=3) continue;
            // Stein X setzen

            // Player O einlesen

            //pos=scanner.nextLine();
            valid=false;
            while (!valid){
                System.out.print("Player O:");
                var pos=scanner.nextLine();
                valid=app.validatePos(pos);
                if (!valid){
                    System.out.println("Falsche Eingabe!");
                    continue;
                }
                int x=app.getX(pos);
                int y=app.getY(pos);

                valid = app.setPiece(x, y, 2);
            }
            app.print(app.board);

            winresult=app.whoWon();
            app.printWinner(winresult);
            // Pos auswerten
            // Stein X setzen
        }

        System.out.println("Thank you for the game...");

    }
}