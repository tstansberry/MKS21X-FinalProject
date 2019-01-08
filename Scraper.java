import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {
  public static void main(String args[]) throws IOException {
    System.out.println(getDefinition(args[0]));
  }

  public static String getDefinition(String word) throws IOException {
    Document doc;
    doc = Jsoup.connect("https://www.dictionary.com/browse/" + word.toLowerCase()).get();
    Elements metas = doc.getElementsByTag("meta");
    Element data = metas.get(1);
    String output = data.toString();
    output = output.substring(34, output.length() - 11);
    return output;
  }
}
