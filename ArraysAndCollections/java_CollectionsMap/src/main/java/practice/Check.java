package practice;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Check {
    private static Pattern phoneText = Pattern.compile("7[0-9]{10}");       //шаблон для телефона
    private static Pattern nameText = Pattern.compile("([a-zA-Zа-яА-Я]+)"); //шаблон для имени

    public static boolean checkName(String input)
    {
        Matcher nameMatcher = nameText.matcher(input);
        return nameMatcher.find() && !nameMatcher.group().isEmpty();
    }

    public static boolean checkPhone(String input) {
        Matcher nameMatcher = phoneText.matcher(input);
        return nameMatcher.find() && !nameMatcher.group().isEmpty();
    }
}
