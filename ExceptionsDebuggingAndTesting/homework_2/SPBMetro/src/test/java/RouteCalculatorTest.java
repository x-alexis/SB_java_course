import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    /* Fantastic map of metro
    *                                               SolarSystem line:
    *                                                     Mercury
    *                                                       |
    *                                                     Venus
    *                                                       |
    * FruitAlley line: Apple - Cherry - Currant - Plum - Peach/Earth - Apricot - Bird cherry
    *                                                       |
    *                                                      Mars
    *                                                       |
    *                                                     Jupiter
    *                                                       |
    * SeaWay line: Shark - Sea-lion - Fish - Sea cow - Lobster/Saturn - Seal - Whale
    *                                                       |
    *                                                     Uranus
    * */
    StationIndex testStationIndex = new StationIndex();
    RouteCalculator testCalculator;

    @Override
    protected void setUp() {
        // создаем предполагаемую карту
        testStationIndex.addLine(new Line(1, "FruitAlley"));   // добавляем туда вновь созданные линии
        testStationIndex.addLine(new Line(2, "SeaWay"));
        testStationIndex.addLine(new Line(3, "SolarSystem"));

        String[][] stations = new String[][]{{"Apple", "Cherry", "Currant", "Plum", "Peach", "Apricot", "Bird cherry"},
                {"Shark", "Sea-lion", "Fish", "Sea cow", "Lobster", "Seal", "Whale"},
                {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus"}};// зададим названия станций двумерным массивом
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 7; column++) {        // добавляем созданные станции на карту
                testStationIndex.addStation(new Station(stations[row][column], testStationIndex.getLine(row + 1)));
                testStationIndex.getLine(row + 1).addStation(testStationIndex.getStation(stations[row][column]));
            }                                                   // их же добавляем линиям
        }
        List<Station> connectionOne = new ArrayList<>();        // 1-й переход
        connectionOne.add(testStationIndex.getStation("Peach"));
        connectionOne.add(testStationIndex.getStation("Earth"));
        List<Station> connectionTwo = new ArrayList<>();          // 2-й переход
        connectionTwo.add(testStationIndex.getStation("Lobster"));
        connectionTwo.add(testStationIndex.getStation("Saturn"));
        testStationIndex.addConnection(connectionOne);      // добавляем
        testStationIndex.addConnection(connectionTwo);

        testCalculator = new RouteCalculator(testStationIndex);
    }
    @Test
    public void testGetRouteOnTheLine() {                           // сравниваем маршруты без пересадок
        Station from = testStationIndex.getStation("Plum");
        Station to = testStationIndex.getStation("Bird cherry");
        List<Station> mustBe = buildRoute("Plum->Peach->Apricot->Bird cherry");
        List<Station> really = testCalculator.getShortestRoute(from, to);
        assertEquals(mustBe, really);
    }
    @Test
    public void testGetRouteWithOneConnection() {                   // сравниваем маршруты с одной пересадкой
        Station from = testStationIndex.getStation("Venus");
        Station to = testStationIndex.getStation("Bird cherry");
        List<Station> mustBe = buildRoute("Venus->Earth->Peach->Apricot->Bird cherry");
        List<Station> really = testCalculator.getShortestRoute(from, to);
        assertEquals(mustBe, really);
    }

    @Test
    public void testGetRouteWithTwoConnections() {                 // сравниваем маршруты с двумя пересадками
        Station from = testStationIndex.getStation("Plum");
        Station to = testStationIndex.getStation("Sea cow");
        List<Station> mustBe = buildRoute("Plum->Peach->Earth->Mars->Jupiter->Saturn->Lobster->Sea cow");
        List<Station> really = testCalculator.getShortestRoute(from, to);
        assertEquals(mustBe, really);
    }

    @Test
    public void testCalculateDurationOnLine() { // будем вычислять длительность для трёх вариантов построения маршрута
        Station from = testStationIndex.getStation("Plum");  // сперва маршрут на линии
        Station to = testStationIndex.getStation("Bird cherry");
        List<Station> route = testCalculator.getShortestRoute(from, to);  // мы уже убедились, чтиог методы работают правильно, так что долой ручное заполнение
        double mustBe = 7.5;
        double really = RouteCalculator.calculateDuration(route);
        assertEquals(mustBe, really);
    }

    @Test
    public void testCalculateDurationWithOneConnection() { // будем вычислять длительность для трёх вариантов построения маршрута
        Station from = testStationIndex.getStation("Venus");  // маршрут с пересадкой
        Station to = testStationIndex.getStation("Bird cherry");
        List<Station> route = testCalculator.getShortestRoute(from, to);  // мы уже убедились, чтиог методы работают правильно, так что долой ручное заполнение
        double mustBe = 11.0;
        double really = RouteCalculator.calculateDuration(route);
        assertEquals(mustBe, really);
    }
    @Test
    public void testCalculateDurationWithTwoConnection() { // будем вычислять длительность для трёх вариантов построения маршрута
        Station from = testStationIndex.getStation("Plum");  // маршрут с двумя пересадками
        Station to = testStationIndex.getStation("Sea cow");
        List<Station> route = testCalculator.getShortestRoute(from, to);  // мы уже убедились, чтиог методы работают правильно, так что долой ручное заполнение
        double mustBe = 19.5;
        double really = RouteCalculator.calculateDuration(route);
        assertEquals(mustBe, really);
    }

    @Test
    public void testCalculateDurationWithoutStation() {            // ну и обязательно стоит проверить случай совпадения исходной и конечной станций
        Station from = testStationIndex.getStation("Currant");
        Station to = testStationIndex.getStation("Currant");
        List<Station> route = testCalculator.getShortestRoute(from, to);  // мы уже убедились, чтиог методы работают правильно, так что долой ручное заполнение
        double mustBe = 0.0;
        double really = RouteCalculator.calculateDuration(route);
        assertEquals(mustBe, really);
    }

    private List<Station> buildRoute(String route) {
        String[] stations = route.split("->");
        List<Station> routeStation = new ArrayList<>();
        for (String station : stations) {
            routeStation.add(testStationIndex.getStation(station));
        }
        return routeStation;
    }
}
