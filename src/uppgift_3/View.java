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
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class View extends JFrame{
     
    JPanel knappPanel = new JPanel();
    JPanel panel = new JPanel();
    JButton blanda = new JButton("Blanda");
    Button sistaKnapp = new Button();
 
    ArrayList<Button> knappar = new ArrayList();
    
    View(){
        add(knappPanel);
        knappPanel.add(blanda);
        blanda.addActionListener(blandare);
        knappPanel.setLayout(new FlowLayout());
        add(panel);
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.setLayout(new GridLayout(4,4,0,0));
        
        skapaKnappar();                         //skapar alla knappar och lägger in de i listan knappar
        Collections.shuffle(knappar);           //Blandar alla knappar förutom sista knappen
        knappar.add(sistaKnapp);
        sistaKnapp.setPreferredSize(new Dimension(100,100));
        
        for(JButton btn : knappar){
            panel.add(btn);
        }
        checkVinst();
           
        this.setLayout(new BorderLayout());
        this.add(knappPanel, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
        
        setVisible(true);
        pack();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
 
    
    ActionListener blandare = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            Collections.shuffle(knappar);
            checkVinst();
            updateButtons();
        }
    };

    //Metoden refeshar och tilldelar de nya positionerna för knapparna
    private void updateButtons(){
        
        panel.removeAll();
        for (JButton btn : knappar){
            panel.add(btn);
        }
        panel.validate();       //Validate uppdaterar panelen
    }


    private void skapaKnappar(){
        for(int j=1; j<16; j++){
            String s = Integer.toString(j);
            Button knapp = new Button(s);
            knapp.position = j-1;
            
            knapp.addActionListener(new ActionListener(){
                 @Override
                public void actionPerformed(ActionEvent e){
                    checkButton(e);
                    checkVinst();
                }  
            });
             if(j==15){

                sistaKnapp.setBorderPainted(false);
                sistaKnapp.setContentAreaFilled(false);             //sista knappen är inte med i listan knappar
                sistaKnapp.position = j;
                sistaKnapp.setSistaKnapp();     //setSistaKnapp ger true 
            }
            knappar.add(knapp);                             //alla tryckbara knappar läggs till
        }
    }   

    private void checkVinst(){
        ArrayList nuvarande = new ArrayList();
        ArrayList svar = new ArrayList();

        int i = 0;
        for (Button btn:knappar){
            nuvarande.add((knappar.indexOf(btn)));      //tar de nuvarande positionerna och sparar de i nuvarande
            svar.add(knappar.get(i).position);          //tar de ursprungliga positionerna och sparar de i svar
            i++;
        }
        if(nuvarande.toString().contentEquals(svar.toString())){                    //Jämför knapparnas nuvarande position med den urpsrungliga
            JOptionPane.showMessageDialog(null,"Grattis! Du har vunnit!");
        }
    }

    private void checkButton(ActionEvent e) {

        int tomRuta = 0;
        int i = 0;
        for (Button button : knappar) {                      //Loopar igenom alla knappar och kollar var sista knappen är,
            if (knappar.get(i).getSistaKnapp()) {            //getSistaKnapp returnerar en boolean
                tomRuta = knappar.indexOf(button);           //Första gången är den alltid på plats 15
            }
            i++;
        }

        JButton button = (JButton) e.getSource();           //Kollar vilken knapp som trycktes
        int bytbar = knappar.indexOf(button);               //Tilldelar positionen av den tryckta knappen
       
        if((bytbar ==4) ||(bytbar ==8)||(bytbar ==12)){
            if ((bytbar + 1 == tomRuta) || (bytbar - 4 == tomRuta) || (bytbar + 4 == tomRuta)) {    //Vänster sida
                Collections.swap(knappar, bytbar, tomRuta);
                updateButtons();
            }
        }
        else if((bytbar ==3) ||(bytbar ==7)||(bytbar ==11)){
            if ((bytbar - 1 == tomRuta) || (bytbar - 4 == tomRuta) || (bytbar + 4 == tomRuta)) {       //Höger sida
                Collections.swap(knappar, bytbar, tomRuta);
                updateButtons();
            }
        }
        else if((bytbar - 1 == tomRuta) || (bytbar + 1 == tomRuta)
                || (bytbar - 4 == tomRuta) || (bytbar + 4 == tomRuta)) {            //Resten
            Collections.swap(knappar, bytbar, tomRuta);
            updateButtons();
        }


    }
    }


            
        


