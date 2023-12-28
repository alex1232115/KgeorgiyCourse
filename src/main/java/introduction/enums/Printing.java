package introduction.enums;
@FunctionalInterface
public interface Printing <T, R, D, S>{
    T print(R r, D d, S s);
}
