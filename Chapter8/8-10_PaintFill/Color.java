import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Color {
    BLACK,
    WHITE,
    YELLOW,
    RED,
    GREEN;
    
    private static final List<Color> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = values().length;
    private static final Random RANDOM = new Random();
    
    public static Color randomColor() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}