/**   
* @Title: AbstractKaptchar.java 
* @Package inid.youpan.blog.kaptchar 
* @author youpan
* @version V1.0   
*/


import java.awt.image.BufferedImage;

/**
 * 验证码抽象类，可继承该类实现验证码
 * 
 * @ClassName: AbstractKaptchar
 * @author yPan
 */
public abstract class AbstractKaptchar {
	private int width = 200;// 验证码的宽度
	private int height = 50;// 验证码的高度
	private int length = 4;// 验证码位数
	private String code;// 验证码code
	private BufferedImage bufferedImage;// 验证码图片

	/**
	 * 英文+数字
	 */
	public static final int NUMBER_AND_LETTER = 0;
	/**
	 * 数字
	 */
	public static final int NUMBER = 1;
	/**
	 * 大小写英文
	 */
	public static final int LETTER = 2;
	/**
	 * 大写英文
	 */
	public static final int LOWER_LETTER = 3;
	/**
	 * 小写英文
	 */
	public static final int UPPER_LETTER = 4;

	/**
	 * 创建图片验证码
	 * 
	 * @author yPan
	 * @param length
	 *            验证码长度
	 * @param type
	 *            验证码类型（0：英文+数字，1：数字，2：大小写英文，3：大写英文，4：小写英文）
	 * @param level
	 *            验证码难度
	 */
	public abstract void createKaptchar(int length, int type);

	/**
	 * 返回验证码图片
	 * 
	 * @author yPan
	 * @return
	 */
	public BufferedImage getImage() {
		return bufferedImage;
	}

	/**
	 * 返回验证码code
	 * 
	 * @author yPan
	 * @return
	 */
	public String getCode() {
		return code;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 生成验证码code
	 * 
	 * @author yPan
	 * @param length
	 * @param type
	 * @return
	 */
	public String createCode(int length, int type) {
		String code = "";
		if (0 == type) {
			code = CipherText.randomNumAndLetter(length);
		}
		if (1 == type) {
			code = CipherText.randomNumber(length);
		}
		if (2 == type) {
			code = CipherText.randomLetter(length);
		}
		if (3 == type) {
			code = CipherText.randomLowerLetter(length);
		}
		if (4 == type) {
			code = CipherText.randomUpperLetter(length);
		}
		this.code = code;
		return code;
	}

	/**
	 * 为指定的code生成图片验证码
	 * 
	 * @author yPan
	 * @param code
	 * @return
	 */
	public abstract BufferedImage createBufferedImage(String code);

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
	
	

}
