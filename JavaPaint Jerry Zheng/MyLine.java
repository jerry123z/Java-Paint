import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.GradientPaint; 

/*Author: Jerry Zheng
 *Last Edited: May 29th 2016
 *Description a line shape object class with xy coordinates, color, gradient, stroke, dashed, dashlength variables. This extends MyShape
 */

public class MyLine extends MyShape
{
     
    // constructor with input values
    public MyLine(int x1, int y1, int x2, int y2, Color color1, Color color2, boolean gradient, int stroke, boolean dashed, int dashLength)
    {
        super(x1, y1, x2, y2, color1, color2, gradient, stroke, dashed, dashLength);
    } // end MyLine constructor
    
    // constructor with no values
    public MyLine()
    {
        super();
    } // end MyLine constructor
     
    // Actually draws the line
    public void draw( Graphics2D g2d )
    {
        if (getDashed() == true)
                g2d.setStroke( new BasicStroke( getStroke(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, getDashLength(), new float[]{getDashLength()}, 0 )); 
            else
                g2d.setStroke( new BasicStroke( getStroke() ));
            
        if( ifGradient() == false)
            g2d.setPaint( getColor1() );
        else
            g2d.setPaint( new GradientPaint( getx1(), gety1(),  getColor1() ,getx2(), gety2(), getColor2(), true));
        
        g2d.drawLine( getx1(), gety1(), getx2(), gety2() );
    } // end method draw
} // end class MyLine