//CS 455x Fall 2017
//PA1
//Name:Zailin Yuan
//USC Net ID: 7247888150

import java.util.Random;




public class CoinTossSimulator {
	
	private int numTwoHead;
	private int numTwoTail;
	private int numHeadTail;
	private int numberTrial;
	
	

	   /**
	      Creates a coin toss simulator with no trials done yet.
	   */
	   public CoinTossSimulator() {
		   numTwoHead = 0;
		   numTwoTail = 0;
		   numHeadTail = 0;
		   numberTrial = 0;
		   
	   }

	   /**
	      Runs the simulation for numTrials more trials. Multiple calls to this method
	      without a reset() between them *add* these trials to the current simulation.
	      
	      @param numTrials  number of trials to for simulation; must be >= 1
	    */
	   public void run(int numTrials) {
		   
		   int sumOfTossing;
		   int i;
		   int tossing1, tossing2;
		   Random toss = new Random();
		   
		
		   numberTrial = numTrials;
		   
		   for(i=0;i<numTrials;i++) 
		   {
		   tossing1 = toss.nextInt(2);  //generate 0 or 1   
		   tossing2 = toss.nextInt(2);   //generate 0 or 1  
		   sumOfTossing = tossing1+tossing2;

//get the number of cases of 0, 1 ,2
		  if(sumOfTossing==0) {
			   numTwoTail++;
		   }
		   else if(sumOfTossing==1) {
			   numHeadTail++;
		   }
		   else{
			   numTwoHead++;
		   }
		   }
		   }
	   

	/**
	      Get number of trials performed since last reset.
	   */
	   public int getNumTrials() {
	       return numberTrial; // DUMMY CODE TO GET IT TO COMPILE
	   }


	   /**
	      Get number of trials that came up two heads since last reset.
	   */
	   public int getTwoHeads() {
	       return numTwoHead; // DUMMY CODE TO GET IT TO COMPILE
	   }


	   /**
	     Get number of trials that came up two tails since last reset.
	   */  
	   public int getTwoTails() {
	       return numTwoTail; // DUMMY CODE TO GET IT TO COMPILE
	   }


	   /**
	     Get number of trials that came up one head and one tail since last reset.
	   */
	   public int getHeadTails() {
	       return numHeadTail; // DUMMY CODE TO GET IT TO COMPILE
	   }


	   /**
	      Resets the simulation, so that subsequent runs start from 0 trials done.
	    */
	   public void reset() {
		   numTwoHead = 0;
		   numTwoTail = 0;
		   numHeadTail = 0;
		   numberTrial = 0;
       }

	}
