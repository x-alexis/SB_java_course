public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]
        char[][] result = new char[size][size];
        for (int i = 0, j = size-1; i < size; i++, j--) {
            for (int y = 0, e = size-1; y < size; y++, e--) {
                result[i][y] = ' ';
                result[i][j] = symbol;
                result[i][i] = symbol;
            }
        }

        return result;
    }
}
