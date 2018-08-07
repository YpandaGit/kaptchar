# kaptchar
利用java实现简单的验证码

## 具体使用方式

```java
	AbstractKaptchar kaptchar = new SimpleKaptchar();
    // 创建验证码，指定证码长度与字符类型
	kaptchar.createKaptchar(24, AbstractKaptchar.UPPER_LETTER);
	resp.setDateHeader("Expires", 0);
	resp.setHeader("Cache-Control",
			"no-store, no-cache, must-revalidate");
	resp.addHeader("Cache-Control", "post-check=0, pre-check=0");
	resp.setHeader("Pragma", "no-cache");
	resp.setContentType("image/jpeg");
	ServletOutputStream out = null;
	try {
		out = resp.getOutputStream();
		ImageIO.write(kaptchar.getImage(), "jpg", out);
		LOGGER.info("captcha:{}",kaptchar.getCode());
		out.flush();
		out.close();
	}catch (Exception e) {
		LOGGER.error(e.getMessage(),e);
	}
```

* 以上局部代码来自于web接口调用的使用方式，resp 是在web应用中常见的的HttpServletResponse

## 图片预览

* 24个字符

![image](https://github.com/YpandaGit/kaptchar/blob/master/captcha.jpg?raw=true)

* 4个字符

![image](https://github.com/YpandaGit/kaptchar/blob/master/captcha_1.jpg?raw=true)
