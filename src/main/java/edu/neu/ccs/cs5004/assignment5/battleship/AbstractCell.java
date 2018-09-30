package edu.neu.ccs.cs5004.assignment5.battleship;

import java.util.Objects;

/**
 * represents a general cell on the map board.
 */
public abstract class AbstractCell implements Cell {
  protected boolean hit;


  /**
   * create a cell.
   *
   * @param hit whether the cell is hit or not.
   */
  public AbstractCell(boolean hit) {
    this.hit = hit;
  }


  /**
   * getter for the information of whether a ship can place on the cell or not.
   *
   * @return the result of whether a ship can place on the cell or not.
   */
  public boolean canPlaceShip() {
    return false;
  }


  /**
   * getter for the hit status of the cell.
   *
   * @return the cell's hit status.
   */
  public boolean isHit() {
    return hit;
  }

  /**
   * abstract method to get the result after attacking a cell.
   */
  public abstract AttackResult getAttackResult();


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
    AbstractCell that = (AbstractCell) obj;
    return hit == that.hit;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    return Objects.hash(hit);
  }

}
