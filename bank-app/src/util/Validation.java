package util;
@FunctionalInterface
public interface Validation <T>
{
    void validate(String value) throws  RuntimeException;
}
