
package Day4;

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
      File myObj = new File("Day4/input.txt");
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
    int index = 0;
    int count = 0;
    while (index < myInput.size()) {
      String passport = myInput.get(index);
      boolean process = true;
      while (process) {
        index++;
        if (index < myInput.size() && !myInput.get(index).equals("")) {
          passport = passport + " " + myInput.get(index);
        } else {
          process = false;
        }
      }
      count += processPassport(passport);
      index++;
    }
    System.out.println(count);
  }

  private static int processPassport(String passport) {
    if (isPresent(passport)) {
      //System.out.println(passport);
      String[] values = passport.split(" ");
      boolean valid = true;
      for (String value : values) {
        String[] key = value.split(":");
        switch (key[0]) {
          case "byr":
            if (!isValidBirthYear(key[1])) {
              valid = false;
            }
            break;
          case "iyr":
            if (!isValidIssueYear(key[1])) {
              valid = false;
            }
            break;
          case "eyr":
            if (!isValidExpirationDt(key[1])) {
              valid = false;
            }
            break;
          case "ecl":
            if (!isValidEyeColor(key[1])) {
              valid = false;
            }
            break;
          case "pid":
            if (!isValidPassportID(key[1])) {
              valid = false;
            }
            break;
          case "hcl":
            if (!isValidHairColor(key[1])) {
              valid = false;
            }
            break;
          case "hgt":
            if (!isValidHeight(key[1])) {
              valid = false;
            }
            break;
        }
      }
      if (valid) {
        //System.out.println(passport);
        return 1;
      }
    }
    return 0;
  }

  private static boolean isValidBirthYear(String year) {
    int intYer = Integer.parseInt(year);
    return intYer >= 1920 && intYer <= 2002;
  }

  private static boolean isValidIssueYear(String year) {
    int intYer = Integer.parseInt(year);
    return intYer >= 2010 && intYer <= 2020;
  }

  private static boolean isValidExpirationDt(String year) {
    int intYer = Integer.parseInt(year);
    return intYer >= 2020 && intYer <= 2030;
  }

  private static boolean isValidEyeColor(String color) {
    return color.equals("amb") ||
      color.equals("blu") ||
      color.equals("brn") ||
      color.equals("gry") ||
      color.equals("grn") ||
      color.equals("hzl") ||
      color.equals("oth");
  }

  private static boolean isValidPassportID(String number) {
    boolean valid = number.length() == 9;
    if (!valid) {
      return false;
    }
    String[] values = number.split("");
    for (String value : values) {
      if (!isValidNumber(value)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isValidHairColor(String color) {
    String[] values = color.split("");
    if (!values[0].equals("#")) {
      return false;
    }
    if (values.length != 7) {
      return false;
    }
    boolean valid = true;
    for (int i = 1; i < values.length; i++) {
      if (!(isValidNumber(values[i]) || isValidLetter(values[i]))) {
        valid = false;
      }
    }
    return valid;
  }

  private static boolean isValidNumber(String num) {
      return num.equals("0") ||
          num.equals("1") ||
          num.equals("2") ||
          num.equals("3") ||
          num.equals("4") ||
          num.equals("5") ||
          num.equals("6") ||
          num.equals("7") ||
          num.equals("8") ||
          num.equals("9");
   }

  private static boolean isValidLetter(String letter) {
    return letter.equals("a") ||
        letter.equals("b") ||
        letter.equals("c") ||
        letter.equals("d") ||
        letter.equals("e") ||
        letter.equals("f");
  }

  private static boolean isValidHeight(String height) {
    if (height.contains("in")) {
      String in = height.replace("in", "");
      int value = Integer.parseInt(in);
      return value >= 59 && value <= 76;
    } else if (height.contains("cm")) {
      String cm = height.replace("cm", "");
      int value = Integer.parseInt(cm);
      return value >= 150 && value <= 193;
    } else {
      return false;
    }
  }

  private static boolean isPresent(String passport) {
    return passport.contains("byr")
        && passport.contains("iyr")
        && passport.contains("eyr")
        && passport.contains("hgt")
        && passport.contains("hcl")
        && passport.contains("ecl")
        && passport.contains("pid");
  }
}
