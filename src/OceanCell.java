import java.util.ArrayList;

public class OceanCell {
    private ArrayList<OceanCellContent> cellContent;

    public OceanCell(ArrayList<OceanCellContent> cellContent) {
        this.cellContent = cellContent;
    }

    public void eraseOceanCellContentFromOceanCell(OceanCellContent oceanCellContentToErase){

    }

    public void putNewOceanCellContentIntoOceanCell(OceanCellContent newOceanCellContent){}

    public ArrayList<OceanCellContent> getCellContent(){
        return cellContent;
    }
}
