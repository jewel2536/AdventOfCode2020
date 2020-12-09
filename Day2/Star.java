package Day2;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class Star {

  public static void main(String[] args) {
    System.out.println("Hello world");
    try {
      File myObj = new File("Day2/input.txt");
      Scanner myReader = new Scanner(myObj);
      int count = 0;
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if (isValidPassword(data)) {
          count++;
        }
      }
      System.out.println(count);
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  private static boolean isValidPassword(String theInput){
    String[] myValues = theInput.split(" ");
    String[] myMinMaxs = myValues[0].split("-");
    int min = Integer.parseInt(myMinMaxs[0]);
    int max = Integer.parseInt(myMinMaxs[1]);
    String letter = myValues[1].substring(0,1);

    String[] myPassword = myValues[2].split("");

    int count = 0;

    if (max > myPassword.length) {
      return false;
    }

    String myChar1 = myPassword[min-1];
    String myChar2 = myPassword[max-1];

    if (!myChar1.equals(myChar2) && (
      myChar1.equals(letter) || myChar2.equals(letter)
    )) {
      return true;
    }

    return false;
  }
}
