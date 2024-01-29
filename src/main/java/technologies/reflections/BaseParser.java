package technologies.reflections;

import introduction.jsonParser.CharSource;

public class BaseParser {
    public static final char END = 0;
    protected CharSource source;
    protected char ch;

    public BaseParser(CharSource source) {
        this.source = source;
        take();
    }

    public char take() {
        final char result = ch;
        ch = source.hasNext() ? source.next(): END;
        return result;
    }

    public boolean take(char expected) {
        if (test(expected)) {
            take();
            return true;
        } else {
            return false;
        }
    }

    public boolean test(char expected) {
        return ch == expected;
    }

    public void expect(String chars) {
        for (char ch: chars.toCharArray()) {
            expect(ch);
        }
    }

    public void expect(char expected) {
        if (!take(expected)) {
            throw error("Expected '" + expected + "', found " + errorChar());
        }
    }



    public void checkEof() {
        if (!eof()) {
            throw error("Expected EOF, found " + errorChar());
        }
    }

    public boolean eof() {
        return ch == END;
    }

    protected  String errorChar() {
        return ch == END ? "EOF" : "'" + ch + "'";
    }

    private boolean between(char min , char max) {
        return min <= ch && ch <= max;
    }

    public IllegalArgumentException error(String message) {
        return source.error(message);
    }
}
