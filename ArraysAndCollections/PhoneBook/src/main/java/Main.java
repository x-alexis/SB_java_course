import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    private static final PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        while (true) {
            String input = Request("Введите номер, имя или команду:");
            if (input.matches("^LIST$")){
                for (String item: phoneBook.getAllContacts()) {
                    System.out.println(item);
                }
            }else if (Check.checkName(input)){
                TreeSet<String> treeSet = (TreeSet<String>) phoneBook.getContactByName(input);
                if (treeSet.size() > 0) for (String item: treeSet) System.out.println(item);
                else {
                    String inputNumber = Request("Такого имени нет в телефонной книге.\n" +
                            "Введите номер для абонента \"" + input + "\":");
                    if(Check.checkPhone(inputNumber)){
                        phoneBook.addContact(inputNumber, input);
                        System.out.println("Контакт сохранён!");
                    }
                };
            }else if (Check.checkPhone(input)){
                String set = phoneBook.getContactByPhone(input);
                if (set.length() > 0) System.out.println(set);
                else {
                    String inputName = Request("Такого номера нет в телефонной книге.\n" +
                            "Введите имя абонента для номера \"" + input + "\":");
                    if(Check.checkName(inputName)){
                        phoneBook.addContact(input, inputName);
                        System.out.println("Контакт сохранён!");
                    }
                };
            }else System.out.println("Не верный ввод.");
        }
    }
    public static String Request(String what){
        System.out.println(what);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
