import java.util.*;
import java.io.*;

class Dictionary {
  private ArrayList<String> words;
  private ArrayList<String> userLengthListOfWords;
  private String dashes;
  private int userWordLength;
  private ArrayList<String> reducerList = new ArrayList<String>(); //listOfWordsContainingUserGuess
  private ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
  
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
  
  //Puts all of the words in userLengthListOfWords that contain userGuesses2 into another list. 
  public void sortListsWithLetter(int userWordLength, String userGuesses2) {
    for (int i = 0; i < userLengthListOfWords.size(); i++) {
      String temp = this.userLengthListOfWords.get(i);
      
      if (temp.contains(userGuesses2))
        this.reducerList.add(temp);
    }
  }
  
  //Categorise a list of lists, based on what position the letter is in a string. 
  public void categoriseLists(int userWordLength, String userGuesses2) {
    for (int i = 0; i < userWordLength; i++) {
      listOfLists.add(new ArrayList<String>());
      for (String word:userLengthListOfWords) {
        if (userGuesses2.equals(word.substring(i, i + 1))) {
          listOfLists.get(i).add(word);
        }
      }
    }
  }
  
  //Find out which list in listOfLists is bigger.
  public ArrayList<String> biggestList() {
    ArrayList<String> tempList = new ArrayList<String>();
    for (int i = 1; i < listOfLists.size(); i++) {
      if (listOfLists.get(i).size() > listOfLists.get(i - 1).size())
        tempList = listOfLists.get(i);
    }
    
    return tempList;
  }
  
  
  //Getters (returns the sizes of local variable lists)
  public int getWordsSize() {
    return this.words.size();
  }
  public int getUserLengthListOfWordsSize() {
    return this.userLengthListOfWords.size();
  }
  public int getReducerListSize() {
    return this.reducerList.size();
  }
  public int getListOfListsSize() {
    return this.listOfLists.size();
  }
  public ArrayList<String> getReducerList() {
    return reducerList;
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