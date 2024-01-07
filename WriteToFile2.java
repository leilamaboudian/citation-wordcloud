import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner; 
import javax.swing.JFileChooser;

/**
  * Creates .txt file with given file name (excluding extension). Writes citation to file.
  * 
  * @author L. Maboudian
  * @version 1
  */

public class WriteToFile2 {
    private FrameBase mainFrame;
    private JLabel headerLabel;
    private JLabel statLabel;
    private JPanel controlPanel;
    private String fileName = "";
    private JLabel citLabel;
    private final JTextField citText;
    private String citation;
    
    /**
     * Constructor for objects of class WriteToFile2
     */
    public WriteToFile2()
    {
        // initialise instance variables
        prepGUI();
        citText = new JTextField(8);
    }

    /**
     * Creates frame to prompt user for file name.
     */ 
    public void prepGUI()
    {
        mainFrame = new FrameBase();
        mainFrame.setSize(555,300);
        mainFrame.setTitle("Writing to a new or existing file:");
        mainFrame.setLayout(new GridLayout(3,1));
        mainFrame.setColors();
        
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent wEvent) {
                System.exit(0);
            }
        });
        headerLabel = mainFrame.setLabel(" Please provide the name of a new or existing file to write to (excluding extension):",555,45);
        statLabel = new JLabel("");
        statLabel.setSize(350, 100);
        mainFrame.add(statLabel, BorderLayout.PAGE_END);
        
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statLabel);
        mainFrame.setVisible(true);  
    }
    
    /**
     * Writes citation to file.
     * 
     * @param userCitation citation text
     */ 
    public void writingToFile(String userCitation)
    {
        citLabel = new JLabel("File name: ");
        
        JButton citButton = new JButton("Write to file!");
        citButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aEvent) {
                fileName = citText.getText();
                citation = userCitation;
                try {
                     mainFrame.remove(citLabel);
                     mainFrame.remove(citText);
                     MakingTheFile mtf = new MakingTheFile();
                     mtf.makeCiteFile(mainFrame, citation, fileName);
                }
                catch (Exception ex) {
                     JLabel label = new JLabel("Error ocurred in saving citation... ");
                     mainFrame.add(label);
                }
            }
        }); 
        controlPanel.add(citLabel);
        controlPanel.add(citText);
        controlPanel.add(citButton);
        mainFrame.setVisible(true);
    }    
}
