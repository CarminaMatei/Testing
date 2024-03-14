package day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JunitParametrized {

    @ParameterizedTest
    @ValueSource(ints = {2, 8, 28, 140})
    public void isEvenNumber(int number){
        assertTrue(number % 2 == 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"doi", "trei", "cinci"})
    void endWith(String str){
        assertTrue(str.endsWith("i"));
    }

    @ParameterizedTest
    @MethodSource("createWords")
    void withMethodSource(String word){
        System.out.println(word);
    }

    private static Stream<String> createWords(){
        return Stream.of("Hello","world");
    }
}
