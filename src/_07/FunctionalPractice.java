package _07;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionalPractice {

    static final List<String> words = List.of("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    public static void main(String[] args) {
        String res = words.stream()
                .filter(word -> word.length() >= 2)
                .map(String::toUpperCase)
                .map(w -> w.substring(0,1))
                .collect(Collectors.joining(" "));
        System.out.println(res.equals("T H A N K")?"성공":"실패");

    }

    void wordProcessTest(){
        String result = words.stream()
                .filter(w -> w.length() > 1)
                .map(String::toUpperCase)
                .map(w -> w.substring(0,1))
                .collect(Collectors.joining(" "));
    }

}
