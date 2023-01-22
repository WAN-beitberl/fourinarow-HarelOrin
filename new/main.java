import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input;
        int first = 0;
        String c1;
        String c2;

        System.out.print("Pick player 1 color: ");
        c1 = scan.nextLine();
        System.out.println();
        System.out.print("Pick player 2 color: ");
        c2 = scan.nextLine();
        do {
            System.out.println();
            System.out.println("Pick if player 1 or 2 is first: ");
            first = scan.nextInt();
        } while (first != 1 && first != 2);
        Game myGame = new Game(c1, c2, first);

        do {
            
            myGame.myb.print();
            
            System.out.print(myGame.getCurrPlayer().getColor() + " player, please enter row to drop piece: ");
            
            input = scan.nextInt() - 1;
            System.out.println();
            
            if (input < 0 || input > 6 || myGame.myb.colFull(input)) {
                System.out.println("Invalid input");
            } else {
            
                myGame.playCol(input);
            
                myGame.changeCurrPlayer();

            }
        } while (myGame.checkWinner() == false);

        myGame.myb.print();

        System.out.println(myGame.getCurrPlayer().getColor() + " HAS WON!!"); 

        scan.close();
    }
}