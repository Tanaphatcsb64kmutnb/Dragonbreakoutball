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

/**
 *
 * @author Acer
 */
public class Howtoplay extends JPanel{
     private  ImageIcon Bg2 = new ImageIcon(this.getClass().getResource("imageoop/Dragonball2.png"));
     private  ImageIcon Left = new ImageIcon(this.getClass().getResource("imageoop/LB.jpg"));
        private  ImageIcon right = new ImageIcon(this.getClass().getResource("imageoop/RB.jpg"));
        private ImageIcon R =new ImageIcon(this.getClass().getResource("imageoop/ra.jpg"));
        private ImageIcon enterr =new ImageIcon(this.getClass().getResource("imageoop/Enter.jpg"));
        private ImageIcon moveleft =new ImageIcon(this.getClass().getResource("imageoop/moveleft.png"));
        private ImageIcon moveright =new ImageIcon(this.getClass().getResource("imageoop/moveright.png"));
        private ImageIcon mover =new ImageIcon(this.getClass().getResource("imageoop/mover.png"));
        private ImageIcon movere =new ImageIcon(this.getClass().getResource("imageoop/moverestart.png"));
        private ImageIcon Howt =new ImageIcon(this.getClass().getResource("imageoop/howtoplayicon.png"));
        private ImageIcon backb =new ImageIcon(this.getClass().getResource("imageoop/back.jpg"));
        public JButton Bleft = new JButton(Left);
	public JButton Bright = new JButton(right);
        public JButton BR = new JButton(R);
        public JButton Benter = new JButton(enterr);
        public JButton back = new JButton(backb);
        Howtoplay(){
            setLayout(null);
           
            Bleft.setBounds(80,130,80,65);
            add(Bleft);
            
            Bright.setBounds(80,230,80,65);
            add(Bright);
            
            BR.setBounds(80,330,80,65);
            add(BR);
            
            Benter.setBounds(80,430,80,60);
            add(Benter);
            
            back.setBounds(280,480,170,75);
            add(back);
	}
      @Override
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(Bg2.getImage(),1,1,700,600,this);
            g.drawImage(moveleft.getImage(), 180, 110, 300, 100, this);
            g.drawImage(moveright.getImage(), 180, 210, 300, 100, this);
            g.drawImage(mover.getImage(), 140, 310, 400, 90, this);
             g.drawImage(movere.getImage(), 140, 410, 400, 90, this);
             g.drawImage(Howt.getImage(), 80, 20, 550, 120, this);
	}
}
