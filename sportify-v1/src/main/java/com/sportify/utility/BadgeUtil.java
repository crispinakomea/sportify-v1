package com.sportify.utility;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Crispin A.
 *
 */
public class BadgeUtil {

	private static final String GENERIC_BADGE = "src/main/resources/img/badge/Generic.png";
	private static final Logger logger = LogManager.getLogger(BadgeUtil.class);

	public static ImageIcon getBadge(String path, double size) {
		BufferedImage bufferedImage = null;
		int scaleX;
		int scaleY;
		try {
			bufferedImage = ImageIO.read(new File(path));
		} catch (IOException e) {
			logger.error(path + " does not exist. (" + e + ")");

			try {
				bufferedImage = ImageIO.read(new File(GENERIC_BADGE));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		scaleX = (int) (bufferedImage.getWidth() * size);
		scaleY = (int) (bufferedImage.getHeight() * size);
		Image image = bufferedImage.getScaledInstance(scaleX, scaleY, Image.SCALE_SMOOTH);
		return new ImageIcon(image);
	}

}
