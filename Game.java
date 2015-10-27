import java.util.*;
import java.io.*;

class Game {
  private int numberOfGuesses;
  private List<String> userGuesses = new ArrayList<String>();
  //private boolean userYesOrNo;
  private Dictionary dict;
  
  //Constructor
  public Game(int numberOfGuesses, String userGuesses) {
    this.numberOfGuesses = numberOfGuesses; //Give the object the number of guesses the user wants.
    this.userGuesses.add(userGuesses); //This will be what the user actually guesses (char).
  }
  
  //Getters
  public int getNumberOfGuesses() {
    return numberOfGuesses;
  }
  public int getUserGuessesSize() {
    return userGuesses.size();
  }
  
  //Method for printing the users guesses as they type them.

}