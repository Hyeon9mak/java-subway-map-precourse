package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void testOrderCreate() {
        Order order = Order.newOrder("1");
        assertThat(order.getOrder()).isEqualTo(0);
        Order order1 = Order.newOrder("2");
        assertThat(order1.getOrder()).isEqualTo(1);
        Order order2 = Order.newOrder("3");
        assertThat(order2.getOrder()).isEqualTo(2);
    }
}
