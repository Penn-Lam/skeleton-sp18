public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int sum = 0;
        while (x < 9) {
            x += 1;
            sum = sum + x;
            System.out.print(sum + " ");
        }
    }
}