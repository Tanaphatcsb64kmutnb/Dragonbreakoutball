/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject1;



import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Home extends JPanel{
        private  ImageIcon Bg = new ImageIcon(this.getClass().getResource("imageoop/Dragonball1.png"));
        private  ImageIcon GameIcon = new ImageIcon(this.getClass().getResource("imageoop/Dragonbicon.png"));
	private  ImageIcon start = new ImageIcon(this.getClass().getResource("imageoop/Start.jpg"));
        private  ImageIcon howtoplay = new ImageIcon(this.getClass().getResource("imageoop/howtoplay.jpg"));
        public JButton Bhowtoplay = new JButton(howtoplay);
	public JButton BStart = new JButton(start);
    
	Home(){
            setLayout(null);
           
            BStart.setBounds(140,370,165,75);
            add(BStart);
            
            Bhowtoplay.setBounds(360,370,165,75);
            add(Bhowtoplay);
	}
        @Override
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(Bg.getImage(),1,1,700,600,this);
             g.drawImage(GameIcon.getImage(), 80, 70, 500, 300, this);
	}
}