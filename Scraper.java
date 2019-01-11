import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {
  public static void main(String args[]) throws IOException {
    System.out.println(getSynonyms("help"));
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
      /*
      if (definitionNumber == null || definitionNumber == 0){
        return getAllDefinitions(word);
      }
      */
      if (! found) throw new IndexOutOfBoundsException();
      return clutteredDefinition.wholeText().toString();
    }
    catch(IndexOutOfBoundsException e) {
      return "Uh oh, something went wrong. Please make sure your number and word are correct!";
    }
    catch(org.jsoup.HttpStatusException e) {
      return "Uh oh, something went wrong. Please make sure your number and word are correct!";
    }
  }

  public static String getSynonyms(String word) throws IOException{
    try {
      Document doc;
      doc = Jsoup.connect("https://www.thesaurus.com/browse/" + word.toLowerCase()).get();

      Elements section = doc.getElementsByTag("section");
      Element targetInfo = section.get(2);
      Elements li = targetInfo.getElementsByTag("li");
      boolean found = false;
      String output = "";
      for (int x = 0; x < li.size(); x ++) {
        output += html2text(li.get(x).toString()) + ", ";
      }
      output.substring(0, output.length() - 2);
      return output;
    }
    catch(org.jsoup.HttpStatusException e) {
      return "Uh oh, something went wrong. Please make sure your number and word are correct!";
    }
  }

  public static String getAllDefinitions(String word) throws IOException{
    String error = "Uh oh, something went wrong. Please make sure your number and word are correct!";
    String output = "";
    boolean stopped = false;
    for (int x = 0; ! stopped; x ++) {
      if (! getDefinition(word, x).equals(error)) {
        output += (x + 1) + ". " + getDefinition(word, x) + "\n";
      }
      else {
        stopped = true;
        if (x == 0) return error;
      }
    }
    return output;
  }

  private static boolean checkValueTag(Element html, int target) {
    target ++;
    String htmlString = html.toString();
    if (! htmlString.substring(4, 9).equals("value")) return false;
    char targetChar = (char)(target + '0');
    if (targetChar != htmlString.charAt(11)) return false;
    return true;
  }

  public static String html2text(String html) {
    return Jsoup.parse(html).text();
}

}
