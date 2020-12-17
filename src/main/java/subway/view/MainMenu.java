package subway.view;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.service.SectionService;

public enum MainMenu {
    STATION("1", "역관리", (key) -> StationDisplay.printMenu()),
    LINE("2", "노선 관리", (key) -> LineDisplay.printMenu()),
    SECTION("3", "구간 관리", (key) -> SectionDisplay.printMenu()),
    PRINT("4", "지하철 노선도 출력", (key) -> SectionService.printAllSections()),
    QUIT("Q", "종료", (key) -> back());

    private final String key;
    private final String name;
    private final Consumer<String> select;

    MainMenu(String key, String name, Consumer<String> select) {
        this.key = key;
        this.name = name;
        this.select = select;
    }

    private static void back() {
    }

    public MainMenu getMenuByInput(String input) {
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
