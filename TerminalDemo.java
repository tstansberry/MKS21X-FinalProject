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
      if (str.charAt(index) == '_') { // loops through the str and checks for "|"
      y++; // increases y to put text on new line instead
      placeholder = 0; // changes placeholder value to 0 because index can't be changed and x needs to keep increasing
      index+=2;
      screen.doResizeIfNecessary();
    }
    else if ((x+placeholder) % (screen.getTerminalSize().getColumns()-5) == 0){ // compares x value with # of columns in world
      y ++ ; // if column end reached it goes to a new line
      placeholder = 0; // changes placeholder value to 0 because index can't be changed and x needs to keep increasing
      screen.doResizeIfNecessary();
    }
    else{
      placeholder++; // if there is no reason to go to a new line the x value moves along
      screen.doResizeIfNecessary();
      }

    screen.setCharacter(x+placeholder, y, new TextCharacter(replacement.charAt(index))); // adds character from index value of string to given location
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
  boolean revert = false;
  String Strmode = "";
  String control = "";
  String Inputclearer = ""; //

  TerminalSize size = screen.getTerminalSize();
  TextGraphics tg = screen.newTextGraphics();

  while (checker) { // runs while ESC isn't pressed

  long tEnd = System.currentTimeMillis();
  long millis = tEnd - tStart;
  if(millis/1000 > lastSecond){
    lastSecond = millis / 1000;
    putString(1,3,screen,"Seconds since start of program: "+lastSecond);

  } // shows how long system has been running

  // for testing
  //putString(1,19,screen,""+size.getRows()+" "+size.getColumns());

  TerminalSize testsize = screen.getTerminalSize();
  if (testsize.getRows() != size.getRows() || testsize.getColumns() != size.getColumns()) {
    screen.clear();
    size = testsize;
  } // resizes world

  // for testing (allows you to see if displays are changing or not)
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
  if (key != null){ // key can never be set to null

    // for all displays
    if (key.getKeyType() == KeyType.ArrowRight) {
      display++;
      display%=6;//6 displays -- last display loops around to first
      screen.clear();
      tEnd = System.currentTimeMillis();
      millis = tEnd - tStart;
      if(millis/1000 > lastSecond){
        lastSecond = millis / 1000;
        putString(1,3,screen,"Seconds since start of program: "+lastSecond);

      }
    } // allows user to move up between displays; might want to remove this part based off displays interact

    if (key.getKeyType() == KeyType.ArrowLeft) {
      display--;
      display%=6;//6 displays -- last display loops around to first
      screen.clear();
      tEnd = System.currentTimeMillis();
      millis = tEnd - tStart;
      if(millis/1000 > lastSecond){
        lastSecond = millis / 1000;
        putString(1,3,screen,"Seconds since start of program: "+lastSecond);

      }
    } // allows user to move down between displays; might want to remove this part based off displays interact


    if (key.getKeyType() == KeyType.Escape){
      checker = false;
    }

    // Inputs for display 0
    if (display == 0){

      String success  =  "The mode you have requested is: " + Strmode + "."; // successful input
      String failure = "Sorry but that is not an available mode. Please try again."; // unsuccessful input

      if ((key.getKeyType() == KeyType.Character)) {
        if (!firstEnterOver){
          Strmode += key.getCharacter(); // adds charater to string as long as enter isn't pressed
          String reset = "                                                               ";
          putString(1,13,screen,reset); //helps clear input
        }
      }

      if (key.getKeyType() == KeyType.Backspace) {
        for (int i = 0; i < Strmode.length(); i++){
          Inputclearer +=  " "; // looks at how long Strmode is and clears it from screen
        }
        putString(1,12,screen,Inputclearer); // white space of the length of Strmode
        Strmode = Strmode.substring(0, Strmode.length() - 1); //takes away last index
        screen.refresh();// putString later in the code displays updated Strmode
      }

      screen.refresh();

      if ((key.getKeyType() == KeyType.Enter)){

        for (int i = 0; i < Strmode.length(); i++){
          Inputclearer +=  " ";
        } // gets rid of putString that displays Strmode

        putString(1,12,screen, Inputclearer); // clears input (doesn't matter if it was valid or not)
        screen.refresh();

        if (Strmode.equals("[1]") || Strmode.equals("[2]") || Strmode.equals("[3]") || Strmode.equals("[4]")){ //checks if input is valid
          putString(1,13,screen,success); // tells user input was valid
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
        if (firstEnterOver){ // this input only matters if ENTER was pressed first
          if (Strmode.equals("[4]")) {
            display = 6;
            display%=6;
          }
          else {
            display = 1; // moves to next display
            display%=6;
          }
          screen.clear();
        }
      }
      if (key.getKeyType() ==  KeyType.Tab){
        if (firstEnterOver){
          for (int i = 0; i < success.length(); i++){
            Inputclearer +=  " ";
          } // takes away the success message
          putString(1,13,screen, Inputclearer); // clears input (doesn't matter if it was valid or not)
          Inputclearer = "";
          for (int i = 0; i < "Please check mode and press SPACE to proceed. You may press TAB to change your mode entry.".length(); i++){
            Inputclearer +=  " ";
          } //clears the message user sees after pressing ENTER
          putString(1,14,screen, Inputclearer); // takes away the message
          screen.refresh();
          firstEnterOver = false; //makes firstEnterOver false so user can make a new mode input
          Strmode = ""; // allows user to restart mode input

        }
      }
    }

    // Inputs for display 0
    if (display == 1){

      String success  =  "The word you have requested is: " + input + "."; // successful input
      String failure = "Sorry but that word not correct. Please try again."; // unsuccessful input

      if ((key.getKeyType() == KeyType.Character)) {
        if (!SecondEnter){
          input += key.getCharacter();
        } // adds characters until ENTER is pressed on this display
      }

      if (key.getKeyType() == KeyType.Backspace) {
        for (int i = 0; i < input.length(); i++){
          Inputclearer +=  " ";
        } //clears input putString
        putString(1,9,screen,Inputclearer);
        input = input.substring(0, input.length() - 1); //takes one index away from the String
        screen.refresh(); // putString later will update the input being displayed
      }

      screen.refresh();

      if ((key.getKeyType() == KeyType.Enter)){

        for (int i = 0; i < input.length(); i++){
          Inputclearer +=  " ";
        } //clears input being displayed on screen

       if (input.equals("--main")){ //checks if input is --main
          putString(1,9,screen, Inputclearer); // clears input (doesn't matter if it was valid or not)
          screen.refresh();
          revert = true; // sets up loop for going back one

        } // should change back to display 0 but doesnt work

        else {

          putString(1,9,screen, Inputclearer); // clears input (doesn't matter if it was valid or not)
          screen.refresh();

          SecondEnter = true;

          putString(1,13,screen,success); // shows input
          putString(1,14,screen,"Please check mode and press SPACE to proceed. You may press TAB to change your mode entry."); //guides user
        }
      }


      if (key.getCharacter().equals(' ')){

        if (revert){
          screen.clear();
          display = 0;
          display%=6;
          screen.clear();
        }

        if (SecondEnter){ //changes display based off mode entry
          if (Strmode.equals("[1]")){
            display = 3;
            display%=6;
            screen.clear();
          }

          if (Strmode.equals("[2]")){
            display = 4;
            display%=6;
            screen.clear();
          }

          if (Strmode.equals("[3]")){
            display = 5;
            display%=6;
            screen.clear();
          }

          if (Strmode.equals("[4]")){
            display = 6;
            display%=6;
            screen.clear();
          }

        }
      }

      if (key.getKeyType() ==  KeyType.Tab){

        if (revert){

          revert = false;
          input = "";
        }

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
          input = ""; //allows user to input a new word

        }

      }

    } // display 1 ends

    // for display greater than 3
    if (display <= 3){

      if ((key.getKeyType() == KeyType.Character)) {

        control += key.getCharacter(); //adds to control

      }

      if (key.getKeyType() == KeyType.Backspace) {
        for (int i = 0; i < control.length(); i++){
          Inputclearer +=  " "; // adds white space of the length of control
        }

        putString(1,12,screen,Inputclearer);// clears the control being displayed
        control = control.substring(0, control.length() - 1);
        screen.refresh();

      }

      screen.refresh();

      if ((key.getKeyType() == KeyType.Enter)){

        for (int i = 0; i < Strmode.length(); i++){
          Inputclearer +=  " ";
        }
        putString(1,12,screen, Inputclearer); // clears input (doesn't matter if it was valid or not)
        screen.refresh();

      }

      if (key.getCharacter().equals(' ')){
        display = 1;
        display%=6;
        screen.clear();
      }

    }

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
    //for testing
    //putString(1,17,screen, "Successful Mode Entry!");
    //putString(1,7,screen, "Type /'--main'/ to return to the homescreen and press ENTER."); //supposed to bring you back to main menu

    putString(1,9,screen,input);

  }

  // code for display 3
  //ISN'T WORKING RIGHT NOW
  //SUPPOSED TO BE DICTIONARY MODE

  if (display == 3){
    putString(1,5,screen,"The mode you have entered is:" + Strmode);
    putString(1,6,screen,"The word you have entered is:" + input);
    //putString(1,7,screen,"Type --controls to see your options on how to proceed"); // if input for control was --control it would show all controls
    //for testing
    //putString(1,17,screen, "Successful Mode Entry!");
    //putString(1,15,screen,control);
    /*
    String result = Scraper.master("everything", input);
    String lookingFor = "\n";
    String replaceWith = "|";
    String newResult = result.replace(lookingFor,replaceWith);
    screen.doResizeIfNecessary();
    putStringSpecial(1,18,screen,newResult);
    */

  }

  // code for display 4
  // DEFINITION  MODE
  if (display == 4){
    putString(1,5,screen,"The mode you have entered is:" + Strmode);
    putString(1,6,screen,"The word you have entered is:" + input);

    //for testing
    //putString(1,17,screen, "Successful Mode Entry!");
    String result = Scraper.master("definition", input);
    String lookingFor = "-\"";
    String replaceWith = " |";
    String newResult = result.replace(lookingFor,replaceWith); //allows for putStringSpecial
    screen.doResizeIfNecessary();
    putStringSpecial(1,10,screen,newResult);

  }

  // code for display 5
  // SYNONYMS MODE
  if (display == 5){
    putString(1,5,screen,"The mode you have entered is:" + Strmode);
    putString(1,6,screen,"The word you have entered is:" + input);

    //for testing
    //putString(1,17,screen, "Successful Mode Entry!");
    String result = Scraper.master("synonyms", input);
/*    for (int index = 0; index < result.length(); index++){
      if (result.substring(index, index + 1).equals("\n")){
        result = result.substring(0, index) + "_" + result.substring(index + 1);
      }
    } */
  //  String newResult = result.replace(lookingFor,replaceWith);
    screen.doResizeIfNecessary();
    putStringSpecial(1,10,screen,result);

  }

  // code for display 6
  //NEED GAME CODE TO MAKE THIS WORKING
   if (display == 6){
  putString(1,5,screen,"The mode you have entered is:" + Strmode);
  putString(1,6,screen,"The word you have entered is:" + input);
//  putString(1,7,screen,"Type /'--controls'/ to see your options on how to proceed");
  putString(1, 9,screen, "Generating game...");
  MatchingGame game = new MatchingGame(10);
  screen.refresh();
  putString(1, 9, screen, "Word Bank:");
  putStringSpecial(1, 10, screen, game.generateWordBank());
  putStringSpecial(1, 12, screen, "Definition:");
  putStringSpecial(1, 13, screen, game.getDefinition());
  //for testing
  //putString(1,17,screen, "Successful Mode Entry!");
  putString(1,15,screen,control);
}
  /*
  String result = Scraper.master("everything", input);
  String lookingFor = "\n";
  String replaceWith = "|";
  String newResult = result.replace(lookingFor,replaceWith);
  screen.doResizeIfNecessary();
  putStringSpecial(1,18,screen,newResult);

}
*/


screen.doResizeIfNecessary();

screen.refresh();

}

screen.stopScreen(); // loops comes here if ESC pressed

}
}

//_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
// OLD CODE TO REFER TO CALL ON SCRAPER AND CONNECT THE FILES

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
