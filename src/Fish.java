public class Fish implements IOceanAnimals{
    private int weight;
    private final String kindOfCellContent;
    public Fish(int weight,String kindOfCellContent) {
        this.weight = weight;
        this.kindOfCellContent = kindOfCellContent;
    }

    @Override
    public void executeTurn() {

    }


    @Override
    public String getKindOfCellContent() {
        return this.kindOfCellContent;
    }
}
