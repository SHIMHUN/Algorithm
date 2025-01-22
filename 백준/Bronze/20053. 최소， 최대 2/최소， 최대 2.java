import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int n = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<n; i++){
//            int cnt = scanner.nextInt();
            int cnt = Integer.parseInt(scanner.nextLine());
            int max = -1000000;
            int min = 1000000;
            String s = scanner.nextLine();
            String[] nums = s.split(" ");

            for(int j=0; j<nums.length; j++){
                int num = Integer.parseInt(nums[j]);
                if(max < num){
                    max = num;
                }
                if(min > num){
                    min = num;
                }
            }
            System.out.println(min + " " + max);
        }
    }
}