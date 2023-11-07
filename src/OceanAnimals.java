public abstract class OceanAnimals extends OceanCellContent {
    protected int weight;

    public OceanAnimals(String kindOfCellContent, OceanCell currentOceanCell, int weight) {
        super(kindOfCellContent, currentOceanCell);
        this.weight = weight;
    }

    protected final void loseWeight() {
        weight -= 1;
        if (weight <= 0) this.clearFromCurrentCell();
    }

}
