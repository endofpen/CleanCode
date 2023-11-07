import java.util.ArrayList;
import java.util.List;

public class OceanCell {
    private ArrayList<OceanCellContent> cellContent;

    public OceanCell(ArrayList<OceanCellContent> cellContent) {
        this.cellContent = cellContent;
    }

    public void putOceanCellContentIntoOceanCell(OceanCellContent newOceanCellContent){

    }

    public void eraseOceanCellContentFromOceanCell(OceanCellContent oldOceanCellContent){

    }

    public ArrayList<OceanCellContent> getCellContent(){
        return cellContent;
    }
}
