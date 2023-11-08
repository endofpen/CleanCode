import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Fish extends OceanAnimal {
    private final List<String> blockingOceanCellContent = List.of("Shark", "Fish", "Rock");
    private int currentDirection;

    public Fish(int weight, String kindOfCellContent, OceanCell currentOceanCell) {
        super(kindOfCellContent, currentOceanCell, weight);
    }

    @Override
    public void executeNextSimulationTurn() {
        calculateNewDirection();
        OceanCell[] neighboringOceanCells = Ocean.getInstance().retrieveNeighboringOceanCells(this);
        OceanCell targetOceanCell = neighboringOceanCells[currentDirection];
        if (targetOceanCell.equals(null)) return;
        ArrayList<OceanCellContent> neighboringOceanCellContents = targetOceanCell.getCellContent();
        if (!isMovingInNeighboringCellPossible(neighboringOceanCellContents)) return;
        moveFromCurrentOceanCellToNeighboringCell(super.getCurrentOceanCell(), targetOceanCell);
    }

    @Override
    void moveFromCurrentOceanCellToNeighboringCell(OceanCell currentOceanCell, OceanCell neighboringOceanCell) {
        eatPlanktonIfPresent(neighboringOceanCell.getCellContent());
        currentOceanCell.eraseOceanCellContentFromOceanCell(this);
        neighboringOceanCell.putNewOceanCellContentIntoOceanCell(this);
    }

    private void calculateNewDirection() {
        currentDirection = new Random().nextInt(0, 7);
    }

    private boolean isMovingInNeighboringCellPossible(ArrayList<OceanCellContent> neighboringOceanCellContents) {
        for (OceanCellContent oceanCellContent : neighboringOceanCellContents) {
            String kindOfOceanCellContent = oceanCellContent.getKindOfCellContent();
            if (!blockingOceanCellContent.contains(kindOfOceanCellContent)) return false;
        }
        return true;
    }

  /*  private void moveFromCurrentOceanCellToNeighboringCell(OceanCell currentOceanCell, OceanCell neighboringOceanCell) {
        eatPlanktonIfPresent(neighboringOceanCell.getCellContent());
        currentOceanCell.eraseOceanCellContentFromOceanCell(this);
        neighboringOceanCell.putNewOceanCellContentIntoOceanCell(this);
    }*/


    private void eatPlanktonIfPresent(ArrayList<OceanCellContent> neighboringOceanCellContents) {
        Optional<OceanCellContent> optionalOceanCellContentWithPlankton = searchThroughOceanCellContentsForPlankton(neighboringOceanCellContents);
        if (optionalOceanCellContentWithPlankton.isEmpty()) return;
        Plankton plankton = (Plankton) optionalOceanCellContentWithPlankton.get();
        int nutritionValueOfPlankton = plankton.retrieveNutritionValueAndRemovePlanktonFromOceanCell();
        super.eat(nutritionValueOfPlankton);
    }

    private Optional<OceanCellContent> searchThroughOceanCellContentsForPlankton(ArrayList<OceanCellContent> oceanCellContents) {
        return oceanCellContents.stream().findFirst()
                .filter(oceanCellContent -> oceanCellContent.getKindOfCellContent().equals("Plankton"));
    }

}
