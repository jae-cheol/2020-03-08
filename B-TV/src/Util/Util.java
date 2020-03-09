package Util;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class Util {
	private BufferedImage imageBuffer;
	// ¹ÙÅÁÈ­¸é Ä¸ÃÄ
	public BufferedImage capture(Rectangle rect){
		try {
			// imageBuffer = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			imageBuffer = new Robot().createScreenCapture(rect);
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();	
		}
		return imageBuffer;
	}
}
