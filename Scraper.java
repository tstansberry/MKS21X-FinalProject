import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {
  public static void main(String args[]) throws IOException {
    System.out.println(getDefinition(args[0], Integer.parseInt(args[1])));
  }

  public static String getDefinition(String word, int definitionNumber) throws IOException {
    try {
      Document doc;
      doc = Jsoup.connect("https://www.dictionary.com/browse/" + word.toLowerCase()).get();
      Elements ol = doc.getElementsByTag("ol");
      Element targetInfo = ol.get(0);
      Elements li = targetInfo.getElementsByTag("li");
      boolean found = false;
      Element clutteredDefinition = null;
      for (int x = 0; x < li.size() && ! found; x ++) {
        clutteredDefinition = li.get(x);
        if (checkValueTag(clutteredDefinition, definitionNumber)) found = true;
      }
      if (! found) throw new IndexOutOfBoundsException();
      return clutteredDefinition.toString();
    }
    catch(IndexOutOfBoundsException e) {
      return "Uh oh, something went wrong. Please make sure your number and word are correct!";
    }
    catch(org.jsoup.HttpStatusException e) {
      return "Uh oh, something went wrong. Please make sure your number and word are correct!";
    }
  }

  private static boolean checkValueTag(Element html, int target) {
    target ++;
    String htmlString = html.toString();
    if (! htmlString.substring(4, 9).equals("value")) return false;
    char targetChar = (char)(target + '0');
    if (targetChar != htmlString.charAt(11)) return false;
    return true;
  }
}
