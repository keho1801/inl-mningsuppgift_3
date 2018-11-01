/*
 */

package uppgift_3;

import javax.swing.JButton;

/**
 *
 * @author kenny
 */
public class Button extends JButton {
    private boolean sistaKnapp = false;
    protected int position;
   
    Button(String s){
        this.setText(s);
    }
    Button(){
        
    }
    
   public void setSistaKnapp(){
       sistaKnapp = true;
   } 
    
    public boolean getSistaKnapp(){
        return sistaKnapp;
    }
}
