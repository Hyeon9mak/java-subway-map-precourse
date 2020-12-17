package subway.service;

import java.util.List;
import java.util.NoSuchElementException;
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
        StationService.validateStationRepositoryEmpty();
        String name = UserInput.getStationNameForDelete();
        Station station = StationService.getStationByName(name);
        StationService.validateContain(station);
        StationRepository.deleteStation(station);
        StationDisplay.printDeleteSuccess();
    }

    public static void validateStationRepositoryEmpty() {
        StationRepository.stations();
    }

    private static void validateContain(Station station) {
        if (SectionService.containByStationService(station)) {
            throw new IllegalArgumentException("노선에 포함된 역은 삭제 할 수 없습니다.");
        }
    }

    public static void print() {
        List<Station> stations = StationRepository.stations();
        StationDisplay.printStations(stations);
    }

    public static Station getStationByName(String name) {
        try {
            return StationRepository.stations().stream()
                .filter(s -> s.getName().equals(name))
                .findAny()
                .get();
        } catch (NoSuchElementException e){
            throw new IllegalArgumentException("등록되지 않은 역 입니다.");
        }
    }
}
