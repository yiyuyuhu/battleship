package edu.neu.ccs.cs5004.assignment5.battleship;


/**
 * represents a water cell.
 */
public abstract class AbstractWaterCell extends AbstractCell implements WaterCell {


  /**
   * create a water cell.
   *
   * @param hit the cell is hit or not.
   */
  public AbstractWaterCell(boolean hit) {
    super(hit);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public AttackResult getAttackResult() {
    return new Miss();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public AbstractWaterCell attackCell() {
    return abstractWaterCellFactory();
  }


  public abstract AbstractWaterCell abstractWaterCellFactory();


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
    return super.hashCode() * 19;
  }

}

