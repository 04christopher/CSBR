import java.awt.*;
import javax.swing.*;
  
public class DrawingPanel extends JPanel{  
   

    public DrawingPanel()
    {
        super();        
        this.setOpaque(true);      
        
    }
    
    private int i = 0;

    public void paint(Graphics g1) { 
        System.out.println("painting!");                                 
        
        this.setBackground(Color.black);   
        this.paintComponent(g1);

        Graphics2D g2d = (Graphics2D) g1;
    
        g2d.setColor(Color.RED);        
        g2d.drawString("Hello", i ,40);    
        i++;         

        g2d.setColor(new Color(150, 19, 31));
        g2d.drawLine(40, 70, 100, 100);        
        
        g2d.setColor(Color.yellow);
        g2d.fillRect(130, 30,100, 80);  

        g2d.setColor(Color.ORANGE);
        g2d.drawOval(30,130,50, 60);          
        
        g2d.setColor(new Color((int)(Math.random() * 0x1000000)));
        g2d.fillOval(130,130,50, 60);  

        g2d.setColor(Color.MAGENTA);
        g2d.drawArc(30, 200, 40,50,90,60);  

        g2d.setColor(Color.BLUE);
        g2d.fillArc(30, 130, 40,50,180,40);   
          
    }  

        public static void main(String[] args) throws Exception
        {  
        DrawingPanel d=new DrawingPanel();          
        JFrame f=new JFrame();  
        f.add(d);  
        f.setSize(400,400);         
        f.setVisible(true);      
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        
        for(int k = 0; k < 2000; k++)
        {            
            Thread.sleep(10);
            d.repaint();
        }
        
    }    
}  