import java.util.ArrayList;
import java.util.Optional;

public class Fish implements IOceanAnimals {
    private int weight;
    private OceanCell currentOceanCell;

    private final String kindOfCellContent;

    public Fish(int weight, String kindOfCellContent) {
        this.weight = weight;
        this.kindOfCellContent = kindOfCellContent;
    }

    @Override
    public void executeNextSimulationTurn() {
        int newDirection = calculateNewDirection();
        OceanCell neighboringOceanCell = Ocean.getInstance().retrieveNeighborOceanCell(this, newDirection);
        ArrayList<OceanCellContent> neighboringOceanCellContents = neighboringOceanCell.getCellContent();
        Optional<OceanCellContent> optionalOceanCellContentWithPlankton = searchThroughListForPlankton(neighboringOceanCellContents);
        if (optionalOceanCellContentWithPlankton.isEmpty()) return;
        moveFromCurrentOceanCellToNeighboringCell(currentOceanCell, neighboringOceanCell);
        eatPlankton((Plankton) optionalOceanCellContentWithPlankton.get());
    }

    private void eatPlankton(Plankton plankton) {
        int nutritionValueOfPlankton = plankton.retrieveNutritionValueAndClearCellContent();
        grow(nutritionValueOfPlankton);
    }

    private void moveFromCurrentOceanCellToNeighboringCell(OceanCell currentOceanCell, OceanCell neighboringOceanCell) {
        currentOceanCell.eraseOceanCellContentFromOceanCell(this);
        neighboringOceanCell.putNewOceanCellContentIntoOceanCell(this);
    }

    @Override
    public String getKindOfCellContent() {
        return this.kindOfCellContent;
    }

    private int calculateNewDirection() {
        return 0;
    }

    private void grow(int nutritionValue) {
    }

    private Optional<OceanCellContent> searchThroughListForPlankton(ArrayList<OceanCellContent> oceanCellContents) {
        return oceanCellContents.stream().findFirst()
                .filter(oceanCellContent -> oceanCellContent.getKindOfCellContent().equals("Plankton"));
    }


}
