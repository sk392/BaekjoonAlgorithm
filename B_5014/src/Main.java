import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int inputF = 0;
	static boolean isMinus = false;
	static int resultN = 0;
	static int inputStart = 0;
	static int inputGoal = 0;
	static int inputUp = 0;
	static int inputDown = 0;
	static boolean[] isArray;
	static Queue mainQueue = new LinkedList();
	static Queue resultQueue = new LinkedList();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		inputF = sc.nextInt();
		inputStart = sc.nextInt();
		inputGoal = sc.nextInt();
		inputUp = sc.nextInt();
		inputDown = sc.nextInt();
		isArray = new boolean[inputF+1];
		for (int i = 1; i < inputF+1; i++) {
			isArray[i] = false;
		}

		mainQueue.add(inputStart + "/" + 0);
		startGoal();
	}

	static void startGoal() {

		while (!mainQueue.isEmpty()) {
			String tempData = (String) mainQueue.poll();
			int mFloor = Integer.parseInt(tempData.split("/")[0]);
			int mCnt = Integer.parseInt(tempData.split("/")[1]);

			if (mFloor == inputGoal) {
				System.out.println(mCnt);
				System.exit(999);
			} else {
				if (mFloor + inputUp <= inputF && isArray[mFloor + inputUp] == false) {
					isArray[mFloor + inputUp] = true;
					mainQueue.add((mFloor + inputUp) + "/" + (mCnt + 1));
				}
				if (mFloor - inputDown >= 1 && isArray[mFloor - inputDown] == false) {
					isArray[mFloor - inputDown] = true;
					mainQueue.add((mFloor - inputDown) + "/" + (mCnt + 1));
				}
			}
		}

		System.out.println("use the stairs");
		
	}

}