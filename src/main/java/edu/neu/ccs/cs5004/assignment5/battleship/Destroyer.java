package edu.neu.ccs.cs5004.assignment5.battleship;

/**
 * Represents a destroyer.
 */
public class Destroyer extends AbstractShip {

  private static final Integer DESTROYER_SIZE = 1;

  /**
   * create a destroyer.
   *
   * @param numberOfHitCells the number of cells of the ship got hit.
   */
  public Destroyer(Integer numberOfHitCells) {
    super(DESTROYER_SIZE, numberOfHitCells);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public AbstractShip hitThisShipAbstractFactory(Integer newNumOfHitCells) {
    return new Destroyer(newNumOfHitCells);
  }


  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    return super.equals(obj);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    return super.hashCode() * 17;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "Destroyer{"
            + "size="
            + size
            + ", numberOfHitCells="
            + numberOfHitCells
            + '}';
  }
}
