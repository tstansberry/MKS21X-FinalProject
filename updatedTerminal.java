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

public class updatedTerminal{


public static void putString(int x, int y, Screen screen, String str) {
  for (int i = 0; i < str.length(); i++) {
    screen.setCharacter(x+i, y, new TextCharacter(str.charAt(i)));
  }
}

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
  }
}

  public static void main(String args[]) throws IOException{
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
      KeyStroke key = screen.pollInput();
      if (key != null) {

          if (key.getKeyType() == KeyType.Escape){
            checker = false;
          }

          if ((key.getKeyType() == KeyType.Character)) {
            output += key.getCharacter();
          }

          if (key.getKeyType() == KeyType.Backspace) {

            output = output.substring(0, output.length() - 1);
            screen.refresh();
          }

            screen.refresh();

          if ((key.getKeyType() == KeyType.Enter)){
            putString(1,15,screen,"The mode you have requested is: " + mode + ".");
            SecondEnter =  true;}

          if ((key.getKeyType() == KeyType.Enter)){
            putString(1,10,screen,"The word you have inputted is: " + output + ".");
            firstEnterOver = true;
            key = null;
          }}

        if (mode.equals("menu")) {
          long tEnd = System.currentTimeMillis();
          long millis = tEnd - tStart;
          if(millis/1000 > lastSecond){
            lastSecond = millis / 1000;
            putString(1,3,screen,"Seconds since start of program: "+lastSecond);

          }
          putString(1,2,screen,"WELCOME TO YOUR TERMINAL DICTIONARY");
          putString(3,2, screen, "Press (1) for the dictionary, (2) for thesaurus, and (3) for matching game.");

        }
        if (mode.equals("definition")) {
          //Code for dictionary
        }
        if (mode.equals("synonyms")) {
          //Code for \thesaurus
        }
        if (mode.equals("game")) {
          //game code
        }
      }
    }
  }
