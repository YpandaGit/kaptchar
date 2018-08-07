/**   
* @Title: CipherText.java 
* @author youpan
* @version V1.0   
*/


import org.apache.commons.lang.math.RandomUtils;

/**
 * 用于生成随机数字或字母 通过ascii码来便捷生成字母或数字
 * 
 * @ClassName: CipherText
 * @author yPan
 */
public class CipherText {

	/**
	 * 返回长度为length的随机数字串
	 * 
	 * @author yPan
	 * @param length
	 * @return
	 */
	public static String randomNumber(int length) {
		StringBuilder result = new StringBuilder();

		// 数字的ascii码范围是48~57
		for (int i = 0; i < length; i++) {
			int num = RandomUtils.nextInt(10) + 48;
			result.append((char) num);
		}
		return result.toString();
	}

	/**
	 * 返回长度为length，不区分大小写的的随机字符串
	 * 
	 * @author yPan
	 * @return
	 */
	public static String randomLetter(int length) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (RandomUtils.nextBoolean()) {// 为真则生成大写字母
				result.append(randomUpperLetter(1));
			} else {// 生成小写字母
				result.append(randomLowerLetter(1));
			}
		}
		return result.toString();
	}

	public static String randomNumAndLetter(int length) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (RandomUtils.nextBoolean()) {// 为真则生成数字
				result.append(randomNumber(1));
			} else if (RandomUtils.nextBoolean()) {// 生成小写字母
				result.append(randomLowerLetter(1));
			} else {
				result.append(randomUpperLetter(1));
			}
		}
		return result.toString();

	}

	/**
	 * 返回长度为length，小写的的随机字符串
	 * 
	 * @author yPan
	 * @param length
	 * @return
	 */
	public static String randomLowerLetter(int length) {
		StringBuilder result = new StringBuilder();
		// 大写字母的ascii码范围是65~90
		for (int i = 0; i < length; i++) {
			int num = RandomUtils.nextInt(26) + 97;
			result.append((char) num);
		}
		return result.toString();
	}

	/**
	 * 返回长度为length，大写的的随机字符串
	 * 
	 * @author yPan
	 * @param length
	 * @return
	 */
	public static String randomUpperLetter(int length) {
		StringBuilder result = new StringBuilder();
		// 大写字母的ascii码范围是97~122
		for (int i = 0; i < length; i++) {
			int num = RandomUtils.nextInt(26) + 65;
			result.append((char) num);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String code = randomNumAndLetter(3);
		System.out.println(code);
		String[] codes = code.split("");
		for(String tmp : codes) {
			System.out.println(tmp);
		}
		
		System.out.println(randomUpperLetter(5));
		System.out.println(randomLowerLetter(5));
		System.out.println(randomNumber(5));
	}
}
