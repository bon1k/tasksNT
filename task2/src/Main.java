import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static float x;
    static float y;
    static float centerX;
    static float centerY;
    static float radius;

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            File file = new File(scanner.nextLine());
            scanner = new Scanner(file);

            while (scanner.hasNextFloat()) {
                centerX = scanner.nextFloat();
                centerY = scanner.nextFloat();
                radius = scanner.nextFloat();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Scanner scanner2 = new Scanner(System.in);
            File file = new File(scanner2.nextLine());
            scanner2 = new Scanner(file);

            while (scanner2.hasNextFloat()) {
                x = scanner2.nextFloat();
                y = scanner2.nextFloat();

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
        }
    }
}