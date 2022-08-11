import java.util.Scanner;

public class Main {
    public static final int BOX_VOLUME = 27;
    public static final int CONTAINER_VOLUME = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strBoxes = scanner.nextLine();

        int boxes = Integer.parseInt(strBoxes);
        int truck = 0;
        int container = 0;
        for (int i = 1; i <= boxes; i++){
            if (i == 1 || (i - 1) % BOX_VOLUME == 0){
                container++;
                if (i == 1 || (container - 1) % CONTAINER_VOLUME == 0){
                    truck++;
                    System.out.println("Грузовик: " + truck);
                }
                System.out.println("\tКонтейнер: " + container);
            }
            System.out.println("\t\tЯщик: " + i);
        }
        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + truck + " шт.");
        System.out.println("контейнеров - " + container + " шт.");
    }

}
