package be.rbdgt.util;

public class SC {
	// PENS
	public static final int WHITE = 0;
	public static final int ICEGREEN = 13;
	public static final int NIGHTBLUE = 22;
	public static final int APRICOT = 26;
	public static final int ULTRAMARINE = 32;
	public static final int APPLEGREEN = 33;
	public static final int GREEN = 36;
	public static final int RED = 40;
	public static final int DARKBLUE = 41;
	public static final int LEAFGREEN = 43;
	public static final int YELLOW = 44;
	public static final int BROWN = 45;
	public static final int BLACK = 46;
	public static final int CRIMSONRED = 50;
	public static final int TURQUOISE = 51;
	public static final int PINEGREEN = 53;
	public static final int ORANGE = 54;
	public static final int VIOLET = 55;
	public static final int ROSE = 56;
	public static final int AZUREBLUE = 57;
	public static final int LILAC = 58;
	public static final int LIGHTLILAC = 59;
	public static final int OLIVEGREEN = 63;
	public static final int DARKOCHRE = 89;
	public static final int LIGHTGREY = 94;
	public static final int DARKGREY = 96;
	public static final int SILVER = 94;
	public static final int GOLD = 44;

	// Returns color code as int from color name
	public static int getColorCode(String colorName) {
		switch (colorName) {
		case "ICEBLUE":
			return 11;
		case "ICEGREEN":
			return 13;
		case "LIGHTEMERALD":
			return 16;
		case "HELIOTROPE":
			return 17;
		case "PURPLE":
			return 19;
		case "NIGHTBLUE":
			return 22;
		case "LEMONYELLOW":
			return 24;
		case "APRICOT":
			return 26;
		case "PINK":
			return 29;
		case "PALEVERMILLION":
			return 30;
		case "LIGHTBLUE":
			return 31;
		case "ULTRAMARINE":
			return 32;
		case "APPLEGREEN":
			return 33;
		case "GREEN":
			return 36;
		case "SANGUINE":
			return 38;
		case "RED":
			return 40;
		case "DARKBLUE":
			return 41;
		case "LEAFGREEN":
			return 43;
		case "YELLOW":
			return 44;
		case "BROWN":
			return 45;
		case "BLACK":
			return 46;
		case "CARMINE":
			return 48;
		case "CRIMSON":
			return 50;
		case "TURQUOISE":
			return 51;
		case "PINEGREEN":
			return 53;
		case "ORANGE":
			return 54;
		case "VIOLET":
			return 55;
		case "ROSE":
			return 56;
		case "AZUREBLUE":
			return 57;
		case "LILAC":
			return 58;
		case "LIGHTLILAC":
			return 59;
		case "OLIVEGREEN":
			return 63;
		case "UMBER":
			return 65;
		case "SIENNA":
			return 75;
		case "LIGHTOCHRE":
			return 88;
		case "DARKOCHRE":
			return 89;
		case "LIGHTGREY":
			return 94;
		case "MEDIUMGREY":
			return 95;
		case "DARKGREY":
			return 96;
		case "DEEPGREY":
			return 97;
		case "PAYNESGREY":
			return 98;
		case "SILVER":
		    return 94;
		case "GOLD":
		    return 44;
		default:
			return 0;
		}
	}
}
