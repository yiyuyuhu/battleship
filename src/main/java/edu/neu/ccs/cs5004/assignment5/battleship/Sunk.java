package edu.neu.ccs.cs5004.assignment5.battleship;

/**
 * represents a "sunk" attack result.
 */
public class Sunk implements AttackResult {

  /**
   * create a new sunk.
   */
  public Sunk() {
  }

  /**
   * {@inheritDoc}.
   */
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    return getClass() == obj.getClass();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    return 31;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "Sunk{}";
  }
}
