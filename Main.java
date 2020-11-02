import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel fahrenheit;
  JLabel celsius;

  JTextField fahrenheitBox;
  JTextField celsiusBox;

  JButton topButton;
  JButton bottomButton;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
    //initialize the main panel
    mainPanel = new JPanel();
    //disable layout helpers
    mainPanel.setLayout(null);
    //create label for fahrenheit and celsius
    fahrenheit = new JLabel("Degrees Fahrenheit");
    celsius = new JLabel("Degrees Celsius");
    //give location and size of labels
    fahrenheit.setBounds(100,300,150,20);
    celsius.setBounds(100,330,150,20);
    //add the labels to the panel
    mainPanel.add(fahrenheit);
    mainPanel.add(celsius);
    //make conversion buttons
    topButton = new JButton("F -> C");
    bottomButton = new JButton("C -> F");
    //give location and size of buttons
    topButton.setBounds(500,300,150,20);
    bottomButton.setBounds(500,330,150,20);
    //action listener for buttons
    topButton.addActionListener(this);
    bottomButton.addActionListener(this);
    //set action command for the buttons
    topButton.setActionCommand("F -> C");
    bottomButton.setActionCommand("C -> F");
    //add the buttons to the panel
    mainPanel.add(topButton);
    mainPanel.add(bottomButton);
    //create the textfields
    fahrenheitBox = new JTextField();
    celsiusBox = new JTextField();
    //give location and size of textfields
    fahrenheitBox.setBounds(300,300,150,20);
    celsiusBox.setBounds(300,330,150,20);
    //add text fields to the panel
    mainPanel.add(fahrenheitBox);
    mainPanel.add(celsiusBox);
    frame.add(mainPanel);
  }

  public void actionPerformed(ActionEvent e){
      // get the command from the action
    String command = e.getActionCommand();
      // This one is for fahrenheit to celsius
    if(command.equals("F -> C")){
      //get the string from the first textfield
      String firstText = fahrenheitBox.getText();
      //convert string to integer
      int num1 = Integer.parseInt(firstText);

      //convert Fahrenheit to Celsius
      int celsius = (num1 - 32)*5/9;
      //put answer in the textfield
      celsiusBox.setText("" + celsius);
      // this one is for celsius to fahrenheit
    }else if(command.equals("C -> F")){
      //get the text from the second textfield
      String secondText = celsiusBox.getText();
      //convert string to integer
      int num2 = Integer.parseInt(secondText);

      //convert celsius to Fahrenheit
      int fahrenheit = (num2/5*9 + 32);
      //put the answer in text field
      fahrenheitBox.setText("" + fahrenheit);
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
