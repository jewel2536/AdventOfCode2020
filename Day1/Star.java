package Day1;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class Star {

  public static void main(String[] args) {
    System.out.println("Hello world");
    try {
      File myObj = new File("Day1/input.txt");
      Scanner myReader = new Scanner(myObj);
      ArrayList<Integer> myInput = new ArrayList<Integer>();
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        myInput.add(Integer.parseInt(data));
      }
      processInput(myInput);
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  private static void processInput(ArrayList<Integer> theInput) {
    for (Integer myValue : theInput) {
      for (Integer myOtherValue : theInput) {
        for (Integer myThirdValue : theInput) {
          int sum = myValue + myOtherValue + myThirdValue;
          if (sum == 2020) {
            System.out.println(myValue);
            System.out.println(myOtherValue);
            System.out.println(myThirdValue);
            System.out.println(myValue * myOtherValue * myThirdValue);
          }
        }
      }
    }

  }


}
