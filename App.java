//Joseph Mulray Final Project Word Guessing Game May 1 2015
//I did not receive help from anyone on this project

import javax.swing.JOptionPane;
// import java.util.*;				//import declarations
import java.io.*;
public class App {

 protected   String tries = JOptionPane.showInputDialog("Numbre of Tries : ");


    public static void main(String [] args) throws IOException
    {
    //Calling welcome Screen
 	Procedure.message();
 	//Game object
    game g = new game();
    //Play game method
    g.playGamep1();

    }


}