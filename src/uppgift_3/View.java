/*
 */
package uppgift_3;
/*
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;


public class View extends JFrame {
    
    JPanel knappPanel = new JPanel();
    JButton knapp = new JButton("Blanda");

    JPanel panel = new JPanel();
    JButton knapp1 = new JButton("1");
    JButton knapp2 = new JButton("2");
    JButton knapp3 = new JButton("3");
    JButton knapp4 = new JButton("4");
    JButton knapp5 = new JButton("5");
    
    View(){
        add(knappPanel);
        add(panel);

        panel.setLayout(new GridLayout(2,2,2,2));
        knappPanel.setLayout(new BorderLayout());
        panel.add(knapp1);
        panel.add(knapp2);
        panel.add(knapp3);
        panel.add(knapp4);
        panel.add(knapp5);
        knapp1.setPreferredSize(new Dimension(100,100));
       
        setVisible(true);
        pack();
        setLocation(600,300);

        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
}

