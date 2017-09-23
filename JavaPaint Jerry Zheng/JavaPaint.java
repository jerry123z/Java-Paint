import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
/*Author: Jerry Zheng
 *Last Edited: Apr 20th 2016
 *Description a program that demonstrates the DrawFrame and DrawPanel classes.
 */
public class JavaPaint
{
    public static void main( String args[] )
    {
        JLabel label = new JLabel("( 0 , 0 )");
        DrawPanel panel = new DrawPanel(label);
        JFrame frame = new DrawFrame(panel);

         
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        frame.setSize( 600, 500 );
        frame.setVisible( true );
        
    } // end main
} // end class TestDraw