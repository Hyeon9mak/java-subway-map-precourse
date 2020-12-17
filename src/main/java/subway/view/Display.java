package subway.view;

public class Display {

    public static void printNotice(String message) {
        System.out.println("## " + message);
    }

    public static void printInformation(String message) {
        System.out.println("[INFO] " + message);
    }

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
