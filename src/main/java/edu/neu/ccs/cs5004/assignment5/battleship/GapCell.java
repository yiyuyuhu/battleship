package edu.neu.ccs.cs5004.assignment5.battleship;

/**
 * represents a gap cell with one or more ships adjacent to it.
 */
public class GapCell extends AbstractWaterCell {

  /**
   * create a gap cell.
   *
   * @param hit the gap cell is hit or not.
   */
  public GapCell(boolean hit) {
    super(hit);
  }

  @Override
  public AbstractWaterCell abstractWaterCellFactory() {
    return new GapCell(true);
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
    return super.hashCode() * 3;
  }


  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "GapCell{"
            +
            "hit="
            + hit
            +
            "}";
  }
}
