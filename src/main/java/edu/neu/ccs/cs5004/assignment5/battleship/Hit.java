package edu.neu.ccs.cs5004.assignment5.battleship;

/**
 * represents a "hit" attack result.
 */
public class Hit implements AttackResult {

  /**
   * create a new hit.
   */
  public Hit() {
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
    return 23;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "Hit{}";
  }
}
