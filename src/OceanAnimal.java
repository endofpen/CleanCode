public abstract class OceanAnimal extends OceanCellContent {
    private int weight;

    private int age;

    public OceanAnimal(String kindOfCellContent, OceanCell currentOceanCell, int weight) {
        super(kindOfCellContent, currentOceanCell);
        this.weight = weight;
    }

    @Override
    public void executeNextSimulationTurn() {
        loseWeight();
        agingAnimal();
        dieIfAgeAndWeightIsZero();
        OceanCell[] neighboringOceanCells = Ocean.getInstance().retrieveNeighboringOceanCells(this);
        OceanCell targetOceanCell = findTargetCellWithFood(neighboringOceanCells);
        moveFromCurrentOceanCellToNeighboringCell(this.getCurrentOceanCell(),targetOceanCell);
        eat(targetOceanCell.getCellContent());
    }

    private void loseWeight() {
        weight -= 1;
    }

    private void agingAnimal() {
        age -= 1;
    }

    abstract void eat(OceanCellContent contentToEat);

    abstract OceanCell findTargetCellWithFood(OceanCell[] neighboringOceanCells);

    abstract void moveFromCurrentOceanCellToNeighboringCell(OceanCell currentOceanCell, OceanCell neighboringOceanCell);

    abstract void multiplayAnimal();

    private void dieIfAgeAndWeightIsZero() {
        if (weight <= 0 | age <= 0) this.clearFromCurrentCell();
    }
}
