import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(); // 출력 최적화를 위한 StringBuilder

        int n = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<n; i++){
            int cnt = Integer.parseInt(scanner.nextLine());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
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
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
    }
}