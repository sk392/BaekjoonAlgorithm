import java.math.BigInteger;
import java.util.Scanner;
//예린이 문제풀이
public class Combination {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      Scanner scan = new Scanner(System.in);
      int r = scan.nextInt();
      Scanner scan2 = new Scanner(System.in);
      int n= scan2.nextInt();

      BigInteger sum = new BigInteger("1");
      BigInteger num = new BigInteger("1");
      
      for(int a=r; a>=1; a--) {
         sum = sum.multiply(BigInteger.valueOf(n));   
         --n;
      }
      
      for(int b=r; b>=1; b--) {
         num = num.multiply(BigInteger.valueOf(b));
         }
      BigInteger answer = sum.divide(num);
      System.out.println(answer);
   }
   

}