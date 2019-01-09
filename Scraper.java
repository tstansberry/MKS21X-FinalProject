import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {
  public static void main(String args[]) throws IOException {
    System.out.println(getDefinition("help", 0));
  }

  public static String getDefinition(String word, int definitionNumber) throws IOException {
    Document doc;
    doc = Jsoup.connect("https://www.dictionary.com/browse/" + word.toLowerCase()).get();
    /*
    Elements metas = doc.getElementsByTag("meta");
    Element data = metas.get(1);
    String output = data.toString();
    output = output.substring(34, output.length() - 11);
    */
    try {
      Elements ol = doc.getElementsByTag("ol");
      Element targetInfo = ol.get(0);
      Elements li = targetInfo.getElementsByTag("li");
      Element clutteredDefinition = li.get(definitionNumber);
      String output = clutteredDefinition.getAttribute("value");
      return output;
    }
    catch(IndexOutOfBoundsException e) {
      return "Uh oh, something went wrong. Please make sure your number and word are correct!";
    }
  }
}
