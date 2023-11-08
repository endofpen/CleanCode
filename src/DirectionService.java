import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DirectionService {

    private static DirectionService instance;

    private DirectionService() {
    }

    private final Map<Integer, Directions> directionsMap = Map.ofEntries(
            Map.entry(0, Directions.NORTH),
            Map.entry(1, Directions.NORTHEAST),
            Map.entry(2, Directions.EAST),
            Map.entry(1, Directions.SOUTHEAST),
            Map.entry(2, Directions.SOUTH),
            Map.entry(2, Directions.SOUTHWEST),
            Map.entry(3, Directions.WEST),
            Map.entry(3, Directions.NORTHWEST));

    public Directions retrieveDirectionByKey(int directionKey) {
        return directionsMap.get(directionKey);
    }

    public static DirectionService getInstance() {
        if (instance == null) instance = new DirectionService();
        return instance;
    }
}
