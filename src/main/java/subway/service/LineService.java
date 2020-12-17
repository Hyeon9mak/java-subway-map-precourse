package subway.service;

import java.util.List;
import java.util.NoSuchElementException;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.LineDisplay;
import subway.view.UserInput;

public class LineService {

    public static void save() {
        StationService.validateStationRepositoryEmpty();
        String name = UserInput.getLineNameForSave();
        Line line = Line.newLineWithName(name);
        SectionService.saveByLineService(line);
        LineRepository.addLine(line);
        LineDisplay.printSaveSuccess();
    }

    public static void delete() {
        String name = UserInput.getLineNameForDelete();
        Line line = LineService.getLineByName(name);
        SectionService.deleteByLineService(line);
        LineRepository.deleteLine(line);
        LineDisplay.printDeleteSuccess();
    }

    public static void print() {
        List<Line> lines = LineRepository.lines();
        LineDisplay.printLines(lines);
    }

    public static Line getLineByName(String name) {
        try {
            return LineRepository.lines().stream()
                .filter(l -> l.getName().equals(name))
                .findAny()
                .get();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("등록되지 않은 노선 입니다.");
        }
    }
}
