import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {
  public static void main(String args[]) throws IOException {
    System.out.println(getDefinition("help"));
  }

  public static String getDefinition(String word) throws IOException {
    Document doc;
    doc = Jsoup.connect("https://www.dictionary.com/browse/" + word.toLowerCase()).get();
    return doc.toString();
  }
}
