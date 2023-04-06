package hello.order.gauge;

import hello.order.OrderService;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class StockConfigV1 {

    @Bean
    public MyStockMetric myStockMetric(OrderService orderService, MeterRegistry meterRegistry) {
        return new MyStockMetric(orderService, meterRegistry);
    }

    static class MyStockMetric {
        private OrderService orderService;
        private MeterRegistry meterRegistry;

        public MyStockMetric(OrderService orderService, MeterRegistry meterRegistry) {
            this.orderService = orderService;
            this.meterRegistry = meterRegistry;
        }

        // 외부 order, cancel 요청이 있을 때 마다 아래 함수가 호출된다고 생각하면 됨
        @PostConstruct
        public void init() {
            // 게이지를 만들 떄 작성한 람다식이 외부에서 메트릭을 확인할 떄마다 사용됨
            Gauge.builder("my.stock", orderService, service -> {
                log.info("stock gauge call");
                int stock = service.getStock().get();
                return stock;
            }).register(meterRegistry);
        }
    }

}
