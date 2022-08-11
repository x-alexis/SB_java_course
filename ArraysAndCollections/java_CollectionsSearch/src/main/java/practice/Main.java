package practice;

import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */
    public static void main(String[] args) {
        List<String> list = CoolNumbers.generateCoolNumbers();

        String searchResult;
        while (true){
            System.out.println("Введите номер для поиска");
            Scanner input = new Scanner(System.in);
            String stringForFind = input.nextLine();

            long start = System.nanoTime();
            if (CoolNumbers.bruteForceSearchInList(list, stringForFind)) {
                searchResult = "найден";
            } else {
                searchResult = "не найден";
            }
            long duration = System.nanoTime() - start;
            System.out.println("Поиск перебором: номер " + searchResult + ", поиск занял " + duration + " нс");

            Collections.sort(list);

            start = System.nanoTime();
            if (CoolNumbers.binarySearchInList(list, stringForFind)) {
                searchResult = "найден";
            } else {
                searchResult = "не найден";
            }
            duration = System.nanoTime() - start;
            System.out.println("Бинарный поиск: номер " + searchResult + ", поиск занял " + duration + " нс");

            start = System.nanoTime();
            if (CoolNumbers.searchInHashSet(new HashSet<>(list), stringForFind)) {
                searchResult = "найден";
            } else {
                searchResult = "не найден";
            }
            duration = System.nanoTime() - start;
            System.out.println("Поиск в HashSet: номер " + searchResult + ", поиск занял " + duration + " нс");

            start = System.nanoTime();
            if (CoolNumbers.searchInTreeSet(new TreeSet<>(list), stringForFind)) {
                searchResult = "найден";
            } else {
                searchResult = "не найден";
            }
            duration = System.nanoTime() - start;
            System.out.println("Поиск в TreeSet: номер " + searchResult + ", поиск занял " + duration + " нс");
        }
    }
}
