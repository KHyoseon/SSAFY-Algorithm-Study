package com.ssafy.w0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
	static int r = 0;
	static int c = 0;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sb.append(z(N, 0, 0, 0));
		System.out.println(sb);
	}
	
	private static int z(int n, int x, int y, int count) {
		/*
		배열을 4등분 해서 r과 c의 값이 어느 범위에 속하는지를 기준으로 진행
		
		n = 3 일 때의 배열의 모습
		0	1	4	5	16	17	20	21
		2	3	6	7	18	19	22	23
		8	9	12	13	24	25	28	29
		10	11	14	15	26	27	30	31
		32	33	36	37	48	49	52	53
		34	35	38	39	50	51	54	55
		40	41	44	45	56	57	60	61
		42	43	46	47	58	59	62	63
		
		왼쪽 위(a), 오른쪽 위(b), 왼쪽 아래(c), 오른쪽 아래(d)로 4등분하여 생각
		각 부분의 기준점은 항상 왼쪽 위의 점
		각 점은 "수(x좌표, y좌표)"로 표현
		추가적으로 2^(n - 1)를 p로 표기
		
		a의 기준점은 0(0, 0)
		
		b의 기준점은 a의 기준점에서 p * p 크기의 사각형을 모두 순회한 뒤 도착
		즉, 기준점의 수는 0 + p * p
		좌표는 x방향으로 p만큼 이동
		
		정리하면 b의 기준점은 16(4, 0)
		
		c의 기준점은 b의 기준점에서 p * p 크기의 사각형을 모두 순회한 뒤 도착
		즉, 기준점의 수는 16 + p * p
		이를 a를 기준으로 생각하면 0 + p * p * 2
		좌표 또한 a를 기준으로 생각하면 y방향으로 p만큼 이동
		
		정리하면 c의 기준점은 32(0, 4)
		
		d의 기준점은 c의 기준점에서 p * p 크기의 사각형을 모두 순회한 뒤 도착
		즉, 기준점의 수는 32 + p * p
		이를 a를 기준으로 생각하면 x방향, y방향으로 모두 이동한 것이므로
		0 + p * p + p * p * 2
		좌표 또한 a를 기준으로 생각하면 x방향으로 p, y방향으로 p만큼 이동
		
		정리하면 d의 기준점은 48(4, 4)
		
		위의 내용을 종합하면 a를 기준으로
		a -> b => 값: + p * p				x좌표: + p	y좌표: 변화x
		a -> c => 값: + p * p * 2			x좌표: 변화x	y좌표: + p
		a -> d => 값: + p * p + p * p * 2	x좌표: + p	y좌표: + p
		
		위와 같은 방법으로 a~d의 값과 기준 좌표를 알 수 있음
		-> r과 c의 위치를 a~d 중 한 곳으로 특정할 수 있음
		-> 특정이 완료 되면 해당 사각형에서 n을 1 낮추고 같은 동작을 수행
		
		*/
		// p: 인덱스 변화량, pd: 값의 변화량, nx: 다음 x값, ny: 다음 y값
		int p = 0, pd = 0, nx = 0, ny = 0;
		
		// n이 0이 됐다는 것은 한 점에 도착했다는 의미이므로 그 점에 있는 값이 문제에서 원하는 값
		if(n == 0)
			return count;
		
		// p: 2^(n - 1), pd: p * p
		p = (int)Math.pow(2, n - 1);
		pd = p * p;
		
		// r이 위쪽에 있으면 현재 y값 유지, 아래쪽에 있으면 p만큼 이동
		if(r >= y + p) {
			ny = y + p;
			count += pd * 2;
		}else {
			ny = y;
		}

		// c가 왼쪽에 있으면 현재 x값 유지, 오른쪽에 있으면 p만큼 이동
		if(c >= x + p) {
			nx = x + p;
			count += pd;
		}else {
			nx = x;			
		}
		
		// nx, ny를 기준으로 사각형을 특정한 뒤 n을 1낮추고 같은 동작 수행
		return z(n - 1, nx, ny, count);
	}
}
