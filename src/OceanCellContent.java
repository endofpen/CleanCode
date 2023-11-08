abstract class OceanCellContent {
    private final String kindOfCellContent;
    private OceanCell currentOceanCell;

    public OceanCellContent(String kindOfCellContent, OceanCell currentOceanCell) {
        this.kindOfCellContent = kindOfCellContent;
        this.currentOceanCell = currentOceanCell;
    }

    public final void clearFromCurrentCell() {
        currentOceanCell.eraseOceanCellContentFromOceanCell(this);
    }

    abstract public void executeNextSimulationTurn();

    public final String getKindOfCellContent() {
        return this.kindOfCellContent;
    }
    public OceanCell getCurrentOceanCell(){return currentOceanCell;}
}
