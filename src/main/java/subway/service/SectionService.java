package subway.service;

import java.util.List;
import java.util.NoSuchElementException;
import subway.domain.Line;
import subway.domain.Order;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.view.MainDisplay;
import subway.view.SectionDisplay;
import subway.view.UserInput;

public class SectionService {

    private static final int NOT_ENOUGH_STATIONS = 2;

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
        SectionService.validateEnoughStations(section);
        Station station = StationService
            .getStationByName(UserInput.getStationNameForDeleteSection());
        section.deleteStation(station);
        SectionDisplay.printDeleteSuccess();
    }

    private static void validateEnoughStations(Section section) {
        if (section.getStations().size() <= NOT_ENOUGH_STATIONS) {
            throw new IllegalArgumentException("노선에 등록된 지하철 역이 2개 이하이므로 삭제가 불가능 합니다.");
        }
    }

    public static void print() {
        try {
            List<Section> sections = SectionRepository.sections();
            SectionService.validateSectionsEmpty(sections);
            MainDisplay.printSections(sections);
        } catch (IllegalArgumentException e){
            MainDisplay.printError(e.getMessage());
        }
    }

    private static void validateSectionsEmpty(List<Section> sections) {
        if (sections.isEmpty()) {
            throw new IllegalArgumentException("지하철 노선도 목록이 비어있습니다.");
        }
    }

    public static void saveByLineService(Line line) {
        Station start = StationService.getStationByName(UserInput.getStationNameForStartStation());
        Station end = StationService.getStationByName(UserInput.getStationNameForEndStation());
        Section section = Section.newSectionWithLineStations(line, start, end);
        SectionRepository.addSection(section);
    }

    public static void deleteByLineService(Line line) {
        Section section = SectionService.getSectionByLineName(line.getName());
        SectionRepository.deleteSection(section);
    }

    private static Section getSectionByLineName(String name) {
        try {
            return SectionRepository.sections().stream()
                .filter(s -> s.getLine().getName().equals(name))
                .findAny()
                .get();
        } catch (
            NoSuchElementException e) {
            throw new IllegalArgumentException("등록되지 않은 노선 입니다.");
        }
    }

    public static boolean containByStationService(Station station) {
        return SectionRepository.sections().stream().anyMatch(s ->
            s.getStations().contains(station));
    }
}
