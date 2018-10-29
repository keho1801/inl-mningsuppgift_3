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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;


public class View extends JFrame {
    
   
    JPanel knappPanel = new JPanel();
    JButton knapp = new JButton("Blanda");
    int count = 0;
    

    JPanel panel = new JPanel();
    
    ArrayList<Button> knappar = new ArrayList();
    

    
    
    View(){
        add(knappPanel);
        add(panel);
        
        for(int j=1; j<16; j++) {
            String s = Integer.toString(j);
            Button knapp = new Button(s);
            knappar.add(knapp);
        }
        
        knapp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                   knapp.setText("blanda");
                    Collections.shuffle(knappar);
                    for(int i = 0; i < 15; i ++){
                        Button button = knappar.get(i);
                        panel.add(button);
                        count = 1;
                        panel.repaint();
                    }
                }
                       
        });
        
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.setLayout(new GridLayout(4,4,0,0));
        knappPanel.setLayout(new FlowLayout());
        this.setLayout(new BorderLayout());
        this.add(knappPanel, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        
        knappar.get(0).setPreferredSize(new Dimension(100,100));
        knappPanel.add(knapp);
  
        Collections.shuffle(knappar);
        
        for(int i = 0; i < 15; i ++){
            Button button = knappar.get(i);
            panel.add(button);
        }
        
        
       
        setVisible(true);
        pack();
        setLocation(600,300);

        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
 
}
            
        


