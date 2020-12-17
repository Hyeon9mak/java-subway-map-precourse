package subway.service;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.LineDisplay;
import subway.view.UserInput;

public class LineService {

    public static void save() {
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
        return LineRepository.lines().stream()
            .filter(l->l.getName().equals(name))
            .findAny()
            .get();
    }
}
