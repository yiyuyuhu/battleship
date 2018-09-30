package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SunkTest {
  private Sunk sunk;
  private Hit hit;
  private Sunk nullSunk = null;

  @Before
  public void setUp() throws Exception {
    sunk = new Sunk();
    hit = new Hit();
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(sunk, sunk);
    Assert.assertNotEquals(sunk, hit);
    Assert.assertNotEquals(sunk, nullSunk);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(sunk.equals(sunk),
            sunk.hashCode() == sunk.hashCode());
    Assert.assertEquals(sunk.equals(hit),
            sunk.hashCode() == hit.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Sunk{}", sunk.toString());
  }
}