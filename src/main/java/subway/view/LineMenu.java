package subway.view;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.service.LineService;

public enum LineMenu {
    SAVE("1", "노선 등록", (key) -> LineService.save()),
    DELETE("2", "노선 삭제", (key) -> LineService.delete()),
    PRINT("3", "노선 조회", (key) -> LineService.print()),
    BACK("B", "돌아가기", (key) -> back());

    private final String key;
    private final String name;
    private final Consumer<String> select;

    LineMenu(String key, String name, Consumer<String> select) {
        this.key = key;
        this.name = name;
        this.select = select;
    }

    private static void back() {
    }

    public static LineMenu getMenuByInput(String input) {
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
