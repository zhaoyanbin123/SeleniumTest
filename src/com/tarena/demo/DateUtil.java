package com.tarena.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	// 时间：Date最常用工具类，用来对时间进行各种操作
	// Date（）: 表示当前的系统时间
	// SimpleDateFormat:美化时间的格式
	// 构造方法：SimpleDateFormat(格式)
	// 格式： yyyy-MM-dd / yyyy-MM-dd HH:mm:ss
	// 方法：format(date);
	public static void main(String[] args) {
		Date date1 = new Date();
		System.out.println("当前系统的时间是：" + date1);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String message = dateFormat.format(date1);
		System.out.println("修改后的系统时间：" + message);

		/*  SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
		  //向控制台输出的时间，一定要转化对应的String
		  
		  String message =teFormat.format(date1);
		  System.out.println("修改后的当前时间："
		  +message);*/

	}
}
