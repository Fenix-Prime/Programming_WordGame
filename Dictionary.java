import java.util.*;
import java.io.*;

class Dictionary {
  private ArrayList<String> words;
  private ArrayList<String> userLengthListOfWords;
  private String dashes;
  private int userWordLength;
  private ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
  private ArrayList<String> mostOptions = new ArrayList<String>();
  
  //Constructer that parses in an int which is the length of the word the user would like.
  public Dictionary(int userLength) throws FileNotFoundException {
    //Construct words
    words = new ArrayList<String>();
    try {
      Scanner text = new Scanner(new BufferedReader(new FileReader("dictionary.txt")));
      while (text.hasNext()) {
        this.words.add(text.next());
      }
    } catch (FileNotFoundException e) {System.out.println("File not found.");}
    
    //Construct the List of words with the user inputten length.
    this.userLengthListOfWords = new ArrayList<String>();
    String temp;
    
    for (int i = 0; i < words.size(); i++) {
      temp = words.get(i); //Change temp at each index.
      if (temp.length() == userLength) {
        this.userLengthListOfWords.add(temp); //If the length of temp is == to userLength, add it to the new list.
      }
    }
    
    //Make sure each Dictionary object has a copy of the userLength
    this.userWordLength = userLength;
  }
  
  //Categorise a list of lists, based on what position the letter is in a string. Then returns the largest list. 
  public void biggestList(int userWordLength, String tempGuess) {
    for (int i = 0; i < userWordLength; i++) {
      listOfLists.add(new ArrayList<String>());
      for (String word:userLengthListOfWords) {
        if (tempGuess.equals(word.substring(i, i + 1))) {
          listOfLists.get(i).add(word);
        }}}
    
    ArrayList<String> tempList = new ArrayList<String>();
    for (int i = 1; i < listOfLists.size(); i++) {
      if (listOfLists.get(i).size() > listOfLists.get(i - 1).size())
        tempList = listOfLists.get(i);
    }
    
    this.mostOptions = tempList;
  }
  
  public void modifyMostOptions(String userGuesses2) {
    String temp = "";
    ArrayList<String> tempList = new ArrayList<String>();
    for (int i = 0; i < mostOptions.size(); i++) {
      temp = mostOptions.get(i);
      for (int j = 0; j < temp.length(); i++) {
        if (temp.substring(j, j + 1).equals(userGuesses2)) {
          tempList.add(temp);
        }
      }
    }
    
    this.mostOptions = tempList;
  }
  
  //Getters (returns the sizes of local variable lists)
  public int getWordsSize() {
    return this.words.size();
  }
  public int getUserLengthListOfWordsSize() {
    return this.userLengthListOfWords.size();
  }
  public int getListOfListsSize() {
    return this.listOfLists.size();
  }
  public int getMostOptionsSize() {
    return this.mostOptions.size();
  }
  public ArrayList<String> getMostOptions() {
    return this.mostOptions;
  }
  public ArrayList<String> getWords() {
    return this.words;
  }
  public ArrayList<String> getUserLengthListOfWords() {
    return this.userLengthListOfWords;
  }
  public ArrayList<ArrayList<String>> getListOfLists() {
    return this.listOfLists;
  }
  public int getUserWordLength() {
    return this.userWordLength;
  }
}