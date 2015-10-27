import java.util.*;
import java.io.*;

public class WordGame {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Hello and welcome to the game! Please enter a word length, between 1 and 29 inclusive.");
    int userWordLength = validWordLength(keyboard);
    //System.out.println(userWordLength);
    System.out.println("Now please enter the amount of guesses you would like to have.");
    int numberOfGuesses = keyboard.nextInt();
    //System.out.println(numberOfGuesses);
    //Running total of words.
    
    //Create a Dictionary object based on user input.
    Dictionary dict = new Dictionary(userWordLength);
    //These were for testing. 
    //System.out.println("Old List: " + dict.getWordsSize());
    //System.out.println("New List: " + dict.getUserLengthListOfWordsSize());
    //System.out.println(dict.getDashes());
    //System.out.println(dict.getUserWordLength());
    
    //Create a Game object based on user input.
    Game gme = new Game(numberOfGuesses, "");
    //Testing
    //System.out.println(gme.getNumberOfGuesses());
    //System.out.println(gme.getUserGuessesSize());
    System.out.println("You have chosen: " + numberOfGuesses +" guesses.");
    System.out.println("Your word is: " + userWordLength + " characters long.");
    System.out.println("Good luck! Please make your first guess.");
    System.out.println(dict.getDashes());
  }
  
  //Method that makes sure the number is between 1 and 29 (the minimum and maximum length of a word).
  public static int validWordLength(Scanner keyboard) {
    int length = 0;
    while (true) {
      try
      {
        length = keyboard.nextInt();
        if(length <= 0 || length > 29) throw new InputMismatchException();
        else break;
      } catch (InputMismatchException ex){
        System.out.println("Oops! Try again. A number between 0 and 29.");
      }
    }
    return length;
  }
}