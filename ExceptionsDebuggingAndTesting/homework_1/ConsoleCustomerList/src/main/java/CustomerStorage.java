import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data){
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalFormatException("Неверный формат команды.");
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        if (!name.matches("([a-zA-Zа-яА-ЯёЁ -]+)")) {
            throw new IllegalNameException("Некорректное имя");
        }
        if (!components[3].matches("(\\s*)?(\\+)?([- ()]?\\d+[- ()]?){10,14}(\\s*)?")) {
            throw new IllegalPhoneException("Некорректный номер телефона");
        }
        if (!components[2].matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")) {
            try {
                throw new IllegalEmailException("Некорректный E-mail");
            } catch (IllegalEmailException e) {
                throw new RuntimeException(e);
            }
        }
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}