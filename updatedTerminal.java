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


public class updatedTerminal {
  public static void main(String args[]) throws IOException{
    Screen screen = new DefaultTerminalFactory().createScreen();
    screen.startScreen(); // display and creation of screen

    long tStart = System.currentTimeMillis();
    long temptime = 0;
    long tempend = 0;
    long lastSecond = 0;
    String output = "";
    boolean running = true;
    boolean firstEnterOver = false;
    boolean SecondEnter = false;
    String mode = "";

    TerminalSize size = screen.getTerminalSize();
    TextGraphics tg = screen.newTextGraphics();

    while (running) {
      Key key = terminal.readInput();
      if (key != null) {
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
}
