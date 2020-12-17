package subway.domain;

public class Order {
    private final int order;

    private Order(String input){
        int order = validateInteger(input);
        this.order = order-1;
    }

    private int validateInteger(String order) {
        try{
            return Integer.parseInt(order);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("순서는 정수 값만 입력 가능합니다.");
        }
    }

    public static Order newOrder(String input) {
        return new Order(input);
    }

    public int getOrder(){
        return order;
    }
}
