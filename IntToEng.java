import java.util.Scanner;

public class IntToEng {
	// メインメソッド
	public static void main(String[] args) {
		System.out.println("put number (-2,147,483,647 ~ 2,147,483,647)");
		Scanner sc = new Scanner(System.in);
		for(;;) {
			int input = sc.nextInt();
			System.out.println(translateEng(input));
		}
	}

	// 数値を英訳する変換するメソッド
	static String translateEng(int n) {
		if(n==0)  return "zero"; //nが0の場合 return 

		String s=""; //return用
		
		//0以下の数
		if(n<0) {
			s+="minus ";
			n=Math.abs(n);
		}
		
		//1,000,000,000 
		if(n/1000000000 >0) s+=hundTenOne(n/1000000000)+"billion ";

		//1,000,000
		if((n%1000000000)/1000000 >0) {
			if(n/1000000000 >0) s+="and ";
		s+=hundTenOne((n%1000000000)/1000000)+"million ";
		}

		//1000
		if((n%1000000)/1000 >0) {
			if(n/1000000 >0) s+="and ";
			s+=hundTenOne((n%1000000)/1000)+"thousand ";
		}

		//1000未満
		if(n%1000>0) {
			if(n/1000>0) s+="and ";
			s+=hundTenOne(n%1000);
		}
		
		return s;
	}

	//(追加)　100,10、1の位を設定するメソッド
	static String hundTenOne(int n) {
		String s="";//return用の文字

		String[] one= {"","one ","two ","three ","four ","five ","six ","seven ","eight ","nine "}; //1
		String[] teen= {"ten ","eleven ","twelve "};//10,11,12(特殊な数え方)
		String[] ten= {"","","twen","thir","four","fif","six","seven","eigh","nine"};//10
		
		//100の位
		if(n/100 >0) s+=one[n/100] +"hundred ";
		
		//10の位
		if((n%100)/10 >0) {
			if(10<= n%100  && n%100< 20) {   //10~19の場合
				if(n%10 <3) s+=  teen[n%10]; //10~12の場合
				else  s+= ten[(n%100)%10 ]+"teen "; //13~19の場合
				
				return s;
			}
			else s+= ten[(n%100)/10 ]+"ty " ; //20~90の場合は10の位までを設定
		}
		
		//１の位
		s+=one[n%10];

		return s;
	}
}





























