import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Fish extends OceanAnimal {
    private final List<String> blockingOceanCellContent = List.of("Shark", "Fish", "Rock");

    public Fish(int weight, String kindOfCellContent, OceanCell currentOceanCell) {
        super(kindOfCellContent, currentOceanCell,weight);
        System.out.println("Constructor Fish");
    }

    @Override
    public void executeNextSimulationTurn() {
        Directions newDirection = calculateNewDirection();
        Optional<OceanCell> neighboringOceanCellOptional = Ocean.getInstance().retrieveNeighborOceanCell(this, newDirection);
        if (neighboringOceanCellOptional.isEmpty()) return;
        ArrayList<OceanCellContent> neighboringOceanCellContents = neighboringOceanCellOptional.get().getCellContent();
        if (!isMovingInNeighboringCellPossible(neighboringOceanCellContents)) return;
        moveFromCurrentOceanCellToNeighboringCell(currentOceanCell, neighboringOceanCellOptional.get());
        loseWeight();
    }

    private boolean isMovingInNeighboringCellPossible(ArrayList<OceanCellContent> neighboringOceanCellContents) {
        for (OceanCellContent oceanCellContent : neighboringOceanCellContents) {
            String kindOfOceanCellContent = oceanCellContent.getKindOfCellContent();
            if (!blockingOceanCellContent.contains(kindOfOceanCellContent)) return false;
        }
        return true;
    }

    private void moveFromCurrentOceanCellToNeighboringCell(OceanCell currentOceanCell, OceanCell neighboringOceanCell) {
        eatPlanktonIfPresent(neighboringOceanCell.getCellContent());
        currentOceanCell.eraseOceanCellContentFromOceanCell(this);
        neighboringOceanCell.putNewOceanCellContentIntoOceanCell(this);
    }

    private Directions calculateNewDirection() {
        int randomDirectionKey = new Random().nextInt(1, 4);
        return DirectionService.getInstance().retrieveDirectionByKey(randomDirectionKey);
    }


    private void eatPlanktonIfPresent(ArrayList<OceanCellContent> neighboringOceanCellContents) {
        Optional<OceanCellContent> optionalOceanCellContentWithPlankton = searchThroughOceanCellContentsForPlankton(neighboringOceanCellContents);
        if (optionalOceanCellContentWithPlankton.isEmpty()) return;
        Plankton plankton = (Plankton) optionalOceanCellContentWithPlankton.get();
        int nutritionValueOfPlankton = plankton.retrieveNutritionValueAndRemovePlanktonFromOceanCell();
        grow(nutritionValueOfPlankton);
    }

    private Optional<OceanCellContent> searchThroughOceanCellContentsForPlankton(ArrayList<OceanCellContent> oceanCellContents) {
        return oceanCellContents.stream().findFirst()
                .filter(oceanCellContent -> oceanCellContent.getKindOfCellContent().equals("Plankton"));
    }

    private void grow(int nutritionValue) {
        this.weight += nutritionValue;
    }
    public void getAttributes(){
        System.out.println(this.weight + " " +this.currentOceanCell +" "+" i am Fish");
    }

}
