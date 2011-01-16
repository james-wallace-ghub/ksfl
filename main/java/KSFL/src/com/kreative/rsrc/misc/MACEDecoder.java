package com.kreative.rsrc.misc;

public class MACEDecoder {
	private static final short[] MACE_TABLE_1 = {
		-13, 8, 76, 222, 222, 76, 8, -13
	};
	
	private static final short[] MACE_TABLE_3 = {
		-18, 140, 140, -18
	};
	
	private static final short[] MACE_TABLE_2 = {
		37, 116, 206, 330, 39, 121, 216, 346,
		41, 127, 225, 361, 42, 132, 235, 377,
		44, 137, 245, 392, 46, 144, 256, 410,
		48, 150, 267, 428, 51, 157, 280, 449,
		53, 165, 293, 470, 55, 172, 306, 490,
		58, 179, 319, 511, 60, 187, 333, 534,
		63, 195, 348, 557, 66, 205, 364, 583,
		69, 214, 380, 609, 72, 223, 396, 635,
		75, 233, 414, 663, 79, 244, 433, 694,
		82, 254, 453, 725, 86, 265, 472, 756,
		90, 278, 495, 792, 94, 290, 516, 826,
		98, 303, 538, 862, 102, 316, 562, 901,
		107, 331, 588, 942, 112, 345, 614, 983,
		117, 361, 641, 1027, 122, 377, 670, 1074,
		127, 394, 701, 1123, 133, 411, 732, 1172,
		139, 430, 764, 1224, 145, 449, 799, 1280,
		152, 469, 835, 1337, 159, 490, 872, 1397,
		166, 512, 911, 1459, 173, 535, 951, 1523,
		181, 558, 993, 1590, 189, 584, 1038, 1663,
		197, 610, 1085, 1738, 206, 637, 1133, 1815,
		215, 665, 1183, 1895, 225, 695, 1237, 1980,
		235, 726, 1291, 2068, 246, 759, 1349, 2161,
		257, 792, 1409, 2257, 268, 828, 1472, 2357,
		280, 865, 1538, 2463, 293, 903, 1606, 2572,
		306, 944, 1678, 2688, 319, 986, 1753, 2807,
		334, 1030, 1832, 2933, 349, 1076, 1914, 3065,
		364, 1124, 1999, 3202, 380, 1174, 2088, 3344,
		398, 1227, 2182, 3494, 415, 1281, 2278, 3649,
		434, 1339, 2380, 3811, 453, 1398, 2486, 3982,
		473, 1461, 2598, 4160, 495, 1526, 2714, 4346,
		517, 1594, 2835, 4540, 540, 1665, 2961, 4741,
		564, 1740, 3093, 4953, 589, 1818, 3232, 5175,
		615, 1898, 3375, 5405, 643, 1984, 3527, 5647,
		671, 2072, 3683, 5898, 701, 2164, 3848, 6161,
		733, 2261, 4020, 6438, 766, 2362, 4199, 6724,
		800, 2467, 4386, 7024, 836, 2578, 4583, 7339,
		873, 2692, 4786, 7664, 912, 2813, 5001, 8008,
		952, 2938, 5223, 8364, 995, 3070, 5457, 8739,
		1039, 3207, 5701, 9129, 1086, 3350, 5956, 9537,
		1134, 3499, 6220, 9960, 1185, 3655, 6497, 10404,
		1238, 3818, 6788, 10869, 1293, 3989, 7091, 11355,
		1351, 4166, 7407, 11861, 1411, 4352, 7738, 12390,
		1474, 4547, 8084, 12946, 1540, 4750, 8444, 13522,
		1609, 4962, 8821, 14126, 1680, 5183, 9215, 14756,
		1756, 5415, 9626, 15415, 1834, 5657, 10057, 16104,
		1916, 5909, 10505, 16822, 2001, 6173, 10975, 17574,
		2091, 6448, 11463, 18356, 2184, 6736, 11974, 19175,
		2282, 7037, 12510, 20032, 2383, 7351, 13068, 20926,
		2490, 7679, 13652, 21861, 2601, 8021, 14260, 22834,
		2717, 8380, 14897, 23854, 2838, 8753, 15561, 24918,
		2965, 9144, 16256, 26031, 3097, 9553, 16982, 27193,
		3236, 9979, 17740, 28407, 3380, 10424, 18532, 29675,
		3531, 10890, 19359, 31000, 3688, 11375, 20222, 32382,
		3853, 11883, 21125, 32767, 4025, 12414, 22069, 32767,
		4205, 12967, 23053, 32767, 4392, 13546, 24082, 32767,
		4589, 14151, 25157, 32767, 4793, 14783, 26280, 32767,
		5007, 15442, 27452, 32767, 5231, 16132, 28678, 32767,
		5464, 16851, 29957, 32767, 5708, 17603, 31294, 32767,
		5963, 18389, 32691, 32767, 6229, 19210, 32767, 32767,
		6507, 20067, 32767, 32767, 6797, 20963, 32767, 32767,
		7101, 21899, 32767, 32767, 7418, 22876, 32767, 32767,
		7749, 23897, 32767, 32767, 8095, 24964, 32767, 32767,
		8456, 26078, 32767, 32767, 8833, 27242, 32767, 32767,
		9228, 28457, 32767, 32767, 9639, 29727, 32767, 32767
	};
	
	private static final short[] MACE_TABLE_4 = {
		 64, 216, 67, 226, 70, 236, 74, 246,
		 77, 257, 80, 268, 84, 280, 88, 294,
		 92, 307, 96, 321, 100, 334, 104, 350,
		 109, 365, 114, 382, 119, 399, 124, 416,
		 130, 434, 136, 454, 142, 475, 148, 495,
		 155, 519, 162, 541, 169, 564, 176, 590,
		 185, 617, 193, 644, 201, 673, 210, 703,
		 220, 735, 230, 767, 240, 801, 251, 838,
		 262, 876, 274, 914, 286, 955, 299, 997,
		 312, 1041, 326, 1089, 341, 1138, 356, 1188,
		 372, 1241, 388, 1297, 406, 1354, 424, 1415,
		 443, 1478, 462, 1544, 483, 1613, 505, 1684,
		 527, 1760, 551, 1838, 576, 1921, 601, 2007,
		 628, 2097, 656, 2190, 686, 2288, 716, 2389,
		 748, 2496, 781, 2607, 816, 2724, 853, 2846,
		 891, 2973, 930, 3104, 972, 3243, 1016, 3389,
		 1061, 3539, 1108, 3698, 1158, 3862, 1209, 4035,
		 1264, 4216, 1320, 4403, 1379, 4599, 1441, 4806,
		 1505, 5019, 1572, 5244, 1642, 5477, 1715, 5722,
		 1792, 5978, 1872, 6245, 1955, 6522, 2043, 6813,
		 2134, 7118, 2229, 7436, 2329, 7767, 2432, 8114,
		 2541, 8477, 2655, 8854, 2773, 9250, 2897, 9663,
		 3026, 10094, 3162, 10546, 3303, 11016, 3450, 11508,
		 3604, 12020, 3765, 12556, 3933, 13118, 4108, 13703,
		 4292, 14315, 4483, 14953, 4683, 15621, 4892, 16318,
		 5111, 17046, 5339, 17807, 5577, 18602, 5826, 19433,
		 6086, 20300, 6358, 21205, 6642, 22152, 6938, 23141,
		 7248, 24173, 7571, 25252, 7909, 26380, 8262, 27557,
		 8631, 28786, 9016, 30072, 9419, 31413, 9839, 32767,
		 10278, 32767, 10737, 32767, 11216, 32767, 11717, 32767,
		 12240, 32767, 12786, 32767, 13356, 32767, 13953, 32767,
		 14576, 32767, 15226, 32767, 15906, 32767, 16615, 32767
	};
	
	private static class MACETable {
		public short[] table1;
		public short[] table2;
		public int stride;
		public MACETable(short[] table1, short[] table2, int stride) {
			this.table1 = table1;
			this.table2 = table2;
			this.stride = stride;
		}
	}
	
	private static final MACETable[] MACE_TABLES = {
		new MACETable(MACE_TABLE_1, MACE_TABLE_2, 4),
		new MACETable(MACE_TABLE_3, MACE_TABLE_4, 2),
		new MACETable(MACE_TABLE_1, MACE_TABLE_2, 4)
	};
	
	private static class MACEChannelData {
		public short index;
		public short factor;
		public short prev2;
		public short prev1;
		public short level;
	}
	
	private static short MACEClip(int n) {
		return (n > 32767) ? 32767 : (n < -32768) ? -32767 : (short)n;
	}
	
	private static short MACEReadTable(MACEChannelData cd, byte v, MACETable table) {
		short curr;
		if ((v & 0xFF) < table.stride) {
			curr = table.table2[((cd.index & 0x7F0) >> 4) * table.stride + (v & 0xFF)];
		} else {
			curr = (short)(- 1 - table.table2[((cd.index & 0x7F0) >> 4) * table.stride + 2*table.stride-(v & 0xFF)-1]);
		}
		if ((cd.index += table.table1[v & 0xFF]-(cd.index >> 5)) < 0) {
			cd.index = 0;
		}
		return curr;
	}
	
	private static void MACEChomp3(MACEChannelData cd, short[] output, int oo, byte v, MACETable table, int channels) {
		short curr = MACEReadTable(cd, v, table);
		curr = MACEClip(curr + cd.level);
		cd.level = (short)(curr - (curr >> 3));
		output[oo] = curr;
	}
	
	private static void MACEChomp6(MACEChannelData cd, short[] output, int oo, byte v, MACETable table, int channels) {
		short curr = MACEReadTable(cd, v, table);
		if ((cd.prev1 ^ curr) >= 0) {
			cd.factor = (short)Math.min(cd.factor + 506, 32767);
		} else if (cd.factor - 314 < -32768) {
			cd.factor = -32767;
		} else {
			cd.factor -= 314;
		}
		curr = MACEClip(curr + cd.level);
		cd.level = (short)((curr * cd.factor) >> 15);
		curr >>= 1;
		output[oo] = (short)(cd.prev1 + cd.prev2 - ((cd.prev2-curr) >> 2));
		output[oo+channels] = (short)(cd.prev1 + curr + ((cd.prev2-curr) >> 2));
		cd.prev2 = cd.prev1;
		cd.prev1 = curr;
	}
	
	private static void MACEDecodeFrame(byte[] buf, short[] samples, MACEChannelData[] ctx, boolean mace3, int channels) {
		for (int i = 0; i < channels; i++) {
			int output = i;
			for (int j = 0; j < buf.length / (mace3 ? (channels << 1) : channels); j++) {
				for (int k = 0; k < (mace3 ? 2 : 1); k++) {
					byte pkt = buf[(mace3 ? (i << 1) : i) + (mace3 ? (j * channels << 1) : (j * channels)) + k];
					byte[][] v = new byte[][]{
							new byte[]{(byte)((pkt >> 5) & 7), (byte)((pkt >> 3) & 3), (byte)(pkt & 7)},
							new byte[]{(byte)(pkt & 7), (byte)((pkt >> 3) & 3), (byte)((pkt >> 5) & 7)}
					};
					for (int l = 0; l < 3; l++) {
						if (mace3) {
							MACEChomp3(ctx[i], samples, output, v[1][l], MACE_TABLES[l], channels);
						} else {
							MACEChomp6(ctx[i], samples, output, v[0][l], MACE_TABLES[l], channels);
						}
						output += (mace3 ? channels : (channels << 1));
					}
				}
			}
		}
	}
	
	public static byte[] decompressMACE3(byte[] compData, int channels) {
		short[] decompData = new short[compData.length*3];
		MACEChannelData[] chData = new MACEChannelData[channels];
		for (int i = 0; i < channels; i++) chData[i] = new MACEChannelData();
		MACEDecodeFrame(compData, decompData, chData, true, channels);
		byte[] ret = new byte[decompData.length];
		for (int i = 0; i < decompData.length; i++) ret[i] = (byte)(decompData[i] >> 8);
		return ret;
	}
	
	public static byte[] decompressMACE6(byte[] compData, int channels) {
		short[] decompData = new short[compData.length*6];
		MACEChannelData[] chData = new MACEChannelData[channels];
		for (int i = 0; i < channels; i++) chData[i] = new MACEChannelData();
		MACEDecodeFrame(compData, decompData, chData, false, channels);
		byte[] ret = new byte[decompData.length];
		for (int i = 0; i < decompData.length; i++) ret[i] = (byte)(decompData[i] >> 8);
		return ret;
	}
}