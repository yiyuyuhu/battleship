package edu.neu.ccs.cs5004.assignment5.battleship;

/**
 * represents a battle ship.
 */
public class Battleship extends AbstractShip {

  private static final Integer BATTLESHIP_SIZE = 4;

  /**
   * construct a battle ship.
   *
   * @param numberOfHitCells the number of cells that the ship occupies got hit.
   */
  public Battleship(Integer numberOfHitCells) {
    super(BATTLESHIP_SIZE, numberOfHitCells);
  }


  /**
   * {@inheritDoc}.
   */
  @Override
  public AbstractShip hitThisShipAbstractFactory(Integer newNumOfHitCells) {
    return new Battleship(newNumOfHitCells);
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
    return super.hashCode() * 7;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "Battleship{"
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
