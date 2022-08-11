package practice;

import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 2500000; i++) {
            String newNumber = Generators.getRandomChar() +
                    Generators.getRandomInt(1, 999, 3) +
                    Generators.getRandomChar() +
                    Generators.getRandomChar() +
                    Generators.getRandomInt(1, 200);
            arrayList.add(newNumber);
        }
        return arrayList;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for (String item : list ) {
            if (item.equals(number)) return true;
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return Collections.binarySearch(sortedList, number) >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
