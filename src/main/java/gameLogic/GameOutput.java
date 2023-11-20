package gameLogic;

public class GameOutput {
    public void outputGreetings() {
        System.out.println("Enter box number to select. Enjoy!\n");
    }

    public void outputGameOver(int winner) {
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }
}
