import java.util.*;

public class PhoneBook {
    private final HashMap<String, String> phoneBook = new HashMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона (отдельные методы для проверки)
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (Check.checkPhone(phone) && Check.checkName(name)){
            phoneBook.put(phone, name);
        }
    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        if (Check.checkPhone(phone)&&phoneBook.containsKey(phone)){
            return phoneBook.get(phone) + " - " + phone;
        }
        return "";
    }

    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        TreeSet<String> treeSet = new TreeSet<>();
        if (Check.checkName(name) && phoneBook.containsValue(name)){
            phoneBook.forEach((key, value) -> {
                if (value.equals(name)) treeSet.add(value + " - " + key);
                    });
            return treeSet;
        }
        return new TreeSet<>();
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        HashMap<String, String> newPhone = new HashMap<>();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()){
            String newValue = entry.getKey();   // получения ключа
            String newKey   = entry.getValue(); // получения значения
            if (newPhone.containsKey(newKey)) newPhone.put(newKey, newPhone.get(newKey) + ", " + newValue);
            else newPhone.put(newKey, newValue);
        }
        for (Map.Entry<String, String> entry : newPhone.entrySet()){
            String key = entry.getKey();        // получения ключа
            String value   = entry.getValue();  // получения значения
            treeSet.add(key + " - " + value);
        }

        return treeSet;
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
   /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}