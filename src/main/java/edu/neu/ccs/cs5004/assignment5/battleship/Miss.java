package edu.neu.ccs.cs5004.assignment5.battleship;

/**
 * represents a "miss" attack result.
 */
public class Miss implements AttackResult {

  /**
   * create a new miss.
   */
  public Miss() {
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
    return 29;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "Miss{}";
  }
}
