package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
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
    }

    public static void print() {
    }
}
