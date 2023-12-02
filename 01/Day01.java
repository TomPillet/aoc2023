import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Day01 {
  public static void main(String[] args) throws IOException {
    BufferedReader file = new BufferedReader(new FileReader("input.txt"));
    System.out.println("Result part one : " + firstPartWithRegex(file));
    System.out.println("Result part two : " + secondPart(file));
    file.close();
  }

  public static Integer firstPartWithRegex(BufferedReader file) throws IOException {
    Pattern oneIntPattern = Pattern.compile("·*\\d");
    Pattern twoIntsPattern = Pattern.compile("^\\D*(\\d|one|two|three|four|five|six|seven|eight|nine).*(\\d)\\D*$");
    Integer result = 0;
    String line;

    while((line = file.readLine()) != null) {
      Matcher oneIntMatcher = oneIntPattern.matcher(line);
      Matcher twoIntsMatcher = twoIntsPattern.matcher(line);

      if (twoIntsMatcher.matches()) {
        result += Integer.parseInt(twoIntsMatcher.group(1) + twoIntsMatcher.group(2));
      } else if (oneIntMatcher.find()) {
        result += Integer.parseInt(oneIntMatcher.group()+oneIntMatcher.group());
      }
    }
    return result;
  }

  public static Integer firstPart(BufferedReader file) throws IOException {
    Integer i, result = 0;
    String line;

    while((line = file.readLine()) != null) {
      String first = "", last = "";
      for (i=0; i<line.length(); i++) {
        if (Character.isDigit(line.charAt(i))) {
          if (first.isEmpty()) {
            first = ""+line.charAt(i);
          }
          last = ""+line.charAt(i);
        }
      }
      result += Integer.parseInt(first+last);
    }
    return result;
  }

  public static Integer secondPart(BufferedReader file) throws IOException {
  // Regex for second part :
  // ^.(one|two|three|four|five|six|seven|eight|nine|\d).*(\d)\D*$
    Integer result = 0;
    String line;

    return result;
  }
}