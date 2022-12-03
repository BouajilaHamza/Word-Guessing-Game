//Joseph Mulray Final Project Word Guessing Game May 1 2015
import javax.swing.JOptionPane;	//importing jOptionPane, util package, and throws IO Exception
import java.util.*;
import java.io.*;


public class game
{
	//Declaring feilds
	Procedure fp2;	Procedure fp1;
	char [] gameboard1;   char [] gameboard2;
	char l1; char l2 ;
	String s1;  String s2 ;
	String let1;  String let2 ;
	int count1; int count2 ;
	char[] L1;
	// String a1 = inputword();
	boolean playAgain;
	String play;
	int numTries1; int numTries2;
	int highscore;
	int scorep1 ;   int scorep2 ;
	Random r  = new Random();
	// boolean w = game1Won(a1);
    public game()throws IOException
    {
    	fp1 = new Procedure();fp2 = new Procedure();	//Procedure object player1
		gameboard1 = new char[12];gameboard2 = new char[12];
    	count1=0;count2 = 0 ;
		playAgain=true;			//variable to test if user wants to play game again
		numTries1=0;numTries2=0;
		
		String s =  fp1.getWord();
		String s2 = fp2.getWord();
		String g1 = generate(s+s2) ;
		String g2 = generate(s+s2) ;

    	  for(int x=0;x<12 ;x++) 	//populatiing gameboard with _ characters of the length of the word.
    	{
			if (s.length() == 12)
				{ 
	   	 			gameboard1[x] = scramble(r, s+s2)[x] ;
				}    	 
			else if(s.length() < 12)
				{
					gameboard1[x] = scramble(r,(s+s2).concat(g1))[x];
				}
			else 
				{
					gameboard1[x] = scramble(r, (s).substring(0, 12))[x];
				}
			
		}

		for(int y=0;y<12 ;y++) 	//populatiing gameboard with _ characters of the length of the word.
    	{
			if (s2.length() == 12)
				{ 
	   	 			gameboard2[y] = scramble(r, s+s2)[y] ;
				}    	 
			else if(s2.length() < 12)
				{
					gameboard2[y] = scramble(r,(s+s2).concat(g2))[y];
				}
			else 
				{
					gameboard2[y] = scramble(r, (s2).substring(0, 12))[y];
				}
		}	}
	


	  



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




	public String generate(String a1)
	{
		String g ="";
		for(int i = 0 ;i <12 - a1.length(); i++)
		{
 			g+=scramble(r,a1)[i] ;
		}
		return g;
	}	



	public void playGamep1()throws IOException		//game method
    {

		JOptionPane.showMessageDialog(null,"   Player 1  ");

    	s1= "Choose a letter to complete the word:\n";

		for(char str: gameboard1)
		{
		s1+=str + " ";											//PRINTING GAMEBOARD AND STORING STRING IN VARIALBE S
		}
		s1+="\nThere are " + fp1.getLength() + " letters in this word" ;

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

	
		if(let1.equals(fp1.getWord()))
		{
			for(int i =0 ; i < let1.length() ;i++)
			{
				gameboard1[i] = let1.toCharArray()[i];
			}
			JOptionPane.showMessageDialog(null,"\t\tGood Job !!\n" + fp1.getWord() + " is the right word !!\nCongradulations you guessed the word!\n So far you have won " + numTries1 + " time(s)!");
		}

	
		
		else	//tests if letter was not in the word
		{	
			while(count1 != 4 && !let1.equals(fp1.getWord()) )
			{
			count1++;
			JOptionPane.showMessageDialog(null, let1 + " is not the word\nYou have " + (4-count1) + "  attempts remaing" );
			let1 = JOptionPane.showInputDialog(s1);
			if(count1 == 4)
			{
				JOptionPane.showMessageDialog(null,"You are out of attempts , Good Luck next Time !! ");
			}
}
		}

	


    }






public void playGamep2()throws IOException		//game method
    {

		JOptionPane.showMessageDialog(null,"   Player 2  ");

    	s2= "Choose a letter to complete the word:\n";

		for(char str: gameboard2)
		{
		s2+=str + " ";											//PRINTING GAMEBOARD AND STORING STRING IN VARIALBE S
		}
		s2+="\nThere are " + fp2.getLength() + " letters in this word" ;

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
		if(let2==null)											//testing to see if user hit the cancel button
		{
		JOptionPane.showMessageDialog(null,"Cancel buttton clicked\n Program Terminated!\n Good-bye!");
		System.exit(0);
		}

	}
	
	
		if(let2.equals(fp2.getWord()))
		{
			for(int i =0 ; i < let2.length() ;i++)
			{
				gameboard2[i] = let2.toCharArray()[i];
			}
			JOptionPane.showMessageDialog(null,"\t\tGood Job !!\n" + fp2.getWord() + " is the right word !!\nCongradulations you guessed the word!\n So far you have won " + numTries2 + " time(s)!");
			System.exit(0);
		}

	
		
		else	//tests if letter was not in the word
		{	
			while(count2 != 4 && !let2.equals(fp2.getWord()) )
			{
			count2++;
			JOptionPane.showMessageDialog(null, let2 + " is not the word\nYou have " + (4-count2) + "  attempts remaing" );
			let2 = JOptionPane.showInputDialog(s2);
			if(count2 == 4)
				{
				JOptionPane.showMessageDialog(null,"You are out of attempts , Good Luck next Time !! ");
				System.exit(0);
				}
			}
		}

	}
	
}












	