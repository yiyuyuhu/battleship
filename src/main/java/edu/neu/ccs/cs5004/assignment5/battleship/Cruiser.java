package edu.neu.ccs.cs5004.assignment5.battleship;

/**
 * represents a cruiser.
 */
public class Cruiser extends AbstractShip {

  private static final Integer CRUISER_SIZE = 3;

  /**
   * create a cruiser.
   *
   * @param numberOfHitCells the number of cells of the ship got hit.
   */
  public Cruiser(Integer numberOfHitCells) {
    super(CRUISER_SIZE, numberOfHitCells);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public AbstractShip hitThisShipAbstractFactory(Integer newNumOfHitCells) {
    return new Cruiser(newNumOfHitCells);
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
    return super.hashCode() * 11;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "Cruiser{"
            +
            "size="
            + size
            +
            ", numberOfHitCells="
            + numberOfHitCells
            +
            '}';
  }
}
