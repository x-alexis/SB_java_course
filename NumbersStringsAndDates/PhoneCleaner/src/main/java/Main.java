import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    String tmp;
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      tmp = input.replaceAll("[^0-9]", "");

      if (tmp.matches("^(([0-9]{1,9})|([0-9]{12,})|((?!([7-8]))[0-9]{11}))$")){
        System.out.println("Неверный формат номера");
        continue;
      }
      if (tmp.length() == 10){
        System.out.println("7" + tmp);
        continue;
      }
      System.out.println("7" + tmp.substring(1));
    }
  }

}
