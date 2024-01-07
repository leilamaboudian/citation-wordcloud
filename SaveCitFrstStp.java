import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Asks user if they would like to save citation
 *
 * @author L. Maboudian
 * @version 1
 */
public class SaveCitFrstStp
{
    /**
     * Presents options to continue (for saving citation in text file).
     * 
     * @param  frame  JFrame to add to
     * @param  citation  citation previously made
     */
    void presNextOptions2(JFrame frame, String citation)
    {
        JLabel nextOpt = new JLabel("Would you like to save your citation in a text file?");
        JButton opt1 = new JButton("Yes!");
        JButton opt2 = new JButton("Nope - back to menu!");
        frame.add(nextOpt);
        frame.add(opt1);
        frame.add(opt2);
        frame.setLayout(new FlowLayout());
        
        opt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aEvent) {
                    frame.dispose();
                    WriteToFile2 writer = new WriteToFile2();
                    writer.writingToFile(citation);
            }
        });
        
        opt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aEvent) {
                frame.dispose();
                ButtonsBack5 bb = new ButtonsBack5();
                bb.backAgain();   
            }
        });
    }
}
