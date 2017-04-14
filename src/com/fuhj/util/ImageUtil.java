/**
 * 
 */
package com.fuhj.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-8-8
 */
public class ImageUtil {
	/**
	 * 将svg字符串转换为png
	 * 
	 * @param svgCode svg代码
	 * @param pngFilePath 保存的路径
	 * @throws TranscoderException svg代码异常
	 * @throws IOException io错误
	 */
	public static void convertToPng(String svgCode, String pngFilePath) throws IOException,
				TranscoderException {

		File file = new File(pngFilePath);

		FileOutputStream outputStream = null;
		try {
			file.createNewFile();
			outputStream = new FileOutputStream(file);
			convertToPng(svgCode, outputStream);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 将svgCode转换成png文件，直接输出到流中
	 * 
	 * @param svgCode svg代码
	 * @param outputStream 输出流
	 * @throws TranscoderException 异常
	 * @throws IOException io异常
	 */
	public static void convertToPng(String svgCode, OutputStream outputStream)
				throws TranscoderException, IOException {
		try {
			byte[] bytes = svgCode.getBytes("utf-8");
			PNGTranscoder t = new PNGTranscoder();
			TranscoderInput input = new TranscoderInput(new ByteArrayInputStream(bytes));
			TranscoderOutput output = new TranscoderOutput(outputStream);
			t.transcode(input, output);
			outputStream.flush();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 默认使用编码UTF-8 SVG文件输入流转String
	 * 
	 * @param svgFile
	 * @return SVG代码
	 * @throws IOException
	 */
	public static String svg2String(File svgFile) throws IOException {
		InputStream in = getInputStream(svgFile);
		return svg2String(in, "UTF-8");
	}

	/**
	 * SVG文件输入流转String
	 * 
	 * @param svgFile
	 * @return SVG代码
	 * @throws IOException
	 */
	public static String svg2String(File svgFile, String charset) throws IOException {
		InputStream in = getInputStream(svgFile);
		return svg2String(in, charset);
	}

	/**
	 * 默认使用编码UTF-8 SVG输入流转String
	 * 
	 * @param in
	 * @return SVG代码
	 */
	public static String svg2String(InputStream in) {
		return svg2String(in, "UTF-8");
	}

	/**
	 * 指定字符集SVG输入流转String
	 * 
	 * @param in 输入流
	 * @param charset 字符编码
	 * @return SVG代码
	 */
	public static String svg2String(InputStream in, String charset) {
		StringBuffer svgBuffer = new StringBuffer();
		BufferedReader bfr = null;
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(in, charset);
			bfr = new BufferedReader(inputStreamReader);
			String line = "";
			while ((line = bfr.readLine()) != null) {
				svgBuffer.append(line);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bfr != null)
					bfr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return svgBuffer.toString();
	}

	public static InputStream getInputStream(File file) throws IOException {
		return new FileInputStream(file);
	}

	public static InputStream getInputStream(String filepath) throws IOException {
		File file = new File(filepath);
		if (file.exists())
			return getInputStream(file);
		else
			return null;
	}

	/***
	 * 按指定的比例缩放图片
	 * 
	 * @param sourceImagePath 源地址
	 * @param destinationPath 改变大小后图片的地址
	 * @param scale 缩放比例，如1.2
	 */
	public static void scaleImage(String sourceImagePath, String destinationPath, double scale, String format) {
		File file = new File(sourceImagePath);
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(file);
			int width = bufferedImage.getWidth();
			int height = bufferedImage.getHeight();

			width = parseDoubleToInt(width * scale);
			height = parseDoubleToInt(height * scale);

			Image image = bufferedImage.getScaledInstance(width, height,
					Image.SCALE_SMOOTH);
			BufferedImage outputImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics graphics = outputImage.getGraphics();
			graphics.drawImage(image, 0, 0, null);
			graphics.dispose();

			ImageIO.write(outputImage, format, new File(destinationPath));
		} catch (IOException e) {
			System.out.println("scaleImage方法压缩图片时出错了");
			e.printStackTrace();
		}

	}

	public static void scaleImage2(BufferedImage sourceImage, String destinationPath, double scale, String format) {
		try {
			if (sourceImage != null) {
				int width = sourceImage.getWidth();
				int height = sourceImage.getHeight();

				width = parseDoubleToInt(width * scale);
				height = parseDoubleToInt(height * scale);
				Image image = sourceImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
				BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics graphics = outputImage.getGraphics();
				graphics.drawImage(image, 0, 0, null);
				graphics.dispose();
				ImageIO.write(outputImage, format, new File(destinationPath));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BufferedImage scaleImage3(BufferedImage sourceImage, double scale) {
		if (sourceImage != null) {
			int width = sourceImage.getWidth();
			int height = sourceImage.getHeight();
			width = parseDoubleToInt(width * scale);
			height = parseDoubleToInt(height * scale);
			Image image = sourceImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics graphics = outputImage.getGraphics();
			graphics.drawImage(image, 0, 0, null);
			graphics.dispose();
			return outputImage;
		}
		return null;
	}

	/***
	 * 将图片缩放到指定的高度或者宽度
	 * 
	 * @param sourceImagePath 图片源地址
	 * @param destinationPath 压缩完图片的地址
	 * @param width 缩放后的宽度
	 * @param height 缩放后的高度
	 * @param auto 是否自动保持图片的原高宽比例
	 * @param format 图图片格式 例如 jpg
	 */
	public static void scaleImageWithParams(String sourceImagePath,
			String destinationPath, int width, int height, boolean auto, String format) {

		try {
			File file = new File(sourceImagePath);
			BufferedImage bufferedImage = null;
			bufferedImage = ImageIO.read(file);
			if (auto) {
				ArrayList<Integer> paramsArrayList = getAutoWidthAndHeight(bufferedImage, width, height);
				width = paramsArrayList.get(0);
				height = paramsArrayList.get(1);
				System.out.println("自动调整比例，width=" + width + " height=" + height);
			}

			Image image = bufferedImage.getScaledInstance(width, height,
					Image.SCALE_DEFAULT);
			BufferedImage outputImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics graphics = outputImage.getGraphics();
			graphics.drawImage(image, 0, 0, null);
			graphics.dispose();
			ImageIO.write(outputImage, format, new File(destinationPath));
		} catch (Exception e) {
			System.out.println("scaleImageWithParams方法压缩图片时出错了");
			e.printStackTrace();
		}

	}

	/**
	 * 将double类型的数据转换为int，四舍五入原则
	 * 
	 * @param sourceDouble
	 * @return
	 */
	private static int parseDoubleToInt(double sourceDouble) {
		int result = 0;
		result = (int) sourceDouble;
		return result;
	}

	/***
	 * 
	 * @param bufferedImage 要缩放的图片对象
	 * @param width_scale 要缩放到的宽度
	 * @param height_scale 要缩放到的高度
	 * @return 一个集合，第一个元素为宽度，第二个元素为高度
	 */
	private static ArrayList<Integer> getAutoWidthAndHeight(BufferedImage bufferedImage, int width_scale, int height_scale) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
		double scale_w = getDot2Decimal(width_scale, width);

		System.out.println("getAutoWidthAndHeight width=" + width + "scale_w=" + scale_w);
		double scale_h = getDot2Decimal(height_scale, height);
		if (scale_w < scale_h) {
			arrayList.add(parseDoubleToInt(scale_w * width));
			arrayList.add(parseDoubleToInt(scale_w * height));
		} else {
			arrayList.add(parseDoubleToInt(scale_h * width));
			arrayList.add(parseDoubleToInt(scale_h * height));
		}
		return arrayList;

	}

	/***
	 * 返回两个数a/b的小数点后三位的表示
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getDot2Decimal(int a, int b) {

		BigDecimal bigDecimal_1 = new BigDecimal(a);
		BigDecimal bigDecimal_2 = new BigDecimal(b);
		BigDecimal bigDecimal_result = bigDecimal_1.divide(bigDecimal_2, new MathContext(4));
		Double double1 = new Double(bigDecimal_result.toString());
		return double1;
	}
}
