public class Main {

    public static void main(String[] args) {
        String input = "<4008> 1234 <5678> 8912";
        String placeholder = "***";
        System.out.println(searchAndReplaceDiamonds(input, placeholder));

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        int beginIndx = 0;
        int lenStr = text.length();
        int charLess = 0;
        int charMore = 0;
        int tmp = 0;
        String newStr = "";

        while (beginIndx < lenStr){
            charLess = text.indexOf("<", beginIndx);
            charMore = text.indexOf(">", beginIndx);

            if (beginIndx == 0 && charLess == charMore && charLess == -1 || charLess > charMore){
                return text;
            }
            tmp = text.indexOf("<", charLess + 1);
            if (tmp < charMore && tmp != -1){
                return text;
            }
            if (beginIndx > 0 && charLess == charMore && charLess == -1){
                newStr += text.substring(beginIndx, lenStr);
                break;
            }
            newStr += text.substring(beginIndx, charLess);
            newStr += placeholder;
            beginIndx = charMore + 1;
        }
        return newStr;
    }
}