/**
 * 
 */
package com.fuhj.itower.ui.vm.gelec;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.imageio.ImageIO;

import com.fuhj.exception.ServiceException;
import com.fuhj.itower.model.GElecInfo;
import com.fuhj.util.FormatUtil;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-11-29
 */
public class ElecImgMark {

	/**
	 * 图片添加水印
	 * 
	 * @param srcImgPath 需要添加水印的图片的路径
	 * @param outImgPath 添加水印后图片输出路径
	 * @param markContentColor 水印文字的颜色
	 * @param waterMarkContent 水印的文字 1-开始 2结束
	 */
	public static void mark(String srcImgPath, String outImgPath, Color markContentColor, GElecInfo info, int tag) throws ServiceException {
		try {
			// 读取原图片信息
			File srcImgFile = new File(srcImgPath);
			Image srcImg = ImageIO.read(srcImgFile);
			int srcImgWidth = srcImg.getWidth(null);
			int srcImgHeight = srcImg.getHeight(null);
			// 加水印
			BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bufImg.createGraphics();
			g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
			int fontSize1 = srcImgWidth / 20;
			int fontSize2 = srcImgWidth / 20;
			Font font1 = new Font("宋体", Font.BOLD, fontSize1);
			Font font2 = new Font("宋体", Font.BOLD, fontSize2);

			/* 消除java.awt.Font字体的锯齿 */
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			int x = 30;
			int y = 80;
			int y_space = 10;
			// int x = (srcImgWidth - getWatermarkLength(watermarkStr, g)) / 2;
			// int y = srcImgHeight / 2;
			g.drawString(createLine("北纬", font1), x, y);
			g.drawString(createLine(String.valueOf(info.getStartLat()), font1), x + 10, y + font1.getSize() + y_space);
			g.drawString(createLine("东经", font1), x, y + (font1.getSize() + y_space) * 2);
			g.drawString(createLine(String.valueOf(info.getStartLng()), font1), x + 10, y + (font1.getSize() + y_space) * 3);

			g.drawString(createLine(info.getStationName(), font2), x, srcImgHeight - (font1.getSize() + y_space) * 3);
			g.drawString(createLine(tag == 1 ? FormatUtil.getFDate(info.getStartTime()) : FormatUtil.getFDate(info.getEndTime()), font1), x,
					srcImgHeight - (font1.getSize() + y_space) * 2);
			
			String tip = tag == 1 ? "开始发电" : "结束发电";
			g.drawString(createLine(tip, font1), x, srcImgHeight - (font1.getSize() + y_space));
			g.dispose();
			// 输出图片
			FileOutputStream outImgStream = new FileOutputStream(outImgPath);
			ImageIO.write(bufImg, "jpg", outImgStream);
			outImgStream.close();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	public static AttributedCharacterIterator createLine(String line, Font font) {
		AttributedString ats = new AttributedString(line);
		ats.addAttribute(TextAttribute.FONT, font, 0, line.length());
		return ats.getIterator();
	}

	/**
	 * 获取水印文字总长度
	 * 
	 * @param waterMarkContent 水印的文字
	 * @param g
	 * @return 水印文字总长度
	 */
	public int getWatermarkLength(String waterMarkContent, Graphics2D g) {
		return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
	}
}
