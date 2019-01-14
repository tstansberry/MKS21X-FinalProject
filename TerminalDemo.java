//API : http://mabe02.github.io/lanterna/apidocs/3.0/
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.io.IOException;
import com.googlecode.lanterna.gui2.Label.*;
import java.awt.Color;
import java.util.*;
import java.io.*;


public class TerminalDemo {

  public static void putString(int x, int y, Screen screen, String str) {
    for (int i = 0; i < str.length(); ++i) {
      screen.setCharacter(x+i, y, new TextCharacter(str.charAt(i)));
    }
  }  // changes the row value and allows you to add text throughout the screen

  public static void putStringSpecial(int x, int y, Screen screen, String str) {
    int checker = x;
    int placeholder = 0;
    for (int index = 0; index < str.length(); index++) {
      if (str.charAt(index) == '|') {
        y++;
        placeholder = 0;
      }
      else if ((x+placeholder) % (screen.getTerminalSize().getColumns()-5) == 0){
        y ++ ;
        placeholder = 0;
      }
      else{
        placeholder++;
      }
      screen.setCharacter(x+placeholder, y, new TextCharacter(str.charAt(index)));
    } // breaks the code based on the screen size

<<<<<<< HEAD
    // yours would add a new feature which breaks the line based off \n does that make sense to you
    // yea basically we are coding the best possible version of a putString
    // you cant j copy paste it youll have to integrate it into it // yours matters more because mine wont work unless yours does
    // just check the logic and even if one word works we are valid // is there any word that only has 1 defintion lol
    // also we could change the Scraper to only return one def
    screen.doResizeIfNecessary();
  }
=======
  screen.doResizeIfNecessary();
}


public static void main(String[] args) throws IOException {

  Screen screen = new DefaultTerminalFactory().createScreen();
  screen.startScreen(); // display and creation of screen

  long tStart = System.currentTimeMillis();
  long temptime = 0;
  long tempend = 0;
  long lastSecond = 0;
  String output = "";
  boolean checker = true;
  boolean firstEnterOver = false;
  boolean SecondEnter = false;
  String mode = "";

  TerminalSize size = screen.getTerminalSize();
  TextGraphics tg = screen.newTextGraphics();

  while (checker) {

    long tEnd = System.currentTimeMillis();
    long millis = tEnd - tStart;
    if(millis/1000 > lastSecond){
      lastSecond = millis / 1000;
      putString(1,3,screen,"Seconds since start of program: "+lastSecond);
>>>>>>> 980a17d331d8aa6af7d0d6778606f87f52b71454


  public static void main(String[] args) throws IOException {

    Screen screen = new DefaultTerminalFactory().createScreen();
    screen.startScreen(); // display and creation of screen

    long tStart = System.currentTimeMillis();
    long temptime = 0;
    long tempend = 0;
    long lastSecond = 0;
    String output = "";
    boolean checker = true;
    boolean firstEnterOver = false;
    boolean SecondEnter = false;
    String mode = "";

    TerminalSize size = screen.getTerminalSize();
    TextGraphics tg = screen.newTextGraphics();

    while (checker) {

      long tEnd = System.currentTimeMillis();
      long millis = tEnd - tStart;
      if(millis/1000 > lastSecond){
        lastSecond = millis / 1000;
        putString(1,3,screen,"Seconds since start of program: "+lastSecond);
        
      }
      putString(1,2,screen,"WELCOME TO YOUR TERMINAL DICTIONARY");
      // putString(1,2,screen,""+size.getRows()+" "+size.getColumns()); // for testing

      // Resize Screen and Display Content
      TerminalSize testsize = screen.getTerminalSize();
      if (testsize.getRows() != size.getRows() || testsize.getColumns() != size.getColumns()) {
        screen.clear();
        size = testsize;

      }

      putString(1,7,screen,"Please start typing a word. Press ENTER after you are done. You can DELETE to fix any mistakes you make.");


      KeyStroke key = screen.pollInput();
      if (key != null && !firstEnterOver) {
        if (key.getKeyType() == KeyType.Escape){
          checker = false;
        }

        if ((key.getKeyType() == KeyType.Character)) {
          output += key.getCharacter();
        }

        if (key.getKeyType() == KeyType.Backspace) {
<<<<<<< HEAD
          output = output.substring(0, output.length() - 1);
          screen.refresh();
        }
=======
          mode = mode.substring(0, mode.length() - 1);
          screen.refresh();
        }

        if ((key.getKeyType() == KeyType.Enter)){
          putString(1,15,screen,"The mode you have requested is: " + mode + ".");
          SecondEnter =  true;
>>>>>>> 980a17d331d8aa6af7d0d6778606f87f52b71454

        if ((key.getKeyType() == KeyType.Enter)){
          putString(1,10,screen,"The word you have inputted is: " + output + ".");
          firstEnterOver = true;
          key = null;
        }
      }

      putString(1,9,screen,output);

      if (firstEnterOver){
        putString(1,12,screen,"Please choose a mode. The available modes are: (1) defintion and (2) synonym. Input either 1 or 2.");
        putString(1,13,screen,"Press ENTER after you are done. You can DELETE to fix any mistakes you make.");

        if (key != null) {
          if (key.getKeyType() == KeyType.Escape){
            checker = false;

          }

          if ((key.getKeyType() == KeyType.Character)) {
            mode += key.getCharacter();
          }

          if ((key.getKeyType() == KeyType.Enter)){
            putString(1,15,screen,"The mode you have requested is: " + mode + ".");
            SecondEnter =  true;

          }
        }

        putString(1,14,screen,mode);
      }

      if (SecondEnter){
        if (mode.equals("1")) {
          putString(1,17,screen, "Successful Mode Entry!");
          String result = Scraper.master("definition", output);
          String lookingFor = "\n";
          String replaceWith = "|";
          String newResult = result.replace(lookingFor,replaceWith);
          screen.doResizeIfNecessary();
          putStringSpecial(1,19,screen,newResult);
        }
        else if (mode.equals("2")) {
          putString(1,17,screen, "Successful Mode Entry!");
          String result = Scraper.master("synonyms", output);
          putStringSpecial(1,19,screen,result);
          screen.doResizeIfNecessary();
        }
        else{
          putString(1,17,screen,"Sorry but the mode you entered is invalid. Click ENTER to reset or ESC to quit.");
        }
      }


      screen.doResizeIfNecessary();
      screen.refresh();}

      screen.stopScreen();
    }
  }
