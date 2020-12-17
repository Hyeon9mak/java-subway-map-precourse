package subway.view;

import java.util.Arrays;

public class MainDisplay extends Display {

    private static final String DISPLAY_NAME = "메인 화면";

    public static void printMenu() {
        printNotice(DISPLAY_NAME);
        Arrays.stream(MainMenu.values()).forEach(menu ->
            System.out.println(menu.getKey() + ". " + menu.getName()));
    }

    public static void loadMenu() {
        MainMenu selectedMenu = null;
        while (selectedMenu != MainMenu.QUIT) {
            printMenu();
            selectedMenu = MainMenu.getMenuByInput(UserInput.getSelectMenu());
            selectedMenu.executeMenu();
        }
    }
}
