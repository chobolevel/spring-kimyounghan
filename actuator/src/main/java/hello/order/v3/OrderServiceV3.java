package hello.order.v3;

import hello.order.OrderService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
public class OrderServiceV3 implements OrderService {

    private final MeterRegistry meterRegistry;
    private AtomicInteger stock = new AtomicInteger(100);

    private static void sleep(int l) {
        try {
            Thread.sleep(l + new Random().nextInt(200));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet();

        Timer timer = Timer.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "order")
                .description("order")
                .register(meterRegistry);
        // 이 코드에서 실질적으로 시간을 측정하는 부분은 record 메서드
        timer.record(() -> {
            log.info("주문");
            stock.incrementAndGet();
            this.sleep(500);
        });
    }

    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();

        Timer timer = Timer.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "cancel")
                .description("cancel")
                .register(meterRegistry);
        // 이 코드에서 실질적으로 시간을 측정하는 부분은 record 메서드
        timer.record(() -> {
            log.info("취소");
            stock.incrementAndGet();
            this.sleep(200);
        });
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
