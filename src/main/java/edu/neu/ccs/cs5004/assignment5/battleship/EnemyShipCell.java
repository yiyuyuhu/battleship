package edu.neu.ccs.cs5004.assignment5.battleship;

/**
 * represent a ship cell with a guessed enemy ship on it.
 */
public class EnemyShipCell extends AbstractShipCell {

  protected boolean belongsToSunkShip;

  /**
   * create a new enemy ship cell.
   *
   * @param hit             whether the cell is hit or not.
   * @param shipCellSunk              whether the cell is sunk or not.
   * @param belongsToSunkShip whether the cell belongs to a sunk ship or not.
   */
  public EnemyShipCell(boolean hit, boolean shipCellSunk, boolean belongsToSunkShip) {
    super(hit, shipCellSunk);
    this.belongsToSunkShip = belongsToSunkShip;
  }



  /**
   * getter for information of whether the enemy ship cell belongs to a sunk ship or not.
   *
   * @return the information of whether the enemy ship cell belongs to a sunk ship or not.
   */
  public boolean isBelongsToSunkShip() {
    return belongsToSunkShip;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  protected AbstractShipCell markShipCellAsSunkFactory() {
    return new EnemyShipCell(this.hit, true, this.belongsToSunkShip);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public AttackResult getAttackResult() {
    if (this.belongsToSunkShip) {
      return new Sunk();
    } else {
      return new Hit();
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public EnemyShipCell attackCell() {
    return new EnemyShipCell(true, this.shipCellSunk, this.belongsToSunkShip);
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

    EnemyShipCell that = (EnemyShipCell) obj;

    return isBelongsToSunkShip() == that.isBelongsToSunkShip();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (isBelongsToSunkShip() ? 1 : 0);
    return result;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "EnemyShipCell{"
            +
            "belongsToSunkShip="
            + belongsToSunkShip
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
