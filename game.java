//Joseph Mulray Final Project Word Guessing Game May 1 2015

import javax.swing.JOptionPane;	//importing jOptionPane, util package, and throws IO Exception
import java.util.*;
import java.io.*;

public class game{
	//Declaring feilds
	Procedure fp1;
	Procedure fp2;

	char [] gameboard1;
	char [] gameboard2;
	char l1;
	char l2 ;
	String s1;
	String s2;
	String let1;
	String let2;
	int count1;
	int count2;
	char[] L;

	boolean playAgain;
	String play;
	int numTries;
	int highscore;
	int scorep1 ;
	int scorep2;
	int nbtry ;

    public game()throws IOException
    {
    	fp1 = new Procedure();	//Procedure object player1
		fp2 = new Procedure();	//Procedure object player2
		gameboard1 = new char[fp1.getLength()];
		gameboard2 = new char[fp2.getLength()];	//creating an array gameboard of chars
    	count1=0;
    	count2=0;

		playAgain=true;			//variable to test if user wants to play game again
		numTries=0;

    	  for(int x=0;x<fp1.getLength();x++) 	//populatiing gameboard with _ characters of the length of the word.
    	 {
    	 	gameboard1[x]='_';
    	 }

		 for(int x=0;x<fp2.getLength();x++) 	//populatiing gameboard with _ characters of the length of the word.
    	 {
    	 	gameboard2[x]='_';
    	 }
    


	 //add shuffled list with letters of the right word
	 String word1=fp1.getWord();
	 List<String> letters = Arrays.asList(word1.split(""));
	 Collections.shuffle(letters);
	 String shuffled = "";

	 for (String letter : letters) {
		 shuffled += letter;}
	 char[] liste=shuffled.toCharArray();
	 L=liste; 
	}






























































	public void playGamep1()throws IOException		//game method
    {

		JOptionPane.showMessageDialog(null,"   Player 1  ");

    	// while(playAgain==true)		//user will be prompted to if wants to playagain if user does not playAgain will = false
    	// {


    	while(count1<4 && game1Won()!=true) //test variables to keep getting usres input until guesses wrong four times or completes word
    	{
    		getLetter1();		//calls getLetter methods
    		testLetter1();		//calls testLetter methods
    	}
    	if (game1Won()==true)	//determines if user wins
    	{
    		numTries++;		//keeps track of number of times user wins
    		JOptionPane.showMessageDialog(null,"Congradulations you guessed the word!\n So far you have won " + numTries + " time(s)!");
    	}
    	if(count1>=4)		//test for number of tries
    	{
    		JOptionPane.showMessageDialog(null,"Sorry you ran out of guesses.\n The word was " + fp1.getWord());
    	}


    	// play= JOptionPane.showInputDialog("Type 'y' to play another game, anything else to quit");
    	// if (play.compareToIgnoreCase("y")!=0) //testing users input whether wants to play again or not.
    	// {
    		playAgain=false;		//stops game method from playing again


    		File file = new File("scores.txt");		//Extra credit highscore reading from scores file
			try (Scanner inputFile = new Scanner(file)) {
				highscore=Integer.parseInt(inputFile.nextLine());	//converting number from file into an integer
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(numTries>highscore)	//comparing the number the user won and the previous highscore
				{
		 		JOptionPane.showMessageDialog(null,"Congradulations! You broke the highscore with " + numTries + " win(s)!\n The previous record was " + highscore + ". ");
		 		PrintWriter outputFile = new PrintWriter(file);	//PrintWriter object to replace number
				outputFile.println(numTries); //replaces number with new highscore
				outputFile.close(); //closes the file
				}
			JOptionPane.showMessageDialog(null, "You won " + numTries + " time(s)\nThanks for playing!\nCome again!");


    	// }
		// else	//if users input is is equal to y
		// 	{
		// count=0;		//resets counter
    	// fp = new Procedure();			//calls Procedure object for another word
    	// gameboard = new char[fp.getLength()];	//creates a new gameboard

    	// 	for(int x=0;x<fp.getLength();x++)
    	// 		{
    	//  		gameboard[x]='_';
    	//  		}

		// 	}
    	// }
    }
























	public void playGamep2()throws IOException		//game method
    {


    	// while(playAgain==true)		//user will be prompted to if wants to playagain if user does not playAgain will = false
    	// {

    	JOptionPane.showMessageDialog(null,"   Player 2 ");

    	while(count2<4 && game2Won()!=true) //test variables to keep getting usres input until guesses wrong four times or completes word
    	{
    		getLetter2();		//calls getLetter methods
    		testLetter2();		//calls testLetter methods
    	}
    	if (game2Won()==true)	//determines if user wins
    	{
    		numTries++;		//keeps track of number of times user wins
    		JOptionPane.showMessageDialog(null,"Congradulations you guessed the word!\n So far you have won " + numTries + " time(s)!");
    	}
    	if(count2>=4)		//test for number of tries
    	{
    		JOptionPane.showMessageDialog(null,"Sorry you ran out of guesses.\n The word was " + fp2.getWord());
    	}


    	// play= JOptionPane.showInputDialog("Type 'y' to play another game, anything else to quit");
    	// if (play.compareToIgnoreCase("y")!=0) //testing users input whether wants to play again or not.
    	// {
    		playAgain=false;		//stops game method from playing again


    		File file = new File("scores.txt");		//Extra credit highscore reading from scores file
			try (Scanner inputFile = new Scanner(file)) {
				highscore=Integer.parseInt(inputFile.nextLine());	//converting number from file into an integer
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(numTries>highscore)	//comparing the number the user won and the previous highscore
				{
		 		JOptionPane.showMessageDialog(null,"Congradulations! You broke the highscore with " + numTries + " win(s)!\n The previous record was " + highscore + ". ");
		 		PrintWriter outputFile = new PrintWriter(file);	//PrintWriter object to replace number
				outputFile.println(numTries); //replaces number with new highscore
				outputFile.close(); //closes the file
				}
			JOptionPane.showMessageDialog(null, "You won " + numTries + " time(s)\nThanks for playing!\nCome again!");


    }




















































    public boolean game1Won() throws IOException //method to test if user guessed every letter returns a boolean
    {
    	boolean winner=true;
    	for(int x=0;x<fp1.getLength();x++)
    	{
		if(gameboard1[x]=='_') //for loop and if statement to read the gameboard array and returns false if an underscore is found.
		{
			winner=false;
		}
    	}
    	return winner;
    }






	public boolean game2Won() throws IOException //method to test if user guessed every letter returns a boolean
    {
    	boolean winner=true;
    	for(int x=0;x<fp2.getLength();x++)
    	{
		if(gameboard2[x]=='_') //for loop and if statement to read the gameboard array and returns false if an underscore is found.
		{
			winner=false;
		}
    	}
    	return winner;
    }
















































	public void getLetter1() //method to get users input of a letter
	{

		 s1= "Choose a letter to complete the word:\n";

		for(char str: gameboard1)
		{
		s1+=str + " ";											//PRINTING GAMEBOARD AND STORING STRING IN VARIALBE S
		}
		s1+="\nThere are " +fp1.getLength() + " letters in this word";

		let1 = JOptionPane.showInputDialog(s1);

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
	}









	public void getLetter2() //method to get users input of a letter
	{

		 s2= "Choose a letter to complete the word:\n";

		for(char str: gameboard2)
		{
		s2+=str + " ";											//PRINTING GAMEBOARD AND STORING STRING IN VARIALBE S
		}
		s2+="\nThere are " +fp2.getLength() + " letters in this word";

		let2 = JOptionPane.showInputDialog(s2);

		if(let2==null) //testing to see if user hit the cancel button
		{
		JOptionPane.showMessageDialog(null,"Cancel buttton clicked\n Program Terminated!\n Good-bye!");
		System.exit(0);	//ends the program
		}

	while(let2.length()==0 || Character.isLetter(let2.charAt(0))== false)		//tests conditions of input whether input was eventered
	{																		// or whether the input was a letter or not
		JOptionPane.showMessageDialog(null,"Invalid answer!");
		let2 = JOptionPane.showInputDialog(s2);
		if(let2 ==null)											//testing to see if user hit the cancel button
		{
		JOptionPane.showMessageDialog(null,"Cancel buttton clicked\n Program Terminated!\n Good-bye!");
		System.exit(0);
		}

	}
		l2=let2.charAt(0);
	}
























	public void testLetter1()		//tests the letter if it is found in the word and replaces that letter
	{								// to the corresponding area on the gameboard

		boolean letterword=false;			//boolean of whether word is in gameboard and replaces that letter on the gameboard
		for(int x=0;x<fp1.getLength();x++)
		{
			if(l1==(fp1.getWord().charAt(x)))
			{
				gameboard1[x]=l1;
				letterword=true;
			}

		}
			if(letterword==false)	//tests if letter was not in the word
			{						//increments count if not
			count1++;
			JOptionPane.showMessageDialog(null, l1 + " is not in the word\nYou have " + (4-count1) + "  tries remaining" );
			}

		}












		public void testLetter2()		//tests the letter if it is found in the word and replaces that letter
	{								// to the corresponding area on the gameboard

		boolean letterword=false;			//boolean of whether word is in gameboard and replaces that letter on the gameboard
		for(int x=0;x<fp2.getLength();x++)
		{
			if(l2==(fp2.getWord().charAt(x)))
			{
				gameboard2[x]=l2;
				letterword=true;
			}

		}
			if(letterword==false)	//tests if letter was not in the word
			{						//increments count if not
			count2++;
			JOptionPane.showMessageDialog(null, l2 + " is not in the word\nYou have " + (4-count2) + "  tries remaining" );
			}

		}




	}


