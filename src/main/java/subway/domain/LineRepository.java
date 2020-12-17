package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        validateEmpty();
        return Collections.unmodifiableList(lines);
    }

    private static void validateEmpty() {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("지하철 노선 목록이 비어있습니다.");
        }
    }

    public static void addLine(Line line) {
        validateDuplicate(line);
        lines.add(line);
    }

    private static void validateDuplicate(Line line) {
        if (lines.stream().anyMatch(l->l.getName().equals(line.getName()))) {
            throw new IllegalArgumentException("이미 등록된 노선 이름입니다.");
        }
    }

    public static boolean deleteLine(Line line) {
        return lines.removeIf(l -> Objects.equals(l, line));
    }
}
