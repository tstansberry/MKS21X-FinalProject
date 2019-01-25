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
    /*  if (str.charAt(index) == '') { // loops through the str and checks for "|" (currently not using this part)
      y++; // increases y to put text on new line instead
      placeholder = 0; // changes placeholder value to 0 because index can't be changed and x needs to keep increasing
      index+=2;
      screen.doResizeIfNecessary();
    } */
    if ((x+placeholder) % (screen.getTerminalSize().getColumns()-5) == 0){ // compares x value with # of columns in world
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

  System.out.println("Loading program...");
  MatchingGame game = new MatchingGame(10);

  Screen screen = new DefaultTerminalFactory().createScreen();
  screen.startScreen(); // display and creation of screen

// I love instance variables sorry
  long tStart = System.currentTimeMillis();
  long temptime = 0;
  long tempend = 0;
  long lastSecond = 0;
  String input = "";
  int display = 0;
  int score = 0;
  boolean checker = true;
  boolean firstEnterOver = false;
  boolean SecondEnter = false;
  boolean revert = false;
  boolean gameEnter = false;
  String Strmode = "";
  String control = "";
  String answer = "";
  String Inputclearer = ""; //
  //screen.refresh();

  TerminalSize size = screen.getTerminalSize();
  TextGraphics tg = screen.newTextGraphics();

  while (checker) { // runs if ESC isn't pressed

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

  display 2:
  - shows results based off word and mode inputs
  - allows user to switch to a different mode with the same word or change word and/or mode

  display 3:
  - shows first 5 definitions and all syns

  display 4:
  - shows all definitions

  display 5:
  - shows all synonyms

  display 6:
  - game

  display < 1:
  - should be able to go back to display 0
  - everything should be set to default at that point
  */

  KeyStroke key = screen.pollInput();
  // for all displays
  if(key != null){
    if (key.getKeyType() == KeyType.Escape){
      checker = false;
    } //results in suspension of program

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
    } //0 ends

    // Inputs for display 1
    if (display == 1){

      String success  =  "The word you have requested is: " + input + "."; // successful input
      String failure = "Sorry but that word not correct. Please try again."; // unsuccessful input

      if ((key.getKeyType() == KeyType.Character)) {
        if (!SecondEnter){
          input += key.getCharacter();
        } // adds characters until ENTER is pressed on this display
      }

      if (key.getKeyType() == KeyType.ArrowLeft) {
        screen.clear();
        display = 1;
        display%=6;//6 displays -- last display loops around to first
        Strmode = ""; //Resets the mode
        input = "";
        screen.refresh();
        screen.clear();
        tEnd = System.currentTimeMillis();
        millis = tEnd - tStart;
        if(millis/1000 > lastSecond){
          lastSecond = millis / 1000;
          putString(1,3,screen,"Seconds since start of program: "+lastSecond);

        }
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

    /*    if (input.equals("--main")){ //checks if input is --main
          putString(1,9,screen, Inputclearer); // clears input (doesn't matter if it was valid or not)
          screen.refresh();
          revert = true; // sets up loop for going back one

        } // should change back to display 0 but doesnt work


        else{ */

          putString(1,9,screen, Inputclearer); // clears input (doesn't matter if it was valid or not)
          screen.refresh();

          SecondEnter = true;

          putString(1,13,screen,success); // shows input
          putString(1,14,screen,"Please check mode and press SPACE to proceed. You may press TAB to change your mode entry."); //guides user
        //}
      }


      if (key.getCharacter().equals(' ')){ // changes to mode based off Strmode input

        /*if (revert){
          screen.clear();
          display = 0;
          display%=6;
          screen.clear();
        }*/

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

      /*  if (revert){

          revert = false;
          input = "";
        } */

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

  } // input loop ends here

  //----------------------------------
  // INTERFACE NON-INPUT RELATED STUFF (STILL DEPENDENT ON INPUTS)

  if (display == 0){
    // code for only display 0 (home screen)

    putString(1,2,screen,"WELCOME TO YOUR TERMINAL DICTIONARY");

    //putString(1,7,screen,"Please start typing a word. Press ENTER after you are done. You can DELETE to fix any mistakes you make.");

    putStringSpecial(1,5,screen, "There are four different modes:" );
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
    putString(1,8,screen,"Press LEFT ARROW to go back to main menu.");
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
    putString(1,8,screen,"Press LEFT ARROW to go back to main menu.");
    //putString(1,7,screen,"Type --controls to see your options on how to proceed"); // if input for control was --control it would show all controls
    //for testing

    //putString(1,17,screen, "Successful Mode Entry!");
    String result = Scraper.getSampleDefinition(input);
    String lookingFor = "___\"";
    String replaceWith = " |";
    putString(1,10,screen,"Definition:");
    putString(1,20,screen,"Synonyms:");
    String newResult = result.replace(lookingFor,replaceWith); //allows for putStringSpecial
    screen.doResizeIfNecessary();
    putStringSpecial(1,12,screen,newResult);

    String resultTwo = Scraper.master("synonyms", input);
    screen.doResizeIfNecessary();
    putStringSpecial(1,22,screen,resultTwo);

    KeyStroke newKey = screen.pollInput();

    if (newKey != null){

        if (newKey.getKeyType() == KeyType.ArrowLeft) { //goes back to mode 0
          screen.clear();
          display = 0;
          //display%=6;//6 displays -- last display loops around to first
          firstEnterOver = false; //sets to og
          SecondEnter = false; //sets to og
          Strmode = ""; //Resets the mode
          input = "";
          screen.refresh();
          screen.clear();
          tEnd = System.currentTimeMillis();
          millis = tEnd - tStart;
          if(millis/1000 > lastSecond){
            lastSecond = millis / 1000;
            putString(1,3,screen,"Seconds since start of program: "+lastSecond);

          }
        }

      }

    }


  // code for display 4
  // DEFINITION  MODE
  if (display == 4){
    putString(1,5,screen,"The mode you have entered is:" + Strmode);
    putString(1,6,screen,"The word you have entered is:" + input);
    putString(1,8,screen,"Press LEFT ARROW to go back to main menu.");
    //for testing
    //putString(1,17,screen, "Successful Mode Entry!");
    String result = Scraper.master("definition", input);
    String lookingFor = "___\"";
    String replaceWith = " |";
    String newResult = result.replace(lookingFor,replaceWith); //allows for putStringSpecial
    screen.doResizeIfNecessary();
    putStringSpecial(1,10,screen,newResult);

    KeyStroke newKey = screen.pollInput();

    if (newKey != null){


        if (newKey.getKeyType() == KeyType.ArrowLeft) {
          screen.clear();
          display = 0;
          firstEnterOver = false;
          SecondEnter = false;
          display%=6;//6 displays -- last display loops around to first
          Strmode = ""; //Resets the mode
          input = "";
          screen.refresh();
          screen.clear();
          tEnd = System.currentTimeMillis();
          millis = tEnd - tStart;
          if(millis/1000 > lastSecond){
            lastSecond = millis / 1000;
            putString(1,3,screen,"Seconds since start of program: "+lastSecond);

          }
        }

      }

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
  KeyStroke newKey = screen.pollInput();

  if (newKey != null){


      if (newKey.getKeyType() == KeyType.ArrowLeft) {
        screen.clear();
        display = 0;
        display%=6;//6 displays -- last display loops around to first
        firstEnterOver = false;
        SecondEnter = false;
        Strmode = ""; //Resets the mode
        input = "";
        screen.refresh();
        screen.clear();
        tEnd = System.currentTimeMillis();
        millis = tEnd - tStart;
        if(millis/1000 > lastSecond){
          lastSecond = millis / 1000;
          putString(1,3,screen,"Seconds since start of program: "+lastSecond);

        }
      }

    }

  }

  // code for display 6
  //NEED GAME CODE TO MAKE THIS WORKING
  while (display == 6){
    String cheat = game.getAnswer();
    String helper = "The correct answer is: " + cheat;
    String scoreDisplay = "SCORE: " + score;
    putString(1,3,screen,"The mode you have entered is:" + Strmode);
    putString(1,5,screen,"WELCOME TO THE MATCHING GAME!");
    putString(1,6,screen,"Type your guess and press ENTER. Press TAB if you decide to give up. Press the LEFT ARROW to go back to the main screen.");
    //putString(1,6,screen,"The word you have entered is:" + input);
    //  putString(1,7,screen,"Type /'--controls'/ to see your options on how to proceed");
    screen.refresh();
    putString(1, 15, screen, "Word Bank:");
    String lookingFor = "___\"";
    String replaceWith = " |";
  //  String ansDisplay = "Your guess: " + answer;
    String result = game.getDefinition();
    String output = "Your input " + answer + " is incorrect.";
    String newResult = result.replace(lookingFor,replaceWith);
    putStringSpecial(1, 16, screen, game.generateWordBank());
    putStringSpecial(1, 18, screen, "Definition:");
    putStringSpecial(1, 19, screen, newResult);
    if (!gameEnter){
      putString(1,10,screen,"Your guess is:"); //10
      putString(1,11,screen,answer); //11
    }
    putString(1,8,screen,scoreDisplay); // tells user input was valid

    boolean cheater = false;

    KeyStroke newKey = screen.pollInput();

    if (newKey != null){

        if (newKey.getKeyType() == KeyType.ArrowLeft) {
          display = 0;
          //display%=6;//6 displays -- last display loops around to first
          firstEnterOver = false;
          SecondEnter = false;
          gameEnter=false;
          Strmode = ""; //Resets the mode
          input = "";
          screen.refresh();
          screen.clear();
          tEnd = System.currentTimeMillis();
          millis = tEnd - tStart;
          if(millis/1000 > lastSecond){
            lastSecond = millis / 1000;
            putString(1,3,screen,"Seconds since start of program: "+lastSecond);

          }
        }

        // follows similar logic as display 0 and 1

        if ((newKey.getKeyType() == KeyType.Character)) {
          if (newKey.getCharacter().equals(' ')){
            if (gameEnter){ // this input only matters if ENTER was pressed first
              // next word function is called here
              String replace = "Your input " + answer + " is correct. Press SPACE for next word.";
              for (int i = 0; i < replace.length(); i++){
                Inputclearer +=  " ";
              }
              putString(1,11,screen, Inputclearer); //11
              answer = "";
              gameEnter = false;
              screen.clear();
              game.nextWord();
              // needs to change word here
              }
          }
          else if (!gameEnter){
            answer += newKey.getCharacter(); // adds charater to string as long as enter isn't pressed
            //String reset = "Your input " + answer + " is incorrect.";

          }
          if (answer.length() > 0){
            for (int i = 0; i < output.length(); i++){
              Inputclearer +=  " ";
            }
            putString(1,12,screen,Inputclearer);
            Inputclearer ="";
            for (int i = 0; i < helper.length(); i++){
              Inputclearer +=  " ";
            }
            putString(1,13,screen,Inputclearer);

          }
        }

        if (newKey.getKeyType() == KeyType.Backspace) {
          if (!gameEnter){
          for (int i = 0; i < answer.length(); i++){
            Inputclearer +=  " "; // looks at how long Strmode is and clears it from screen
          }
          putString(1,11,screen,Inputclearer); // white space of the length of Strmode //11
          answer = answer.substring(0, answer.length() - 1); //takes away last index
          screen.refresh();// putString later in the code displays updated answer
        }
        }

       /*  commented out so that functions in matchingGame.java can be added to make this working */

       if ((newKey.getKeyType() == KeyType.Enter)){
          gameEnter = true;
          for (int i = 0; i < answer.length(); i++){
            Inputclearer +=  " ";
          } // gets rid of putString that displays Strmode
          putString(1,11,screen, Inputclearer); // clears input (doesn't matter if it was valid or not) //11
          Inputclearer = "";
          for (int i = 0; i < "Your guess is: ".length(); i++){
            Inputclearer +=  " ";
          }
          putString(1,10,screen, Inputclearer); //10
          Inputclearer = "";
          for (int i = 0; i < scoreDisplay.length(); i++){
            Inputclearer +=  " ";
          }
          putString(1,8,screen, Inputclearer);
          screen.refresh();



          if (game.checkAnswer(answer)){ //if answer is correctl
            putString(1,11,screen,"Your input " + answer + " is correct. Press SPACE for next word."); //11
            if (!cheater){
            score += 100;
            screen.refresh();
          }
            else{
            cheater = false;
            }
          }

          else{
            putString(1,12,screen,output);
            score = score - 50;
            answer = "";
            gameEnter = false;
            screen.refresh();
          }

        }

        if (newKey.getKeyType() ==  KeyType.Tab){
              cheater = true;
              putString (1,13,screen,helper); //13
              for (int i = 0; i < answer.length(); i++){
                Inputclearer +=  " ";
              } // gets rid of putString that displays Strmode
              putString(1,11,screen, Inputclearer); // clears input (doesn't matter if it was valid or not) //11
              Inputclearer = "";
              for (int i = 0; i < "Your guess is: ".length(); i++){
                Inputclearer +=  " ";
              }
            }
            putString(1,10,screen, Inputclearer); //10

      }
    }


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
