public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse (String[] strings){
        String tempString;
        for (int i = strings.length - 1, y = 0; i >= strings.length / 2 ; i--, y++) {
            tempString = strings[y];
            strings[y] = strings[i];
            strings[i] = tempString;
        }
        return strings;
    }
}
