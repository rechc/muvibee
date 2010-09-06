package de.muvibee.playground.cr;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JList;

public class Entry_new {
	
	private String cover;
//	private ImageIcon icon;
	private String author;
	private String title;
	
	public Entry_new(String cover, String author, String title) {
		this.cover = "resources/icons/" + cover;
		this.author = author;
		this.title = title;
	}

	private ImageIcon getImage() {
		return resizeIcon(70, 70, cover);
	}
	
	public ImageIcon resizeIcon(int width, int height, String path) {
		ImageIcon result = null;
		try {
			BufferedImage src = ImageIO.read(new File(path));			
			AffineTransform trans = AffineTransform.getScaleInstance(
					(double)width/src.getWidth(), (double)height/src.getHeight());
			Graphics2D g = (Graphics2D) src.getGraphics();
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
	
	@Override
	public String toString() {
		return author + "\n " + title;
	}
}
