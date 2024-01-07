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
import java.awt.event.*;
import javax.swing.*;

/**
 * Displays Frame to redirect user to citation window.
 *
 * @author L. Maboudian
 * @version 1
 */
public class ButtonsDisplayer4
{
    /**
     * Creates new Frame & displays button to redirect user to citation window.
     */ 
    void citing()
    {
      // Prepare the frame
      FrameBase frame = new FrameBase();
      frame.setFrameSize();
      JLabel label = frame.setLabel(" Time to cite!", 575, 45);
      JButton button = frame.addOnlyOneButton("Yes!!!", 225, 45); 
      frame.setColors();
      frame.makeBot();
      frame.setTitle("Citing...");
      frame.compFrame();
      
      // Prepare the response for when the user clicks the button
      class ClickListener implements ActionListener { // this is an inner class 
          public void actionPerformed(ActionEvent event) {
             Object obj = event.getSource(); 
             if (obj == button) {
                 frame.dispose();
                 
                 CitationBoxes cb = new CitationBoxes();
                 cb.showTxtField();
             }
          } 
       } 

      // Link the listener to the button
      ActionListener listener = new ClickListener();
      button.addActionListener(listener);
    }
}
