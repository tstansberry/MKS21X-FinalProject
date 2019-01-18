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
    int mode = 0;
    String output = "";
    boolean checker = true;
    boolean firstEnterOver = false;
    boolean SecondEnter = false;
    String Strmode = "";

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
        }
      }
      putString(1,9,screen,output);
      putString(1,14,screen,Strmode);

      if (key.getKeyType() == KeyType.ArrowRight) {
        mode++;
        mode%=3;//2 modes
        screen.clear();
        tEnd = System.currentTimeMillis();
        millis = tEnd - tStart;
        if(millis/1000 > lastSecond){
          lastSecond = millis / 1000;
          putString(1,3,screen,"Seconds since start of program: "+lastSecond);
        }
    }


      putString(1,2,screen,"WELCOME TO YOUR TERMINAL DICTIONARY");
      putString(1,5, screen, "Press (1) for the dictionary, (2) for thesaurus, and (3) for matching game.");
      screen.doResizeIfNecessary();
      screen.refresh();
    }

      /*  if (key != null && firstEnterOver){
          if (mode == 1){

          putString(1,12,screen,"Please choose a mode. The available modes are: (1) defintion and (2) synonym. Input either 1 or 2.");
          putString(1,13,screen,"Press ENTER after you are done. You can DELETE to fix any mistakes you make.");

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
              putString(1,15,screen,"The mode you have requested is: " + Strmode + ".");
              SecondEnter =  true;}

              if ((key.getKeyType() == KeyType.Enter)){
                putString(1,10,screen,"The word you have inputted is: " + output + ".");
                firstEnterOver = true;
                key = null;
              }
            }

            if ((key.getKeyType() == KeyType.Character)) {
              Strmode += key.getCharacter();
            }

            if ((key.getKeyType() == KeyType.Enter)){
              putString(1,15,screen,"The mode you have requested is: " + Strmode + ".");
              SecondEnter =  true;

            }
          }
          */


        screen.stopScreen();

      }}

          /*  if (mode.equals("menu")) {
          long tEnd = System.currentTimeMillis();
          long millis = tEnd - tStart;
          if(millis/1000 > lastSecond){
          lastSecond = millis / 1000;
          putString(1,3,screen,"Seconds since start of program: "+lastSecond);







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

//-----------------------
while(running){
Key key = terminal.readInput();
if (key != null)
{

//YOU CAN PUT DIFFERENT SETS OF BUTTONS FOR DIFFERENT MODES!!!

//only for the game mode.
if(mode == 0){
if (key.getKind() == Key.Kind.Escape) {
terminal.exitPrivateMode();
running = false;
}
}

//for all modes
if (key.getCharacter() == ' ') {
mode++;
mode%=2;//2 modes
terminal.clearScreen();
lastTime = System.currentTimeMillis();
currentTime = System.currentTimeMillis();
}
}

terminal.applySGR(Terminal.SGR.ENTER_BOLD);
putString(1,1,terminal, "This is mode "+mode,Terminal.Color.WHITE,Terminal.Color.RED);
terminal.applySGR(Terminal.SGR.RESET_ALL);


if(mode==0){
lastTime = currentTime;
currentTime = System.currentTimeMillis();
timer += (currentTime -lastTime);//add the amount of time since the last frame.
//DO GAME STUFF HERE
putString(1,3,terminal, "Game here...",Terminal.Color.WHITE,Terminal.Color.RED);
putString(3,5,terminal, "Time: "+timer,Terminal.Color.WHITE,Terminal.Color.RED);
}
else{

terminal.applySGR(Terminal.SGR.ENTER_BOLD,Terminal.SGR.ENTER_BLINK);
putString(1,3,terminal, "Not game, just a pause!",Terminal.Color.RED,Terminal.Color.WHITE);
terminal.applySGR(Terminal.SGR.RESET_ALL);

}

}
------------ */
