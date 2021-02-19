import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Visualizer {
	BufferedImage image;
	int xAxis;
	int yAxis;
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	
	
	Visualizer(int x, int y){
		
		this.image = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
		this.xAxis = x;
		this.yAxis = y;
		
		
		this.panel.add(new JLabel(new ImageIcon(image)));
		
		this.frame.add(panel);
		this.frame.setVisible(true);
		this.frame.pack();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	void draw( Board board) {
		
		
		for(int i=0; i<xAxis; i++) {
			for(int j=0; j<yAxis; j++) {
				if(board.fields[i][j].value == 1)
					image.setRGB(i, j, new Color(0,0,0).getRGB());
				else
					image.setRGB(i, j, new Color(255,255,255).getRGB());
			}
		}
		
		
		panel.add(new JLabel(new ImageIcon(image)));
		
		frame.add(panel);
		frame.revalidate();
		frame.repaint();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
