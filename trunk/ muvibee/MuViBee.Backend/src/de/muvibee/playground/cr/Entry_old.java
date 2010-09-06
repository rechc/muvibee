package de.muvibee.playground.cr;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class Entry_old extends JPanel{
	
	String imagePath;
	String test = "test";
	
	public Entry_old(String cover, String author, String title) {
		// -----------------
		// |       | Author |
		// | Cover |________|
		// |       | Titel  |
		// |_______|________|
		
		setLayout(new GridLayout(1,2, 0,0));
		setPreferredSize(new Dimension(10, 80));
		
		imagePath = "resources/icons/" + cover;
		JLabel label = new JLabel();
		
		label.setIcon(resizeIcon(70, 70, imagePath));
		add(label);
		
		JPanel author_title = new JPanel(new GridLayout(2,1,0,0));
		JLabel authorLbl = new JLabel(author);
		JLabel titleLbl = new JLabel(title);
		author_title.add(authorLbl);
		author_title.add(titleLbl);		
		add(author_title);
	}
	
	private ImageIcon resizeIcon(int width, int height, String path) {
		ImageIcon result = null;
		try {
			BufferedImage src = ImageIO.read(new File(path));
			AffineTransform trans = AffineTransform.getScaleInstance(
					(double)width/src.getWidth(), (double)height/src.getHeight());
			Graphics2D g = (Graphics2D) this.getGraphics();
//			g.drawRenderedImage(src, trans);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gd = ge.getDefaultScreenDevice();
			GraphicsConfiguration cg = gd.getDefaultConfiguration();

			int transparency = src.getColorModel().getTransparency();
			BufferedImage dest = cg.createCompatibleImage(
			width, height, transparency);
			g = dest.createGraphics();
			g.drawRenderedImage(src, trans);
			g.dispose();

			result = new ImageIcon(dest);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;		
	}
	
	public ImageIcon getImage() {
			return resizeIcon(70, 70, imagePath);
	}
	
	public Entry_old getEntry(){
		return this;
	}
	
	public String getTitle() {
		return test;
	}

}
