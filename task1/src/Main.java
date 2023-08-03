import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] startArray = IntStream.iterate(1, i -> i + 1).limit(n).toArray();
        int index = 0;
        do {
            System.out.print(startArray[index]);
            index = (index + m - 1) % n;
        } while (index != 0);
    }
}