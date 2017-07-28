import java.util.ArrayList;
import java.util.Scanner;

public class Main1697 {
	static int resultCnt = 0;
	static int[] array = new int[100002];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int now, destination;
		now = sc.nextInt();// 현재 위치
		destination = sc.nextInt();// 목적지.
		if (now >= 0 && now <= 100000 && destination >= 0 && destination <= 100000) {
			if (now >= destination)
				System.out.println(destination - now);
			else {
				array[now] = 0;
				array[destination] = -1;
				getSearch(now, 0);
			}
		} else {
			System.exit(999);
		}

	}

	public static void getSearch(int mNow, int cnt) {
		int afterDestination = 0;
		// 너비 우선 탐색.
		if (mNow - 1 >= 0) {
			System.out.println((mNow-1)+"번째 : " + (cnt +1));
			if (array[mNow - 1] == -1) {
				System.out.println((cnt + 1));
				System.exit(999);
			} else if (array[mNow - 1] == 0) {
				array[mNow - 1] = (cnt + 1);
				getSearch(mNow - 1, cnt + 1);
			}
		}
		
		if(mNow + 1 <=100000){
			System.out.println((mNow+1)+"번째 : " + (cnt +1));
			if (array[mNow + 1] == -1) {
				System.out.println((cnt + 1));
				System.exit(999);
			} else if (array[mNow + 1] == 0) {
				array[mNow + 1] = (cnt + 1);
				getSearch(mNow + 1, cnt + 1);
			}
		}
		
		if(mNow * 2 <=100000){
			System.out.println((mNow*2)+"번째 : " + (cnt +1));
			if (array[mNow*2] == -1) {
				System.out.println((cnt + 1));
				System.exit(999);
			} else if (array[mNow*2] == 0) {
				array[mNow*2] = (cnt + 1);
				getSearch(mNow*2, cnt + 1);
			}
		}
	}

}
