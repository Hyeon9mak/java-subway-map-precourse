package subway.service;

import java.util.List;
import subway.domain.Line;
import subway.domain.Order;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.view.MainDisplay;
import subway.view.SectionDisplay;
import subway.view.UserInput;

public class SectionService {

    public static void insert() {
        Section section = SectionService
            .getSectionByLineName(UserInput.getLineNameForInsertSection());
        Station station = StationService
            .getStationByName(UserInput.getStationNameForInsertSection());
        Order order = Order.newOrder(UserInput.getOrderForInsert());
        section.insertStation(station, order);
        SectionDisplay.printInsertSuccess();
    }

    public static void delete() {
        Section section = SectionService.
            getSectionByLineName(UserInput.getLineNameForDeleteSection());
        Station station = StationService
            .getStationByName(UserInput.getStationNameForDeleteSection());
        section.deleteStation(station);
        SectionDisplay.printDeleteSuccess();
    }

    public static void print() {
        List<Section> sections = SectionRepository.sections();
        MainDisplay.printSections(sections);

    }

    public static void saveByLineService(Line line) {
        Station start = StationService.getStationByName(UserInput.getStationNameForStartStation());
        Station end = StationService.getStationByName(UserInput.getStationNameForEndStation());
        Section section = Section.newSectionWithLineStations(line, start, end);
        SectionRepository.addSection(section);
    }

    private static Section getSectionByLineName(String name) {
        return SectionRepository.sections().stream()
            .filter(s -> s.getLine().getName().equals(name))
            .findAny()
            .get();
    }

    public static boolean containByStationService(Station station) {
        return SectionRepository.sections().stream().anyMatch(s ->
            s.getStations().contains(station));
    }
}
