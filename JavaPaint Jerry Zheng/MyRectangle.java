import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.BasicStroke;
import java.awt.GradientPaint;
/*Author: Jerry Zheng
 *Last Edited: May 29th 2016
 *Description a rectangle shape object class with xy coordinates, filled, color, gradient, stroke, dashed, dashlength variables.  This extends MyBoundedShape
 */

public class MyRectangle extends MyBoundedShape
{
    
     
    // constructor with input values
    public MyRectangle(int x1, int y1, int x2, int y2, Color color1, Color color2, boolean gradient, int stroke, boolean dashed, int dashLength , boolean filled)
    {
        super(x1, y1, x2, y2, color1, color2, gradient, stroke, dashed, dashLength, filled);
    } // end MyRectangle constructor
    
    // constructor with no values
    public MyRectangle( )
    {
         super();
    } // end MyRectangle constructor
     
    // Actually draws the line
    public void draw( Graphics2D g2d )
    {
        if( ifGradient() == false)
            g2d.setPaint( getColor1() );
        else
            g2d.setPaint( new GradientPaint( getx1(), gety1(),  getColor1() ,getx2(), gety2(), getColor2(), true));
        if (getDashed() == true)
                g2d.setStroke( new BasicStroke( getStroke(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, getDashLength(), new float[]{getDashLength()}, 0 )); 
            else
                g2d.setStroke( new BasicStroke( getStroke() ));
        if (getFilled()== true){
            g2d.fill( new Rectangle2D.Double(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight()));
        }
        else{
            g2d.draw( new Rectangle2D.Double(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() ));
        }
    } // end method draw
    
} // end class MyRectangle