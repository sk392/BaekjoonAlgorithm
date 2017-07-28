import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;// 결과값

		int inputN = sc.nextInt();//설탕 키로수
		if(inputN<3 || inputN>5000)
			System.exit(999);
		else{
			int number1 =inputN %10;
			if(number1==1 ||number1 ==6){
				if((inputN-6)%5 != 0 || (inputN-6)<0)
					result = -1;
				else
					result = 2 + (inputN-6)/5;
			}else if(number1==2 ||number1 ==7){
				if((inputN-12)%5 != 0 || (inputN-12)<0)
					result = -1;
				else
					result = 4 + (inputN-12)/5;
				
			}else if(number1==3 ||number1 ==8){
				if((inputN-3)%5 != 0 || (inputN-3)<0)
					result = -1;
				else
					result = 1 + (inputN-3)/5;
				
			}else if(number1==4 ||number1 ==9){
				if((inputN-9)%5 != 0 || (inputN-9)<0)
					result = -1;
				else
					result = 3 + (inputN-9)/5;
				
			}else{
				if((inputN)%5 != 0)
					result = -1;
				else
					result =(inputN)/5;
			}
			System.out.println(result);
		}
	}
}
