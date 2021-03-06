import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.File;

/*Author: Jerry Zheng
 *Last Edited: May 29th 2016
 *Description an object that opens Preferences.txt and will hold instance variables of the preferences
 * if it cannot be read defaults will be used
 */ 

class FileInput {
    int defaultShape = 0;
    boolean fillBox = false;
    int color1Red = 0;
    int color1Green = 0;
    int color1Blue = 0;
    int color2Red = 255;
    int color2Green = 255;
    int color2Blue = 255;
    boolean gradientBox = false;
    int strokeField = 1;
    boolean dashBox = false;
    int dashField = 1;
    public FileInput() {
 
        // Try to open, read, and close the file.
        try {
            Scanner fileInput = new Scanner( new File("Preferences.txt") );
            
            defaultShape = Integer.parseInt(fileInput.next());
            
            fillBox = Boolean.parseBoolean(fileInput.next());
            
            color1Red = Integer.parseInt(fileInput.next());
            color1Green = Integer.parseInt(fileInput.next());
            color1Blue = Integer.parseInt(fileInput.next());
            
            color2Red = Integer.parseInt(fileInput.next());
            color2Green = Integer.parseInt(fileInput.next());
            color2Blue = Integer.parseInt(fileInput.next());
            
            gradientBox = Boolean.parseBoolean(fileInput.next());
            strokeField =  Integer.parseInt(fileInput.next());
            dashBox = Boolean.parseBoolean(fileInput.next());
            dashField =  Integer.parseInt(fileInput.next());
            
            fileInput.close();
        }
        catch ( IOException ioException ) {
        }
        catch ( java.lang.NumberFormatException e)
        {
        }
    } // end FileInput
    
    public int getDefaultShape(){
        return defaultShape;
    }
    
    public boolean getFillBox(){
        return fillBox;
    }
    
    public int getColor1Red(){
        return color1Red;
    }
    public int getColor1Green(){
        return color1Green;
    }
    public int getColor1Blue(){
        return color1Blue;
    }
    
    public int getColor2Red(){
        return color2Red;
    }
    public int getColor2Green(){
        return color2Green;
    }
    public int getColor2Blue(){
        return color2Blue;
    }
    public boolean getGradientBox(){
        return gradientBox;
    }
    public int getStrokeField(){
        return strokeField;
    }
    public boolean getDashBox(){
        return dashBox;
    }
    public int getDashField(){
        return dashField;
    }
}