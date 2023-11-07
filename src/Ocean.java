import java.util.ArrayList;

public class Ocean {
    private static Ocean instance;
    private static ArrayList<OceanCellContent> oceanContent;
    private Ocean(){}

    public static Ocean getInstance() {
        if (instance == null) instance = new Ocean();
        return instance;
    }
    public OceanCell retrieveNeighborOceanCell(OceanCellContent currentOceanCell, Directions direction){
        return null;
    }
    public ArrayList<OceanCell> getOceanContent(){
        return new ArrayList<OceanCell>();
    }

}
