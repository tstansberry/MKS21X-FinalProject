import java.io.IOException;
import java.util.Random;
import java.io.*;
import java.util.*;

public class MatchingGame{
  private ArrayList<String> wordBank;
  private int size;
  private ArrayList<String> answers;


  public static void main(String[] args) throws IOException{
    MatchingGame game = new MatchingGame(10);
    for (int x = 0; x < 10; x ++) {
      System.out.println((x + 1) + ". " + game.wordBank.get(x));
    }
    //System.out.println("Answer: " + game.answers.get(0));
    System.out.println("Definition: \n" + game.answers.get(1));
    System.out.println("Answer: " + game.getAnswer());

    game.resetGame(10);
    System.out.println("\n\n");
    for (int x = 0; x < 10; x ++) {
      System.out.println((x + 1) + ". " + game.wordBank.get(x));
    }
    //System.out.println("Answer: " + game.answers.get(0));
    System.out.println("Definition: \n" + game.answers.get(1));
    System.out.println("Answer: " + game.getAnswer());
    game.resetGame(10);
  }

  public MatchingGame(int length) throws IOException{
    generateWords(length);
    generateAnswers();
    randomizeWords();
  }

  private void generateWords(int quantity) throws IOException{
    wordBank = new ArrayList<String>(quantity + 1);
    size = quantity + 1;
    for (int x = 0; x < quantity; x ++) {
      wordBank.add(Scraper.getRandomWord());
    }
  }

  private void generateAnswers() throws IOException{
    answers = new ArrayList<String>(2);
    answers.add(Scraper.getRandomWord());
    wordBank.add(answers.get(0));
    answers.add(Scraper.getDefinition(answers.get(0)));
  }

  private void randomizeWords() {
    ArrayList<String> output = new ArrayList<String>(size);
    Random rand = new Random();
    for (int x = 0; x < size; x ++) {
      int n = rand.nextInt(wordBank.size());
      output.add(wordBank.remove(n));
    }
    wordBank = output;
  }

  public String generateWordBank() {
    String output = "";
    for (int x = 0; x < size; x ++) {
      output += wordBank.get(x) + ", ";
    }
    output = output.substring(0, output.length() - 2);
    return output;
  }

  public String getDefinition() {
    return answers.get(1);
  }

  public String getAnswer() {
    return answers.get(0);
  }

  public boolean checkAnswer(String input) {
    return input.equals(answers.get(0));
  }

  public void resetGame(int length) throws IOException{
    generateWords(length);
    generateAnswers();
    randomizeWords();
  }
}
