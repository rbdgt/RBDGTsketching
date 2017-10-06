package be.rbdgt.util;

import java.awt.Color;

import processing.core.PImage;

public class ColorMethods {
	private static int blackThreshold = 50;

	/** Max value for red (or hue) set by colorMode */
	private static float colorModeX = 255; // = 255;

	/** Max value for green (or saturation) set by colorMode */
	private static float colorModeY = 255; // = 255;

	/** Max value for blue (or value) set by colorMode */
	private static float colorModeZ = 255; // = 255;

	private static int cacheHsbKey; // Keeps the last converted color.
	private static float[] cacheHsbValue = new float[3];

	private static float hue(int rgb) {
		if (rgb != cacheHsbKey) { // If last converted color is the same then
									// conversion doesn't need to be done again
			Color.RGBtoHSB((rgb >> 16) & 0xff, (rgb >> 8) & 0xff, rgb & 0xff, cacheHsbValue);
			cacheHsbKey = rgb;
		}
		return cacheHsbValue[0] * colorModeX;
	}

	private static float saturation(int rgb) {
		if (rgb != cacheHsbKey) {
			Color.RGBtoHSB((rgb >> 16) & 0xff, (rgb >> 8) & 0xff, rgb & 0xff, cacheHsbValue);
			cacheHsbKey = rgb;
		}
		return cacheHsbValue[1] * colorModeY;
	}

	private static final float brightness(int rgb) {
		if (rgb != cacheHsbKey) {
			Color.RGBtoHSB((rgb >> 16) & 0xff, (rgb >> 8) & 0xff, rgb & 0xff, cacheHsbValue);
			cacheHsbKey = rgb;
		}
		return cacheHsbValue[2] * colorModeZ;
	}
	
	public static int getAverageColor(PImage img) {
		img.loadPixels();
		int r = 0, g = 0, b = 0;
		for (int i = 0; i < img.pixels.length; i++) {
			int c = img.pixels[i];
			r += c >> 16 & 0xFF;
			g += c >> 8 & 0xFF;
			b += c & 0xFF;
		}
		r /= img.pixels.length;
		g /= img.pixels.length;
		b /= img.pixels.length;
		return new Color(r, g, b).getRGB();
	}

	public static boolean detColor(int c, int detColor) {
		// color detC = stabilo.s88(detColor);

		float bri = brightness(c);
		float hue = hue(c) / 255 * 360; // HUE rescaling from 255 to 360\u00b0
		float sat = saturation(c);

		if ((hue > 165 && hue < 185) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.ICEGREEN) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.NIGHTBLUE) {
			return true;
		}
		if ((hue > 5 && hue < 30) && (sat > 29 && sat < 49) && (bri > 85 && bri < 101) && detColor == SC.APRICOT) {
			return true;
		}
		if ((hue > 190 && hue < 210) && (sat > 10 && sat < 101) && (bri > 30 && bri < 90)
				&& detColor == SC.ULTRAMARINE) {
			return true;
		}
		if ((hue > 59 && hue < 79) && (sat > 10 && sat < 101) && (bri > 63 && bri < 80) && detColor == SC.APPLEGREEN) {
			return true;
		}
		if ((hue > 135 && hue < 160) && (sat > 10 && sat < 101) && (bri > 45 && bri < 65) && detColor == SC.GREEN) {
			return true;
		}

		if ((hue > 335 || hue < 20) && (sat > 10 && sat < 101) && (bri > 40 && bri < 95) && detColor == SC.RED) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.DARKBLUE) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.LEAFGREEN) {
			return true;
		}
		if ((hue > 40 && hue < 55) && (sat > 10 && sat < 101) && (bri > 30 && bri < 101) && detColor == SC.YELLOW) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.BROWN) {
			return true;
		}
		if (bri < blackThreshold && detColor == SC.BLACK) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.CRIMSONRED) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.TURQUOISE) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.PINEGREEN) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.ORANGE) {
			return true;
		}
		if ((hue > 250 && hue < 290) && (sat > 10 && sat < 101) && (bri > 30 && bri < 95) && detColor == SC.VIOLET) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.ROSE) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.AZUREBLUE) {
			return true;
		}
		if ((hue > 290 && hue < 340) && (sat > 10 && sat < 101) && (bri > 30 && bri < 95) && detColor == SC.LILAC) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.LIGHTLILAC) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.OLIVEGREEN) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.DARKOCHRE) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.LIGHTGREY) {
			return true;
		}
		if ((hue > 220 && hue < 240) && (sat > 10 && sat < 101) && (bri > 30 && bri < 40) && detColor == SC.DARKGREY) {
			return true;
		}
		return false;
	}

	public static boolean determineColor(int c, int detColor) {
		float brightness = brightness(c);
		float hue = hue(c) / 255 * 360; // HUE rescaling from 255 to 360\u00b0
		float saturation = saturation(c);
		// BLACK
		if (brightness < 80 && detColor == SC.BLACK) {
			return true;
		}
		// RED
		if ((hue > 320 || hue < 15) && saturation > 120 && detColor == SC.RED) {
			return true;
		}
		// BLUE
		if (hue > 140 && hue < 281 && saturation > 50 && detColor == SC.NIGHTBLUE) {
			return true;
		}
		// GREEN
		if (hue > 60 && hue < 200 && saturation > 10 && detColor == SC.GREEN) {
			return true;
		}
		// YELLOW
		if (hue > 40 && hue < 81 && saturation > 10 && detColor == SC.YELLOW) {
			return true;
		}
		// PINK
		if ((hue > 280 || hue < 10) && saturation > 10 && saturation < 150 && detColor == SC.ROSE) {
			return true;
		}
		// PURPLE
		if (hue > 240 && hue < 281 && brightness < 100 && saturation > 50 && detColor == SC.VIOLET) {
			return true;
		}
		// BROWN
		if (hue > 14 && hue < 40 && saturation > 50 && detColor == SC.BROWN) {
			return true;
		}
		// int LIGHTGREEN = 9;
		// int LIGHTBLUE = 10;
		// GREY
		if (brightness > 80 && saturation < 50 && detColor == SC.LIGHTGREY) {
			return true;
		}
		// ORANGE
		if (hue > 14 && hue < 40 && saturation > 50 && detColor == SC.ORANGE) {
			return true;
		}

		// draw = true;

		return false;
	}
}
