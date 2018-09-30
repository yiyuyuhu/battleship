package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MissTest {
  private Hit hit;
  private Miss miss;
  private Miss nullMiss = null;

  @Before
  public void setUp() throws Exception {
    hit = new Hit();
    miss = new Miss();
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(miss, miss);
    Assert.assertNotEquals(miss, hit);
    Assert.assertNotEquals(miss, nullMiss);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(miss.equals(hit),
            miss.hashCode() == hit.hashCode());
    Assert.assertEquals(miss.equals(miss),
            miss.hashCode() == miss.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Miss{}", miss.toString());
  }
}