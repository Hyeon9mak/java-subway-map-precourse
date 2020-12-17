package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(Section section){
        sections.add(section);
    }

    private static void validateEmpty() {
        if(sections.isEmpty()){
            throw new IllegalArgumentException("등록되어 있는 노선구간이 없습니다.");
        }
    }
}
