package introduction.jsonParser;

public class BaseParser {
    public static final char END = 0;
    protected CharSource source;
    protected char ch;

    public BaseParser(CharSource source) {
        this.source = source;
        take();
    }

    protected char take() {
        final char result = ch;
        ch = source.hasNext() ? source.next(): END;
        return result;
    }

    protected boolean take(char expected) {
        if (test(expected)) {
            take();
            return true;
        } else {
            return false;
        }
    }

    protected boolean test(char expected) {
        return ch == expected;
    }

    protected void expect(String chars) {
        for (char ch: chars.toCharArray()) {
            expect(ch);
        }
    }

    protected void expect(char expected) {
        if (!take(expected)) {
            throw error("Expected '" + expected + "', found " + errorChar());
        }
    }



    protected void checkEof() {
        if (!eof()) {
            throw error("Expected EOF, found " + errorChar());
        }
    }

    protected boolean eof() {
        return ch == END;
    }

    protected  String errorChar() {
        return ch == END ? "EOF" : "'" + ch + "'";
    }

    protected boolean between(char min , char max) {
        return min <= ch && ch <= max;
    }

    protected IllegalArgumentException error(String message) {
        return source.error(message);
    }
}
