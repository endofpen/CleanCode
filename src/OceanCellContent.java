abstract class OceanCellContent {
    private final String kindOfCellContent;
    protected OceanCell currentOceanCell;

    public OceanCellContent(String kindOfCellContent, OceanCell currentOceanCell) {
        this.kindOfCellContent = kindOfCellContent;
        this.currentOceanCell = currentOceanCell;
    }

    public void clearFromCurrentCell() {
        currentOceanCell.eraseOceanCellContentFromOceanCell(this);
    }

    abstract public void executeNextSimulationTurn();


    public String getKindOfCellContent() {
        return this.kindOfCellContent;
    }
}
