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

import java.util.Scanner; 
import javax.swing.JFileChooser; 

/**
 * Prompt user for text file to create word cloud. Create cloud from file.
 *
 * @author L. Maboudian
 * @version 1
 */
public class ButtonsDisplayer3
{
    /**
     * Displays Frame to prompt user for text file (.txt) to create word cloud. Creates and displays word cloud from file text.
     * Throws exception for invalid file type or missing file.
     */
    void presNext1()
    {
        // Prepare the frame
      FrameBase frame = new FrameBase();
      frame.setFrameSize();
      frame.setLabel(" Please attach a text file of your reading material:", 575, 45);
      JButton button = frame.addOnlyOneButton("Attach text file!", 225, 45); 
      frame.setColors();
      frame.makeBot();
      frame.setTitle("- Text file -");
      frame.compFrame(); 
 
      // Prepare the response for when the user clicks the button
      class ClickListener implements ActionListener { // this is an inner class 
          public void actionPerformed(ActionEvent event) {
             Object obj = event.getSource(); 
             if (obj == button) {
                 try {
                    frame.dispose();
                    MyWordCloudLine wordCloudLine = new MyWordCloudLine();
                    wordCloudLine.createCloud();
                 }
                 catch(Exception ex)
                 {
                     JLabel label = new JLabel("Invalid filetype or file not found.");
                     frame.add(label); 
                 }   
             }
         } 
         } 

      // Link the listener to the button
      ActionListener listener = new ClickListener();
      button.addActionListener(listener);
    }
}
