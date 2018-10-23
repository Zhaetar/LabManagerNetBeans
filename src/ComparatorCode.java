
import java.util.Comparator;

/**
 * @author Barbara Luisa
 * @author Matheus Patrick
 */
public class ComparatorCode implements Comparator<Runner> {
    @Override
    public int compare(Runner r1, Runner r2) {
        return Integer.compare(r1.getCode(), r2.getCode());
    }
}