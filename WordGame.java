import java.util.*;
import java.io.*;

public class WordGame {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Hello and welcome to the game! Please enter a word length, between 1 and 29 inclusive.");
    int userWordLength = validWordLength(keyboard);
    System.out.println("Now please enter the amount of guesses you would like to have.");
    int numberOfGuesses = keyboard.nextInt();
    
    //Create a Dictionary object based on user input.
    Dictionary dict = new Dictionary(userWordLength);
    //Create a Game object based on user input.
    Game gme = new Game(numberOfGuesses, "", userWordLength);
    
    System.out.println("You have chosen: " + numberOfGuesses +" guesses.");
    System.out.println("Your word is: " + userWordLength + " characters long.");
    System.out.println(gme.getDashes().replace("[", "").replace(",", "").replace("]", ""));
    System.out.println("Good luck! Please make your first guess.");
    
    String userGuesses = ""; //What the user actually guesses.
    String userGuesses2 = ""; //This will be the LAST LETTER the user guessed.
    int count = 0;
    ArrayList<String> mostOptions;
    while (count < numberOfGuesses) {
      userGuesses = gme.buildUserGuesses(keyboard);
      count++;
      System.out.println("You have guessed: " + userGuesses);
      
      userGuesses2 = userGuesses.substring(userGuesses.length() - 1, userGuesses.length()); //Get the last Guess.
      
      dict.sortListsWithLetter(userWordLength, userGuesses2); //Reduce and sort a list of words that only contain the last guess.
      
      dict.categoriseLists(userWordLength, userGuesses2);//This makes a lists of lists, categorising each list by index of userGesses2
      mostOptions = dict.biggestList();//Find the biggest list (most options) in the list of lists.
      System.out.println(mostOptions);
      if (gme.modifyDashes(mostOptions, userGuesses2))
        System.out.println(gme.getDashes().replace("[", "").replace(",", "").replace("]", ""));
      else
        System.out.println("KJN");

    }
  }
  
  
  //Method that makes sure the number is between 1 and 29 (the minimum and maximum length of a word).
  public static int validWordLength(Scanner keyboard) {
    int length = 0;
    while (true) {
      try
      {
        length = keyboard.nextInt();
        if((length <= 0 || length > 29)) throw new InputMismatchException();
        else break;
      } catch (InputMismatchException ex){
        System.out.println("Oops! Try again. A number between 0 and 29.");
      }
    }
    return length;
  }
}