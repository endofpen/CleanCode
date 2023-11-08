public class Plankton extends OceanCellContent{
    private final int nutritionValue;

    public Plankton(int nutritionValue, String kindOfCellContent, OceanCell currentOceanCell) {
        super(kindOfCellContent,currentOceanCell);
        this.nutritionValue = nutritionValue;
    }

    public int retrieveNutritionValueAndRemovePlanktonFromOceanCell(){
    super.getCurrentOceanCell().eraseOceanCellContentFromOceanCell(this);
    return nutritionValue;
    }

    @Override
    public void executeNextSimulationTurn() {

    }
}
