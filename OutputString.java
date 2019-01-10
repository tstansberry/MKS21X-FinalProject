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
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.dialog.DialogResult;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class OutputString extends JFrame implements ActionListener {
        private JButton b1;
        private JButton b2;
        private JTextField t;
        private Container box;
        public OutputString(){
            this.setTitle("Dictionary");
            this.setSize(600,400);
            this.setLocation(100,100);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            
            box = this.getContentPane();
            box.setLayout(new FlowLayout());
            
            b1 = new JButton("definition");
            b2 = new JButton("synonym");
            t = new JTextField(10);
            
            b1.addActionListener(this);
            b2.addActionListener(this);
            t.addActionListener(this);
            
            
            box.add(b1);
            box.add(b2);
            box.add(t);
        }
        
       
    



