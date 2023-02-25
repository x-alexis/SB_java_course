import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ok");

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalTime().isBefore(LocalTime.now().plusHours(2)))
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE)
                .collect(Collectors.toList());
    }

}
