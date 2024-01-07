
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
 * Establishes a basic design for JFrames of similar format.
 *
 * @author L. Maboudian
 * @version 1
 */

public class FrameBase extends JFrame
{
    // instance variables 
    private int frameWidth;
    private int frameHeight;
    
    /**
     * Constructor for objects of class FrameBase
     */
    public FrameBase()
    {
        // initialise instance variables
        frameWidth = 400;
        frameHeight = 400;
    }
    
    /**
     * Constructor for objects of class FrameBase
     */
    public FrameBase(int width, int height)
    {
        // initialise instance variables
        frameWidth = width;
        frameHeight = height;
    }
    
    /**
     * Sets size of frame.
     */
    public void setFrameSize()
    {
        this.setSize(frameWidth, frameHeight);
    }
    
    /**
     * Creates a JLabel in the frame top.
     *
     * @param  lTxt  label text
     * @param  w  label width
     * @param  h  label height
     * @return  JLabel created
     */
    public JLabel setLabel(String lTxt, int w, int h)
    {
        JLabel label = new JLabel(lTxt);
        label.setPreferredSize(new Dimension(w, h));
        this.add(label, BorderLayout.PAGE_START);
        return label;
    }
    
    /**
     * Adds a JButton in the left end of the frame.
     *
     * @param  b1Txt  button text
     * @param  w1  button width
     * @param  h1  button height
     * @return  JButton created
     */
    public JButton addFirstButton(String b1Txt, int w1, int h1)
    {
        JButton button1 = new JButton(b1Txt);
        button1.setPreferredSize(new Dimension(w1, h1)); 
        this.add(button1, BorderLayout.WEST);
        return button1;
    }
    
    /**
     * Adds a JButton in the right end of the frame.
     *
     * @param  b2Txt  button text
     * @param  w2  button width
     * @param  h2  button height
     * @return  JButton created
     */
    public JButton addSecondButton(String b2Txt, int w2, int h2)
    {
        JButton button2 = new JButton(b2Txt);
        button2.setPreferredSize(new Dimension(w2, h2)); 
        this.add(button2, BorderLayout.EAST);
        return button2;
    }
    
    /**
     * Adds a JButton in the center of the frame.
     *
     * @param  bTxt  button text
     * @param  w  button width
     * @param  h  button height
     * @return  JButton created
     */
    public JButton addOnlyOneButton(String bTxt, int w, int h)
    {
        JButton button = new JButton(bTxt);
        button.setPreferredSize(new Dimension(w, h)); 
        this.add(button, BorderLayout.CENTER);
        
        int x = frameWidth - w;
        JButton xtraButton1 = new JButton("");
        xtraButton1.setPreferredSize(new Dimension(x, h)); 
        xtraButton1.setBackground(new Color(225,225,225));
        xtraButton1.setOpaque(true);
        xtraButton1.setBorderPainted(false);
        this.add(xtraButton1, BorderLayout.WEST);
        JButton xtraButton2 = new JButton("");
        xtraButton2.setPreferredSize(new Dimension(x, h)); 
        xtraButton2.setBackground(new Color(225,225,225));
        xtraButton2.setOpaque(true);
        xtraButton2.setBorderPainted(false);
        this.add(xtraButton2, BorderLayout.EAST);
        
        return button;
    }
    
    /**
     * Establishes colors of frames.
     */
    public void setColors()
    {
        // put your code here
        this.setBackground(new Color(5,55,195));
        this.getContentPane().setBackground(new Color(225,225,225));
    }
    
    /**
     * Space for the bottom of the frame.
     */
    public void makeBot()
    {
        // put your code here
        JButton button = new JButton(""); 
        this.add(button, BorderLayout.PAGE_END);
        button.setBackground(new Color(225,225,225));
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(frameWidth, 15));
    }
    
    /**
     * Completes frame.
     */
    public void compFrame()
    {
        // put your code here
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }
    
}
