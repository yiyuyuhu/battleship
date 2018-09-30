package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HitTest {
  private Hit hit;
  private Miss miss;
  private Hit nullHit = null;

  @Before
  public void setUp() throws Exception {
    hit = new Hit();
    miss = new Miss();
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(hit, hit);
    Assert.assertNotEquals(hit, miss);
    Assert.assertNotEquals(hit, nullHit);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(hit.equals(miss),
            hit.hashCode() == miss.hashCode());
    Assert.assertEquals(hit.equals(hit),
            hit.hashCode() == hit.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Hit{}", hit.toString());
  }
}