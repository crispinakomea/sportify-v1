package com.sportify.utility;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BadgeUtil {

	private static final String GENERIC_BADGE = "src/main/resources/img/badge/Generic.png";
	private static final Logger logger = LogManager.getLogger(BadgeUtil.class);

	public static ImageIcon getBadge(String path, int size) {
		Image image = null;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			logger.info(StringUtils.capitalize(path) + " does not exist. (" + e + ")");

			try {
				image = ImageIO.read(new File(GENERIC_BADGE));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		image = image.getScaledInstance(size, size, Image.SCALE_SMOOTH);
		return new ImageIcon(image);
	}

}
