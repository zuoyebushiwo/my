package com.zuoye.base.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//	Java�����⣺��ȡһƪӢ�����£�������г��ֵ��ʵĴ�������5��,д��java����
public class Counts {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(
				"D:\\main.txt"));

		StringBuffer buffer = new StringBuffer();
		String line = null;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		reader.close();

		Pattern expression = Pattern.compile("[a-zA-Z]+");
		String string = buffer.toString();
		Matcher matcher = expression.matcher(string);
		Map<String, Integer> map = new TreeMap<String, Integer>();
		String word = "";
		int times = 0;

		while (matcher.find()) {
			word = matcher.group();
			if (map.containsKey(word)) {
				times = map.get(word);
				map.put(word, times + 1);
			} else {
				map.put(word, 1);
			}
		}

		/*
		 * ���ģ���ΰ���TreeMap ��value���������key����.��Map.Entry���ڼ���� ��д�Ƚ���������
		 * Collections.sort(list, comparator);���� ����
		 */
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
				map.entrySet());

		/*
		 * ��д�Ƚ��� ȡ�����ʸ�����value���Ƚ�
		 */
		Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> left,
					Entry<String, Integer> right) {
				return left.getValue().compareTo(right.getValue());
			}

		};

		Collections.sort(list, comparator); // ����
		

	}

}
