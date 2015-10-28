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
    
    String userGuesses = "";
    String userGuesses2 = "";
    String tempGuess = "";
    
    userGuesses = gme.buildUserGuesses(keyboard); //What the user actually guesses.
    tempGuess = userGuesses.substring(1, 2); //A String that is only used once to build biggestList.
    System.out.println("You have guessed: " + userGuesses);
    
    dict.biggestList(userWordLength, tempGuess);
    System.out.println(dict.getMostOptions());
    
    int count = 0;
    while (count < numberOfGuesses - 1) {
      userGuesses = gme.buildUserGuesses(keyboard);
      System.out.println("You have guessed: " + userGuesses); 
      count++;
      
      userGuesses2 = userGuesses.substring(userGuesses.length() - 1, userGuesses.length()); //This will be the LAST LETTER the user guessed.
      dict.modifyMostOptions(userGuesses2);
      System.out.println(dict.getMostOptions());
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