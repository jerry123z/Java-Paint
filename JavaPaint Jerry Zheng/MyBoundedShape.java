import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
 
/*Author: Jerry Zheng
 *Last Edited: May 29th 2016
 *Description a bounded shape object class with xy coordinates, filled, color, gradient, stroke, dashed, dashlength variables. This extends MyShape
 */

abstract public class  MyBoundedShape extends MyShape
{
    private boolean filled;
    
    // constructor with input values
    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color1, Color color2, boolean gradient, int stroke, boolean dashed, int dashLength , boolean filled )
    {
        super(x1, y1, x2, y2, color1, color2, gradient, stroke, dashed, dashLength);
        this.filled = filled;//set the fill variable
    } // end MyBoundedShape constructor
    
    // constructor with no values
    public MyBoundedShape( )
    {
         this(0,0,0,0,Color.BLACK,Color.WHITE,false, 1, false, 1, false);
    } // end MyBoundedShape constructor
    
    protected int getUpperLeftX()
    {
        if (getx2() > getx1())
            return getx1();
        else
            return getx2();
    }
    
    //returns the left Y value
    protected int getUpperLeftY()
    {
        if (gety2() > gety1())
            return gety1();
        else
            return gety2();
    }
    
    //returns the height
    protected int getHeight()
    {
        return Math.abs(gety1()-gety2());
    }
    
    //returns the width
    protected int getWidth()
    {
        return Math.abs(getx1()-getx2());
    }
    
    //returns the filled boolean variable
    protected boolean getFilled()
    {
        return filled;
    }
}