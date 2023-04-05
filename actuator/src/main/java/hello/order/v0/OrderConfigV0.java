package hello.order.v0;

import hello.order.OrderService;
import org.springframework.context.annotation.Bean;

//@Configuration
public class OrderConfigV0 {

    @Bean
    public OrderService orderService() {
        return new OrderServiceV0();
    }

}
