<<<<<<< HEAD
//API : http://mabe02.github.io/lanterna/apidocs/2.1/
import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;
=======
//API : http://mabe02.github.io/lanterna/apidocs/3.0/
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.io.IOException;
import java.awt.Color;
import java.util.*;
import java.io.*;
>>>>>>> Terminal

public class TerminalDemo {

<<<<<<< HEAD
	public static void putString(int r, int c,Terminal t, String s){
		t.moveCursor(r,c);
		for(int i = 0; i < s.length();i++){
            t.moveCursor(r,c);
			t.putCharacter(s.charAt(i));
		}
	}
	public static void main(String[] args) {


		int x = 10;
		int y = 10;

		Terminal terminal = TerminalFacade.createTextTerminal();
		terminal.enterPrivateMode();

		TerminalSize size = terminal.getTerminalSize();
		terminal.setCursorVisible(true);

		boolean running = true;

		long tStart = System.currentTimeMillis();
		long lastSecond = 0;

		while(running){

			//terminal.moveCursor(x,y);
			terminal.applyBackgroundColor(Terminal.Color.WHITE);
			terminal.applyForegroundColor(Terminal.Color.BLACK);
			//applySGR(a,b) for multiple modifiers (bold,blink) etc.
			//terminal.applySGR(Terminal.SGR.ENTER_UNDERLINE);
			//terminal.putCharacter('\u00a4');
			//terminal.putCharacter(' ');
			terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			terminal.applyForegroundColor(Terminal.Color.DEFAULT);
			//terminal.applySGR(Terminal.SGR.RESET_ALL);


		/*	terminal.moveCursor(size.getColumns()-5,5);
			terminal.applyBackgroundColor(Terminal.Color.RED);
			terminal.applyForegroundColor(Terminal.Color.YELLOW);
			terminal.applySGR(Terminal.SGR.ENTER_BOLD);
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter('\u262d');
			terminal.putCharacter(' ');
			terminal.moveCursor(size.getColumns()-5,6);
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			terminal.applyForegroundColor(Terminal.Color.DEFAULT);  */

			Key key = terminal.readInput();

			if (key != null)
			{

                boolean checker = false;
                String output = "";

				if (key.getKind() == Key.Kind.Escape) {

					terminal.exitPrivateMode();
					running = false;
				}

                if (key.getKind() == Key.Kind.NormalKey) {
                    output += key.getCharacter();
                    }

                    //if (key.getKind() == Key.Kind.Enter) {
                        putString(1,20,terminal,output);
                    //}







			//	putString(1,4,terminal,"["+key.getCharacter() +"]");
			//	putString(1,1,terminal,key.getCharacter()+"");//to clear leftover letters pad withspaces
			}
/*
			//DO EVEN WHEN NO KEY PRESSED:
			long tEnd = System.currentTimeMillis();
			long millis = tEnd - tStart;
			putString(1,2,terminal,"Milliseconds since start of program: "+millis);
			if(millis/1000 > lastSecond){
				lastSecond = millis / 1000;
				//one second has passed.
				putString(1,3,terminal,"Seconds since start of program: "+lastSecond);
=======
  public static void putString(int x, int y, Screen screen, String str) {
		for (int i = 0; i < str.length(); ++i) {
			screen.setCharacter(x+i, y, new TextCharacter(str.charAt(i)));
		}
	}
>>>>>>> Terminal

	public static void main(String[] args) throws IOException {

  Screen screen = new DefaultTerminalFactory().createScreen();
  screen.startScreen();

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

    // Score Keeping
    long tEnd = System.currentTimeMillis();
    long millis = tEnd - tStart;
    if(millis/1000 > lastSecond){
      lastSecond = millis / 1000;
      putString(1,3,screen,"Seconds since start of program: "+lastSecond);

    }


    // Resize World and Game
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
        }

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
        putString(1,17,screen, "Success!");
      //  putString(1,18,Scraper.master("definition", output));
      }
      else if (mode.equals("2")) {
        putString(1,17,screen, "Success!");
      //  putString(1,18,Scraper.master("synonyms", output));
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
