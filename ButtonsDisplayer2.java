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
 * Displays buttons with options: word cloud or citation. 
 *
 * @author L. Maboudian
 * @version 1
 */
public class ButtonsDisplayer2
{
    /**
     * Presents options to continue (word cloud / citation). Directs user to next frame accordingly.
     */
    void presNextOptions1()
    {
      // Prepare the frame
      FrameBase frame = new FrameBase();
      frame.setFrameSize();
      frame.setLabel(" Would you like to make a word cloud from a text file, or skip to the citation process?", 575, 45);
      JButton button1 = frame.addFirstButton("Word cloud!", 250, 45);
      JButton button2 = frame.addSecondButton("Citation!", 250, 45);
      frame.setColors();
      frame.makeBot();
      frame.setTitle("Word clouds!");
      frame.compFrame();
      
      // Prepare the response for when the user clicks the button
      class ClickListener implements ActionListener { // this is an inner class 
          public void actionPerformed(ActionEvent event) {
             Object obj = event.getSource(); 
             if (obj == button1) {
                 frame.dispose();
                 ButtonsDisplayer3 bd3 = new ButtonsDisplayer3();
                 bd3.presNext1();
             }
             else if (obj == button2) {
                 frame.dispose();
                 ButtonsDisplayer4 bd4 = new ButtonsDisplayer4();
                 bd4.citing();
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
