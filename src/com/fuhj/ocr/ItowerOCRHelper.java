package com.fuhj.ocr;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class ItowerOCRHelper {
	private static Map<BufferedImage, String> trainMap = null;
	static {
		try {
			trainMap = loadTrainData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		File dir = new File("E:/fuhj/itower/ocr");
		// if(!dir.exists()){
		// dir.mkdirs();
		// }
		// for(int i=1;i<=66;i++){
		// File f=new File(dir.getAbsolutePath()+File.separator+i+".jpg");
		// if(!f.exists()){
		// f.createNewFile();
		// }
		// BufferedImage img =
		// ImageIO.read(Request.Get("http://180.153.49.130:9000/servlet/ValidateCodeServlet").execute().returnContent().asStream());
		//
		// ImageIO.write(img,"jpg",f);
		// }

		// final String destDir = dir.getAbsolutePath() + "/tmp";
		// for (File file : dir.listFiles()) {
		// if (file.isFile()) {
		// cleanImage(file, destDir);
		// }
		// }

		// List<BufferedImage> temp = splitImage(ImageIO.read(new
		// File("E:/fuhj/itower/ocr/tmp/2.jpg")));
		// int i = 21;
		// for (BufferedImage img : temp) {
		// File f = new File("E:/fuhj/itower/ocr/split" + File.separator + i +
		// ".jpg");
		// if (!f.exists()) {
		// f.createNewFile();
		// }
		// ImageIO.write(img, "jpg", f);
		// i++;
		// }

		// System.out.println(getSingleCharOcr(ImageIO.read(new
		// File("E:/fuhj/itower/ocr/split/1.jpg")), trainMap));
		System.out.println(getOcr(ImageIO.read(new File("E:/fuhj/itower/ocr/33.jpg"))));

	}

	/**
	 * 载入训练好的字摸
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Map<BufferedImage, String> loadTrainData() throws Exception {
		String path = ItowerOCRHelper.class.getResource("train").getFile(); 
		
		Map<BufferedImage, String> map = new HashMap<BufferedImage, String>();
		File dir = new File(path);
		System.out.println(path);
		if (!dir.exists()) {
			return null;
		}
		File[] files = dir.listFiles();
		for (File file : files) {
			map.put(ImageIO.read(file), file.getName().charAt(0) + "");
		}
		trainMap = map;

		return trainMap;
	}

	public static String getOcr(BufferedImage img) throws Exception {
		List<BufferedImage> listImg = splitImage(img);
		String result = "";
		for (BufferedImage bi : listImg) {
			result += getSingleCharOcr(bi, trainMap);
		}
		return result;
	}

	/**
	 * 识别分割的单个字符
	 * 
	 * @param img
	 * @param map
	 * @return
	 */
	public static String getSingleCharOcr(BufferedImage img, Map<BufferedImage, String> map) {
		String result = "#";
		int width = img.getWidth();
		int height = img.getHeight();
		int min = width * height;
		for (BufferedImage bi : map.keySet()) {
			int count = 0;
			if (Math.abs(bi.getWidth() - width) > 2)
				continue;
			int widthmin = width < bi.getWidth() ? width : bi.getWidth();
			int heightmin = height < bi.getHeight() ? height : bi.getHeight();
			Label1: for (int x = 0; x < widthmin; ++x) {
				for (int y = 0; y < heightmin; ++y) {
					if (isBlack(img.getRGB(x, y)) != isBlack(bi.getRGB(x, y))) {
						count++;
						if (count >= min)
							break Label1;
					}
				}
			}
			if (count < min) {
				min = count;
				result = map.get(bi);
			}
		}
		return result;
	}

	// 判断拆分验证码的标准：就是定义验证码中包含的各数字的x、y坐标值，及它们的宽度（width）、高度（height）。
	private static List<BufferedImage> splitImage(BufferedImage image) throws Exception {
		final int DIGIT_WIDTH = 14;
		final int DIGIT_HEIGHT = 16;

		List<BufferedImage> digitImageList = new ArrayList<BufferedImage>();
		digitImageList.add(image.getSubimage(3, 2, DIGIT_WIDTH, DIGIT_HEIGHT));
		digitImageList.add(image.getSubimage(19, 2, DIGIT_WIDTH, DIGIT_HEIGHT));
		digitImageList.add(image.getSubimage(33, 2, DIGIT_WIDTH, DIGIT_HEIGHT));
		digitImageList.add(image.getSubimage(48, 2, DIGIT_WIDTH, DIGIT_HEIGHT));

		return digitImageList;
	}

	/**
	 * 
	 * @param sfile
	 *            需要去噪的图像
	 * @param destDir
	 *            去噪后的图像保存地址
	 * @throws IOException
	 */
	public static void cleanImage(File sfile, String destDir) throws IOException {
		File destF = new File(destDir);
		if (!destF.exists()) {
			destF.mkdirs();
		}
		BufferedImage binaryBufferedImage = cleanImage(sfile);
		ImageIO.write(binaryBufferedImage, "jpg", new File(destDir, sfile.getName()));
	}

	/**
	 * 
	 * @param sfile
	 *            需要去噪的图像
	 * @param destDir
	 *            去噪后的图像保存地址
	 * @throws IOException
	 */
	public static BufferedImage cleanImage(BufferedImage bufferedImage) throws IOException {
		int h = bufferedImage.getHeight();
		int w = bufferedImage.getWidth();

		// 灰度化
		int[][] gray = new int[w][h];
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				int argb = bufferedImage.getRGB(x, y);
				// 图像加亮（调整亮度识别率非常高）
				int r = (int) (((argb >> 16) & 0xFF) * 1.1);
				int g = (int) (((argb >> 8) & 0xFF) * 0.1);
				int b = (int) (((argb >> 0) & 0xFF) * 0.1);
				if (r >= 255) {
					r = 255;
				}
				if (g >= 255) {
					g = 255;
				}
				if (b >= 255) {
					b = 255;
				}
				gray[x][y] = (int) Math.pow((Math.pow(r, 2.2) * 0.2973 + Math.pow(g, 2.2) * 0.6274 + Math.pow(b, 2.2) * 0.0753), 1 / 2.2);
			}
		}

		// 二值化
		int threshold = ostu(gray, w, h);
		BufferedImage binaryBufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_BINARY);
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				if (gray[x][y] > threshold) {
					gray[x][y] |= 0x00FFFF;
				} else {
					gray[x][y] &= 0xFF0000;
				}
				binaryBufferedImage.setRGB(x, y, gray[x][y]);
			}
		}

		// 矩阵打印
		// for (int y = 0; y < h; y++) {
		// for (int x = 0; x < w; x++) {
		// if (isBlack(binaryBufferedImage.getRGB(x, y))) {
		// System.out.print("*");
		// } else {
		// System.out.print(" ");
		// }
		// }
		// System.out.println();
		// }
		return binaryBufferedImage;

	}

	/**
	 * 
	 * @param sfile
	 *            需要去噪的图像
	 * @param destDir
	 *            去噪后的图像保存地址
	 * @throws IOException
	 */
	public static BufferedImage cleanImage(File sfile) throws IOException {

		return cleanImage(ImageIO.read(sfile));
	}

	public static boolean isBlack(int colorInt) {
		Color color = new Color(colorInt);
		if (color.getRed() + color.getGreen() + color.getBlue() <= 300) {
			return true;
		}
		return false;
	}

	public static boolean isWhite(int colorInt) {
		Color color = new Color(colorInt);
		if (color.getRed() + color.getGreen() + color.getBlue() > 300) {
			return true;
		}
		return false;
	}

	public static int isBlackOrWhite(int colorInt) {
		if (getColorBright(colorInt) < 30 || getColorBright(colorInt) > 730) {
			return 1;
		}
		return 0;
	}

	public static int getColorBright(int colorInt) {
		Color color = new Color(colorInt);
		return color.getRed() + color.getGreen() + color.getBlue();
	}

	public static int ostu(int[][] gray, int w, int h) {
		int[] histData = new int[w * h];
		// Calculate histogram
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				int red = 0xFF & gray[x][y];
				histData[red]++;
			}
		}

		// Total number of pixels
		int total = w * h;

		float sum = 0;
		for (int t = 0; t < 256; t++)
			sum += t * histData[t];

		float sumB = 0;
		int wB = 0;
		int wF = 0;

		float varMax = 0;
		int threshold = 0;

		for (int t = 0; t < 256; t++) {
			wB += histData[t]; // Weight Background
			if (wB == 0)
				continue;

			wF = total - wB; // Weight Foreground
			if (wF == 0)
				break;

			sumB += (float) (t * histData[t]);

			float mB = sumB / wB; // Mean Background
			float mF = (sum - sumB) / wF; // Mean Foreground

			// Calculate Between Class Variance
			float varBetween = (float) wB * (float) wF * (mB - mF) * (mB - mF);

			// Check if new maximum found
			if (varBetween > varMax) {
				varMax = varBetween;
				threshold = t;
			}
		}
		return threshold;
	}
}