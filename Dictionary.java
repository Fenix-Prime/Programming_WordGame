import java.util.*;
import java.io.*;

class Dictionary {
  private List<String> words;
  private List<String> userLengthListOfWords;
  private String dashes;
  private int userWordLength;
  
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
    
    //Construct a string of dashes, the length of the user inputted length.
    List<String> tempList = new ArrayList<String>();
    for (int i = 0; i < userLength; i++) {
      tempList.add("_ ");
    }
    String[] tempArray = tempList.toArray(new String[0]);
    this.dashes = Arrays.toString(tempArray).replace("[", "").replace(",", "").replace("]", "");
    
    //Make sure each Dictionary object has a copy of the userLength
    this.userWordLength = userLength;
  }
  
  //Getters (returns the sizes of local variable lists)
  public int getWordsSize() {
    return this.words.size();
  }
  public int getUserLengthListOfWordsSize() {
    return this.userLengthListOfWords.size();
  }
  public String getDashes() {
    return this.dashes;
  }
  public int getUserWordLength() {
    return this.userWordLength;
  }
}