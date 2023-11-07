import java.util.ArrayList;
import java.util.Optional;

public class Ocean {
    private static Ocean instance;
    private static ArrayList<OceanCellContent> oceanContent;
    private Ocean(){}

    public static Ocean getInstance() {
        if (instance == null) instance = new Ocean();
        return instance;
    }
    public Optional<OceanCell> retrieveNeighborOceanCell(OceanCellContent currentOceanCell, Directions direction){
        return Optional.empty();
    }
    public ArrayList<OceanCell> getOceanContent(){
        return new ArrayList<OceanCell>();
    }

}
