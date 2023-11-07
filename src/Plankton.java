public class Plankton extends OceanCellContent{
    private int nutritionValue;

    public Plankton(int nutritionValue, String kindOfCellContent, OceanCell currentOceanCell) {
        super(kindOfCellContent,currentOceanCell);
        this.nutritionValue = nutritionValue;
    }

    public int retrieveNutritionValueAndClearCellContent(){
    currentOceanCell.eraseOceanCellContentFromOceanCell(this);
    return nutritionValue;
    }

    @Override
    public void executeNextSimulationTurn() {

    }
}
