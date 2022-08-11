import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    String[] tmp;
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
      if (input.split("\\s").length != 3 || input.replaceAll("[^0-9]", "").length() > 0 ){
        System.out.println("Введенная строка не является ФИО");
      }else {
        tmp = input.replaceAll("[^А-я|\\-|\\s]", "").split("\\s");
        System.out.println("Фамилия: " + tmp[0]);
        System.out.println("Имя: " + tmp[1]);
        System.out.println("Отчество: " + tmp[2]);
      }
    }
  }

}