import java.util.*;
import java.io.*;

class Game {
  private int numberOfGuesses;
  private List<String> userGuesses = new ArrayList<String>();
  //private boolean userYesOrNo;
  private String[] dashes;
  private Dictionary dict;
  
  //Constructor
  public Game(int numberOfGuesses, String userGuesses, int userLength) {
    this.numberOfGuesses = numberOfGuesses; //Give the object the number of guesses the user wants.
    this.userGuesses.add(userGuesses); //This will be what the user actually guesses (char).
    
    //Construct a string of dashes, the length of the user inputted length.
    this.dashes = new String[userLength];
    for (int i = 0; i < dashes.length; i++) {
      this.dashes[i] = "_";
    } 
  }
  
  //Method that returns the users guesses as a string.
  public String buildUserGuesses(Scanner keyboard) {
    userGuesses.add(keyboard.next());
    String[] tempArray = userGuesses.toArray(new String[0]);
    return Arrays.toString(tempArray).replace("[", "").replace(",", "").replace("]", "");
  }
  
  //Modifies the "dashes" as the user gets a correct input. 
//  public boolean modifyDashes(ArrayList<String> mostOptions, String userGuesses2) {
//    String temp = "";
//    for (int i = 0; i < mostOptions.size(); i++) {
//      temp = mostOptions.get(i);
//      for (int j = 0; j < dashes.length; j++) {
//        if (temp.substring(j, j + 1).equals(userGuesses2)) {
//          dashes[j] = userGuesses2;
//          return true;
//        }
//      }
//    }
//    return false;
//  }
  
  //Getters
  public int getNumberOfGuesses() {
    return numberOfGuesses;
  }
  public int getUserGuessesSize() {
    return userGuesses.size();
  }
  public String getDashes() {
    return Arrays.toString(dashes);
  }
  
  //Method for printing the users guesses as they type them.

}