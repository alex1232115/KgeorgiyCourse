package jsonParserTest;

import introduction.jsonParser.JSON;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

public class JSONTest {
    @Test
    public void testBoolean() {
        valid(true, "true");
        valid(false, "false");
    }

    @Test
    public void testNull() {
        valid(null, "null");
        invalid("nul");
        invalid("nul2");
        invalid("null2");
    }
    @Test
    public void testWhitespace() {
        valid(null, "\r\n\tnull");
        valid(null, "\r\n\tnull \n\r\t");
        valid(null, "\r\n\tnull \n\r\t");
    }

    @Test
    public void testString() {
        valid("", "\"\"");
        valid("abc", "\"abc\"");
        valid("123", "\"123\"");
        invalid("\"hello");
        invalid("\"hello\"~");
    }

    @Test
    public void testInteger() {
        valid(0, "0");
        valid(0, "-0");
        valid(9, "9");
        invalid("01");
        valid(123, "123");
        valid(-123, "-123");
        invalid("+123");
        invalid("--123");
        invalid("-");
        invalid("1000000000000000000000");
    }

    @Test
    public void testArray() {
        valid(List.of(), "[]");
        valid(List.of(), "[ ]");
        valid(List.of(true), "[ true ]");
        valid(List.of(true, false), "[ true, false ]");
        valid(List.of(true, false, 123), "[true,false,123]");
        valid(List.of(true, false, 123), "[true , false , 123 ]");
        invalid("[a]");
        invalid("[123, ]");
    }

    @Test
    public void testMap(){
        valid(Map.of(), "{}");
        valid(Map.of(), "{ }");
        valid(Map.of("hello", true), "{ \"hello\": true}");
        valid(Map.of("hello", true, "world", false),
                "{ \"hello\": true, \"world\": false}"
        );
        valid(Map.of("hello", true, "world", false),
                "{ \"hello\": true , \"world\": false }"
        );
        invalid("{ \"hello\"}");
        invalid("{hello: true}");
        invalid("{: true}");
        valid(Map.of("", 123), "{\"\": 123}");
        invalid("{\"hello\":true,\"hello\":false}");
        invalid("{\"hello\":null,\"hello\":false}");
        invalid("{\"hello\":null,\"hello\":null}");
    }

    @Disabled
    @Test
    public void testEscape() {
        System.out.println("\"\\\"\\\\/\\n\\r\\f\\b\"");
        valid("\"\\/\n\r\f\b", "\"\\\"\\\\/\\n\\r\\f\\b\"");
    }

    @Test
    public void testNestedArrays() {
        valid(List.of(List.of()), "[[]]");
        valid(List.of(List.of(), List.of()), "[[], []]");
        valid(
                List.of(List.of(true, false), List.of(123), "hello"),
                "[[true, false], [123], \"hello\"]");
    }

    private void invalid(final String input) {
        try {
            final Object result = JSON.parse(input);
            Assertions.fail("Invalid input: " + input + " ' parsed as " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void valid(Object expected, String input) {
        Assertions.assertEquals(expected, JSON.parse(input));
    }
}