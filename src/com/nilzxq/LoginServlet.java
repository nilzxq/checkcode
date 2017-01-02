package com.nilzxq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zxq @date 2017年1月2日
 *验证码的校验
 */
public class LoginServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//获得原先的验证码
		String piccode = (String) request.getSession().getAttribute("piccode");
		String checkcode = request.getParameter("checkcode");
		//大小写
		checkcode = checkcode.toUpperCase();
		//乱码
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		//比较是否相等
		if(checkcode.equals(piccode)){
			out.println("验证码输入正确！");
		}else{
			out.println("验证码输入错误！！！");
		}
		//刷新输出流
		out.flush();
		//关闭
		out.close();
		
	}
}
