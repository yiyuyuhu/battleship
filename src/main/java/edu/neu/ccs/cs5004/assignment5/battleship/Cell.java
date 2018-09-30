package edu.neu.ccs.cs5004.assignment5.battleship;

public interface Cell {

  /**
   * get the information of whether the cell is available for placing a ship or not.
   *
   * @return true if the cell is available, false otherwise.
   */
  boolean canPlaceShip();

  /**
   * get the result of attacking a cell.
   *
   * @return result of attacking a cell.
   */
  AttackResult getAttackResult();

  /**
   * Attack a cell and update the status of the cell and its ship as hit.
   *
   * @return the attacked cell with information updated..
   */
  Cell attackCell();
}
