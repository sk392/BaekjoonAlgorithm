import java.util.Scanner;

public class Main {

	static int[][] dp = new int[100][100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] result;// 결과값

		int inputCnt = sc.nextInt();
		result = new int[inputCnt];
		for (int i = 0; i < inputCnt; i++) {
			int inputN = sc.nextInt();
			int inputM = sc.nextInt();
			if(inputN<=0 || inputN>inputM || inputM>=30)
				System.exit(999);
			result[i] = combination(inputM, inputN);
		}
		for (int i = 0; i < inputCnt; i++) {
			System.out.println(result[i]);
		}
	}

	// nCr 값을 반환하는 메서드
	public static int combination(int n, int r) {
		if (n == r || r == 0)
			return 1;
		if (dp[n][r] > 0)
			return dp[n][r];

		dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
		return dp[n][r];
	}
}
