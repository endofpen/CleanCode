public abstract class OceanAnimal extends OceanCellContent {
    protected int weight;

    //TODO wie gehe ich mit protected aber public variablen um?
    public OceanAnimal(String kindOfCellContent, OceanCell currentOceanCell, int weight) {
        super(kindOfCellContent, currentOceanCell);
        this.weight = weight;
    }

    protected void loseWeight() {
        weight -= 1;
        if (weight <= 0) this.clearFromCurrentCell();
    }

}
