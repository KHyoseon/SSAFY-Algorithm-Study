
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2504 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 주어진 괄호열 문자열
		String[] s = br.readLine().split("");

		// 열린 괄호 문자열
		String open = "([";

		// 스택에 넣으면서 값 계산 및 옳은 괄호열인지 판단
		// ():2, []:3
		// (x):2*x, [x]:3*x
		// xy:x+y

		// 더해진 총 결과값
		int result = 0;
		// 곱하는 덩어리값
		int temp = 1;
		// 닫히는 중인지
		boolean isClosing = false;

		Stack<String> stack = new Stack<>();
		for (int i = 0; i < s.length; i++) {
			// 현재 문자가 열린 괄호면 스택에 넣기
			if (open.contains(s[i])) {
				stack.push(s[i]);
				
				//이제 닫히는 중 아님(닫히기 시작하면 result+=temp)
				isClosing = false;
				//괄호에 맞게 temp값 곱하기
				if (s[i].equals("(")) {
					temp *= 2;
				} else if (s[i].equals("[")) {
					temp *= 3;
				}
			}
			// 현재 문자가 닫힌 괄호면...
			else {
				// 스택 빈 상태에서 닫힌 괄호가 나오면 0 출력 후 종료
				if (stack.isEmpty()) {
					System.out.println(0);
					return;
				}

				// 짝이 맞는 괄호가 나오면 스택에서 빼기
				if (stack.peek().equals("(") && s[i].equals(")") || stack.peek().equals("[") && s[i].equals("]")) {
					stack.pop();

					// 닫히기 시작할 때 곱해둔 temp를 결과 result에 더하기
					if (!isClosing) {
						result += temp;
						isClosing = true;
					}

					// 현재 괄호를 벗어나면서 temp 해당 값만큼 나눠서 다음 덩어리에 곱할 수 있게 해두기
					if (s[i].equals(")")) {
						temp /= 2;
					} else if (s[i].equals("]")) {
						temp /= 3;
					}
				} else {
					// 괄호 짝 안맞으면 0 출력 후 종료
					System.out.println(0);
					return;
				}
			}
		}
		// 문자열이 끝난 후 괄호 남아있으면 0 출력 후 종료
		if (!stack.isEmpty()) {
			System.out.println(0);
			return;
		}
		// 결과 출력
		System.out.println(result);
	}
}
