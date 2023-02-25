import java.util.Scanner;
import org.apache.logging.log4j.*;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final Marker INPUT_QUERIES = MarkerManager.getMarker("INPUT_QUERIES");
    private static final Marker IS_ERRORS = MarkerManager.getMarker("IS_ERRORS");

    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            logger.info(INPUT_QUERIES, "Call command: " + command);
            String[] tokens = command.split("\\s+", 2);

            if (tokens[0].equals("add")) {
                try {
                    executor.addCustomer(tokens[1]);
                } catch (Exception e){
                    logger.error(IS_ERRORS, "Wrong command! " + command, e);
                }
            } else if (tokens[0].equals("list")) {
                executor.listCustomers();
            } else if (tokens[0].equals("remove")) {
                try {
                    executor.removeCustomer(tokens[1]);
                } catch (Exception e){
                    System.out.println("Wrong command! " + command);
                    logger.error(IS_ERRORS, "Wrong command! " + command, e);
                }
            } else if (tokens[0].equals("count")) {
                System.out.println("There are " + executor.getCount() + " customers");
            } else if (tokens[0].equals("help")) {
                System.out.println(helpText);
            } else {
               System.out.println("Wrong command! " + command);
            }
        }
    }
}
