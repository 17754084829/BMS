package servlet.login.verify_code_servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.login.utils.VerifyCode;


@WebServlet(name="verify_code",urlPatterns= {"/login/verify_code"})
public class Verify_Code_Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("获取验证码");
		 
        try {

                 int width=200;

                 int height=60;

                 BufferedImage verifyImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

                 //生成对应宽高的初始图片

                 String randomText = VerifyCode.drawRandomText(width,height,verifyImg);

                 //单独的一个类方法，出于代码复用考虑，进行了封装。

                 //功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符                   

                 req.getSession().setAttribute("code", randomText);

                 resp.setContentType("image/png");//必须设置响应内容类型为图片，否则前台不识别

                 OutputStream os = resp.getOutputStream(); //获取文件输出流    

                 ImageIO.write(verifyImg,"png",os);//输出图片流

                 os.flush();

                 os.close();//关闭流

        } catch (IOException e) {

                 e.printStackTrace();

        }

	}

}
