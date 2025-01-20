import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        String line = scanner.nextLine();

        String[] nums = line.split(" ");
        int[] numbers = Arrays.stream(nums).mapToInt(Integer::parseInt).toArray();

//        System.out.println(n);
//        System.out.println(Arrays.toString(numbers));
//        System.out.println(Junhyeon(n,numbers));
//        System.out.println(Sungmin(n,numbers));

        int junhyeon = Junhyeon(n, numbers);
        int sungmin = Sungmin(n, numbers);
        if(junhyeon == sungmin){
            System.out.println("SAMESAME");
        }else if(junhyeon > sungmin){
            System.out.println("BNP");
        }else if(junhyeon < sungmin){
            System.out.println("TIMING");
        }

    }

    public static int Junhyeon(int n, int[] numbers){
        int cash = n;
        int stock_cnt = 0;
        for(int i = 0; i < numbers.length; i++){
            if(cash>= numbers[i]){
                stock_cnt += cash/numbers[i];
                cash = cash%numbers[i];
            }
        }
        return cash + numbers[13]*stock_cnt;
    }

    public static int Sungmin(int n, int[] numbers){
        int cash = n;
        int stock_cnt = 0;

        for(int i = 3; i < numbers.length; i++){ //3일 연속 가격 상승 -> 전량 매도
            if(numbers[i-3] < numbers[i-2] && numbers[i-2] < numbers[i-1] && numbers[i-1] < numbers[i]){
                cash += stock_cnt * numbers[i];
                stock_cnt = 0;
            }else if(numbers[i-3] > numbers[i-2] && numbers[i-2] > numbers[i-1] && numbers[i-1] > numbers[i]){
                stock_cnt += cash/numbers[i];
                cash = cash%numbers[i];
            }
        }

        return cash + numbers[13]*stock_cnt;
    }
}