package edu.neu.ccs.cs5004.assignment5.battleship;

/**
 * represents a ship cell.
 */
public abstract class AbstractShipCell extends AbstractCell implements ShipCell {

  protected boolean shipCellSunk;


  /**
   * create a ship cell.
   *
   * @param hit        whether the cell is hit or not.
   * @param shipCellSunk whether the cell is sunk.
   */
  public AbstractShipCell(boolean hit, boolean shipCellSunk) {
      super(hit);
    this.shipCellSunk = shipCellSunk;
  }


  /**
   * getter for information of whether the ship cell is sunk or not.
   *
   * @return the information of whether the ship cell is sunk or not.
   */
  public boolean isShipCellSunk() {
    return shipCellSunk;
  }

  /**
   * mark a ship cell as sunk.
   *
   * @return a ship cell marked as sunk.
   */
  public AbstractShipCell markShipCellAsSunk() {
    return markShipCellAsSunkFactory();
  }

  /**
   * Copies a ship cell with a new sunk status.
   *
   * @return copied ship cell.
   */
  protected abstract AbstractShipCell markShipCellAsSunkFactory();


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
    if (!super.equals(obj)) {
      return false;
    }

    AbstractShipCell that = (AbstractShipCell) obj;

    if (isShipCellSunk() != that.isShipCellSunk()) {
      return false;
    }

    return true;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (isShipCellSunk() ? 1 : 0);
    return result;
  }
}
