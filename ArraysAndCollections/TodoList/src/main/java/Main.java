import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();
    private static final String ERROR = "Запись не является набором команд...";

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        String command;
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        String withoutCommand;

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("0")) break;

            if (!input.matches("ADD((\\s)+[0-9]+)*((\\s)+([A-z0-9]+))+")
                    && !input.matches("(EDIT)((\\s)+[0-9]+(\\s)+([A-z0-9]+))+")
                    && !input.matches("(DELETE)(\\s)+([0-9]+)")
                    && !input.matches("^LIST$")
            ){
                System.out.println(ERROR);
                continue;
            }
            command = input.replaceAll("[^(ADD|EDIT|DELETE|LIST)]","");

            withoutCommand = input.replaceAll("^(ADD|EDIT|DELETE|LIST)","").trim();

            switch (command){
                case "ADD":
                    if (withoutCommand.matches("^[0-9]+((\\s)+([A-z0-9]+))+")){
                        index = Integer.parseInt(withoutCommand.replaceAll("[^(0-9)]",""));
                        todoList.add(index, withoutCommand.replaceAll("^[0-9]+","").trim());
                    }else {
                        todoList.add(withoutCommand);
                    }
                    break;
                case "DELETE":
                    if (!withoutCommand.matches("^[0-9]+$")){
                        System.out.println(ERROR);
                        continue;
                    }
                    todoList.delete(Integer.parseInt(withoutCommand));
                    break;
                case "EDIT":
                    index = Integer.parseInt(withoutCommand.replaceAll("[^(0-9)]",""));
                    todoList.edit(withoutCommand.replaceAll("^[0-9]+","").trim(),index);
                    break;
                case "LIST":
                    int counter = 0;
                    ArrayList<String> todo = todoList.getTodos();
                    for (String item : todo) {
                        System.out.println(counter++ + " - " + item);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
        }
    }
}
