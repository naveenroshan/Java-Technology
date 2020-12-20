package wildCard.And.BoundedWildCard.InGenerics;
/**
 *
 * @author Naveen
 */
public class Coords<T extends TwoD> {
    T[] coords;

    Coords(T[] o) {
        coords = o;
    }
}
