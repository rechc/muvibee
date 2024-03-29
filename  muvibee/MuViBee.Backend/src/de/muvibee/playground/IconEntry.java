package de.muvibee.playground;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

@SuppressWarnings("serial")
public class IconEntry extends JLabel {

	private final String imagePath;
	private ImageIcon image;

	public IconEntry(String imagePath) {
		this.imagePath = "resources/icons/" + imagePath;
	}

	public ImageIcon getImage() {
		if (image == null) {
			image = resizeIcon(90, 100, imagePath);
		}
		return image;
	}

	private ImageIcon resizeIcon(int width, int height, String path) {
		ImageIcon result = null;
		try {
			BufferedImage src = ImageIO.read(new File(path));
			BufferedImage dest = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			
			AffineTransform trans = AffineTransform.getScaleInstance((double)width/src.getWidth(), (double)height/src.getHeight());
			
			Graphics2D g2d = (Graphics2D) dest.createGraphics();
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			g2d.drawImage(src, trans, null);			
			g2d.dispose();
			
			result = new ImageIcon(dest);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;		
	}
	
//	public ImageIcon resizeIcon(JList list, int width, int height, String path) {
//		ImageIcon result = null;
//		try {
//			BufferedImage src = ImageIO.read(new File(path));			
//			AffineTransform trans = AffineTransform.getScaleInstance(
//					(double)width/src.getWidth(), (double)height/src.getHeight());
//			Graphics2D g = (Graphics2D) list.getGraphics();
//			g.drawRenderedImage(src, trans);
//			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//			GraphicsDevice gd = ge.getDefaultScreenDevice();
//			GraphicsConfiguration cg = gd.getDefaultConfiguration();
//
//			int transparency = src.getColorModel().getTransparency();
//			BufferedImage dest = cg.createCompatibleImage(
//			width, height, transparency);
//			g = dest.createGraphics();
//			g.drawRenderedImage(src, trans);
//			g.dispose();
//
//			result = new ImageIcon(dest);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return result;		
//	}
}
