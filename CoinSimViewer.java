package HW1;

import java.util.Scanner;
import javax.swing.JFrame;


public class CoinSimViewer {
	public static void main(String args[]) {
		
//Show instructions to start:
		instructions();
		
//define height and width of the frame:
		int frameH = 1000;
		int frameW = 850;
		int trialTimesCarrier;   
		
//input variables:
		Scanner input =new Scanner(System.in);
		trialTimesCarrier = input.nextInt();
		
//check the entered value:
		while(trialTimesCarrier<=0){
			System.out.println("Enter number of trials: " + trialTimesCarrier);
			System.out.println("ERROR: Number entered must be greater than 0.");
			
			trialTimesCarrier = input.nextInt();
		}
			
		System.out.println("Enter number of trials: " + trialTimesCarrier);

//draw frame and the bars:
		JFrame frame = new JFrame();
		frame.setSize(frameW,frameH);
		frame.setTitle("Tossing Statistics:");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CoinSimComponent coinSim = new CoinSimComponent(trialTimesCarrier, frameW, frameH);
		frame.add(coinSim);
		
		frame.setVisible(true);
			
	}
	
	//tells users what does this simulator do and how to use it:
	public static void instructions() {
		System.out.println("Welcome to coin toss simulator!");
		System.out.println("This program gives statical results of tossing a lot of coins.");
		System.out.println("Please enter times of tossing you want, results will appear as graph: ");
	}
}

