/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;

public class Play extends JFrame implements ActionListener{  
	Home home = new Home();
	Gameplay gameplay = new Gameplay();
        Howtoplay How = new Howtoplay();
	 Play(){
		this.setSize(700,600);
		this.add(home);
                home.BStart.addActionListener(this);
                home.Bhowtoplay.addActionListener(this);
                How.back.addActionListener(this);
                
	}
        
        @Override
	public void actionPerformed(ActionEvent e) {
            if(e.getSource()== home.BStart){
		this.setLocationRelativeTo(null);
		this.remove(home);
                this.setSize(700,600);
                this.add(gameplay);
                gameplay.requestFocusInWindow();
           
	}
            else if(e.getSource()== home.Bhowtoplay){
                this.setLocationRelativeTo(null);
		this.remove(home);
                this.setSize(700,600);
                this.add(How);
                How.requestFocusInWindow();
            }
            
           else if(e.getSource()== How.back){
                this.setLocationRelativeTo(null);
		this.remove(How);
                this.setSize(700,600);
                this.add(home);
                home.requestFocusInWindow();
            }
            this.validate();
            this.repaint();
        
     
        
        
	
        }
}
