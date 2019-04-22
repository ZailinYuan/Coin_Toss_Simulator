package HW1;

import java.util.Scanner;
import javax.swing.JFrame;


public class CoinSimViewer {
	public static void main(String args[]) {
		
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
		frame.setTitle("CoinSim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CoinSimComponent coinSim = new CoinSimComponent(trialTimesCarrier, frameW, frameH);
		frame.add(coinSim);
		
		frame.setVisible(true);
			
	}
}
