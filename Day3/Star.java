
package Day3;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Star {

  public static void main(String[] args) {
    System.out.println("Hello world");
    try {
      File myObj = new File("Day3/input.txt");
      Scanner myReader = new Scanner(myObj);
      ArrayList<String> myInput = new ArrayList<String>();
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        myInput.add(data);
      }
      processInput(myInput);
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void processInput(ArrayList<String> myInput) {
    int numRows = myInput.size();
    int numColumns = numRows * 7;
    List<List<String>> map = new ArrayList<List<String>>();

    for(String myRow : myInput) {
      String myNewRow = "";
      while (myNewRow.length() < numColumns) {
        myNewRow = myNewRow + myRow;
      }
      String[] myListRow = myNewRow.split("");
      map.add(Arrays.asList(myListRow));
    }

    int treeCount = 1;
    treeCount = treeCount * tryPath(map, 1, 1);
    treeCount = treeCount * tryPath(map, 3, 1);

    treeCount = treeCount * tryPath(map, 5, 1);
    treeCount = treeCount * tryPath(map, 7, 1);
    treeCount = treeCount * tryPath(map, 1, 2);

    System.out.println(treeCount);
  }

  private static int tryPath(List<List<String>> map, int xInc, int yInc) {
    int treeCount = 0;
    int x = 0;
    int y = 0;
    while(y < map.size()) {
      String space = map.get(y).get(x);
      if (space.equals("#")) {
        treeCount++;
      }
      x = x + xInc;
      y = y + yInc;
    }
    return treeCount;
  }

}
