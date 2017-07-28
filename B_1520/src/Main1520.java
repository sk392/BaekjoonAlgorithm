
import java.util.Scanner;

public class Main1520 {
	static int[] inputA = new int[2];
	static int[][] inputB;
	static int[][] resultB;
	static int cnt = 0;
	static boolean isRun = true;

	public static void main(String[] args) {
		initInput();
		run(inputA[0]-1, inputA[1]-1);
		System.out.println(resultB[inputA[0]-1][inputA[1]-1]);
		
		/*for(int i=0; i<inputA[0]; i++){
			for(int j=0; j<inputA[1]; j++){
				System.out.print(resultB[i][j]+" ");
			}
			System.out.println("");
		}*/

	}

	private static int initInput() {

		Scanner sc = new Scanner(System.in);
		inputA[0] = sc.nextInt(); // 테스트 케이스
		inputA[1] = sc.nextInt(); // 테스트 케이스
		if (inputA[0] <= 500 && inputA[1] <= 500 && inputA[0] > 0 && inputA[1] > 0) {
			inputB = new int[inputA[0]][inputA[1]];
			resultB = new int[inputA[0]][inputA[1]];
			for (int i = 0; i < inputA[0]; i++) {
				for (int j = 0; j < inputA[1]; j++) {
					inputB[i][j] = sc.nextInt();
					if (inputB[i][j] > 10000 || inputB[i][j] <= 0) {
						System.out.println("인풋에러!");
						System.exit(999);
						return 0;
					}
					resultB[i][j] = -1;
				}
			}
		} else {
			System.out.println("인풋에러!");
			System.exit(999);
		}
		return 0;
	}

	private static int run(int x, int y) {
		int now = inputB[x][y];
		int result =0;
		if(x>=0 && y>=0){
			if(x-1>=0 && inputB[x-1][y]> now){
				cnt++;
				if(resultB[x-1][y]==-1)
					result+= run(x-1,y);
				else
					result +=resultB[x-1][y];
			}

			if(x+1<inputA[0] && inputB[x+1][y]> now){
				cnt++;
				if(resultB[x+1][y]==-1)
					result+= run(x+1,y);
				else
					result +=resultB[x+1][y];
			}
			
			if( y-1>=0 && inputB[x][y-1]> now){
				cnt++;
				if(resultB[x][y-1]==-1)
					result+= run(x,y-1);
				else
					result +=resultB[x][y-1];
			}

			if( y+1<inputA[1] && inputB[x][y+1]> now){
				cnt++;
				if(resultB[x][y+1]==-1)
					result+= run(x,y+1);
				else
					result +=resultB[x][y+1];
			}
			if(x==0&&y==0){
				cnt++;
				result =1;
			}
		}
		resultB[x][y] = result;
		return result;
	}

}
