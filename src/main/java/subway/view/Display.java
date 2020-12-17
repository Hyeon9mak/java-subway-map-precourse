package subway.view;

public class Display {

    public static void printNotice(String message) {
        System.out.println("\n## " + message);
    }

    public static void printInformation(String message) {
        System.out.println("\n[INFO] " + message);
    }

    public static void printError(String message) {
        System.out.println("\n[ERROR] " + message);
    }

    public static void printSelectError(){
        System.out.println("\n[ERROR] 선택할 수 없는 기능입니다.");
    }
}
