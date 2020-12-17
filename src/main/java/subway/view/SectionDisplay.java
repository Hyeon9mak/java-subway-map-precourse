package subway.view;

import java.util.Arrays;

public class SectionDisplay extends Display{
    private static final String displayName = "구간 관리 화면";

    public static void printMenu() {
        printNotice(displayName);
        Arrays.stream(SectionMenu.values()).forEach(menu ->
            System.out.println(menu.getKey() + ". " + menu.getName()));
    }

    public static void loadMenu() {
        SectionMenu selectedMenu = null;
        while (selectedMenu != SectionMenu.BACK) {
            printMenu();
            selectedMenu = SectionMenu.getMenuByInput(UserInput.getSelectMenu());
            selectedMenu.executeMenu();
        }
    }
}
