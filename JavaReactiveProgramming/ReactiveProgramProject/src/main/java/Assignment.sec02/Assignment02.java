package Assignment.sec02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class Assignment02 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        StockPricePublisher.getPriceFlux()
                .subscribeWith(new Subscriber<Integer>() {
                    private Subscription s;

                    @Override
                    public void onSubscribe(Subscription s) {
                        this.s = s;
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer price) {
                        System.out.println(LocalDateTime.now() + " : Price - " + price);
                        if(price > 20 || price < 10 ){
                            this.s.cancel();
                            latch.countDown();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                       latch.countDown();
                    }

                    @Override
                    public void onComplete() {
                        latch.countDown();
                    }
                });
        latch.await();
    }
}
