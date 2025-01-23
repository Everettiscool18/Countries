// Date: 1/23/25
// Name: Everett
// Description: Made the GUI that manages the country is done. 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class Main 
{
  private Country[] countryArray = new Country[10];  
  private int index = 0;
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  private JTextField textField;

  public static void main(String[] args) {
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }



  public void loadCountries() 
  {
    File file = new File("/workspaces/Countries/workspace/countries-data.csv");
    Scanner scan = null;
    try {
      scan = new Scanner(file);
    } catch(FileNotFoundException e) { 
        System.out.println("File not found");     
    }
    for (int i=0; i<countryArray.length; i++) {
      String input = scan.nextLine();
      String[] data = input.split(",");
      countryArray[i] = new Country(data[0],data[1],data[2],data[3]);
    }
  }

 


  public void showCountry() {
    Country currentCountry = countryArray[index];
    String imagefile = currentCountry.getImageFile();
    img = new ImageIcon("/workspaces/Countries/workspace/"+imagefile);
    imageLabel.setIcon(img);
  }


  
  public void nextButtonClick()
  {
    if (index >= 10) {
      index = 0;
    } else {
      index++;
    }
    int rant = (int) Math.random()*3;
    if (rant == 0) {
      outputLabel.setText("what country is this img from?");
    } else if (rant == 1) {
      outputLabel.setText("what is this nation's capital?");
    }
    textField.setText("");
    showCountry();
  }

  public void reviewButtonClick()
  {
    outputLabel.setText(countryArray[index].toString());
  }

  public void quizButtonClick()
  {
    Country currentCountry = countryArray[index];

    if (outputLabel.getText().indexOf("capital") > 0) {
      if (textField.getText().toLowerCase().equals(currentCountry.getCapital().toLowerCase())) {
        outputLabel.setText("good job! click next to continue");
      } else {
        outputLabel.setText("incorrect :(");
      }

    } else {

      if (textField.getText().toLowerCase().equals(currentCountry.getName().toLowerCase())) {
        outputLabel.setText("good job! click next to continue");

      } else {
        outputLabel.setText("incorrect :(");
      }
    
    }

  }





public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        // create a new image icon
        img = new ImageIcon("worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);
        outputLabel.setText("Click 'Next' to start!");
        jFrame.add(outputLabel);
        textField = new JTextField(35);
        jFrame.add(textField);
        jFrame.setVisible(true);
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });
}
  
}