package pack0208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main2504 {

	static Stack<Character> stack;
	static Stack<Integer> nums;
	static Map<Character, Character> dic;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		dic = new HashMap<>();
		dic.put(')', '(');
		dic.put(']', '[');
		
		stack = new Stack<>();
		nums = new Stack<>();
		boolean result = true;
		String input = br.readLine();
		
		int j=0;
		int point=0;
		do {
			switch(input.charAt(j)) {
			case '(':
			case '[':
				stack.add(input.charAt(j));
				break;
			case ')':
			case ']':
				point = calcPoint(input.charAt(j), 0);
				if(point<0) result = false;
				stack.add('*');
				break;
			default:
				result=false;
			}
		} while((j++<input.length()-1) && result);
		
		if(stack.size()!=nums.size()) {
			bw.write("0\n");
			result = false;
		} else {
			int sum=0;
			for(int n: nums) {
				sum+=n;
			}
			bw.write(sum+"\n");
		}
		bw.flush();
	}
	private static int calcPoint(char key, int point) {
		if(stack.empty())	return Integer.MIN_VALUE;
		char tmp = stack.pop();
		if(tmp==dic.get(key)) {
			int flag=3;
			if(tmp=='(')	flag=2;
			if(point==0)	point++;
			nums.add(point*flag);
			return point*flag;
		}
		if(tmp=='(' || tmp=='[') {
			return Integer.MIN_VALUE;
		} else {
			int p = nums.pop();
			return calcPoint(key, point+p);
		}
	}

}
