import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int[] startArray = IntStream.iterate(1, i -> i + 1).limit(n).toArray();
        int index = 0;
        do {
            System.out.print(startArray[index]);
            index = (index + m - 1) % n;
        } while (index != 0);
    }
}