import java.util.ArrayList;

public class Ocean {
    private static Ocean instance;
    private static ArrayList<OceanCellContent> oceanContent;
    private Ocean(){}

    public static Ocean getInstance() {
        if (instance == null) instance = new Ocean();
        return instance;
    }
    public static OceanCell retrieveNeighborOceanCell(OceanCellContent currentOceanCell, int direction){
        return null;
    }
    public static ArrayList<OceanCell> getOceanContent(){
        return new ArrayList<OceanCell>();
    }
}
