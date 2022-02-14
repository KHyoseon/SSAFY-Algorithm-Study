import java.util.Scanner;

public class Algo2_구미_5반_김지혜 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// Scanner 객체 생성
		int n = sc.nextInt();		// 신청한 동아리의 수
		int s = sc.nextInt();		// 가입을 위해 필요한 팀원 3명 능력의 합
		int m = sc.nextInt();		// 가입을 위해 필요한 개인 능력치
		int num = 0;
		String result = "";
		
		for(int i=0; i<n; i++) {	// 신청한 동아리 수만큼 반복
			int x1 = sc.nextInt();	// 팀원 x1의 능력치
			int x2 = sc.nextInt();	// 팀원 x2의 능력치
			int x3 = sc.nextInt();	// 팀원 x3의 능력치
			int sum = x1 + x2 + x3;	// 팀원들의 능력치 합
			if(sum >= s && x1 >= m && x2 >= m && x3 >= m) {	// 가입을 위한 조건에 맞는지 확인
				num += 1;
				result += x1+" "+ x2 + " " + x3 + " ";      // 조건이 맞으면 출력
			}
		}
		System.out.println(num);
		System.out.println(result);
	}
}
