import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Day01 {
  public static void main(String[] args) throws IOException {
    BufferedReader file = new BufferedReader(new FileReader("input.txt"));
    System.out.println("Result part one : " + firstPart(file));
    System.out.println("Result part two : " + secondPart(file));
    file.close();
  }

  public static Integer firstPart(BufferedReader file) throws IOException {
    Pattern oneIntPattern = Pattern.compile("·*\\d");
    Pattern twoIntsPattern = Pattern.compile("^\\D*(\\d|one|two|three|four|five|six|seven|eight|nine).*(\\d)\\D*$");
    Integer result = 0;
    String line;

    while((line = file.readLine()) != null) {
      Matcher oneIntMatcher = oneIntPattern.matcher(line);
      Matcher twoIntsMatcher = twoIntsPattern.matcher(line);
      // System.out.println("-----------------------------");
      // System.out.println(line);
      
      if (twoIntsMatcher.matches()) {
        result += Integer.parseInt(twoIntsMatcher.group(1) + twoIntsMatcher.group(2));
        // System.out.println(twoIntsMatcher.group(1) + twoIntsMatcher.group(2));
      } else if (oneIntMatcher.find()) {
        result += Integer.parseInt(oneIntMatcher.group()+oneIntMatcher.group());
        // System.out.println(oneIntMatcher.group()+oneIntMatcher.group());
      }
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