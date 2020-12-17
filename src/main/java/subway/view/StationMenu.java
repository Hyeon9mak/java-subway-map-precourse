package subway.view;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.service.StationService;

public enum StationMenu {
    SAVE("1", "역 등록", (key) -> StationService.save()),
    DELETE("2", "역 삭제", (key) -> StationService.delete()),
    PRINT("3", "역 조회", (key) -> StationService.print()),
    BACK("B", "돌아가기", (key) -> back());

    private final String key;
    private final String name;
    private final Consumer<String> select;

    StationMenu(String key, String name, Consumer<String> select) {
        this.key = key;
        this.name = name;
        this.select = select;
    }

    private static void back() {
    }

    public static StationMenu getMenuByInput(String input) {
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
