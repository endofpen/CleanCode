public class Shark implements IOceanAnimals{
    private final String kindOfOceanCellContent;

    public Shark(String kindOfOceanCellContent) {
        this.kindOfOceanCellContent = kindOfOceanCellContent;
    }

    @Override
    public void executeNextSimulationTurn() {

    }

    @Override
    public String getKindOfCellContent() {
        return kindOfOceanCellContent;
    }
}
