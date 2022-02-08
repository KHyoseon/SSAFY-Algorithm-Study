package com.ssafy.st0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 2월 7일 월요일 랜각코
public class Main_2504 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int temp = 1, res = 0;
		boolean plus = false;
		String str = "";
		Stack<Character> stk = new Stack<>();
		Map<Character, Integer> cti = new HashMap<Character, Integer>() {{
			put('(', 2);
			put('[', 3);
		}};
		Map<Character, Character> pair = new HashMap<Character, Character>() {{
			put(')', '(');
			put(']', '[');
		}};
		
		str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(' || str.charAt(i) == '[') {
				stk.push(str.charAt(i));
				temp *= cti.get(str.charAt(i));
				plus = true;
			}else if(str.charAt(i) == ')' || str.charAt(i) == ']') {
				if(stk.isEmpty()) {
					res = 0;
					break;
				}else if(stk.peek() != pair.get(str.charAt(i))) {
					res = 0;
					break;
				}else {
					if(plus == true) {
						res += temp;
						plus = false;
					}
					temp /= cti.get(pair.get(str.charAt(i)));
					stk.pop();
				}
			}
		}
		if(!stk.isEmpty())
			res = 0;
		
		System.out.println(res);
	}
}
