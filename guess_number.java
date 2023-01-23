import java.util.*;
public class NumberGuessing {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
    public static void main(String[] args) {
        NumberGuessing methodChange = new NumberGuessing();
        methodChange.menu(scoreBoard);
    }
    public void menu(ArrayList<Integer> scoreBoard) {
        NumberGuessing methodChange = new NumberGuessing();
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("\n\nWelcome to guess number game");
        System.out.println("(1) Start the Game");
        System.out.println("(2) Score Board");
        System.out.println("(3) Exit the game");
        System.out.println("");
        try {
            System.out.print("Enter your choice from (1),(2),(3) : ");
            int menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.print("\n"+" Enter the range of numbers: ");
                    int numberRange = input.nextInt();
                    int randomNumber = methodChange.randomNumber(numberRange);
                    methodChange.guessNumber(randomNumber);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+" You are exitted from the game.");
                    System.out.println("Thankyou...!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid entry...!");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(scoreBoard);
        }
    }
    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }
    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("Lower");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("Your guess is right in " + guess + " try!");
        } else {
            System.out.println("Your guess is right in " + guess + " tries!\n");
        }
        scoreBoard.add(guess);
        System.out.println(" ");

        menu(scoreBoard);
    }
    public void displayScoreBoard() {
        System.out.println("-----------------------------");
        System.out.println("         Score Board         ");
        System.out.println("-----------------------------\n");
        System.out.println("Details of all your finished attempts : " +"\n");
        Collections.sort(scoreBoard);
        for (Integer scores : scoreBoard) {
            System.out.println("You've finished the game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(scoreBoard);
    }
}