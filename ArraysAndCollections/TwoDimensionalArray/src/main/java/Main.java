import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив
        char[][] array = TwoDimensionalArray.getTwoDimensionalArray(11);
        for (char[] item: array) {
            System.out.println(Arrays.toString(item));
        }
    }
}
