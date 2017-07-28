import java.util.Scanner;

public class Main {
	static int[] Dp = new int[31];
	static int[] result = new int[31];

	public static void main(String[] args) {
		int inputA;

		Scanner sc = new Scanner(System.in);
		inputA = sc.nextInt();
		if (inputA < 1 || inputA > 30 || inputA % 2 != 0) {
			System.exit(999);

		}

		Dp[0] = 1;
		result[0] = 1;
		Dp[2] = 3;
		for (int i = 4; i <= 30; i += 2)
			Dp[i] = 2;

		for (int i = 2; i <= inputA; i+=2){
	        for (int j = 2; j <= i; j += 2){
	            result[i] += Dp[j] * result[i - j];
	 
	        }
	    }
		System.out.println(result[inputA]);

	}

}
