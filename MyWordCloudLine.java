import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Scanner; 
import java.util.Arrays;

/**
 * Creates a Word Cloud from a String of text
 *
 * @author L. Maboudian
 * @version 4
 */
public class MyWordCloudLine
{
     private String[] uniqueWords;
     private int[] counts;
     public String[] uselessWords = {"the", "this", "that", "these", "those", "than", "there", "their", "own", "our", "and", "yet", "its", "them", "but", "for", "with", "when", "while", "can", "still", "from", "are", "were", "was", "because"};
    
     /**
      * Constructor for MyWordCloudLine objects
      */
     public MyWordCloudLine()
     {
     } 
     
     /**
      * Constructor for MyWordCloudLine objects, if given a String[] of words to not include in the cloud
      * 
      * @param myUselessWords words to not include in the cloud
      */
     public MyWordCloudLine(String[] myUselessWords)
     {
         String[] moreUselessWords = new String[uselessWords.length + myUselessWords.length];
         int count = 1;
         for (int i = 0; i<uselessWords.length; i++){
             moreUselessWords[i] = uselessWords[i];
             count++;
            }
         for (int i = 0; i<myUselessWords.length; i++){
             moreUselessWords[count] = myUselessWords[i];
             count++;
            }
         uselessWords = moreUselessWords;
     }
     
     /**
         * Takes String of text and returns sorted array of all the words in the text, one element per word.
         * Does not include words shorter than 3 characters, common words such as "the", and words inputted in the contructor to ignore (myUselessWords).
         * @param wordString String of text
         * @return String array of all relevant words, sorted, with duplicates included
         */
     public String[] getWordsFromString( String wordString )
     {
       String wordsTestStr2 = wordString.replaceAll("\\p{Punct}", "");

       String[] words1= wordsTestStr2.split(" ");
 
       String[] wordsCleaned = new String[words1.length];

       for (int i = 0; i<words1.length; i++)
       {
           String word = words1[i];
           String cleanedWordLower = word.toLowerCase();
           if (!Arrays.asList(uselessWords).contains(cleanedWordLower) && cleanedWordLower.length() > 2)
            {
                wordsCleaned[i] = cleanedWordLower;
            }
       }

       int numCleanWords = 0;
       for (String clnWord : wordsCleaned)
       {
           if (clnWord != null) {
               numCleanWords ++;
           }
       }
       
       String[] cleanWords = new String[numCleanWords];
       int count = 0;
       for (int j = 0; j<wordsCleaned.length; j++)
        {
            if (wordsCleaned[j] != null) {
               cleanWords[count] = wordsCleaned[j];
               count++;
            }
        }  
       
       Arrays.sort(cleanWords);
       return cleanWords;
     }

     /**
         * Takes sorted array of Strings and sets uniqueWords and counts fields
         * @param allWords array with all the words, sorted, duplicates of words included
         */
     public void setUniqueWordsAndCounts( String[] allWords )
     {
        String[] uniqueWords1 = new String[allWords.length];
        int[] counts1 = new int[allWords.length];
            
        uniqueWords1[0] = allWords[0];
        String prevWord = allWords[0];
        int prevIndex = 0;
        for (int i = 0; i<allWords.length; i++)
        {
            String currentWord = allWords[i];
            if (currentWord.equals(prevWord))
            {
                counts1[prevIndex] ++;
            }
            else 
            {
                prevWord = allWords[i];
                uniqueWords1[prevIndex+1] = currentWord;
                counts1[prevIndex+1] = 1;
                prevIndex ++;
            }
        }
      
        int numUniquewords = 0;
        for (String unqWord : uniqueWords1) 
        { 
            if (unqWord != null) {
                numUniquewords ++;
            }
        }
        
        uniqueWords = new String[numUniquewords];
        counts = new int[numUniquewords];
        for (int j = 0; j<numUniquewords; j++)
        {
            uniqueWords[j] = uniqueWords1[j];
            counts[j] = counts1[j]; 
        }
     }
     
     /**
         * Gets array of all unique words in text, no duplicates.
         * @return array of all unique words, as Strings
         */
     public String[] getUniqueWords()
     {
        return uniqueWords;
     }
     
     /**
         * Gets counts of all unique words (in same order as uniqueWords array).
         * i.e. counts[i is the count of how many times uniqueWords[i] appears in text.
         * @return counts of each unique word
         */
     public int[] getCounts()
     {
        return counts;
     }

     /**
         * Creates graphical display of word cloud, assuming uniqueWords and counts fields have been set.
         * If number of unique words is greater than 350, only includes words with count > 1. Otherwise includes all unique words.
         * After displaying cloud, prompts user if they would like to continue or quit.
         */
     public void displayWords()
     {
        FrameBase frame = new FrameBase();
        frame.setPreferredSize(new Dimension(1200,1000));
        frame.setBackground(new Color(5,55,195));
        frame.setTitle("Your word cloud!!!");
        int wordCount = 0;
        
        for (int y = 0; y<uniqueWords.length/10; y++)
        {
            FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 25, 0);
            frame.setLayout(fl);
            for(int x=0; x<=10; x++)
            {
                if (uniqueWords.length >350){
                    if (wordCount<uniqueWords.length && counts[wordCount] > 1 ){ 
                        JLabel label = new JLabel(uniqueWords[wordCount]);
                        label.setFont(new Font("Serif", Font.BOLD, counts[wordCount]*10));
                        
                        frame.add(label);
                        
                        int R = (int)(Math.random()*256);
                        int G = (int)(Math.random()*256);
                        int B = (int)(Math.random()*256);
                        Color color = new Color(R, G, B); //random color, but can be bright or dull
            
                        //to get rainbow, pastel colors
                        Random random = new Random();
                        final float hue = random.nextFloat();
                        final float saturation = 0.5f;//1.0 for brilliant, 0.0 for dull
                        final float luminance = 0.8f; //1.0 for brighter, 0.0 for black
                        color = Color.getHSBColor(hue, saturation, luminance);
                    
                        label.setForeground(color);
                    }
                 }
                else {
                    if (wordCount<uniqueWords.length ){ 
                        JLabel label = new JLabel(uniqueWords[wordCount]);
                        label.setFont(new Font("Serif", Font.BOLD, counts[wordCount]*10));
                        
                        frame.add(label);
                        
                        int R = (int)(Math.random()*256);
                        int G = (int)(Math.random()*256);
                        int B = (int)(Math.random()*256);
                        Color color = new Color(R, G, B); //random color, but can be bright or dull
            
                        //to get rainbow, pastel colors
                        Random random = new Random();
                        final float hue = random.nextFloat();
                        final float saturation = 0.5f;//1.0 for brilliant, 0.0 for dull
                        final float luminance = 0.8f; //1.0 for brighter, 0.0 for black
                        color = Color.getHSBColor(hue, saturation, luminance);
                    
                        label.setForeground(color); 
                    }
                 }
                wordCount++;
            }
                
        }
        
        frame.pack();
        frame.setVisible(true);
        
       
        JLabel contLabel = new JLabel("Would you like to continue to the citation process?");
        frame.add(contLabel);
        JButton yesButton = new JButton("Yes, continue!");
        JButton noButton = new JButton("I'm done, back to menu...");
        frame.add(yesButton);
        frame.add(noButton); 
        
        // Prepare the response for when the user clicks the button
          class ClickListener implements ActionListener { // this is an inner class, i.e., inside main method
              public void actionPerformed(ActionEvent event) {
                 Object obj = event.getSource(); 
                 if (obj == yesButton) {
                     frame.dispose();
                     CitationBoxes cb = new CitationBoxes();
                     cb.showTxtField();
                 }
                 else if (obj == noButton) {
                     frame.dispose();
                     ButtonsBack5 bb = new ButtonsBack5();
                     bb.backAgain();        
                 }
             } 
             } 
    
          // Link the listener to the button
          ActionListener listener = new ClickListener();
          ActionListener listener2 = new ClickListener();
          
          yesButton.addActionListener(listener);
          noButton.addActionListener(listener2);
     }
     
     /**
         * Reads text from inputted text file (.txt) and creates word cloud.
         * Throws Exception for invalid file type.
         */
     public void createCloud() throws Exception
     {
         String contents = "";
         
         JFileChooser fileChooser = new JFileChooser();
         if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            
             // Get the selected file
            java.io.File inFile = fileChooser.getSelectedFile(); 

            // Create a Scanner for the file
            Scanner input = new Scanner(inFile);
            
            // Read text from the file
            while (input.hasNext()) { 
                contents += " " + input.nextLine(); 
            }

            // Close the file
            input.close();
         }
         else {
            System.out.println("No file selected / invalid filetype");
         }
         
         String[] wordArray = getWordsFromString(contents);
         setUniqueWordsAndCounts(wordArray);
         displayWords();
         
     }
}

