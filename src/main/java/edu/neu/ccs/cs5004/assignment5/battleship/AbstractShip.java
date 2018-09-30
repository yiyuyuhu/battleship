package edu.neu.ccs.cs5004.assignment5.battleship;


/**
 * represents a ship on the map board.
 */
public abstract class AbstractShip implements Ship {
  protected Integer size;
  protected Integer numberOfHitCells;

  /**
   * create a ship with given size and number of hit cells.
   *
   * @param size             the number of cells the ship occupies.
   * @param numberOfHitCells the number of cells of the ship been hit.
   */
  public AbstractShip(Integer size, Integer numberOfHitCells) {
    this.size = size;
    this.numberOfHitCells = numberOfHitCells;
  }


  /**
   * getter for the size of the ship.
   *
   * @return the the size of the ship.
   */
  public Integer getSize() {
    return this.size;
  }


  /**
   * getter for the number of hit cells of a ship.
   *
   * @return the the number of hit cells of a ship.
   */
  public Integer getNumberOfHitCells() {
    return this.numberOfHitCells;
  }


  /**
   * create a ship after being hit.
   *
   * @return a ship after being hit.
   */
  public AbstractShip hitThisShip() {
    Integer newNumOfHitCells = (this.numberOfHitCells + 1) > this.size
            ? this.size : this.numberOfHitCells + 1;
    return hitThisShipAbstractFactory(newNumOfHitCells);
  }


  /**
   * Copies a ship with a new number of hit cells.
   *
   * @param newNumOfHitCells of a copied shape.
   * @return copied ship.
   */
  public abstract AbstractShip hitThisShipAbstractFactory(Integer newNumOfHitCells);


  /**
   * getter for information of whether the ship is sunk or not.
   *
   * @return the information of whether the ship is sunk or not.
   */
  public Boolean isSunk() {
    return this.getSize().equals(this.getNumberOfHitCells());
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

    AbstractShip that = (AbstractShip) obj;

    if (getSize() != null ? !getSize().equals(that.getSize()) : that.getSize() != null) {
      return false;
    }
    return getNumberOfHitCells() != null
            ? getNumberOfHitCells().equals(that.getNumberOfHitCells())
            : that.getNumberOfHitCells() == null;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    int result = getSize() != null ? getSize().hashCode() : 0;
    result = 31 * result + (getNumberOfHitCells() != null ? getNumberOfHitCells().hashCode() : 0);
    return result;
  }
}
