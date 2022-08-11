public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    // смысла использовать модуль нет, минус в квадрате = плюс
    public static double getCircleSquare(double radius) {
        return Math.PI * radius * radius;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        return (4 * Math.PI * Math.pow(Math.abs(radius), 3)) / 3;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        return a + b > c && b + c > a && c + a > b;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (!isTrianglePossible(a, b, c)) {return -1.;}

        double p = (a + b + c) / 2; // полупериметр

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
