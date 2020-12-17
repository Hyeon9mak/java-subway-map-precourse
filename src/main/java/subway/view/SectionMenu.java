package subway.view;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.service.SectionService;

public enum SectionMenu {
    SAVE("1", "구간 등록", (key) -> SectionService.save()),
    DELETE("2", "구간 삭제", (key) -> SectionService.delete()),
    BACK("B", "돌아가기", (key) -> back());

    private final String key;
    private final String name;
    private final Consumer<String> select;

    SectionMenu(String key, String name, Consumer<String> select) {
        this.key = key;
        this.name = name;
        this.select = select;
    }

    private static void back() {
    }

    public static SectionMenu getMenuByInput(String input) {
        return Arrays.stream(values()).filter(mainMenu
            -> mainMenu.key.equals(input))
            .findAny()
            .get();
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public void executeMenu() {
        select.accept(key);
    }
}
