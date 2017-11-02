package com.Blog.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {
	 /**
	  * 将时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss(中间可填充任何文字字符，月份MM必须大写，否则和分钟mm冲突，HH取得的是24小时制，hh取得是12小时制)
	  * 
	  * @return
	  */
	 public static String dateToStr(Date date, String formatStr) {
	  SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
	  String dateString = formatter.format(date);
	  return dateString;
	 }
	 
	 /**
	  * 将字符串时间格式转换成date格式
	  * 
	  * @param strDate
	  * @return
	  */
	 public static Date strToDate(String strDate, String formatStr) {
	  SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
	  ParsePosition pos = new ParsePosition(0);
	  Date strtodate = formatter.parse(strDate, pos);
	  return strtodate;
	 }
	 
	 public static  void main(String[] s) {
		/* Date date = new Date();
		 String dateStr = dateToStr(date, "yyyMMdd HH_mm=ss");
		 System.out.println(dateStr);
		 String datestring = "2012-05-06 18-25-36";
		 Date dates = strToDate(datestring, "yyyy-mm-dd hh-mm-ss");
		 System.out.println(dates);
		 System.out.println("5015-08-06".replace("-", ""));
		 System.out.println(getDifBy2Date(1000, 1890));*/
		 //sumDate("2015-11-26 10:05:35",2);
//		 substractToDays("2017-01-26 14:59:11","2017-02-26 14:59:11");
		 System.out.println(getYesterday());

		 }

	public static boolean isGreatNowDate(Long date){
	 	boolean flag = false;
	 	Date d = new Date();
	 	if(date>d.getTime()){
	 		flag = true;
		}
		return flag;
	}
	public static String toStringDate(Long date, String formater){
		Date d = new Date(date);
		SimpleDateFormat sdf = new SimpleDateFormat(formater);
		String result = sdf.format(d);
		return result;
	}
	 public static String getDifBy2Date(long start, long end){
		 long dif = end - start;
		 float num= (float)dif/1000;   
		 DecimalFormat df = new DecimalFormat("0.000");//格式化小数
		 String s = df.format(num);//返回的是String类型
		return s;
		 
	 }
	 
	 	/**
		 * 获取指定时间相差diff天的日期
		 * @param endTime 
		 * @param diff 正数为之后的日期，负数为之前的日期
		 * @return
		 */
	 public static String getDiffDay(String endTime, int diff){
			if (null == endTime || "".equals(endTime)) {
				return "";
			}
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			Date endDate = null;
			try {
				endDate = df.parse(endTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(endDate!=null){
				cal.setTime(endDate);
				cal.add(Calendar.DATE, diff);
				String date = df.format(cal.getTime());
				return date;
			}
			return "";
		}
	 
		/**
		 * 获取昨天时间
		 * @return
		 */
	 public static String getYesterday(){
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, -1);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			String date = df.format(cal.getTime());
			return date;
		}
	 
	 
	 /**
	 * @param sourceDate   原始日期
	 * @param incrementMonth   需要增加/减少的月数
	 * *java中对日期的加减操作
		*gc.add(1,-1)表示年份减一.
		*gc.add(2,-1)表示月份减一.
		*gc.add(3.-1)表示周减一.
		*gc.add(5,-1)表示天减一.
		*GregorianCalendar类的add(int field,int amount)方法表示年月日加减.
		*field参数表示年,月.日等.
		*amount参数表示要加减的数量.
	 */
	public static String sumDate(String sourceDate, int incrementMonth){
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 GregorianCalendar gc=new GregorianCalendar();
		 try {
	            gc.setTime( format.parse(sourceDate));//new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sourceDate) 
	            gc.add(2, incrementMonth);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		 System.out.println(format.format(gc.getTime()));
		 
		 return format.format(gc.getTime());
	 }
	// flag是标识，详情见sumDate（param1，param2）
	public static String sumDate(String sourceDate, int incrementMonth, int flag){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		GregorianCalendar gc=new GregorianCalendar();
		try {
			gc.setTime( format.parse(sourceDate));//new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sourceDate) 
			gc.add(flag, incrementMonth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(format.format(gc.getTime()));
		
		return format.format(gc.getTime());
	}
	public static Long substractToDays(String startTime, String endTime){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 =null;
		Date date2 =null;
		try {
			date1 = format.parse(startTime);
			 date2 = format.parse(endTime);
			 Long days = (date2.getTime()-date1.getTime())/(24*60*60*1000);
			 System.out.println(days);
			 return days;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	 private static final String[] NUMBERS = { "〇", "一", "二", "三", "四", "五", "六", "七", "八", "九" };


	 public static synchronized String toChinese(String str) {
	     StringBuffer sb = new StringBuffer();
	     if(str!=null && !"-".equals(str) && !"".equals(str) && !"null".equals(str)){
	    	 sb.append(getSplitDateStr(str, 0)).append(" ").append(
		             getSplitDateStr(str, 1)).append(" ").append(
		             getSplitDateStr(str, 2));
	    	 return sb.toString();
	     } else {
	    	 return str;
	     }
	     
	 }
	
	
	 public static String getSplitDateStr(String str, int unit) {
	     // unit是单位 0=年 1=月 2日
	     String[] DateStr = str.split("-");
	     if (unit > DateStr.length)
	         unit = 0;
	     StringBuffer sb = new StringBuffer();
	     for (int i = 0; i < DateStr[unit].length(); i++) {
	
	         if ((unit == 1 || unit == 2) && Integer.valueOf(DateStr[unit]) > 9) {
	        	 if(unit == 1) 
	        		 sb.append(convertNum(DateStr[unit].substring(0, 1))).append("十").append(convertNum(DateStr[unit].substring(1, 2))).append("月");
	        	 else if(unit==2)
	        		 sb.append(convertNum(DateStr[unit].substring(0, 1))).append("十").append(convertNum(DateStr[unit].substring(1, 2))).append("日");
	             break;
	         } else {
	             sb.append(convertNum(DateStr[unit].substring(i, i + 1)));
	             if(i==DateStr[unit].length()-1){
	            	 if(unit == 0) sb.append("年");
	            	 else  if(unit == 1) sb.append("月");
	            	 else if(unit == 2) sb.append("日");
	             }
	            	 
	         }
	     }
	     if (unit == 1 || unit == 2) {
	         return sb.toString().replaceAll("^一", "").replace("〇", "");
	     }
	     return sb.toString();
	
	 }
	
	 private static String convertNum(String str) {
	     return NUMBERS[Integer.valueOf(str)];
	 }
	
	
	 public static boolean isNumeric(String str) {
	     Pattern pattern = Pattern.compile("[0-9]*");
	     Matcher isNum = pattern.matcher(str);
	     if (!isNum.matches()) {
	         return false;
	     }
	     return true;
	 }
	
	public static Long substractOneDay(String startTime, String endTime){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 =null;
		Date date2 =null;
		try {
			date1 = format.parse(startTime);
			date2 = format.parse(endTime);
			Long days = (date2.getTime()-date1.getTime())/(24*60*60*1000);
			System.out.println(days);
			return days;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
