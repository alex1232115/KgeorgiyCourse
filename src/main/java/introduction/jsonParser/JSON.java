package introduction.jsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class JSON {
    // Utility class
    private JSON() {
    }

    static Object parse(final CharSource charSource) {
        return new JSONParser(charSource).parseJSON();
    }

    public static Object parse(final String string) {
        return parse(new StringCharSource(string));
    }

    private static class JSONParser extends BaseParser {

        public JSONParser(CharSource source) {
            super(source);
        }

        public Object parseJSON() {
            final Object result = parseElement();
            checkEof();
            return result;
        }

        private Object parseElement() {
            skipWhitespace();
            final Object result = parseValue();
            skipWhitespace();
            return result;
        }

        private Object parseValue() {
            if (take('t')) {
                expect("rue");
                return true;
            } else if (take('f')) {
                expect("alse");
                return false;
            } else if (take('n')){
                expect("ull");
                return null;
            } else if (test('"')) {
                return parseString();
            } else if (test('-') || between('0', '9')){
                return parseInteger();
            } else if (take('[')) {
                return parseArray();
            } else if (take('{')) {
                return parseObject();
            }
              else {
                throw error("Unsupported input");
            }
        }

        private Map<String, Object> parseObject() {
            skipWhitespace();
            if (take('}')) {
                return Map.of();
            }
            final Map<String, Object> object = new HashMap<>();
            do {
                skipWhitespace();
                final String key = parseString();
                if (object.containsKey(key)) {
                    throw error("Duplicate key " + key);
                }
                skipWhitespace();
                expect(':');
                final Object value = parseElement();
                final Object prev = object.put(key, value);

            } while (take(','));
            expect('}');
            return object;

        }

        private List<Object> parseArray() {
            skipWhitespace();
            if (take(']')) {
                return List.of();
            }
            final List<Object> elements = new ArrayList<>();
            do {
                elements.add(parseElement());
            } while (take(','));
            expect(']');
            return elements;
        }

        private Integer parseInteger() {
            final StringBuilder number = new StringBuilder();
            if (take('-')) {
                number.append('-');
            }
            if (take('0')) {
                return 0;
            }
            while (between('0', '9')) {
                number.append(take());
            }
            try {
                return Integer.parseInt(number.toString());
            } catch (NumberFormatException e) {
                throw error("Invalid number " + number);
            }
        }

        private String parseString() {
            final StringBuilder sb = new StringBuilder();
            expect('"');
            while (!eof() && !test('"')) {
                if (take('\\')) {
                    sb.append(parseEscape());
                }
                sb.append(take());
            }
            expect('"');
            return sb.toString();
        }

        private char parseEscape() {
            if (take('r')) {
                return 'r';
            } else if (take('r')) {
                return '\r';
            } else if (take('n')) {
                return '\n';
            } else if (take('"')) {
                return '"';
            } else if (take('\\')) {
                return '\\';
            } else if (take('/')) {
                return '/';
            } else if (take('b')) {
                return '\b';
            } else if (take('f')) {
                return '\f';
            } else if (take('t')) {
                return '\t';
            } else {
                throw error("Expected escape symbol, found " + errorChar());
            }
        }

        private void skipWhitespace() {
            while (take(' ') || take('\r') || take('\n') || take('\t')) {
            }
        }
    }
}
