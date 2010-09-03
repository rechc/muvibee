package de.muvibee.playground;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

public class IconList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListView lv = new ListView();
		lv.pack();
		IconList.centerWindow(lv);
		lv.setVisible(true);
		
		TreeView tv = new TreeView();
		tv.pack();
		IconList.centerWindow(tv);
		tv.setLocation(400, 180);
		tv.setVisible(true);
	}

	// Fenster aud Bildschirmmitte zentrieren
	public static final void centerWindow(Window win) {
	    Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
	    Dimension winDim = win.getSize();
	    // Vorsicht: getSize() liefert erst einen vernueftigen Wert, nachdem pack(), setSize(), setVisible(), ...
	    // auf dem Window aufgerufen wurden!

	    // wenn das Fenster groesser als der Desktop ist, Fenster auf Desktopgroesse verkleinern
	    if (screenDim.width < winDim.width) {
	        win.setSize(screenDim.width, winDim.height);
	    }

	    if (screenDim.height < winDim.height) {
	        win.setSize(winDim.width, screenDim.height);
	    }

	    // Fenster zentrieren
	    int x = (screenDim.width - winDim.width) / 2;
	    int y = (screenDim.height - winDim.height) / 2;
	    win.setLocation(x, y);
	}

	
}

