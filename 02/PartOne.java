import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PartOne {
    private static Pattern gameIdPattern = Pattern.compile("Game(\\d+):.*");
    private static Pattern blueNumberPattern = Pattern.compile("(\\d+)blue");
    private static Pattern greenNumberPattern = Pattern.compile("(\\d+)green");
    private static Pattern redNumberPattern = Pattern.compile("(\\d+)red");

    private static int maxBlueCubes = 14, maxGreenCubes = 13, maxRedCubes = 12;
            
    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("input.txt"));
        String line;
        int countValidGames = 0;

        while ((line = file.readLine()) != null) {
            String game = line.replaceAll("\\s", "");
            Matcher gameIdMatcher = gameIdPattern.matcher(game);
            
            if(gameIdMatcher.find() && isGameValid(game)) { 
                countValidGames += Integer.parseInt(gameIdMatcher.group(1));
            }
        }
        System.out.println("Valid games = "+countValidGames);
        file.close();
    }
    
    private static boolean isGameValid(String game) {
        game = game.replaceAll("Game(\\d+):","");
        String[] sets = game.split(";");
        
        for (int i=0; i<sets.length; i++) {
            String currentSet = sets[i];
            int blueCubes = extractNumberOfCubesByColor(currentSet, blueNumberPattern);
            int greenCubes = extractNumberOfCubesByColor(currentSet, greenNumberPattern);
            int redCubes = extractNumberOfCubesByColor(currentSet, redNumberPattern);
            
            if (maxBlueCubes < blueCubes || maxGreenCubes < greenCubes || maxRedCubes < redCubes) {
                return false;
            }
        }
        return true;
    }

    private static int extractNumberOfCubesByColor(String set, Pattern patternColor) {
        Matcher colorNumberMatcher = patternColor.matcher(set);
        return colorNumberMatcher.find() ? Integer.parseInt(colorNumberMatcher.group(1)) : 0;
    }
}
