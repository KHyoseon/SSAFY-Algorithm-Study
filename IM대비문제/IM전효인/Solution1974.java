/**
 * SWEA 1974. 스도쿠 검증
 * 
 * 220214 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1974 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 개수
		int T=Integer.parseInt(br.readLine());
		//결과 저장할 문자열
		StringBuilder sb=new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			//스도쿠 정보 이차원 배열
			int[][] sudoku=new int[9][9];
			for(int i=0;i<9;i++) {
				sudoku[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			//스도쿠 맞는지 체크하고 결과 저장
			if(checkRow(sudoku) && checkCol(sudoku) && checkBox(sudoku)) {
				sb.append(1);
			}else {
				sb.append(0);
			}
			sb.append("\n");
		}
		//결과 출력
		System.out.println(sb.toString());
	}
	
	//가로줄 체크
	public static boolean checkRow(int[][] sudoku) {
		//가로줄 9칸 보면서 중복되는 숫자 체크
		for(int r=0;r<9;r++) {
			//1~9 나왔는지 확인하는 배열
			boolean[] check=new boolean[10];

			for(int c=0;c<9;c++) {
				if(!check[sudoku[r][c]]) {
					check[sudoku[r][c]]=true;
				}else {
					return false;
				}
			}
		}
		return true;
	}
	
	//세로줄 체크
	public static boolean checkCol(int[][] sudoku) {
		//세로줄 9칸 보면서 중복되는 숫자 체크
		for(int c=0;c<9;c++) {
			//1~9 나왔는지 확인하는 배열
			boolean[] check=new boolean[10];

			for(int r=0;r<9;r++) {
				if(!check[sudoku[r][c]]) {
					check[sudoku[r][c]]=true;
				}else {
					return false;
				}
			}
		}
		return true;
	}
	
	//3x3 네모칸 체크
	public static boolean checkBox(int[][] sudoku) {
		//3x3 네모칸 9개의 시작칸에서 확인
		for(int r=0;r<9;r+=3) {
			for(int c=0;c<9;c+=3) {
				if(!checkBox(r,c,sudoku)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean checkBox(int r,int c,int[][] sudoku) {
		//1~9 나왔는지 확인하는 배열
		boolean[] check=new boolean[10];
		
		//3x3 9칸 보면서 중복되는 숫자 체크
		for(int i=r;i<r+3;i++) {
			for(int j=c;j<c+3;j++) {
				if(!check[sudoku[i][j]]) {
					check[sudoku[i][j]]=true;
				}else {
					return false;
				}
			}
		}
		return true;
	}
}
