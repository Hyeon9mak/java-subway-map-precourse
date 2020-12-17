package subway.service;

import java.util.List;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.StationDisplay;
import subway.view.UserInput;

public class StationService {

    public static void save() {
        String name = UserInput.getStationNameForSave();
        Station station = Station.newStationWithName(name);
        StationRepository.addStation(station);
        StationDisplay.printSaveSuccess();
    }

    public static void delete() {
    }

    public static void print() {
        List<Station> stations = StationRepository.stations();
        StationDisplay.printStations(stations);
    }

    public static Station getStationByName(String name) {
        return StationRepository.stations().stream()
            .filter(s->s.getName().equals(name))
            .findAny()
            .get();
    }
}
