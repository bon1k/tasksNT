import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] didgits = new int[0];
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(line));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                if (((line = reader.readLine()) == null)) {
                    break;
                }
                int num = Integer.parseInt(line);
                int[] temp = new int[didgits.length + 1];
                System.arraycopy(didgits, 0, temp, 0, didgits.length);
                temp[didgits.length] = num;
                didgits = temp;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        int sum = 0;
        for (int num : didgits) {
            sum += num;
        }
        int average = sum / didgits.length;
        int minStep = 0;
        for (int num : didgits) {
            minStep += Math.abs(num - average);
        }
        System.out.println(minStep);
    }
}