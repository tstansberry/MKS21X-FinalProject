import java.io.IOException;

public class MatchingGame{
  public String[] wordBank;
  public String[] answers;

  public static void main(String[] args) throws IOException{
    MatchingGame game = new MatchingGame(10);
    for (int x = 0; x < 10; x ++) {
      System.out.println(game.wordBank[x]);
    }
    System.out.println("Answer: " + game.answers[0]);
    System.out.println("Definition: " + game.answers[1]);
  }

  public MatchingGame(int length) throws IOException{
    generateWords(length);
    generateAnswers();
  }

  private void generateWords(int quantity) throws IOException{
    wordBank = new String[quantity];
    for (int x = 0; x < quantity; x ++) {
      wordBank[x] = Scraper.getRandomWord();
    }
  }

  private void generateAnswers() throws IOException{
    answers = new String[2];
    answers[0] = Scraper.getRandomWord();
    answers[1] = Scraper.getDefinition(answers[0]);
  }
}
