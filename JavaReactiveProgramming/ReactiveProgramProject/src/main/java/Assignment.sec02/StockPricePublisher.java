package Assignment.sec02;

import com.example.utility.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPricePublisher {
    public static Flux<Integer> getPriceFlux(){
        AtomicInteger atomicInteger = new AtomicInteger(10);
        return Flux.interval(Duration.ofSeconds(1))
                   .map(i -> atomicInteger.getAndAccumulate(
                        Util.faker().random().nextInt(-5, 5),
                        Integer::sum
                   ));
    }
}
