import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;

import java.io.PrintWriter;
import java.io.IOException;

/*Author: Jerry Zheng
 *Last Edited: May 29th 2016
 *Description a J frame with widgets that allows the user to edit and save the preferences.txt file
 */

public class PrefFrame extends JFrame
{
    private JLabel nameLabel;
    private JComboBox shapeTypeBox;
    private JLabel shapeTypeLabel;
    private final String shapes[] = {"Line", "Rectangle", "Circle", "Rounded Rectangle", "Pen"};
    private JCheckBox fillBox;
    private JButton color1Button;
    private JButton color2Button;
    private JCheckBox gradientBox;
    private JLabel strokeLabel;
    private JTextField strokeField;
    private JCheckBox dashBox;
    private JLabel dashLabel;
    private JTextField dashField;
    private JButton saveButton;
    
    @SuppressWarnings("unchecked")
    public PrefFrame()
    {
        super( "Preferences" );
        //Load preferences
        FileInput prefValues = new FileInput();

        setLayout( new GridBagLayout()); // set Gridbag layout
        
        GridBagConstraints constraints = new GridBagConstraints(); // create gridbag Constraints 
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        //add widgets
        nameLabel = new JLabel("Edit Preferences");
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        add(nameLabel, constraints);
        
        shapeTypeLabel = new JLabel("Default Shape");
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        add(shapeTypeLabel, constraints);
        
        shapeTypeBox = new JComboBox( shapes ); 
        shapeTypeBox.setMaximumRowCount( 5 );
        constraints.gridx = 1;
        add(shapeTypeBox, constraints);
        shapeTypeBox.setSelectedIndex(prefValues.getDefaultShape());
        
        fillBox = new JCheckBox("Fill");
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridy = 2;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        add(fillBox, constraints);
        if (prefValues.getFillBox())
            fillBox.doClick();
        
        ColorChooserButton color1Button = new ColorChooserButton(new Color(prefValues.getColor1Red(),prefValues.getColor1Green(),prefValues.getColor1Blue()));
        color1Button.addColorChangedListener(new ColorChooserButton.ColorChangedListener() {
            @Override
            public void colorChanged(Color newColor) {
            }
        });
        constraints.gridy = 3;
        add(color1Button, constraints);
        
        ColorChooserButton color2Button = new ColorChooserButton(new Color(prefValues.getColor2Red(),prefValues.getColor2Green(),prefValues.getColor2Blue()));
        color2Button.addColorChangedListener(new ColorChooserButton.ColorChangedListener() {
            @Override
            public void colorChanged(Color newColor) {
            }
        });
        constraints.gridy = 4;
        add(color2Button, constraints);
        
        gradientBox = new JCheckBox("Gradient");
        constraints.gridy = 5;
        add(gradientBox, constraints);
        if (prefValues.getGradientBox())
            gradientBox.doClick();
        
        strokeLabel = new JLabel("Stroke Length:");
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        constraints.anchor=GridBagConstraints.LINE_END;
        add(strokeLabel, constraints);
        
        strokeField = new JTextField(""+prefValues.getStrokeField());
        constraints.gridx = 1;
        constraints.ipadx = 50;
        constraints.anchor=GridBagConstraints.LINE_START;
        add(strokeField,constraints);
        
        dashBox = new JCheckBox("Dashed");
        constraints.gridy = 7;
        constraints.gridx = 0;
        constraints.ipadx = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        add(dashBox, constraints);
        if (prefValues.getDashBox())
          dashBox.doClick();
        
        dashLabel = new JLabel("Dash Length:");
        constraints.gridy = 8;
        constraints.gridwidth = 1;
        constraints.anchor=GridBagConstraints.LINE_END;
        add(dashLabel, constraints);
        
        dashField = new JTextField(""+prefValues.getDashField());
        constraints.gridx = 1;
        constraints.anchor=GridBagConstraints.LINE_START;
        add(dashField,constraints);
       
        saveButton = new JButton("Save");
        constraints.gridy = 9;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        add(saveButton,constraints);
        
        //action listener for the save button saves the values in the other widgets into preferences.txt
        saveButton.addActionListener(           
         new ActionListener()
         {   
            public void actionPerformed( ActionEvent event )
            {
                try {
                    PrintWriter fileOutput = new PrintWriter( "Preferences.txt" );
                    
                    fileOutput.printf(""+shapeTypeBox.getSelectedIndex()+" ");
                    fileOutput.printf(fillBox.isSelected() ? "true" + " " : "false" +" ");
                    fileOutput.printf(""+color1Button.getSelectedColor().getRed()+" "+color1Button.getSelectedColor().getGreen()+" "+color1Button.getSelectedColor().getBlue()+" ");
                    fileOutput.printf(""+color2Button.getSelectedColor().getRed()+" "+color2Button.getSelectedColor().getGreen()+" "+color2Button.getSelectedColor().getBlue()+" ");
                    fileOutput.printf(gradientBox.isSelected() ? "true" + " " : "false" +" ");
                    fileOutput.printf(strokeField.getText()+" ");
                    fileOutput.printf(dashBox.isSelected() ? "true" + " " : "false" +" ");
                    fileOutput.printf(dashField.getText()+" ");
                    fileOutput.close();
                    dispose();
                }
                catch ( IOException ioException ) {
                    System.out.printf( "Error with Preferences.txt: %s\n", ioException);
                }
            } 
         } 
      );

    }
}