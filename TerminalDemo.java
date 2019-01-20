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
    for (int i = 0; i < str.length(); i++) {
      screen.setCharacter(x+i, y, new TextCharacter(str.charAt(i)));
    }
  }  // changes the row value and allows you to add text throughout the screen

  public static void putStringSpecial(int x, int y, Screen screen, String str) {
    int checker = x;
    int placeholder = 0;
    String replacement = str;
    for (int index = 0; index < str.length(); index++) {
      if (str.charAt(index) == '|') { // loops through the str and checks for "|"
      y++; // increases y to put text on new line instead
      placeholder = 0; // changes placeholder value to 0 because index can't be changed and x needs to keep increasing
      index++;
    }
    else if ((x+placeholder) % (screen.getTerminalSize().getColumns()-5) == 0){ // compares x value with # of columns in world
      y ++ ; // if column end reached it goes to a new line
      placeholder = 0; // changes placeholder value to 0 because index can't be changed and x needs to keep increasing
    }
    else{
      placeholder++; // if there is no reason to go to a new line the x value moves along
    }
    screen.setCharacter(x+placeholder, y, new TextCharacter(str.charAt(index))); // adds character from index value of string to given location
  }
  screen.doResizeIfNecessary();
}

public static void main(String[] args) throws IOException {

  Screen screen = new DefaultTerminalFactory().createScreen();
  screen.startScreen(); // display and creation of screen

  long tStart = System.currentTimeMillis();
  long temptime = 0;
  long tempend = 0;
  long lastSecond = 0;
  String input = "";
  int display = 0;
  boolean checker = true;
  boolean firstEnterOver = false;
  boolean SecondEnter = false;
  boolean modeGoing = true;
  String Strmode = "";
  String Inputclearer = ""; //

  TerminalSize size = screen.getTerminalSize();
  TextGraphics tg = screen.newTextGraphics();

  while (checker) {

    long tEnd = System.currentTimeMillis();
    long millis = tEnd - tStart;
    if(millis/1000 > lastSecond){
      lastSecond = millis / 1000;
      putString(1,3,screen,"Seconds since start of program: "+lastSecond);

    }

    // for testing
    // putString(1,2,screen,""+size.getRows()+" "+size.getColumns());

    TerminalSize testsize = screen.getTerminalSize();
    if (testsize.getRows() != size.getRows() || testsize.getColumns() != size.getColumns()) {
      screen.clear();
      size = testsize;
    } // resizes world

    putString(1,1,screen, "Current Display: " +  display);
    /*
    EXPLANATION AND REFERENCE ON DISPLAYS AND HOW THEY SHOULD FUNCTION

    display 0:
    - is the homepage/ the screen your first open
    - use will enter the mode they want to use

    display 1:
    - takes you to a screen where your mode can be confirmed
    - asks user for word inputted

    display 3:
    - shows results based off word and mode inputs
    - allows user to switch to a different mode with the same word or change word and/or mode
    */

    KeyStroke key = screen.pollInput();
    if (key != null){

      // for all displays
      /*    if (key.getKeyType() == KeyType.ArrowRight) {
      display++;
      display%=3;
      screen.clear();
      tEnd = System.currentTimeMillis();
      millis = tEnd - tStart;
      if(millis/1000 > lastSecond){
      lastSecond = millis / 1000;
      putString(1,3,screen,"Seconds since start of program: "+lastSecond);

    }
  }

  if (key.getKeyType() == KeyType.ArrowLeft) {
  display--;
  display%=3;//3 displays
  screen.clear();
  tEnd = System.currentTimeMillis();
  millis = tEnd - tStart;
  if(millis/1000 > lastSecond){
  lastSecond = millis / 1000;
  putString(1,3,screen,"Seconds since start of program: "+lastSecond);

}
} */

if (key.getKeyType() == KeyType.Escape){
  checker = false;
}

// for display 0
if (display == 0){

  String success  =  "The mode you have requested is: " + Strmode + "."; // successful input
  String failure = "Sorry but that is not an available mode. Please try again."; // unsuccessful input

  if ((key.getKeyType() == KeyType.Character)) {
    if (!firstEnterOver){
      Strmode += key.getCharacter();
      String reset = "                                                               ";
      putString(1,13,screen,reset);
    }
  }

  if (key.getKeyType() == KeyType.Backspace) {
    for (int i = 0; i < Strmode.length(); i++){
      Inputclearer +=  " ";
    }
    putString(1,12,screen,Inputclearer);
    Strmode = Strmode.substring(0, Strmode.length() - 1);
    screen.refresh();
  }

  screen.refresh();

  if ((key.getKeyType() == KeyType.Enter)){

    for (int i = 0; i < Strmode.length(); i++){
      Inputclearer +=  " ";
    }
    putString(1,12,screen, Inputclearer); // clears input (doesn't matter if it was valid or not)
    screen.refresh();

    if (Strmode.equals("[1]") || Strmode.equals("[2]") || Strmode.equals("[3]") || Strmode.equals("[4]")){ //checks if input is valid
      putString(1,13,screen,success);
      putString(1,14,screen,"Please check mode and press SPACE to proceed. You may press TAB to change your mode entry.");
      firstEnterOver = true;
    }

    else{
      putString(1,13,screen,failure); // tells user input is invalid
      Strmode = ""; // allows user to reenter a new input
      screen.refresh();
    }

  }

  if (key.getCharacter().equals(' ')){
    if (firstEnterOver){
      display = 1;
      display%=4;
      screen.clear();
    }
  }
  if (key.getKeyType() ==  KeyType.Tab){
    if (firstEnterOver){
      for (int i = 0; i < success.length(); i++){
        Inputclearer +=  " ";
      }
      putString(1,13,screen, Inputclearer); // clears input (doesn't matter if it was valid or not)
      Inputclearer = "";
      for (int i = 0; i < "Please check mode and press SPACE to proceed. You may press TAB to change your mode entry.".length(); i++){
        Inputclearer +=  " ";
      }
      putString(1,14,screen, Inputclearer);
      screen.refresh();
      firstEnterOver = false;
      Strmode = "";

    }
  }


}

// for display 1
if (display == 1){

  String success  =  "The word you have requested is: " + input + "."; // successful input
  String failure = "Sorry but that word not correct. Please try again."; // unsuccessful input


  if ((key.getKeyType() == KeyType.Character)) {
    if (!SecondEnter){
      input += key.getCharacter();
    }
  }

  if (key.getKeyType() == KeyType.Backspace) {
    for (int i = 0; i < input.length(); i++){
      Inputclearer +=  " ";
    }
    putString(1,12,screen,Inputclearer);
    input = input.substring(0, input.length() - 1);
    screen.refresh();
  }

  screen.refresh();

  if ((key.getKeyType() == KeyType.Enter)){

    for (int i = 0; i < input.length(); i++){
      Inputclearer +=  " ";
    }
    putString(1,8,screen, Inputclearer); // clears input (doesn't matter if it was valid or not)
    screen.refresh();

    SecondEnter = true;

    putString(1,13,screen,success);
    putString(1,14,screen,"Please check mode and press SPACE to proceed. You may press TAB to change your mode entry.");
  }


  if (key.getCharacter().equals(' ')){

    if (SecondEnter){
      if (Strmode.equals("[1]")){
        display += 1;
        display%=5;
        screen.clear();
      }
    }

    if (SecondEnter){
      if (Strmode.equals("[2]")){
        display += 2;
        display%=5;
        screen.clear();
      }
    }

    if (SecondEnter){
      if (Strmode.equals("[3]")){
        display += 3;
        display%=5;
        screen.clear();
      }
    }

    if (SecondEnter){
      if (Strmode.equals("[4]")){
        display += 4;
        display%=5;
        screen.clear();
      }
    }

  }

  if (key.getKeyType() ==  KeyType.Tab){

    if (SecondEnter){
      for (int i = 0; i < success.length(); i++){
        Inputclearer +=  " ";
      }
      putString(1,13,screen, Inputclearer); // clears input (doesn't matter if it was valid or not)
      Inputclearer = "";
      for (int i = 0; i < "Please check mode and press SPACE to proceed. You may press TAB to change your mode entry.".length(); i++){
        Inputclearer +=  " ";
      }
      putString(1,14,screen, Inputclearer);
      screen.refresh();
      SecondEnter = false;
      input = "";

    }

  }

} // display 1 ends

} // input loop ends here

//----------------------------------
// INTERFACE NON-INPUT RELATED STUFF (STILL DEPENDENT ON INPUTS)

if (display == 0){
  // code for only display 0 (home screen)

  putString(1,2,screen,"WELCOME TO YOUR TERMINAL DICTIONARY");

  //putString(1,7,screen,"Please start typing a word. Press ENTER after you are done. You can DELETE to fix any mistakes you make.");

  putStringSpecial(1,5,screen, "There are three different modes:" );
  putStringSpecial(1,6,screen, "[1] DICTIONARY" );
  putStringSpecial(1,7,screen, "[2] DEFINITION" );
  putStringSpecial(1,8,screen, "[3] SYNONYMS" );
  putStringSpecial(1,9,screen, "[4] VOCAB TESTING GAME" );
  putString(1,10,screen, "What mode would you like to choose? Please follow the following format: [number]. Press ENTER when done.");

  if (!firstEnterOver){

    putString(1,12,screen, Strmode); // shows user what they're typing but this is replaced after they submit their mode request a
  }

}

// code for display 1
if (display == 1){

  putString(1,5,screen,"The mode you have entered is: " + Strmode);
  putString(1,6,screen,"Please enter the word you'd like to use. Press ENTER when done.");

  putString(1,screen.getTerminalSize().getRows()-3, screen, "Type --main' to return to the homescreen");

  if (!SecondEnter){

    putString(1,8,screen,input);
  }
}

// code for display 2
if (display == 2){
  putString(1,5,screen,"The mode you have entered is:" + Strmode);
  putString(1,6,screen,"The word you have entered is:" + input);

  //putString(1,17,screen, "Successful Mode Entry!");
  String result = Scraper.master("everything", input);
  String lookingFor = "\n";
  String replaceWith = "|";
  String newResult = result.replace(lookingFor,replaceWith);
  screen.doResizeIfNecessary();
  putStringSpecial(1,10,screen,newResult);

}

// code for display 3
if (display == 3){
  putString(1,5,screen,"The mode you have entered is:" + Strmode);
  putString(1,6,screen,"The word you have entered is:" + input);

  //putString(1,17,screen, "Successful Mode Entry!");
  String result = Scraper.master("definition", input);
  String lookingFor = "\n";
  String replaceWith = "|";
  String newResult = result.replace(lookingFor,replaceWith);
  screen.doResizeIfNecessary();
  putStringSpecial(1,10,screen,newResult);

}

// code for display 4
if (display == 4){
  putString(1,5,screen,"The mode you have entered is:" + Strmode);
  putString(1,6,screen,"The word you have entered is:" + input);

  //putString(1,17,screen, "Successful Mode Entry!");
  String result = Scraper.master("synonyms", input);
  String lookingFor = "\n";
  String replaceWith = "|";
  String newResult = result.replace(lookingFor,replaceWith);
  screen.doResizeIfNecessary();
  putStringSpecial(1,10,screen,newResult);

}

// code for display 3
/*if (display == 5){
putString(1,5,screen,"The mode you have entered is:" + Strmode);
putString(1,6,screen,"The word you have entered is:" + input);

//putString(1,17,screen, "Successful Mode Entry!");
String result = Scraper.master("game", input);
String lookingFor = "\n";
String replaceWith = "|";
String newResult = result.replace(lookingFor,replaceWith);
screen.doResizeIfNecessary();
putStringSpecial(1,10,screen,newResult);

} */

screen.doResizeIfNecessary();

screen.refresh();

}

screen.stopScreen(); // loops comes here if ESC pressed
}

}



//_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
/*  if (firstEnterOver){
putString(1,12,screen,"Please choose a mode. The available modes are: (1) defintion and (2) synonym. Input either 1 or 2.");
putString(1,13,screen,"Press ENTER after you are done. You can DELETE to fix any mistakes you make.");

if (key != null) {
if (key.getKeyType() == KeyType.Escape){
checker = false;

}

if ((key.getKeyType() == KeyType.Character)) {
Strmode += key.getCharacter();
}

if ((key.getKeyType() == KeyType.Enter)){
putString(1,15,screen,"The mode you have requested is: " + Strmode + ".");
SecondEnter =  true;

}
} */


/*    if (SecondEnter){
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
} */
