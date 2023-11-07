public class Plankton implements OceanCellContent{
    private final String kindOfCellContent;
    private OceanCell currentOceanCell;
    private int nutritionValue;

    public Plankton(String kindOfCellContent, int nutritionValue) {
        this.kindOfCellContent = kindOfCellContent;
        this.nutritionValue = nutritionValue;
    }

    @Override
    public String getKindOfCellContent() {
        return kindOfCellContent;
    }

    public int retrieveNutritionValueAndClearCellContent(){
    currentOceanCell.eraseOceanCellContentFromOceanCell(this);
    return nutritionValue;
    }
}
