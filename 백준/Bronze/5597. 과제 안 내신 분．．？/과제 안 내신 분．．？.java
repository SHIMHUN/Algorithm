import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int[] arr = new int[31];

        for(int i=1; i<31; i++){
            arr[i] = 0;
        }

        for(int i=0; i<28; i++){
            int num = scanner.nextInt();
            arr[num] = num;
        }

//        for(int i=1; i<31; i++){
//            System.out.println(arr[i]);
//        }

        int a = 0;
        int b = 0;
        for(int i=1; i<31; i++){
            if(a == 0 && arr[i] == 0){
                a = i;
            }else if(b == 0 && arr[i] == 0){
                b = i;
            }
        }

        System.out.println(a);
        System.out.println(b);
    }
}