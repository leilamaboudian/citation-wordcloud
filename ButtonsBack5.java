import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import java.awt.Color;
import javax.swing.JComponent;

import java.awt.Component;
import javax.swing.SwingConstants;

import java.awt.*;

/**
 * Creates starting page with main menu.
 *
 * @author L. Maboudian
 * @version 1
 */
public class ButtonsBack5
{
    /**
       * Presents main menu of options: Start & Quit
       */
    void backAgain()
    {
      // Prepare the frame
      FrameBase frame = new FrameBase();
      frame.setFrameSize();
      frame.setLabel(" Ready to transform literature into intriguing word clouds, AND store citations? Press Start!", 575, 45);
      JButton button1 = frame.addFirstButton("Start", 250, 45);
      JButton button2 = frame.addSecondButton("Quit", 250, 45);
      frame.setColors();
      frame.makeBot();
      frame.setTitle("Word clouds and paper storage!");
      frame.compFrame();
      
      // Prepare the response for when the user clicks the button
      class ClickListener implements ActionListener { // this is an inner class
          public void actionPerformed(ActionEvent event) {
             Object obj = event.getSource(); 
             if (obj == button1) {
                 frame.dispose();
                 ButtonsDisplayer2 bd2 = new ButtonsDisplayer2();
                 bd2.presNextOptions1();
             }
             else if (obj == button2) {
                 frame.dispose();
             }
         } 
         } 

      // Link the listener to the button
      ActionListener listener = new ClickListener();
      ActionListener listener2 = new ClickListener();
      
      button1.addActionListener(listener);
      button2.addActionListener(listener2);
      
    }
}
