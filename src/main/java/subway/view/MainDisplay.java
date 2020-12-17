package subway.view;

import java.util.Arrays;

public class MainDisplay extends Display {

    private static final String displayName = "메인 화면";

    public static void printMainMenu() {
        printNotice(displayName);
        Arrays.stream(MainMenu.values()).forEach(menu ->
            System.out.println(menu.getKey() + ". " + menu.getName()));
    }

    public static void loadMenu() {
        MainMenu selectedMenu = null;
        while (selectedMenu != MainMenu.QUIT) {
            printMainMenu();
            break;
        }
    }
}
