import java.util.Scanner;

public class IntToEng {
	// メインメソッド
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			int input = sc.nextInt();
			if(input<0) break; //0以下の数が入力されたならbreak
			
			System.out.println(translateEng(input));
		}
	}

	// 数値を英訳する変換するメソッド (0~999)
	static String translateEng(int n) {
		String s=""; //return用の文字

		String[] one= {"","one ","two ","three ","four ","five ","six ","seven ","eight ","nine "}; //1
		String[] teen= {"ten","eleven","twelve"};//10,11,12(特殊)
		String[] ten= {"","","twen","thir","four","fif","six","seven","eigh","nine"};//10
		
		if(n==0)  return "zero"; //nが0の場合 return 
		
		if(n/100 >0) s+=one[n/100] +"hundred ";//100の位

		//10の位
		if((n%100)/10 >0) {
			if(10<= n%100  && n%100< 20) {   //10~19の場合
				if(n%10 <3) s+=  teen[n%10]; //10~12の場合
				else  s+= ten[(n%100)%10 ]+"teen"; //13~19の場合
				
				return s;
			}
			else s+= ten[(n%100)/10 ]+"ty " ; //20~90の場合は10の位までを設定
		}
		
		//１の位
		s+=one[n%10];

		return s;
	}
}





























