package edu.neu.ccs.cs5004.assignment5.battleship;

import java.util.Objects;

/**
 * represent a ship cell with a specific ship cell placed on it.
 */
public class SpecificShipCell extends AbstractShipCell {
  private AbstractShip absShip;

  /**
   * create a new specific ship cell
   *
   * @param hit        the cell was hit or not.
   * @param shipCellSunk the cell is sunk or not.
   * @param absShip      the specific ship placed on the cell.
   */
  public SpecificShipCell(boolean hit, boolean shipCellSunk, AbstractShip absShip) {
    super(hit, shipCellSunk);
    this.absShip = absShip;
  }

  /**
   * get the specific ship placed on this specific ship cell.
   *
   * @return the specific ship placed on this specific ship cell.
   */
  public AbstractShip getAbsShip() {
    return this.absShip;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  protected AbstractShipCell markShipCellAsSunkFactory() {
    return new SpecificShipCell(this.hit, true, this.absShip);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public AttackResult getAttackResult() {
    if (this.absShip.isSunk()) {
      return new Sunk();
    } else {
      return new Hit();
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public SpecificShipCell attackCell() {
    AbstractShip newShip = this.absShip.hitThisShip();
    return new SpecificShipCell(true, newShip.isSunk(), newShip);
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
    if (!super.equals(obj)) {
      return false;
    }
    SpecificShipCell that = (SpecificShipCell) obj;
    return Objects.equals(absShip, that.absShip);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), absShip);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "SpecificShipCell{"
            +
            "absShip="
            + absShip
            +
            ", shipCellSunk="
            + shipCellSunk
            +
            ", hit="
            + hit
            +
            '}';
  }
}
