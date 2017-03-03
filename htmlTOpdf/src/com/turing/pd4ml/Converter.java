package com.turing.pd4ml;

import java.awt.Insets;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;

import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;

/**
 * 依赖jar包：fonts.jar    pd4ml.jar   ss_css2.jar    
 * PD4ML实现html2pdf，速度快，纠错能力强，支持多种中文字体。相比较于IText和Flying Sauser方便许多
 * @author vsc_hrj
 *
 */
public class Converter {
	public static void main(String[] args) throws Exception {
		File pdfFile = new File("C:/Users/Administrator/Desktop/pdffile.pdf");
		StringBuffer  sb = new StringBuffer();
		sb.append("html代码拼接位置");
		StringReader sr = new StringReader(sb.toString());
		//第一种方法
		htmltopdf(pdfFile, sr);
		//第二种方法
		htmltopdf1(new File("C:/Users/Administrator/Desktop/pdf.pdf"), "C:/Users/Administrator/Desktop/html.html");
	}
	 /*
	  * 第一种方法：html代码转pdf文件
	  */
	private static void htmltopdf(File outputPDFFile, StringReader strReader) throws Exception {
		FileOutputStream fos = new FileOutputStream(outputPDFFile);
		PD4ML pd4ml = new PD4ML();
		pd4ml.setPageInsets(new Insets(20,10,10,10));
		pd4ml.setHtmlWidth(950);
		pd4ml.setPageSize(pd4ml.changePageOrientation(PD4Constants.A4));
		pd4ml.useTTF("java:fonts", true);
		pd4ml.setDefaultTTFs("KaiTi_GB2312", "KaiTi_GB2312", "KaiTi_GB2312");
		pd4ml.enableDebugInfo();
		pd4ml.render(strReader, fos);
	}
	
	/*
	  * 第二种方法：html文件代码转pdf文件
	  */
	private static void htmltopdf1(File outputPDFFile, String inputHTMLFileName) throws Exception {
		FileOutputStream fos = new FileOutputStream(outputPDFFile);
		PD4ML pd4ml = new PD4ML();
		pd4ml.setPageInsets(new Insets(20,10,10,10));
		pd4ml.setHtmlWidth(950);
		pd4ml.setPageSize(pd4ml.changePageOrientation(PD4Constants.A4));
		pd4ml.useTTF("java:fonts", true);
		pd4ml.setDefaultTTFs("KaiTi_GB2312", "KaiTi_GB2312", "KaiTi_GB2312");
		pd4ml.enableDebugInfo();
		pd4ml.render("file:" + inputHTMLFileName,fos);
	}
}
