import java.util.List;
import java.util.Scanner;

public class Main {
    private static final EmailList emailList = new EmailList();
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        String command;
        String withoutCommand;

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO: write code here
            if (!input.matches("ADD((\\s)+(.+))")
                    && !input.matches("^LIST$"))
            {
                System.out.println(WRONG_EMAIL_ANSWER);
                continue;
            }
            command = input.replaceAll("[^(ADD|LIST)]","");

            withoutCommand = input.replaceAll("^(ADD|LIST)","").trim();

            switch (command){
                case "ADD":
                    emailList.add(withoutCommand);
                    break;
                 case "LIST":
                    List<String> emails = emailList.getSortedEmails();
                    for (String item : emails) {
                        System.out.println(item);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }


        }
    }
}
