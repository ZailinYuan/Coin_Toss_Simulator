//CS 455x Fall 2017
//PA1
//Name:Zailin Yuan
//USC Net ID: 7247888150

package HW1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;



public class CoinSimComponent extends JComponent {
	
	private int inputNumTrial;
	int frameHeight;
	int frameWidth;
	
	
	public CoinSimComponent() {
		this(0,0,0);
	}
	
	
	public CoinSimComponent(int getTrialTimes, int Fwidth, int Fheight) {
		inputNumTrial = getTrialTimes;
		frameHeight = Fheight;
		frameWidth = Fwidth;
	}
	
	
	
	/**
    Run the simulator by calling CoinTossSimlator
 */
	public void paintComponent(Graphics g) {

		//variables to receive the number of cases 0,1,2 from CoinTossSimulator
		int numTrials;
		int numHeads;
		int numTails;
		int numHeadTails;
		
		//variables to receive the ratio of each case 0,1,2
		int ratioHeads;
		int ratioTails;
		int ratioHeadTails;
		
		
		CoinTossSimulator tossing = new CoinTossSimulator();
		tossing.run(inputNumTrial);
		
		
//get the results(4) from Simulation:		
		numTrials = tossing.getNumTrials();
		numHeads = tossing.getTwoHeads();
		numTails = tossing.getTwoTails();
		numHeadTails = tossing.getHeadTails();
		
		
//show the status of Simulation process:
		if(numTrials == inputNumTrial)
			System.out.println("Simulation runs with no error!");
		else
			System.out.println("Warning! An error happens when running the simulator!"
					+ " This may lead the results to be wrong!");
		
		
//process the results from simulation:		
		double DnumTrials = numTrials;
		
		ratioHeads = (int)(Math.round(numHeads*100/DnumTrials));
		ratioTails = (int)(Math.round(numTails*100/DnumTrials));
		ratioHeadTails = 100-ratioHeads-ratioTails;
		
		
		
//initialize the data needed to fill the frame:
		double RATIO1 = 0.1;
		double RATIO2 = 0.9;
		int CHARHEIGHT= 20;
		int WIDTH = 100;
		
		int widthOfBuffer;
		int left1, left2, left3;
		int barHeight1, barHeight2, barHeight3;
		double scale;
		int bottom;
		
		
//determine value for all bars:
		bottom = (int)(Math.round(RATIO2*frameHeight-CHARHEIGHT));
		widthOfBuffer = (int)(Math.round(RATIO1*frameHeight));
		scale = (frameHeight-(widthOfBuffer*2)-CHARHEIGHT)/100.0;
		
		
//data of bar1:
		left1 = (int)Math.round((frameWidth-(WIDTH*3))/4.0);
		barHeight1 = ratioHeads;
		
		System.out.println(left1);
		
		
//data of bar2:
		left2 = left1*2+WIDTH;
		barHeight2 = ratioHeadTails;
		
		
//data of bar3:
		left3 = left1*3+WIDTH*2;
		barHeight3 = ratioTails;
		
		
//draw bars:
		Graphics2D g2 = (Graphics2D)g;
		Bar barTwoHeads = new Bar(bottom,left1,WIDTH,barHeight1,scale,
				Color.RED,"Two Heads: "+numHeads+"("+ratioHeads+"%)");
		Bar barHeadTails = new Bar(bottom,left2,WIDTH,barHeight2,scale,
				Color.GREEN,"A Head and a Tail: "+numHeadTails+"("+ratioHeadTails+"%)");
		Bar barTwoTails = new Bar(bottom,left3,WIDTH,barHeight3,scale,
				Color.BLUE,"Two Tails: "+numTails+"("+ratioTails+"%)");
		
		barTwoHeads.draw(g2);
		barTwoTails.draw(g2);
		barHeadTails.draw(g2);
		
		
//reset the simulator:
		tossing.reset();
	}
}



