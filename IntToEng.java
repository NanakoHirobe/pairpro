import java.util.Scanner;

public class IntToEng {
    // ���C�����\�b�h
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(;;) {
            int input = sc.nextInt();
            if(input<0) break; //0�ȉ��̐������͂��ꂽ�Ȃ�break

            System.out.println(translateEng(input));
        }
    }

    // ���l���p�󂷂�ϊ����郁�\�b�h (0~999)
    static String translateEng(int n) {
        String s=""; //return�p�̕���

        String[] one= {"","one ","two ","three ","four ","five ","six ","seven ","eight ","nine "}; //1
        String[] teen= {"ten","eleven","twelve"};//10,11,12(����)
        String[] ten= {"","","twen","thir","four","fif","six","seven","eigh","nine"};//10
        
        // ����
        int digits = 0;
        int temp = n;
        while(temp > 0) {
            temp /= 10;
            digits++;
        }
         
        // int�^�̔z��ɓ����
        // numbers[0]��1�̈�, numbers[1]��10�̈�, numbers[2]��100�̈�...
        int[] numbers = new int[digits];
        for (int i = 0; i < digits; i++) {
            numbers[digits - i - 1] = (int) ((n % Math.pow(10, digits - i)) / Math.pow(10, digits - i -1));
        } 
        
        //n��0�̏ꍇ return
        if(n==0)  return "zero"; 
        
        //1000�̈� && 1000�̈ʂ�0������
        if(digits >= 4 && numbers[3] != 0) s+=one[numbers[3]] +"thousand ";

        //100�̈� && 100�̈ʂ�0������
        if(digits >= 3 && numbers[2] != 0) s+=one[numbers[2]] +"hundred ";

        //10�̈� && 10�̈ʂ�0������
        if(digits >= 2 && numbers[1] != 0) {
            if(numbers[1] == 1) {   //10~19�̏ꍇ
                if(numbers[0] <3) s+=  teen[numbers[0]]; //10~12�̏ꍇ
                else  s += ten[numbers[1]]+"teen"; //13~19�̏ꍇ
                return s;
            }
            else s+= ten[numbers[1]]+"ty " ; //20~90�̏ꍇ��10�̈ʂ܂ł�ݒ�
        }

        //1�̈�
        s+=one[numbers[0]];

        return s;
    }
}