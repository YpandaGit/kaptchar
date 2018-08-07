/**   
* @Title: SimpleKaptchar.java 
* @author youpan
* @version V1.0   
*/
package inid.youpan.blog.kaptchar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.apache.commons.lang.math.RandomUtils;

/**
 * @ClassName: SimpleKaptchar
 * @author yPan
 */
public class SimpleKaptchar extends AbstractKaptchar {

	/**
	 * 验证码类型（0：英文+数字，1：数字，2：大小写英文，3：大写英文，4：小写英文）
	 */
	@Override
	public void createKaptchar(int length, int type) {

		// 生成随机字符串
		String code = createCode(length, type);

		// 动态更图片宽度（字符数量 * 45）

		setWidth(length * 45);

		// 创建验证码图片
		createBufferedImage(code);
	}

	@Override
	public BufferedImage createBufferedImage(String code) {
		BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		int codeX = 10;// 起始像素点X
		int codeY = getHeight() - getHeight() / 5;// 起始像素点Y
		Graphics2D graph = bufferedImage.createGraphics();
		// 设置背景色
		graph.setColor(Color.white);
		graph.fillRect(0, 0, getWidth(), getHeight());

		// 设置字体
		Font font = new Font("Inconsolata", Font.BOLD, getWidth() / code.length() - 5);
		graph.setFont(font);

		// 绘制灰色干扰线
		graph.setColor(Color.GRAY);
		for (int i = 0, x, y; i < 10; i++) {
			x = RandomUtils.nextInt(getWidth());
			y = RandomUtils.nextInt(getHeight());
			graph.drawLine(x, y, getWidth() - RandomUtils.nextInt(getWidth()), getHeight() - RandomUtils.nextInt(getHeight()));
		}

		// 画图
		String[] codes = code.split("");
		for (int i = 0; i < codes.length; i++) {
			graph.setColor(new Color(RandomUtils.nextInt(255), RandomUtils.nextInt(255), RandomUtils.nextInt(255)));
			graph.drawString(codes[i], i * getWidth() / codes.length + codeX, codeY);
		}

		graph.setColor(new Color(RandomUtils.nextInt(255), RandomUtils.nextInt(255), RandomUtils.nextInt(255)));
		setBufferedImage(bufferedImage);
		return bufferedImage;
	}

}
