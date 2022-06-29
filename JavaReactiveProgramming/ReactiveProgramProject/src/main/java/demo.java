import reactor.core.publisher.Flux;

public class demo {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .filter(i -> i > 6)
                .take(2)
                .next()
                .subscribe(System.out::println);
    }
}
