package edu.neu.ccs.cs5004.assignment5.battleship;

public interface Ship {

  /**
   * getter for information of whether the ship is sunk or not.
   *
   * @return the information of whether the ship is sunk or not.
   */
  Boolean isSunk();

  /**
   * create a ship after being hit.
   *
   * @return a ship after being hit.
   */
  AbstractShip hitThisShip();
}
