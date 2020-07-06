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

		String re=""; //return用
		
		if(n<0) {
			re+="minus ";
			n=Math.abs(n);
		}
		
		//1,000,000,000 
		if(n/1000000000 >0) re+=hundTenOne(n/1000000000)+"billion ";

		//1,000,000
		if((n%1000000000)/1000000 >0) {
			if(n/1000000000 >0) re+="and ";
			re+=hundTenOne((n%1000000000)/1000000)+"million ";
		}

		//1000~1,000,000未満
		if((n%1000000)/1000 >0) {
			if(n/1000000 >0) re+="and ";
			re+=hundTenOne((n%1000000)/1000)+"thousand ";
		}

		//1000未満
		if(n%1000>0) {
			if(n/1000>0) re+="and ";
			re+=hundTenOne(n%1000);
		}
		
		return re;
	}

	//(追加)　100,10、1の位を設定するメソッド
	static String hundTenOne(int n) {
		String re="";//return用

		String[] one= {"","one ","two ","three ","four ","five ","six ","seven ","eight ","nine "}; //1
		String[] teen= {"ten ","eleven ","twelve "};//10,11,12(特殊な数え方)
		String[] ten= {"","","twen","thir","four","fif","six","seven","eigh","nine"};//10
		
		if(n/100 >0) {
			re+=one[n/100] +"hundred ";
		//	if(n%100>0)  re+="and ";
		}
		
		
		//10の位
		if((n%100)/10 >0) {
			
			if(10<= n%100  && n%100< 20) {   //10~19の場合
				if(n%10 <3) re+=  teen[n%10]; //10~12の場合
				else  re+= ten[(n%100)%10 ]+"teen "; //13~19の場合
				
				return re;
			}
			else re+= ten[(n%100)/10 ]+"ty " ; //20~90の場合は10の位までを設定
		}
		
		//１の位
		re+=one[n%10];

		return re;
	}
}





























