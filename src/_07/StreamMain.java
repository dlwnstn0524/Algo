package _07;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String[] args) {

        /**
         * 배열과 같은 스트릠은 아래와 같이 선언할 수 있다.
         */
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);

        /*
        스트림은 builder 패턴을 활용하여 chaining 시킬 수 있다
         */
        Stream<String> builderStream = Stream.<String>builder()
                .add("a")
                .add("b")
                .add("c")
                .build();

        Stream<String> generatedStream = Stream.generate(()->"a").limit(3);
        Stream<Integer> iteratedStream = Stream.iterate(0, n->n+2).limit(6);

        Stream<String> stream2 = Arrays.stream(arr)
                .map(String::toUpperCase);


    }
}
