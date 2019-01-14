//API : http://mabe02.github.io/lanterna/apidocs/2.1/
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.graphics.*;
import java.io.IOException;
import java.awt.Color;
import java.util.*;
import java.io.*;


public class TerminalDemo {

  public static void putString(int x, int y, Screen screen, String str) {
		for (int i = 0; i < str.length(); ++i) {
			screen.setCharacter(x+i, y, new TextCharacter(str.charAt(i)));
		}
	}

	public static void main(String[] args) throws IOException {

  Screen screen = new DefaultTerminalFactory().createScreen();
  screen.startScreen();

  long tStart = System.currentTimeMillis();
  long temptime = 0;
  long tempend = 0;
  long lastSecond = 0;

  TerminalSize size = screen.getTerminalSize();
  TextGraphics tg = screen.newTextGraphics();

  while (true) {

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

    output = "";

    KeyStroke key = screen.pollInput();
			if (key != null) {
				if (key.getKeyType() == KeyType.Escape){
        break;
      }

				if ((key.getKeyType() == KeyType.Character)) {
          output += key.getCharacter();
					temptime = millis;
					tempend = temptime + 1000;

				}

        if ((key.getKeyType() == KeyType.Enter)){
          putString(1,10,screen,"The word you have inputted is:" + output);
        }
			}

      //DO EVEN WHEN NO KEY PRESSED:


    screen.doResizeIfNecessary();
    screen.refresh();}

		screen.stopScreen();
	}
}
