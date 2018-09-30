package edu.neu.ccs.cs5004.assignment5.battleship;

/**
 * represents a submarine.
 */
public class Submarine extends AbstractShip {

  private static final Integer SUBMARINE_SIZE = 2;

  /**
   * create a submarine.
   *
   * @param numberOfHitCells the number of cells of the ship got hit.
   */
  public Submarine(Integer numberOfHitCells) {
    super(SUBMARINE_SIZE, numberOfHitCells);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public AbstractShip hitThisShipAbstractFactory(Integer newNumOfHitCells) {
    return new Submarine(newNumOfHitCells);
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
    return super.hashCode() * 13;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "Submarine{"
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
