/**
 * Stabilo Colors
 * A Processing library returning all available Stabilo 68/88 colors.
 * http://www.rbdgt.be
 *
 * Copyright 2015 Robin De Groote
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      Robin De Groote
 * @modified    15/01/2015
 * @version     1.4 (1.4.0)
 */

package be.rbdgt.util;

import java.util.Arrays;
import processing.core.*;

public class Stabilo {

	PApplet parent;

	private int[] s68 = { 11, 13, 16, 17, 19, 22, 24, 26, 29, 30, 31, 32, 33, 36, 38, 40, 41, 43, 44, 45, 46, 48, 50, 51, 53, 54, 55, 56, 57, 58, 59, 63, 65, 75, 88, 89, 94, 95, 96, 97, 98 };
	private int[] s88 = { 13, 22, 26, 32, 33, 36, 40, 41, 43, 44, 45, 46, 50, 51, 53, 54, 55, 56, 57, 58, 59, 63, 89, 94, 96 };
	public final static String VERSION = "1.4.0";

	public Stabilo(PApplet theParent) {
		parent = theParent;
		welcome();
	}

	private void welcome() {
		System.out.println("Stabilo Colors 1.0.0 by Robin De Groote");
	}

	// Returns opaque color from color code for Stabilo 68
	public int s68(int colorCode) {
		if (contains(s68, colorCode)) {
			return getColor(colorCode);
		} else {
			return badcolor();
		}
	}

	// Returns opaque color from color name for Stabilo 68
	public int s68(String colorName) {
		int colorCode = getColorCode(colorName);
		if (contains(s68, colorCode)) {
			return getColor(colorCode);
		} else {
			return badcolor();
		}
	}

	// Returns color from color code for Stabilo 68 with certain transparency
	public int s68(int colorCode, int alpha) {
		if (contains(s68, colorCode)) {
			return adjustAlpha(getColor(colorCode), alpha);
		} else {
			return badcolor();
		}
	}

	// Returns color from color name for Stabilo 68 with certain transparency
	public int s68(String colorName, int alpha) {
		int colorCode = getColorCode(colorName);
		if (contains(s68, colorCode)) {
			return adjustAlpha(getColor(colorCode), alpha);
		} else {
			return badcolor();
		}
	}

	// Returns opaque color from color code for Stabilo 88
	public int s88(int colorCode) {
		if (contains(s88, colorCode)) {
			return getColor(colorCode);
		} else {
			return badcolor();
		}
	}

	// Returns opaque color from color name for Stabilo 68
	public int s88(String colorName) {
		int colorCode = getColorCode(colorName);
		if (contains(s88, colorCode)) {
			return getColor(colorCode);
		} else {
			return badcolor();
		}
	}

	// Returns color from color code for Stabilo 88 with certain transparency
	public int s88(int colorCode, int alpha) {
		if (contains(s88, colorCode)) {
			return adjustAlpha(getColor(colorCode), alpha);
		} else {
			return badcolor();
		}
	}

	// Returns color from color name for Stabilo 88 with certain transparency
	public int s88(String colorName, int alpha) {
		int colorCode = getColorCode(colorName);
		if (contains(s88, colorCode)) {
			return adjustAlpha(getColor(colorCode), alpha);
		} else {
			return badcolor();
		}
	}

	// Returns color name as String from color code
	public String getColorName(int colorCode) {
		switch (colorCode) {
		case 11:
			return "ice_blue";
		case 13:
			return "ice_green";
		case 16:
			return "light_emerald";
		case 17:
			return "heliotrope";
		case 19:
			return "purple";
		case 22:
			return "night_blue";
		case 24:
			return "lemon_yellow";
		case 26:
			return "apricot";
		case 29:
			return "pink";
		case 30:
			return "pale_vermillion";
		case 31:
			return "light_blue";
		case 32:
			return "ultramarine";
		case 33:
			return "apple_green";
		case 36:
			return "green";
		case 38:
			return "sanguine";
		case 40:
			return "red";
		case 41:
			return "dark_blue";
		case 43:
			return "leaf_green";
		case 44:
			return "yellow";
		case 45:
			return "brown";
		case 46:
			return "black";
		case 48:
			return "carmine";
		case 50:
			return "crimson_red";
		case 51:
			return "turquoise";
		case 53:
			return "pine_green";
		case 54:
			return "orange";
		case 55:
			return "violet";
		case 56:
			return "rose";
		case 57:
			return "azure_blue";
		case 58:
			return "lilac";
		case 59:
			return "light_lilac";
		case 63:
			return "olive_green";
		case 65:
			return "umber";
		case 75:
			return "sienna";
		case 88:
			return "light_ochre";
		case 89:
			return "dark_ochre";
		case 94:
			return "light_grey";
		case 95:
			return "medium_grey";
		case 96:
			return "dark_grey";
		case 97:
			return "deep_grey";
		case 98:
			return "paynes_grey";
		default:
			return "NO_COLOR";
		}
	}

	// Returns color code as int from color name
	public int getColorCode(String colorName) {
		switch (colorName) {
		case "ice_blue":
			return 11;
		case "ice_green":
			return 13;
		case "light_emerald":
			return 16;
		case "heliotrope":
			return 17;
		case "purple":
			return 19;
		case "night_blue":
			return 22;
		case "lemon_yellow":
			return 24;
		case "apricot":
			return 26;
		case "pink":
			return 29;
		case "pale_vermillion":
			return 30;
		case "light_blue":
			return 31;
		case "ultramarine":
			return 32;
		case "apple_green":
			return 33;
		case "green":
			return 36;
		case "sanguine":
			return 38;
		case "red":
			return 40;
		case "dark_blue":
			return 41;
		case "leaf_green":
			return 43;
		case "yellow":
			return 44;
		case "brown":
			return 45;
		case "black":
			return 46;
		case "carmine":
			return 48;
		case "crimson_red":
			return 50;
		case "turquoise":
			return 51;
		case "pine_green":
			return 53;
		case "orange":
			return 54;
		case "violet":
			return 55;
		case "rose":
			return 56;
		case "azure_blue":
			return 57;
		case "lilac":
			return 58;
		case "light_lilac":
			return 59;
		case "olive_green":
			return 63;
		case "umber":
			return 65;
		case "sienna":
			return 75;
		case "light_ochre":
			return 88;
		case "dark_ochre":
			return 89;
		case "light_grey":
			return 94;
		case "medium_grey":
			return 95;
		case "dark_grey":
			return 96;
		case "deep_grey":
			return 97;
		case "paynes_grey":
			return 98;
		default:
			return 0;
		}
	}

	// Returns color from colorCode
	private int getColor(int colorCode) {
		switch (colorCode) {
		case 11:
			int iceblue_11 = parent.color(173, 211, 234);
			return iceblue_11;
		case 13:
			int icegreen_13 = parent.color(41, 182, 166);
			return icegreen_13;
		case 16:
			int lightemerald_16 = parent.color(138, 188, 129);
			return lightemerald_16;
		case 17:
			int heliotrope_17 = parent.color(196, 130, 176);
			return heliotrope_17;
		case 19:
			int purple_19 = parent.color(132, 28, 65);
			return purple_19;
		case 22:
			int nightblue_22 = parent.color(15, 30, 95);
			return nightblue_22;
		case 24:
			int lemonyellow_24 = parent.color(236, 233, 76);
			return lemonyellow_24;
		case 26:
			int apricot_26 = parent.color(246, 174, 149);
			return apricot_26;
		case 29:
			int pink_29 = parent.color(203, 118, 141);
			return pink_29;
		case 30:
			int palevermillion_30 = parent.color(194, 89, 42);
			return palevermillion_30;
		case 31:
			int lightblue_31 = parent.color(37, 120, 190);
			return lightblue_31;
		case 32:
			int ultramarine_32 = parent.color(0, 135, 203);
			return ultramarine_32;
		case 33:
			int applegreen_33 = parent.color(160, 189, 0);
			return applegreen_33;
		case 36:
			int green_36 = parent.color(0, 142, 70);
			return green_36;
		case 38:
			int sanguine_38 = parent.color(149, 52, 45);
			return sanguine_38;
		case 40:
			int red_40 = parent.color(223, 1, 22);
			return red_40;
		case 41:
			int darkblue_41 = parent.color(0, 67, 148);
			return darkblue_41;
		case 43:
			int leafgreen_43 = parent.color(113, 183, 58);
			return leafgreen_43;
		case 44:
			int yellow_44 = parent.color(255, 204, 1);
			return yellow_44;
		case 45:
			int brown_45 = parent.color(102, 65, 36);
			return brown_45;
		case 46:
			int black_46 = parent.color(0, 20, 27);
			return black_46;
		case 48:
			int carmine_48 = parent.color(175, 18, 29);
			return carmine_48;
		case 50:
			int crimsonred_50 = parent.color(206, 0, 65);
			return crimsonred_50;
		case 51:
			int turquoise_51 = parent.color(0, 155, 177);
			return turquoise_51;
		case 53:
			int pinegreen_53 = parent.color(0, 87, 68);
			return pinegreen_53;
		case 54:
			int orange_54 = parent.color(239, 123, 0);
			return orange_54;
		case 55:
			int violet_55 = parent.color(85, 36, 127);
			return violet_55;
		case 56:
			int rose_56 = parent.color(227, 21, 130);
			return rose_56;
		case 57:
			int azureblue_57 = parent.color(0, 187, 218);
			return azureblue_57;
		case 58:
			int lilac_58 = parent.color(165, 0, 123);
			return lilac_58;
		case 59:
			int lightlilac_59 = parent.color(188, 152, 196);
			return lightlilac_59;
		case 63:
			int olivegreen_63 = parent.color(53, 94, 50);
			return olivegreen_63;
		case 65:
			int umber_65 = parent.color(76, 63, 47);
			return umber_65;
		case 75:
			int sienna_75 = parent.color(94, 61, 44);
			return sienna_75;
		case 88:
			int lightochre_88 = parent.color(178, 141, 73);
			return lightochre_88;
		case 89:
			int darkochre_89 = parent.color(194, 96, 23);
			return darkochre_89;
		case 94:
			int lightgrey_94 = parent.color(185, 201, 214);
			return lightgrey_94;
		case 95:
			int mediumgrey_95 = parent.color(130, 137, 147);
			return mediumgrey_95;
		case 96:
			int darkgrey_96 = parent.color(103, 115, 131);
			return darkgrey_96;
		case 97:
			int deepgrey_97 = parent.color(58, 63, 69);
			return deepgrey_97;
		case 98:
			int paynesgrey_98 = parent.color(27, 50, 84);
			return paynesgrey_98;
		default:
			return badcolor();
		}
	}

	// Returns completely transparent WHITE as color
	private int badcolor() {
		System.out.println("Colorcode doesn't exist for this type of pen.");
		return parent.color(255, 255, 255, 0);
	}

	// Returns true if color code is in array of possible color codes for pen
	private boolean contains(int[] a, int i) {
		Arrays.sort(a);
		return Arrays.binarySearch(a, i) > -1;
	}

	// Returns color with adjusted alpha value
	private int adjustAlpha(int color, int alpha) {
		return (alpha << 24) | (color & 0x00ffffff);
	}

	// Returns file version
	public static String version() {
		return VERSION;
	}
}
