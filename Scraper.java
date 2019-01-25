import java.io.IOException;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {
  public static void main(String args[]) throws IOException {
    System.out.println(master(args[0], args[1]));
    //System.out.println(getRandomWord());
  }

  //Compiles all the methods into one, taking the place of main
  public static String master(String returnType, String word) throws IOException{
    String error = "Uh oh, something went wrong. Please make your inputs are formatted correctly: \"<return type> + <word>\"";
    if (returnType.equals("definition")) return getDefinition(word) ;//return getDefinition(word, 0);
    else if (returnType.equals("synonyms")) return getSynonyms(word);
    else {
      return error;
    }
  }

  //Original code, gets a specific definition for a word
  public static String getDefinition(String word) throws IOException {
    String error = "Uh oh, something went wrong. Please make your inputs are formatted correctly: \"<return type> + <word>\"";
    try {
      Document doc;
      doc = Jsoup.connect("https://www.dictionary.com/browse/" + word.toLowerCase()).get();
      Elements div = doc.getElementsByTag("div");
      int value = 0;
      String output = "";
      for (int x = 0; x < div.size(); x ++) {
        if (checkValueTag(div.get(x), value)) {
          output += (value + 1) + "." + html2text(div.get(x).toString()) + "___\"";
          value ++;
        }
      }
      return output;
      //Old code, before the html on dictionary.com was changed
      /*
      Elements ol = doc.getElementsByTag("ol");
      Element targetInfo = ol.get(0);
      Elements li = targetInfo.getElementsByTag("li");
      boolean found = false;
      Element clutteredDefinition = null;
      return li.toString();

      for (int x = 0; x < li.size() && ! found; x ++) {
        clutteredDefinition = li.get(x);
        if (checkValueTag(clutteredDefinition, definitionNumber)) found = true;
      }
      if (! found) throw new IndexOutOfBoundsException();
      return clutteredDefinition.wholeText().toString();
      */
    }
    catch(IndexOutOfBoundsException e) {
      return "1 " + error;
    }
    catch(org.jsoup.HttpStatusException e) {
      return "2 " + error;
    }
  }


  public static String getSampleDefinition(String word) throws IOException {
    String error = "Uh oh, something went wrong. Please make your inputs are formatted correctly: \"<return type> + <word>\"";
    try {
      Document doc;
      doc = Jsoup.connect("https://www.dictionary.com/browse/" + word.toLowerCase()).get();
      Elements div = doc.getElementsByTag("div");
      int value = 0;
      String output = "";
      for (int x = 0; x < div.size() && value < 1; x ++) {
        if (checkValueTag(div.get(x), value)) {
          output += (value + 1) + "." + html2text(div.get(x).toString()) + "___\"";
          value ++;
        }
      }
      return output;
    }
    catch(IndexOutOfBoundsException e) {
      return "1 " + error;
    }
    catch(org.jsoup.HttpStatusException e) {
      return "2 " + error;
    }
  }


  //Using the previous method, gets all the definitions for a word
  /*
  public static String getAllDefinitions(String word) throws IOException{
    String error = "Uh oh, something went wrong. Please make your inputs are formatted correctly: \"<return type> + <word>\"";
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
  }*/

  //Uses thesaurus.com to get the synonyms for a given word
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
      return "Uh oh, something went wrong. Please make your inputs are formatted correctly: \"<return type> + <word>\"";
    }
  }

  //Helper function for getDefinition
  private static boolean checkValueTag(Element html, int target) {
    target ++;
    String htmlString = html.toString();
    if (! htmlString.substring(5, 10).equals("value")) return false;
    if (! findTarget(htmlString).equals(target + "")) return false;
    return true;
  }

  public static String findTarget(String html) {
    String output = "";
    int start = html.indexOf("\"");
    boolean finished  = false;
    for (int x = start + 1; ! finished; x ++) {
      if (html.charAt(x) == '\"') finished = true;
      else {
        output += html.charAt(x);
      }
    }
    return output;
  }

  //Removes the html tags from a string
  private static String html2text(String html) {
    return Jsoup.parse(html).text();
  }

  public static String getRandomWord() throws IOException{
    try {
      Document doc;
      doc = Jsoup.connect("https://htmlstrip.com/random-word-generator/").get();

      Elements div = doc.getElementsByTag("div");
      Element specificDiv = div.get(16);
      Elements span = specificDiv.getElementsByTag("span");
      Random rand = new Random();
      int n = rand.nextInt(span.size());
      Element specificSpan = span.get(n);
      return html2text(specificSpan.toString());
    }
    catch(org.jsoup.HttpStatusException e) {
      return "Uh oh, something went wrong. Please make your inputs are formatted correctly: \"<return type> + <word>\"";
    }
  }
}
