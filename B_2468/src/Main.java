import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] resultValue;
	static int[][] inputValue;
	static int inputN = 0;
	static int inputMax = 0;
	static int cntMax = 0;
	static Queue mainQueue = new LinkedList();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		inputN = sc.nextInt();
		if (inputN > 100)
			System.exit(999);

		inputValue = new int[inputN][inputN];
		resultValue = new int[inputN][inputN];

		for (int i = 0; i < inputN; i++) {
			for (int j = 0; j < inputN; j++) {
				int input = sc.nextInt();
				inputValue[i][j] = input;
				if (input > inputMax)
					inputMax = input;// 최고값 도출.
				if (input > 100)
					System.exit(999);

			}
		}

		for (int k = 0; k < inputMax; k++) {
			resultValue = new int[inputN][inputN];
			mainQueue = new LinkedList();
			for (int i = 0; i < inputN; i++) {
				for (int j = 0; j < inputN; j++) {

					if (k >= inputValue[i][j])
						resultValue[i][j] = 999;// 완전 블록처리
					else {
						resultValue[i][j] = 0;// 안전영역 처리
						mainQueue.add(i + "/" + j);
					}
				}
			} // resultValue 초기화

			int size = mainQueue.size();
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				String tempData = (String) mainQueue.poll();
				int x = Integer.parseInt(tempData.split("/")[0]);
				int y = Integer.parseInt(tempData.split("/")[1]);
				if (resultValue[x][y] == 0) {
					// 체크하지 않은 좌표일 경우
					setCheck(x, y);
					cnt++;
				}
			}
			if (cnt > cntMax)
				cntMax = cnt;
		} // Main for(k)

		System.out.println(cntMax);

	}

	static void setCheck(int x, int y) {

		resultValue[x][y] = 1;// 해당 셀을 체크해주고.
		if (x - 1 >= 0 && resultValue[x - 1][y] == 0) {
			setCheck(x - 1, y);
		}
		if (x + 1 < inputN && resultValue[x + 1][y] == 0) {
			setCheck(x + 1, y);
		}
		if (y - 1 >= 0 && resultValue[x][y - 1] == 0) {
			setCheck(x, y - 1);
		}
		if (y + 1 < inputN && resultValue[x][y + 1] == 0) {
			setCheck(x, y + 1);
		}

	}

}
