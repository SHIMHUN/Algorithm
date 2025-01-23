import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i=1; i<n+1; i++){
            for(int j=0; j<n-i; j++){
                System.out.print(" ");
            }
            for(int z=n-i; z<n; z++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}