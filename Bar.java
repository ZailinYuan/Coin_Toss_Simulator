//CS 455x Fall 2017
//PA1
//Name:Zailin Yuan
//USC Net ID: 7247888150

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;



public class Bar {
	   
	int drawBottom;
	  int drawLeft;
	  int drawWidth;
	  int drawBarHeight;
	  double drawScale;
	  String LABEL;
	  Color COLOR;


	   /**
	      Creates a labeled bar.  You give the height of the bar in application
	      units (e.g., population of a particular state), and then a scale for how
	      tall to display it on the screen (parameter scale). 
	  
	      @param bottom  location of the bottom of the label
	      @param left  location of the left side of the bar
	      @param width  width of the bar (in pixels)
	      @param barHeight  height of the bar in application units
	      @param scale  how many pixels per application unit
	      @param color  the color of the bar
	      @param label  the label at the bottom of the bar
	   */
	   public Bar(int bottom, int left, int width, int barHeight,
	              double scale, Color color, String label) {
		   
		  drawBottom = bottom;
		  drawLeft = left;
		  drawWidth = width;
		  drawBarHeight = barHeight;
		  drawScale = scale;
		  LABEL = label;
		  COLOR =color;
		   
		   
	   }
	   
	   /**
	      Draw the labeled bar. 
	      @param g2  the graphics context
	   */
	   public void draw(Graphics2D g2) {
		   
		   int labelX;                     //x-coordinate of label
		   int labelY;                     //x-coordinate of label
		   int barY;                      //y-coordinate of bar
		   int barH;                      //height of bar
		   int widthOfLabel;
		   
//set the char:
		   g2.setFont(new Font("TimesRoman",Font.PLAIN,16));
		   g2.setColor(Color.BLACK);
		   Font font = g2.getFont();
		   FontRenderContext context = g2.getFontRenderContext();
		   Rectangle2D labelBounds = font.getStringBounds(LABEL, context);
		   
//draw char:
		   widthOfLabel = (int) labelBounds.getWidth();
		   
		   labelX = drawLeft - ((widthOfLabel-drawWidth)/2);
		   labelY = drawBottom;
		   g2.drawString(LABEL,labelX,labelY);

		   
//draw bar:
		   barH = (int)Math.round(drawScale*drawBarHeight);
		   barY = drawBottom -20- barH;
		   g2.setColor(COLOR);
		   Rectangle bar = new Rectangle(drawLeft,barY,drawWidth,barH);
		   g2.draw(bar);
		   g2.fill(bar);
		   
	   }
	   
	}
