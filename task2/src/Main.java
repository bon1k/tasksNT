import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static float x;
    static float y;
    static float centerX;
    static float centerY;
    static float radius;

    public static void main(String[] args) {
        try {
            String circleDataFile = args[0];
            String pointsDataFile = args[1];

            BufferedReader circleReader = new BufferedReader(new FileReader(circleDataFile));
            BufferedReader pointsReader = new BufferedReader(new FileReader(pointsDataFile));

            String[] circleTokens = circleReader.readLine().split(" ");
            centerX = Float.parseFloat(circleTokens[0]);
            centerY = Float.parseFloat(circleTokens[1]);
            String radiusToken = circleReader.readLine();
            radius = Float.parseFloat(radiusToken);

            String pointLine;
            while ((pointLine = pointsReader.readLine()) != null) {
                String[] pointTokens = pointLine.split(" ");
                x = Float.parseFloat(pointTokens[0]);
                y = Float.parseFloat(pointTokens[1]);

                float distance = (x - centerX) * (x - centerX) + (y - centerY) * (y - centerY);
                if (distance < radius * radius) {
                    System.out.println(1);
                } else if (distance > radius * radius) {
                    System.out.println(2);
                } else {
                    System.out.println(0);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}