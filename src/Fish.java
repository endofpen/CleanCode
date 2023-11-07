import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Fish extends OceanAnimals {
    private int weight;

    public Fish(int weight, String kindOfCellContent, OceanCell currentOceanCell) {
        super(kindOfCellContent, currentOceanCell);
        this.weight = weight;
    }

    @Override
    public void executeNextSimulationTurn() {
        Directions newDirection = calculateNewDirection();
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

    private Directions calculateNewDirection() {
        int randomDirectionKey = new Random().nextInt(1 - 5);
        return DirectionService.getInstance().retrieveDirectionByKey(randomDirectionKey);
    }

    private void grow(int nutritionValue) {
        this.weight += nutritionValue;
    }

    private Optional<OceanCellContent> searchThroughListForPlankton(ArrayList<OceanCellContent> oceanCellContents) {
        return oceanCellContents.stream().findFirst()
                .filter(oceanCellContent -> oceanCellContent.getKindOfCellContent().equals("Plankton"));
    }


}
