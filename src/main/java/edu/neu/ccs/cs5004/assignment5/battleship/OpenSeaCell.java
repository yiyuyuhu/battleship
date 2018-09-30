package edu.neu.ccs.cs5004.assignment5.battleship;

/**
 * represents a open sea cell that has no ship adjacent to it.
 */
public class OpenSeaCell extends AbstractWaterCell {
  /**
   * create a open sea cell.
   *
   * @param hit the open sea cell is hit or not.
   */
  public OpenSeaCell(boolean hit) {
    super(hit);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean canPlaceShip() {
    return true;
  }


  @Override
  public AbstractWaterCell abstractWaterCellFactory() {
    return new OpenSeaCell(true);
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
    return super.hashCode() * 5;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "OpenSeaCell{"
            +
            "hit="
            + hit
            +
            "} ";

  }
}
