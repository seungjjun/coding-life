public interface MovieConverter <T extends Movie> {
    T convert(T movie);
}
