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

//	Java面试题：读取一篇英文文章，输出其中出现单词的次数最多的5个,写出java函数
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
		 * 核心：如何按照TreeMap 的value排序而不是key排序.将Map.Entry放在集合里， 重写比较器，在用
		 * Collections.sort(list, comparator);进行 排序
		 */
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
				map.entrySet());

		/*
		 * 重写比较器 取出单词个数（value）比较
		 */
		Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> left,
					Entry<String, Integer> right) {
				return left.getValue().compareTo(right.getValue());
			}

		};

		Collections.sort(list, comparator); // 排序
		

	}

}
