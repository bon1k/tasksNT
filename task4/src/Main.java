import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] didgits = new int[0];
        String arrayDataFile = args[0];

        BufferedReader arrayReader = new BufferedReader(new FileReader(arrayDataFile));
        String arrayLine;
        while ((arrayLine = arrayReader.readLine()) != null) {

            int num = Integer.parseInt(arrayLine);
            int[] temp = new int[didgits.length + 1];
            System.arraycopy(didgits, 0, temp, 0, didgits.length);
            temp[didgits.length] = num;
            didgits = temp;
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