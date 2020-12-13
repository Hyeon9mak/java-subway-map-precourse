package subway.view;

import java.util.Arrays;
import java.util.function.Consumer;
import subway.service.StationService;

public enum StationMenu {
    SAVE_STATION("1", "역 등록",
        (menuKey) -> StationService.save(UserInput.getSaveStationName())),
    DELETE_STATION("2", "역 삭제",
        (menuKey) -> StationService.delete(UserInput.getDeleteStationName())),
    PRINT_STATIONS("3", "역 조회",
        (menuKey) -> StationService.print()),
    BACK_TO_MAINMENU("B", "돌아가기",
        (menuKey) -> back());

    private final String menuKey;
    private final String menuName;
    private Consumer<String> menuSelect;

    StationMenu(String menuKey, String menuName, Consumer<String> menuSelect) {
        this.menuKey = menuKey;
        this.menuName = menuName;
        this.menuSelect = menuSelect;
    }

    public static StationMenu getMenuByInput(String input) {
        return Arrays.stream(values()).filter(mainMenu
            -> mainMenu.getMenuKey().equals(input))
            .findAny().get();
    }

    public String getMenuKey() {
        return menuKey;
    }

    public String getMenuName() {
        return menuName;
    }

    public void executeMenu(String menuKey) {
        menuSelect.accept(menuKey);
    }

    private static void back() {
    }
}
