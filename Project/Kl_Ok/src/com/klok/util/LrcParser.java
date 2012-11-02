package com.klok.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * ������������LRC�ļ� ������������LRC�ļ�����һ��LrcInfo������ ���ҷ������LrcInfo����s author:java_mzd
 */
public class LrcParser {
	private static LrcInfo lrcinfo = new LrcInfo();

	private static long currentTime = 0;//�����ʱʱ��
	private static String currentContent = null;//�����ʱ���
	private static List<Double> time=new ArrayList<Double>();
	private static List<String> lrc=new ArrayList<String>();
	/**
	 * �����ļ�·������ȡ�ļ�������һ��������
	 * 
	 * @param path
	 *            ·��
	 * @return ������
	 * @throws FileNotFoundException
	 */
	private static InputStream readLrcFile(String path) throws FileNotFoundException {
		File f = new File(path);
		InputStream ins = new FileInputStream(f);
		return ins;
	}
	public static LrcInfo parser(String path) throws Exception {
		InputStream in = readLrcFile(path);
		lrcinfo = parser(in);
		return lrcinfo;
	}

	/**
	 * ���������е���Ϣ����������һ��LrcInfo����
	 * 
	 * @param inputStream
	 *            ������
	 * @return �����õ�LrcInfo����
	 * @throws IOException
	 */
	public static LrcInfo parser(InputStream inputStream) throws IOException {
		// �����װ
		InputStreamReader inr = new InputStreamReader(inputStream,"UTF-8");
		BufferedReader reader = new BufferedReader(inr);
		// һ��һ�еĶ���ÿ��һ�У�����һ��
		String line = null;
		while ((line = reader.readLine()) != null) {
			parserLine(line);
		}
		// ȫ�������������info
		lrcinfo.setTime(time);
		lrcinfo.setLrc(lrc);
		return lrcinfo;
	}
	/**
	 * �����������ʽ����ÿ�о������
	 * ���ڽ���������󣬽�������������Ϣ������LrcInfo������
	 * 
	 * @param str
	 */
	private static void parserLine(String str) {
		// ȡ�ø�������Ϣ
		if (str.startsWith("[ti:")) {
			String title = str.substring(4, str.length() - 1);
			System.out.println("title--->" + title);
			lrcinfo.setTitle(title);
		}// ȡ�ø�����Ϣ
		else if (str.startsWith("[ar:")) {
			String singer = str.substring(4, str.length() - 1);
			System.out.println("singer--->" + singer);
			lrcinfo.setSinger(singer);
		}// ȡ��ר����Ϣ
		else if (str.startsWith("[al:")) {
			String album = str.substring(4, str.length() - 1);
			System.out.println("album--->" + album);
			lrcinfo.setAlbum(album);
		}// ͨ������ȡ��ÿ������Ϣ
		else {
			// �����������
			String reg = "\\[(\\d{2}:\\d{2}\\.\\d{2})\\]";
			// ����
			Pattern pattern = Pattern.compile(reg);
			Matcher matcher = pattern.matcher(str);
			// �������ƥ�����ִ�����²���
			while (matcher.find()) {
				// �õ�ƥ�����������
				String msg = matcher.group();
				// �õ����ƥ���ʼ������
				int start = matcher.start();
				// �õ����ƥ�������������
				int end = matcher.end();
				// �õ����ƥ�����е�����
				int groupCount = matcher.groupCount();
				// �õ�ÿ����������
				for (int i = 0; i <= groupCount; i++) {
					String timeStr = matcher.group(i);
					if (i == 1) {
						// ���ڶ����е���������Ϊ��ǰ��һ��ʱ���
						currentTime = strToLong(timeStr);
					}
				}
				// �õ�ʱ���������
				String[] content = pattern.split(str);
				// �����������
				for (int i = 0; i < content.length; i++) {
					if (i == content.length - 1) {
						// ����������Ϊ��ǰ����
						currentContent = content[i];
					}
				}
				if (content.length == 0) {
					// ����������Ϊ��ǰ����
					currentContent = "";
				}
				// ����ʱ�������ݵ�ӳ��
				time.add((double) currentTime/1000);
				lrc.add("'"+currentContent+"'");
				System.out.println("put---currentTime--->" + (double) currentTime/1000
						+ "----currentContent---->" + currentContent);
			}
		}
	}
	/**
	 * �������õ��ı�ʾʱ����ַ�ת��ΪLong��
	 * 
	 * @param group
	 *            �ַ���ʽ��ʱ���
	 * @return Long��ʽ��ʱ��
	 */
	private static long strToLong(String timeStr) {
		// ��Ϊ������ַ�����ʱ���ʽΪXX:XX.XX,���ص�longҪ�����Ժ���Ϊ��λ
		// 1:ʹ�ã��ָ� 2��ʹ��.�ָ�
		String[] s = timeStr.split(":");
		int min = Integer.parseInt(s[0]);
		String[] ss = s[1].split("\\.");
		int sec = Integer.parseInt(ss[0]);
		int mill = Integer.parseInt(ss[1]);
		return min * 60 * 1000 + sec * 1000 + mill * 10;
	}

	public static void main(String[] args) {
		LrcParser lp = new LrcParser();
		try {
			lp.parser("D:\\����\\xx.lrc");
		} catch (Exception e) {
			System.out.println("parser erro");
			e.printStackTrace();
		}

	}
}