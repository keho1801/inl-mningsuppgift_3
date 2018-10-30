/*
 */
package uppgift_3;
/*
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;


public class View extends JFrame {
    
   
    JPanel knappPanel = new JPanel();
    JButton blanda = new JButton("Blanda");
    int count = 0;
    

    JPanel panel = new JPanel();
    
    ArrayList<Button> knappar = new ArrayList();
    ArrayList positioner = new ArrayList();

    
    
    View(){
        createPositions();
        add(knappPanel);
        add(panel);Button 
        sistaKnapp = new Button();
        
        for(int j=1; j<16; j++) {
            String s = Integer.toString(j);
            Button knapp = new Button(s);
            knapp.putClientProperty("position", positioner.get(j-1));
            knapp.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkButton(e);
                    vinst();
                }
                
            });
            if(j==15){
             
             sistaKnapp.setBorderPainted(false);
             sistaKnapp.setContentAreaFilled(false);
             sistaKnapp.putClientProperty("position", positioner.get(j));
             sistaKnapp.setSistaKnapp();
            }
            knappar.add(knapp);
        }
//        Collections.shuffle(knappar);
        knappar.add(sistaKnapp);
        vinst();
        blanda.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    Collections.shuffle(knappar);
                    vinst();
                    updateButtons();
                }
                       
        });
        
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.setLayout(new GridLayout(4,4,0,0));
        knappPanel.setLayout(new FlowLayout());
        this.setLayout(new BorderLayout());
        this.add(knappPanel, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        
        knappar.get(0).setPreferredSize(new Dimension(100,100));
        knappPanel.add(blanda);
  
        
        for(JButton btn : knappar){
            panel.add(btn);
        }

        setVisible(true);
        pack();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
 
    
            //ska flyttas till model
        private void updateButtons() {

            panel.removeAll();

            for (JButton btn : knappar) {
                panel.add(btn);
            }
            
            panel.validate();
        }
        
        private void createPositions(){
            for(int i =0; i<4; i++){
                for(int j=0; j<4; j++){
                    positioner.add(new Point(i,j));
                }
            }
        }
        
        private void vinst(){
            ArrayList nuvarande = new ArrayList();
            
            for(Button btn : knappar){
                nuvarande.add((Point) btn.getClientProperty("position"));
            }

            if(positioner.toString().contentEquals(nuvarande.toString())){
                System.out.println("Du har Vunnit!");
            }
        }
        
            private void checkButton(ActionEvent e) {

            int lidx = 0;
            int i = 0;
            for (Button button : knappar) {
                if (knappar.get(i).getSistaKnapp()) {
                
                    lidx = knappar.indexOf(button);
                }
                i++;
            }

            JButton button = (JButton) e.getSource();
            int bidx = knappar.indexOf(button);
            if((bidx ==4) ||(bidx ==8)||(bidx ==12)){
                if ((bidx + 1 == lidx) || (bidx - 4 == lidx) || (bidx + 4 == lidx)) {
                    Collections.swap(knappar, bidx, lidx);
                    updateButtons();
                }
            }
            else if((bidx ==3) ||(bidx ==7)||(bidx ==11)){
                if ((bidx - 1 == lidx) || (bidx - 4 == lidx) || (bidx + 4 == lidx)) {
                    Collections.swap(knappar, bidx, lidx);
                    updateButtons();
                }
            }
            else if((bidx - 1 == lidx) || (bidx + 1 == lidx)
                    || (bidx - 4 == lidx) || (bidx + 4 == lidx)) {
                Collections.swap(knappar, bidx, lidx);
                updateButtons();
            }


    }
}


            
        


