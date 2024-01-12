package jsonParserTest;

import introduction.jsonParser.JSON;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;


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
    public void testMap() {
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
        assertEquals(expected, JSON.parse(input));
    }
}

/*
    M O C K I T O - T R A I N I N G
*/

@ExtendWith(MockitoExtension.class)
class MockTest {
    @Mock
    List mockList;

    @Test
    public void whenNotUseMockAnnotation_thenCorrect() {
        //эти методы не будут ничего делать – это заглушки
        mockList.add("one");
        mockList.add("two");
    }
}

@ExtendWith(MockitoExtension.class)
class SpyTest {
    @Test
    public void whenMockSpyMethod() {
        List<String> mockList = Mockito.spy(new ArrayList<String>());
        //эти методы будут работать!
        mockList.add("one");
        mockList.add("two");
    }

    @Spy
    List<String> mockList = new ArrayList<>();

    @Test
    public void whenMockSpyAnnotation() {
        mockList.add("one");
        mockList.add("two");
    }
}

@ExtendWith(MockitoExtension.class)
class DoReturnTest {
    @Mock
    List mockList;

    @Test
    public void doReturnAnnotation() {
        //создаем правило: вернуть 10 при вызове метода size
        Mockito.doReturn(10).when(mockList).size();
        //тут вызывается метод и вернет 10!!
        assertEquals(10, mockList.size());
    }
}

@ExtendWith(MockitoExtension.class)
class WhenTest {
    @Mock
    List mockList;

    @Test
    public void whenMockAnnotation() {
        //создаем правило: вернуть 10 при вызове метода size
        Mockito.when(mockList.size()).thenReturn(10);

        //тут вызывается метод и вернет 10!!
        assertEquals(10, mockList.size());
    }
}

@ExtendWith(MockitoExtension.class)
class DoThrowTest {
    @Mock
    List mockList;

    @Test
    public void whenMockAnnotation() {
        Mockito.when(mockList.size()).thenThrow(IllegalStateException.class);
        assertThrows(IllegalStateException.class, () -> mockList.size()); //тут кинется исключение
    }
}

@ExtendWith(MockitoExtension.class)
class ParamsTest {
    @Mock
    List mockList;

    @Test
    public void whenMockAnnotation() {
        //добавление первого правила
        Mockito.doReturn("Иван").when(mockList).get(10);
        //добавление второго правила
        Mockito.doReturn("Марья").when(mockList).get(500);

        Mockito.doReturn("Dimon").when(mockList).remove(anyInt());

        assertEquals("Иван", mockList.get(10));
        assertEquals("Марья", mockList.get(500));
        assertNull(mockList.get(450));
        assertEquals("Dimon", mockList.remove(250));
        assertEquals("Dimon", mockList.remove(35));
    }
}

@ExtendWith(MockitoExtension.class)
class DoAnswerTest {
    @Mock
    List mockList;

    @Test
    public void whenMockAnnotation() {
        Mockito.doAnswer(invocation -> {
            int parameter = invocation.getArgument(0);
            return parameter * parameter;
        }).when(mockList).get(anyInt());

        assertEquals(100, mockList.get(10));
        assertEquals(25, mockList.get(5));
    }
}

@ExtendWith(MockitoExtension.class)
class VerifyTest {
    @Mock
    List<String> mockList;

    @Test
    public void whenMockAnnotation() {
        //вызов метода
        String name = mockList.get(10);

        //проверяем вызывался ли метод
        Mockito.verify(mockList).get(10);
    }

    @Test
    public void checkCountOfMethodInvoke_Correct() {
        String name1 = mockList.get(1);  //вызов метода
        String name2 = mockList.get(2);  //вызов метода
        String name3 = mockList.get(3);  //вызов метода

        //проверяем, что метод get() вызывался 3 раза
        Mockito.verify(mockList, times(3)).get(anyInt());
    }

    @Test
    public void checkCorrectInvokeOrder() {
        mockList.size();
        mockList.add("a parameter");
        mockList.clear();

        InOrder inOrder = Mockito.inOrder(mockList);
        inOrder.verify(mockList).size();
        inOrder.verify(mockList).add("a parameter");
        inOrder.verify(mockList).clear();
    }
}

@ExtendWith(MockitoExtension.class)
class ThenThrowTest {
    @Mock
    List mockList;

    @Test
    public void whenMockAnnotation() {
        //задаем поведение метода (нужно только для демонстрации)
        Mockito.when(mockList.size()).thenThrow(IllegalStateException.class);

        //проверяем бросится ли IllegalStateException при вызове метода size
        assertThrows(IllegalStateException.class, () -> mockList.size());
    }
}

@ExtendWith(MockitoExtension.class)
class staticMethodTest {
    @Test
    void givenStaticMethodWithNoArgs() {
        try (MockedStatic<staticMethodTest> utilities = Mockito.mockStatic(staticMethodTest.class)) {
            //добавляем правило
            utilities.when(staticMethodTest::name).thenReturn("Привет");

            //проверяем, что правило работает
            assertEquals("Привет", staticMethodTest.name());
        }
    }

    public static String name() {
        return "Leha";
    }
}
