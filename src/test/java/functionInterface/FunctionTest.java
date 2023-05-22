package functionInterface;

import org.example.feature.functionInterface.CustomFunction;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.*;

public class FunctionTest {

    @Test
    public void test() {
        CustomFunction c = () -> System.out.println("test");
        c.execute();

        Predicate<String> p = (s) -> s.equals("test");
        System.out.println(p.test("test"));

        Consumer<String> consumer = System.out::println;
        consumer.accept("consumer");

        Supplier<String> supplier = () -> {
            return "supplier";
        };
        System.out.println(supplier.get());

        UnaryOperator<String> uq = (s) -> {
            return s + " uq";
        };
        System.out.println(uq.apply("operator"));

        BiFunction<Integer, Integer, String> bi = (i, j) -> {
            if (Objects.equals(i, j)) {
                return "equal";
            } else {
                return "not equal";
            }
        };
        System.out.println(bi.apply(1, 2));

        DoubleToIntFunction df = (d) -> (int) d;
        System.out.println(df.applyAsInt(6.020));

    }
}
