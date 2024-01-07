import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner; 
import javax.swing.JFileChooser;

/**
 * Make a word file with the given citation.
 *
 * @author L. Maboudian
 * @version 1
 */
public class MakingTheFile
{
    /**
     * Creates word file with given citation
     * 
     * @param mainFrame JFrame to which to add confirmation text.
     * @param citation text of citation
     * @param fileName name of file
     */
    public void makeCiteFile(FrameBase mainFrame, String citation, String fileName) throws Exception {      
        mainFrame.setLayout(new FlowLayout());
        
        java.io.File file = new java.io.File(fileName + ".txt");
        if (file.exists()) {
            try {
                // Create a Scanner for the file
                Scanner input = new Scanner(file);
                String inputText = ""; 
                // Read text from the file
                while (input.hasNext()) { 
                    inputText += input.nextLine() + "\n"; 
                }

                // Close the file
                input.close();
                
                java.io.PrintWriter output = new java.io.PrintWriter(file);

                // Write formatted output to the file
                output.println(inputText);
                output.println(citation); 

                // Close the file
                output.close();
                
                mainFrame.setSize(555,250);
                mainFrame.setLabel(" Your citation has been added to the existing file!",555,25);
                JButton button1yes = mainFrame.addFirstButton("New citation / word cloud!", 200, 25);
                JButton button2no = mainFrame.addSecondButton("I'm done - quit!", 200, 25);
                
                class ClickListener implements ActionListener { // this is an inner class, i.e., inside main method
                      public void actionPerformed(ActionEvent event) {
                         Object obj = event.getSource(); 
                         if (obj == button1yes) {
                             mainFrame.dispose();
                             ButtonsBack5 bb = new ButtonsBack5(); 
                             bb.backAgain();
                         }
                         else if (obj == button2no) {
                             mainFrame.dispose();
                         }
                     } 
                  } 
            
                // Link the listener to the button
                ActionListener listener = new ClickListener();
                ActionListener listener2 = new ClickListener();
                  
                button1yes.addActionListener(listener);
                button2no.addActionListener(listener2);
            }
            catch (Exception ex) {
                mainFrame.setLayout(new FlowLayout());
                mainFrame.setSize(555,300);
                JLabel label5 = new JLabel("An error ocurred in writing to the file...");
                mainFrame.add(label5);
            }
        }
        else {
            try {
                java.io.PrintWriter output = new java.io.PrintWriter(file);

                // Write formatted output to the file
                output.println("\n"+citation); 

                // Close the file
                output.close();

                mainFrame.setSize(555,250);
                mainFrame.setLabel(" Your citation has been added to the file!",555,50);
                JButton yesButton1 = mainFrame.addFirstButton("New citation / word cloud!", 200, 45);
                JButton noButton2 = mainFrame.addSecondButton("I'm done - quit!", 200, 45);
                
                class ClickListener implements ActionListener { // this is an inner class, i.e., inside main method
                      public void actionPerformed(ActionEvent event) {
                         Object obj = event.getSource(); 
                         if (obj == yesButton1) {
                             mainFrame.dispose();
                             ButtonsBack5 bb = new ButtonsBack5();
                             bb.backAgain();
                         }
                         else if (obj == noButton2) {
                             mainFrame.dispose();
                         }
                      } 
                  } 
            
                // Link the listener to the button
                ActionListener listener = new ClickListener();
                ActionListener listener2 = new ClickListener();
                  
                yesButton1.addActionListener(listener);
                noButton2.addActionListener(listener2);
            }
            catch (Exception ex) {
                mainFrame.setLayout(new FlowLayout());
                mainFrame.setSize(555,300);
                JLabel label6 = new JLabel("An error ocurred in writing to the file...");
                mainFrame.add(label6);
            }
       }
    }
}
