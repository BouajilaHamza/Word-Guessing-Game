//Joseph Mulray Final Project Word Guessing Game May 1 2015

import javax.swing.JOptionPane;	//importing jOptionPane, util package, and throws IO Exception
import java.util.*;
import java.io.*;


public class game
{
	//Declaring feilds
	Procedure fp1;

	
	char [] gameboard1;

	char l1;
	String s1;
	String let1;
	int count1;
	char[] L1;

	boolean playAgain;
	String play;
	int numTries;
	int highscore;
	int scorep1 ;
	Random r  = new Random();
    public game()throws IOException
    {
    	fp1 = new Procedure();	//Procedure object player1
		gameboard1 = new char[12];
    	count1=0;

		playAgain=true;			//variable to test if user wants to play game again
		numTries=0;

		//add shuffled list for fp1 and fp2 with letters of the right word

		
    	  for(int x=0;x<12 ;x++) 	//populatiing gameboard with _ characters of the length of the word.
    	{
			if (fp1.getWord().length() == 12)
			{ 
	   	 	gameboard1[x] = scramble(r, fp1.getWord())[x] ;
			}    	 
			else 
			{
				if(fp1.getWord().length() < 12)
				{
					System.out.print(scramble(r, fp1.getWord()) + " | ");System.out.println(generate(fp1.getWord()) + " | ");
					gameboard1[x] = scramble(r, fp1.getWord().concat(generate(fp1.getWord())))[x];
				}
				else 
				{
					gameboard1[x] = scramble(r, fp1.getWord().substring(0, 12))[x];
				}
			}
			System.out.println("----------------------");
			System.out.println(gameboard1[x]);
		}
	}


	  



// function for creating shuffled word
public char[] scramble( Random random, String inputString )
{
    // Convert your string into a simple char array:
    char a[] = inputString.toCharArray();

    // Scramble the letters using the standard Fisher-Yates shuffle, 
    for( int i=0 ; i<a.length; i++ )
    {
        int j = random.nextInt(a.length);
        // Swap letters
        char temp = a[i]; a[i] = a[j];  a[j] = temp;
    }       
    return a ;
}




	public String generate(String w)
	{
		String g ="";
		for(int i = 0 ;i <12 - w.length(); i++)
		{
 			g+=scramble(r,w)[i] ;
		}
		return g;
	}	



	public void playGamep1()throws IOException		//game method
    {

		// JOptionPane.showMessageDialog(null,"   Player 1  ");

    	// while(playAgain==true)		//user will be prompted to if wants to playagain if user does not playAgain will = false
    	// {


    	while(game1Won()!=true) //test variables to keep getting usres input until guesses wrong four times or completes word
    	{
    		getLetter1();		//calls getLetter methods
    		testLetter1();		//calls testLetter methods
    	
    		if (game1Won()==true)	//determines if user wins
    		{
				JOptionPane.showMessageDialog(null,"Congradulations you guessed the word!\n So far you have won " + numTries + " time(s)!");

    			// numTries++;		//keeps track of number of times user wins
				break;
    		}

		}
    	// if(count1>=4)		//test for number of tries
    	// {
    	// 	JOptionPane.showMessageDialog(null,"Sorry you ran out of guesses.\n The word was " + fp1.getWord());
    	// }


    	// play= JOptionPane.showInputDialog("Type 'y' to play another game, anything else to quit");
    	// if (play.compareToIgnoreCase("y")!=0) //testing users input whether wants to play again or not.
    	// {
    		// playAgain=false;		//stops game method from playing again


    		// File file = new File("scores.txt");		//Extra credit highscore reading from scores file
			// try (Scanner inputFile = new Scanner(file)) {
			// 	highscore=Integer.parseInt(inputFile.nextLine());	//converting number from file into an integer
			// } catch (NumberFormatException e) {
			// 	// TODO Auto-generated catch block
			// 	e.printStackTrace();
			// }
			// if(numTries>highscore)	//comparing the number the user won and the previous highscore
			// 	{
		 	// 	JOptionPane.showMessageDialog(null,"Congradulations! You broke the highscore with " + numTries + " win(s)!\n The previous record was " + highscore + ". ");
		 	// 	PrintWriter outputFile = new PrintWriter(file);	//PrintWriter object to replace number
			// 	outputFile.println(numTries); //replaces number with new highscore
			// 	outputFile.close(); //closes the file
			// 	}
			// JOptionPane.showMessageDialog(null, "You won " + numTries + " time(s)\nThanks for playing!\nCome again!");

    }




    public boolean game1Won() throws IOException //method to test if user guessed every letter returns a boolean
    {
    	boolean winner=true;
    	// for(int x=0;x< 12;x++)
    	// {
		if(getLetter1().contains(fp1.getWord())) ;//for loop and if statement to read the gameboard array and returns false if an underscore is found.
		{
			System.out.println(gameboard1.toString() +" | ");System.out.println(getLetter1());
			System.out.println(getLetter1().contains(fp1.getWord()));
			winner=false;
			JOptionPane.showMessageDialog(null,"You have guessed the Word ");
			System.exit(0);
		}
    	// }

    	return winner;
	}








	public String getLetter1() //method to get users input of a letter
	{

		 s1= "Choose a letter to complete the word:\n";

		for(char str: gameboard1)
		{
		s1+=str + " ";											//PRINTING GAMEBOARD AND STORING STRING IN VARIALBE S
		}
		s1+="\nThere are " +fp1.getLength() + " letters in this word";

		let1 = JOptionPane.showInputDialog(s1);
		System.out.println(let1);

		if(let1==null) //testing to see if user hit the cancel button
		{
		JOptionPane.showMessageDialog(null,"Cancel buttton clicked\n Program Terminated!\n Good-bye!");
		System.exit(0);	//ends the program
		}

	while(let1.length()==0 || Character.isLetter(let1.charAt(0))== false)		//tests conditions of input whether input was eventered
	{																		// or whether the input was a letter or not
		JOptionPane.showMessageDialog(null,"Invalid answer!");
		let1 = JOptionPane.showInputDialog(s1);
		if(let1==null)											//testing to see if user hit the cancel button
		{
		JOptionPane.showMessageDialog(null,"Cancel buttton clicked\n Program Terminated!\n Good-bye!");
		System.exit(0);
		}

	}
		l1=let1.charAt(0);
		return let1;
	}










	public void testLetter1()		//tests the letter if it is found in the word and replaces that letter
	{								// to the corresponding area on the gameboard

		// boolean letterword=false;			//boolean of whether word is in gameboard and replaces that letter on the gameboard
		// for(int x=0;x<fp1.getLength();x++)
		// {
			if(getLetter1().contains(fp1.getWord()))
			{
				gameboard1 = getLetter1().toCharArray();
				// letterword=true;
			}

		
			
			// if(letterword==false)	//tests if letter was not in the word
			// else{						//increments count if not
				
			// count1++;
			// JOptionPane.showMessageDialog(null, let1 + " is not the word\nYou have " + (4-count1) + "  tries remaining" );
			// }

	}

}










		


