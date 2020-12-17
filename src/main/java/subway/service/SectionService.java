package subway.service;

import subway.domain.Line;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.view.UserInput;

public class SectionService {

    public static void save() {
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
