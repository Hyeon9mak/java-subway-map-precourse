package subway.view;

import java.util.Arrays;

public class StationDisplay extends Display {

    private static final String DISPLAY_NAME = "역 관리 화면";
    private static final String SAVE_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";

    public static void printMenu() {
        printNotice(DISPLAY_NAME);
        Arrays.stream(StationMenu.values()).forEach(menu ->
            System.out.println(menu.getKey() + ". " + menu.getName()));
    }

    public static void loadMenu() {
        StationMenu selectedMenu = null;
        while (selectedMenu != StationMenu.BACK) {
            printMenu();
            selectedMenu = StationMenu.getMenuByInput(UserInput.getSelectMenu());
            selectedMenu.executeMenu();
        }
    }

    public static void printSaveSuccess() {
        printInformation(SAVE_SUCCESS_MESSAGE);
    }
}
