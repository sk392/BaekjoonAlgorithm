import java.util.ArrayList;
import java.util.Scanner;

public class Main2922 {
	static ArrayList<Integer[]> resultArray = new ArrayList<>();
	static String[] input;
	static int pointCnt = 0;
	static int result = 0;
	static int[] points = new int[10];// 각 언더바 포지션
	static boolean[][] able = new boolean[11][2];// 0에는 모음가능, 1에는 자음가능.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Integer[] cntArray = {0,0};//0엔 모음, 1엔 자음
		input = sc.nextLine().split("");
		if(input.length>100)
			System.exit(999);
		// 언더바 위치 및 무게 값 초기화
		for (int i = 0; i < 10; i++) {
			points[i] = -1;
		}
		// 언더바 위치 추출
		for (int i = 0; i < input.length; i++) {
//			System.out.println(i + " // "+input[i]);
			if (input[i].equals("_")) {
				points[pointCnt] = i;
				pointCnt++;
				
				if(pointCnt>10)
					System.exit(999);
			}
		}
	//	System.out.println(pointCnt);
/*		for(int i=0; i<pointCnt;i++){
			System.out.println(points[i]);
		}
*/
		getCnt(0, input, able,cntArray);
/*		for(int i=0; i<pointCnt;i++){
			able =getAble(i, points[i], input, able);
		}
*/		
		/*for(int i=0; i<resultArray.size();i++){
			System.out.println(resultArray.get(i)[0]+" / "+ resultArray.get(i)[1]);
		}*/
/*		for(int i=0; i<10;i++){
			System.out.print(able[i][0]+" / "+ able[i][1]);
			System.out.println("");
		}
*/		System.out.println(result);

	}

	public static void getCnt(int mPosition,  String[] mInput, boolean[][] mAble,Integer[] mCntArray) {
		
		// 21 or 5 or 26
		mAble = getAble(mPosition, points[mPosition], mInput, mAble);
//		for(int i=0; i<mAble.length;i++)
//			System.out.println("Postion = "+mPosition+"points = "+points[mPosition]+mAble[mPosition][0] +" / " + mAble[mPosition][1]);
		if (mAble[mPosition][0]) {
			// 모음이 가능하다면 재귀함수로 다음 포인트를 부름
			if (mPosition == pointCnt - 1) {
				// 마지막인 경우
				for(int i=0; i<10;i++){
					System.out.print(mAble[i][0]+" / "+ mAble[i][1] + " /// ");
				}
				System.out.println("");
				for (int i = 0; i < mInput.length; i++)
					if (mInput[i].equals("L")){
						mCntArray[0]++;
						mCntArray[1]--;
						resultArray.add(mCntArray);
						break;
					}
				

			} else {
				mInput[points[mPosition]] = "A";
				mCntArray[0]++;
				getCnt(mPosition + 1, mInput, mAble,mCntArray);

			}

		}
		if (mAble[mPosition][1]) {
			// 자음이 가능하다면 재귀함수로 다음 포인트를 부름
			if (mPosition == pointCnt - 1) {
				// 마지막인 경우
				resultArray.add(mCntArray);
				for(int i=0; i<10;i++){
					System.out.print(mAble[i][0]+" / "+ mAble[i][1]+ " /// ");
					
				}
				System.out.println("");
				
			} else {
				mInput[points[mPosition]] = "L";
				getCnt(mPosition + 1, mInput, mAble,mCntArray);

			}
		}
		
	}

	// pointsPostion은 언더바의 위치 값(최대 10개중에 몇 번째 언더바인지
	// inputPosition은 언더바의 인풋의 위치값 (n번째 언더바가 몇에 위치해 있는지.
	public static boolean[][] getAble(int pointsPosition, int inputPosition, String[] mInput, boolean[][] mAble) {
		boolean isVowel = true, isConsonant = true;// 해당 자리에 모음 및 자음ㅇ ㅣ가능한지.

		int startPosition = inputPosition - 2;
		if (inputPosition - 2 < 0)
			startPosition = inputPosition - 1;
		if (inputPosition - 1 < 0)
			startPosition = inputPosition;

		for (int i = startPosition; i <= inputPosition; i++) {

			int cntVowel = 0, cntConsonant = 0;
			if (i < mInput.length - 2) {
				for (int j = i; j <= i + 2; j++) {
					// System.out.println("i = "+i + "startPosition =
					// "+startPosition + "inputPosition = "+inputPosition +"j =
					// "+j );
					if (isVowel(mInput[j]) == 1)
						cntConsonant++;
					else if (isVowel(mInput[j]) == 0)
						cntVowel++;

				}
				cntConsonant++;
				cntVowel++;
				if (cntConsonant == 3)
					isConsonant = false;
				if (cntVowel == 3)
					isVowel = false;
			}
		}
		mAble[pointsPosition][0] = isVowel;
		mAble[pointsPosition][1] = isConsonant;
		return mAble;
	}

	// 모음인지 판단, 0면 모음/1 자음/2 언더바
	public static int isVowel(String mInput) {
		String[] vowelArray = { "A", "E", "I", "O", "U" };
		if (mInput.equals("_"))
			return 2;

		// 모음인지 판단.
		for (int i = 0; i < vowelArray.length; i++) {
			if (mInput.equals(vowelArray[i]))
				return 0;
		}
		return 1;
	}

}
