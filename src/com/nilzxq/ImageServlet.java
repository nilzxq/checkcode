package com.nilzxq;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 /**
 * @author zxq @date 2017年1月2日
 *用于生成图片验证码
 */
public class ImageServlet extends HttpServlet{
	
	 public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		BufferedImage bi=new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		//画个图片
		Graphics g=bi.getGraphics();
		Color c=new Color(200,150,255);
		g.setColor(c);
		g.fillRect(0, 0, 68, 22);
		//随机产生
		char[] ch="ABCDEFGHIJKMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random r=new Random();
		int len=ch.length,index;
		//保存字符
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<4;i++){
			index=r.nextInt(len);
			g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
		    //字符画到图片上
			g.drawString(ch[index]+"",(i*15)+3, 18);
			sb.append(ch[index]);
		}
		request.getSession().setAttribute("piccode",sb.toString());
		ImageIO.write(bi, "JPG",response.getOutputStream());
	 }

}