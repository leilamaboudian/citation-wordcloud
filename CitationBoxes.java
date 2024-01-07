import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Provides slots for citation information and collects citation.
 *
 * @author L. Maboudian
 * @version 1
 */
public class CitationBoxes
{
    // instance variables 
    private FrameBase mainFrame;
    private JLabel headerLabel;
    private JLabel statLabel;
    private JPanel controlPanel;


    /**
     * Constructor for objects of class CitationBoxes
     */
    public CitationBoxes()
    {
        // initialise instance variables
        prepGUI();
    }

    /**
     * Prepares GUI that propmpts user for citation.
     */
    public void prepGUI()
    {
        mainFrame = new FrameBase(850,200);
        mainFrame.setFrameSize();
        mainFrame.setTitle("Citing...");
        mainFrame.setLayout(new GridLayout(3,1));
        mainFrame.setColors();
        
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent wEvent) {
                System.exit(0);
            }
        });
        
        headerLabel = mainFrame.setLabel(" Please provide the following information to create your citation:",575,45);
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
     * Shows text fields for entering citation information. Collects information entered.
     */
    public void showTxtField()
    {
        JLabel ttlLabel = new JLabel("Title: "); // , JLabel.LEFT
        JLabel authLabel = new JLabel("      Author: "); // , JLabel.CENTER
        JLabel yrLabel = new JLabel("      Date published: "); //, JLabel.RIGHT
        JLabel pubLabel = new JLabel("      Publisher/Journal: ");
        
        final JTextField ttlText = new JTextField(6);
        final JTextField authText = new JTextField(6);
        final JTextField yrText = new JTextField(6);
        final JTextField pubText = new JTextField(6);
        
        JButton citeButton = new JButton("Cite!");
        citeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aEvent) {
                String data = " Your citation:   ";
                data += authText.getText();
                data += ". (" + yrText.getText() +").";
                data += " \"" + ttlText.getText() +".\"";
                data += " " + pubText.getText() +".";
                statLabel.setText(data + "   ");

                SaveCitFrstStp sCfS = new SaveCitFrstStp();
                sCfS.presNextOptions2(mainFrame, data);
            }
        });
        
        controlPanel.add(ttlLabel);
        controlPanel.add(ttlText);
        controlPanel.add(authLabel);
        controlPanel.add(authText);
        controlPanel.add(yrLabel);
        controlPanel.add(yrText);
        controlPanel.add(pubLabel);
        controlPanel.add(pubText);
        controlPanel.add(citeButton);
        mainFrame.setVisible(true);
        
        
    }
}
