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
        
        // 桁数
        int digits = 0;
        int temp = n;
        while(temp > 0) {
            temp /= 10;
            digits++;
        }
         
        // int型の配列に入れる
        // numbers[0]に1の位, numbers[1]に10の位, numbers[2]に100の位...
        int[] numbers = new int[digits];
        for (int i = 0; i < digits; i++) {
            numbers[digits - i - 1] = (int) ((n % Math.pow(10, digits - i)) / Math.pow(10, digits - i -1));
        } 
        
        //nが0の場合 return
        if(n==0)  return "zero"; 
        
        //1000の位 && 1000の位が0を除く
        if(digits >= 4 && numbers[3] != 0) s+=one[numbers[3]] +"thousand ";

        //100の位 && 100の位が0を除く
        if(digits >= 3 && numbers[2] != 0) s+=one[numbers[2]] +"hundred ";

        //10の位 && 10の位が0を除く
        if(digits >= 2 && numbers[1] != 0) {
            if(numbers[1] == 1) {   //10~19の場合
                if(numbers[0] <3) s+=  teen[numbers[0]]; //10~12の場合
                else  s += ten[numbers[1]]+"teen"; //13~19の場合
                return s;
            }
            else s+= ten[numbers[1]]+"ty " ; //20~90の場合は10の位までを設定
        }

        //1の位
        s+=one[numbers[0]];

        return s;
    }
}