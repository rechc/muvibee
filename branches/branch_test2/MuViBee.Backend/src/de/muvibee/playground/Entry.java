package de.muvibee.playground;

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

public class Entry {

	private final String title;
	private final String imagePath;
	private ImageIcon image;

	public Entry(String name, String imagePath) {
		this.title = name;
		this.imagePath = "resources/icons/" + imagePath;
	}

	public String getTitle() {
		return title;
	}

	public ImageIcon getImage(JList list) {
		if (image == null) {
			image = resizeIcon(list, 70, 70, imagePath);
//			image = new ImageIcon(imagePath);
			
		}
		return image;
	}

	public ImageIcon resizeIcon(JList list, int width, int height, String path) {
		ImageIcon result = null;
		try {
			BufferedImage src = ImageIO.read(new File(path));			
			AffineTransform trans = AffineTransform.getScaleInstance(
					(double)width/src.getWidth(), (double)height/src.getHeight());
			Graphics2D g = (Graphics2D) list.getGraphics();
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
	
	public String toString() {
		return title;
	}
}