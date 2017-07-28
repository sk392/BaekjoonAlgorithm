import java.util.Scanner;
//맞았다!!!!!!!!!!!!!!!!
public class Main {
	private static int nowInput=0;
	private static int inputA=0;	
	public static void main(String[] args) {
		long cnt;
		cnt = 0; // 결과 값
		initInput();
		long[] init = new long[10];
		getResult(inputA, init);

	}

	private static void initInput() {
		Scanner sc = new Scanner(System.in);
		inputA = sc.nextInt();
		if (!(inputA >= 1 && inputA <= 100))
			System.exit(999);
	}

	private static void getResult(int inputData, long[] before) {
		long[] now = new long[10];
			
		if (inputData == inputA) {
			--inputData;
			if(inputData ==0){
				System.out.println(9);
				System.exit(999);
			}
			
			for(int i=1; i<now.length; i++){
				now[i] = 1;				
			}
			getResult(inputData,now);
			
		} else {
			
			if(inputData ==0){
				int result =0;
				for(int i=0; i<before.length; i++){
				
					result += before[i];
					result = result %1000000000;
				}
				
				System.out.println(result);
				System.exit(999);
			}
			--inputData;

			for(int i=0; i<now.length; i++){
				if(i==0)
					now[i] =  before[i+1];
				else if(i==9)
					now[i] =  before[i-1];
				else
					now[i] = before[i-1] + before[i+1];
				now[i] = now[i] %1000000000;
			}
			getResult(inputData, now);

		}
	}
	
}
