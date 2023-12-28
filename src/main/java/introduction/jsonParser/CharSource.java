package introduction.jsonParser;

public interface CharSource {
    boolean hasNext();
    char next();
    IllegalArgumentException error(String message);
}
