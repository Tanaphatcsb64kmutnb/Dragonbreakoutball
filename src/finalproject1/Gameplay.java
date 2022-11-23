/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    public boolean play = false;
    private int score = 0;
    private int totalBricks = 21;
    private Timer timer;
    private int delay = 4;
    private int playerX = 310;
    private int ballposX = 310;
    private int ballposY = 500;
    private int ballXdir = -1;
    private int ballYdir = -2;
    private ImageIcon backg = new ImageIcon(this.getClass().getResource("imageoop/Dragonball.jpg"));
    private ImageIcon ball = new ImageIcon(this.getClass().getResource("imageoop/ball.png"));
    private ImageIcon cloud = new ImageIcon(this.getClass().getResource("imageoop/cloud.png"));
    private ImageIcon loss = new ImageIcon(this.getClass().getResource("imageoop/Gameover.png"));
    private ImageIcon won = new ImageIcon(this.getClass().getResource("imageoop/won.png"));
    private ImageIcon uscore = new ImageIcon(this.getClass().getResource("imageoop/Yourscore.png"));
    
    private MapGen map;
    
    
   
    
    public Gameplay(){
       
        map = new MapGen(3, 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
          timer = new Timer(delay, this);
          timer.start();
          
          if(ballposY >578){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
           
                     
            
        }
          
          
    }
    
    public void paint(Graphics g){
      
        g.drawImage(backg.getImage(), 1,1, 692, 592, this);
        map.draw((Graphics2D)g);
        //borders
        g.setColor(Color.white);
        g.fillRect(0, 0, 3,592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691,0,3,592);
        
        //scores
        g.setColor(Color.white);
        g.setFont(new Font("serlf",Font.BOLD,25));
        g.drawString("" + score,500,30);
        
         g.drawImage(uscore.getImage(), 350,-6, 140, 60, this);
        //paddle
        g.drawImage(cloud.getImage(),playerX, 520, 110, 40, this);
        
        
        //ball
        g.drawImage(ball.getImage(),ballposX, ballposY, 25, 25, this);
        
        if(totalBricks <= 0){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
             g.drawImage(won.getImage(), 90,150,480, 300, this);
            
        }
        if(ballposY >578){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
           
            g.drawImage(loss.getImage(), 90,150,480, 300, this);
            
            
        }
        g.dispose();
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(playerX >= 600){
            playerX = 600;
         }else{
                moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(playerX < 10){
                playerX = 10;
            }else{
                moveLeft();
            }
        }
        
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(!play){
                play = true;
                ballposX = 120;
                ballposY = 350;
                ballXdir = -1;
                ballYdir = -2;
                playerX = 310;
                score = 0;
                totalBricks = 21;
                map = new MapGen(3,7);
            }
        }
            if(e.getKeyCode() == KeyEvent.VK_R){
            if(!play){
                play = true;
                ballposX = 120;
                ballposY = 350;
                ballXdir = -1;
                ballYdir = -2;
                playerX = 310;
                score = 0;
                
                for(int i =1 ;i<4;i++){
                totalBricks = 21*i;
                map = new MapGen(3*i,7*i);
                i++;
                }
            }
            }
            
    }
    public void moveRight(){
        play = true;
        playerX+=20;
    }
    public void moveLeft(){
        play = true;
        playerX-=20;
     }

    

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.start();
        if(play){
            if(new Rectangle(ballposX, ballposY,20,20).intersects(new Rectangle(playerX,550,100,8))){
                ballYdir = -ballYdir;
            }
            
            A:for(int i = 0;i <map.map.length;i++){
                for(int j=0 ;j<map.map[0].length;j++){
                    if(map.map[i][j] > 0){
                        int brickX = j*map.brickWidth + 80;
                        int brickY = i * map.brickHeight + 50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;
                        
                        Rectangle rect = new Rectangle(brickX, brickY,brickWidth,brickHeight);
                        Rectangle ballRect = new Rectangle(ballposX,ballposY,20,20);
                        Rectangle brickRect = rect;
                        
                        if(ballRect.intersects(brickRect)){
                        map.setBrickValue(0, i, j);
                        totalBricks --;
                        score += 5;
                        
                        if(ballposX +19 <= brickRect.x || ballposX +1 >= brickRect.x + brickRect.width){
                            ballXdir = -ballXdir;
                        } else{
                            ballYdir = - ballYdir;
                        }
                        break A;
                        }
                        }
                        
                    }
                }
            }
            
            ballposX += ballXdir;
            ballposY += ballYdir;
            if(ballposX <0){
                ballXdir = -ballXdir;
            }
            if(ballposY <0){
                ballYdir = -ballYdir;
            }
            if(ballposX >670){
                ballXdir = -ballXdir;
            }
            repaint();
        }

    void setTitle(String breakout_Ball) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setResizable(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }