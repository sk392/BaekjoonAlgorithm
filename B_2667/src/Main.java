import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] resultValue;
	static int[][] inputValue;
	static int inputN = 0;
	static int cntAPT = 0;
	static int cnt=0;
	static Queue mainQueue = new LinkedList();
	static Queue resultQueue = new LinkedList();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		inputN = Integer.parseInt(sc.nextLine());
		if (inputN > 100)
			System.exit(999);

		inputValue = new int[inputN][inputN];
		resultValue = new int[inputN][inputN];
		String input;
		for (int i = 0; i < inputN; i++) {
			input = sc.nextLine();
			for (int j = 0; j < inputN; j++) {
				inputValue[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
			}
		}
		for (int i = 0; i < inputN; i++) {
			for (int j = 0; j < inputN; j++) {
				if(inputValue[i][j]==1){
					mainQueue.add(i + "/" + j);
					resultValue[i][j] = 0;
				}else{
					resultValue[i][j] = 999;					
				}
			}
		}
		int mainSize = mainQueue.size();
		for (int i = 0; i < mainSize; i++) {
			String tempData = (String) mainQueue.poll();
			int x = Integer.parseInt(tempData.split("/")[0]);
			int y = Integer.parseInt(tempData.split("/")[1]);
			if (resultValue[x][y] == 0) {
				// 체크하지 않은 좌표일 경우
				cnt =0;
				setCheck(x, y);
				resultQueue.add(cnt);
			}
		}
		
		
		int resultSize= resultQueue.size();
		int[] resultArray = new int[resultSize];
		for(int i=0;i<resultSize; i ++ ){
			resultArray[i] = (int)resultQueue.poll();
		}
		resultArray = sorting(resultArray);
		System.out.println(resultSize);
		for(int i=0;i<resultSize; i ++ ){
			System.out.println(resultArray[i]);
		}
	}

	static void setCheck(int x, int y) {
		
		resultValue[x][y] = 1;// 해당 셀을 체크해주고.
		cnt++;
		
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
	static int[] sorting(int[] inputArray){
		int mSize = inputArray.length;
		int[] mArray = inputArray;
		for(int i=0; i<mSize; i++){
			for(int j=0; j<mSize; j++){
				if(mArray[j]>mArray[i]){
					int temp=0;
					temp = mArray[i];
					mArray[i] = mArray[j];
					mArray[j] = temp;
				}
			}
		}
		return mArray;
	}

}
