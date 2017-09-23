import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/*Author: Jerry Zheng
 *Last Edited: May 29th 2016
 *Description an object class with only buffered image variable and a draw method. This extends MyShape
 */
public class MyImage extends MyShape
{
    BufferedImage image;
    //constructor sets and image
    public MyImage(BufferedImage image)
    {
        this.image = image;
    }
    
    // Actually draws the image
    public void draw( Graphics2D g2d )
    {
        g2d.drawImage( image, 0, 0,null);
    } // end method draw
}