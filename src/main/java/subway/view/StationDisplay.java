package subway.view;

import java.util.Arrays;

public class StationDisplay extends Display {

    private static final String displayName = "역 관리 화면";

    public static void printMenu() {
        printNotice(displayName);
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
}
