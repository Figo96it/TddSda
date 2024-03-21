package org.example.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class FibonacciTest {

    @Test
    void checkCorrectResultOfFibonacciCalculatorWithJUnitTest(){
        //given
        int input = 7;
        int expectedOutput = 13;
        //when
        int result = Fibonacci.calculateFibonacci(input);
        //then
        Assertions.assertEquals(expectedOutput, result);
    }

    @Test
    void checkIncorrectResultOfFibonacciCalculatorWithJUnitTest(){
        //given
        int input = 7;
        int expectedOutput = 20;
        //when
        int result = Fibonacci.calculateFibonacci(input);
        //then
        Assertions.assertNotEquals(expectedOutput, result);
    }

    @Test
    void checkCorrectResultOfFibonacciCalculatorWithAssertJTest(){
        //given
        int input = 7;
        int expectedOutput = 13;
        //when
        int result = Fibonacci.calculateFibonacci(input);
        //then
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(expectedOutput);
    }

    @Test
    void checkIncorrectResultOfFibonacciCalculatorWithAssertJTest(){
        //given
        int input = 7;
        int expectedOutput = 2;
        //when
        int result = Fibonacci.calculateFibonacci(input);
        //then
        org.assertj.core.api.Assertions.assertThat(result).isNotEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @ValueSource(ints = {7})
    void checkCorrectResultOfFibonacciCalculatorWithAParametrizedValueSourceTest(int input){
        //given
        int expectedOutput = 13;
        //when
        int result = Fibonacci.calculateFibonacci(input);
        //then
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @ValueSource(ints = {9})
    void checkIncorrectResultOfFibonacciCalculatorWithAParametrizedValueSourceTest(int input){
        //given
        int expectedOutput = 13;
        //when
        int result = Fibonacci.calculateFibonacci(input);
        //then
        org.assertj.core.api.Assertions.assertThat(result).isNotEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @CsvSource(value = {"7,13","8,21","14,377"}, delimiter = ',')
    void checkCorrectResultOfFibonacciCalculatorWithAParametrizedCsvSourceTest(int input, int expectedOutput){
        // given in input params
        //when
        int result = Fibonacci.calculateFibonacci(input);
        //then
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,13","18,21"}, delimiter = ',')
    void checkIncorrectResultOfFibonacciCalculatorWithAParametrizedCsvSourceTest(int input, int expectedOutput){
        // given in input params
        //when
        int result = Fibonacci.calculateFibonacci(input);
        //then
        org.assertj.core.api.Assertions.assertThat(result).isNotEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @MethodSource("provideDataForFibonacci")
    void checkCorrectResultOfFibonacciCalculatorWithAParametrizedMethodSourceSourceTest(int input, int expectedOutput){
        // given in input params
        //when
        int result = Fibonacci.calculateFibonacci(input);
        //then
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(expectedOutput);
    }

    private static Stream<Object[]> provideDataForFibonacci(){
        return Stream.of(
                new Object[]{7,13},
                new Object[]{2,1}
        );
    }



}
