import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	static long[][] resultValue = new long[2500][3];
	static long[][] inputValue = new long[2500][2];
	static int cnt = 0;
	static boolean isAble = false;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		cnt = sc.nextInt();

		
		TreeMap<String, Integer> tmap = new TreeMap<String, Integer>();
	      

	      //100000010000000  1 2 3 4 
		if (cnt >= 1 && cnt <= 2500) {
			for (int i = 0; i < cnt; i++) {
				long inputA = sc.nextInt();
				long inputB = sc.nextInt();
				if (inputA >= -1000000 && inputA <= 1000000 && inputB >= -1000000 && inputB <= 1000000) {
					resultValue[i][0] = inputA + inputB;
					resultValue[i][1] = inputA - inputB;
					resultValue[i][2] = inputA * inputB;
					inputValue[i][0] = inputA;
					inputValue[i][1] = inputB;
					if(tmap.containsKey(inputA + "_"+inputB)){
						
						tmap.put(inputA + "_"+inputB, tmap.get(inputA + "_"+inputB)+1);
						if(tmap.get(inputA + "_"+inputB)>=4){
							System.out.println("impossible");
							System.exit(0);
						}
					}else{
						tmap.put(inputA + "_"+inputB,1);
						
					}
				} else {
					System.exit(0);
				}

			}

			String[][] strArray = new String[2500][2];// 0은 값, 1은 연산자.
			getResult(strArray, 0);
			System.out.println("impossible");
		} else {
			System.exit(0);
		}
	}

	static void getResult(String[][] array, int index) {
		for (int j = 0; j < 3; j++) {
			boolean is = true;
			for (int i = 0; i < index; i++) {
				if (array[i][0].equals(resultValue[index][j] + "")) {//set
					is = false;
					break;
				}
			}
			if (is) {
				String[][] mArray = array;
				mArray[index][0] = resultValue[index][j] + "";
				String X = "";// 연산자;
				if (j == 0)
					X = "+";
				if (j == 1)
					X = "-";
				if (j == 2)
					X = "*";
				
				mArray[index][1] = X;
				if (index == cnt - 1) {
					for (int i = 0; i < cnt; i++) {
						System.out.println(inputValue[i][0] + " " + mArray[i][1] + " " + inputValue[i][1] + " = " + mArray[i][0]);
					}
					System.exit(0);
				} else {
					getResult(mArray, index + 1);
				}
			}

		}

	}

}
