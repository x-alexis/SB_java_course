import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine().trim();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

      int beginIndx = 0;
      int spaceIndx;
      int lenStr = input.length();

      if (isValid(input)) {
        beginIndx =0;
        spaceIndx = input.indexOf(" ", beginIndx);
        if (spaceIndx < 0) {spaceIndx = lenStr;}
        System.out.println("Фамилия: " + input.substring(beginIndx, spaceIndx).trim());

        beginIndx = spaceIndx + 1;
        spaceIndx = input.indexOf(" ", beginIndx);
        if (spaceIndx < 0) {spaceIndx = lenStr;}
        System.out.println("Имя: " + input.substring(beginIndx, spaceIndx).trim());

        beginIndx = spaceIndx + 1;
        spaceIndx = input.indexOf(" ", beginIndx);
        if (spaceIndx < 0) {spaceIndx = lenStr;}
        System.out.println("Отчество: " + input.substring(beginIndx, spaceIndx).trim());
      }else {
        System.out.println("Введенная строка не является ФИО");
      }
    }
  }

  private static boolean isValid(String input){
    int A = 'А';
    int ya = 'я';
    int def = '-';
    int space = ' ';
    int curChar;
    int error = 0;
    int spaceCount = 0;
    int beginIndx = 0;
    int lenStr = input.length();

    while (beginIndx < lenStr){
      curChar = input.charAt(beginIndx);
      if (curChar != def && curChar != space && (curChar <= A || curChar >= ya)){
        error++;
      }
      if (curChar == space){spaceCount++;};
      beginIndx++;
    }
    return error == 0 && spaceCount == 2;
  }

}