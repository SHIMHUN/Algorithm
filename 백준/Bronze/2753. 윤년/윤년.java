import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        if(n%4 == 0 && (n % 100 != 0 || n% 400 == 0)){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
}