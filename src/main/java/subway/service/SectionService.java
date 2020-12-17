package subway.service;

import subway.domain.Line;
import subway.domain.Order;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.view.SectionDisplay;
import subway.view.UserInput;

public class SectionService {

    public static void insert() {
        Section section = SectionService.getSectionByLineName(UserInput.getLineNameForInsert());
        Station station = StationService.getStationByName(UserInput.getStationNameForInsert());
        Order order = Order.newOrder(UserInput.getOrderForInsert());
        section.insertStation(station, order);
        SectionDisplay.printInsertSuccess();
    }

    private static Section getSectionByLineName(String name) {
        return SectionRepository.sections().stream()
            .filter(s -> s.getLine().getName().equals(name))
            .findAny()
            .get();
    }

    public static void delete() {
    }

    public static void print() {
    }

    public static void saveByLineService(Line line) {
        Station start = StationService.getStationByName(UserInput.getStationNameForStart());
        Station end = StationService.getStationByName(UserInput.getStationNameForEnd());
        Section section = Section.newSectionWithLineStations(line, start, end);
        SectionRepository.addSection(section);
    }

    public static void printSections() {
    }
}
