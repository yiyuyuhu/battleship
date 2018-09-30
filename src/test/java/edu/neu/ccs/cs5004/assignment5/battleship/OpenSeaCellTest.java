package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OpenSeaCellTest {
  private OpenSeaCell openSeaCell;
  private OpenSeaCell hitOpenSeaCell;

  @Before
  public void setUp() throws Exception {
    openSeaCell = new OpenSeaCell(false);
    hitOpenSeaCell = new OpenSeaCell(true);
  }

  @Test
  public void abstractWaterCellFactory() {
    Assert.assertEquals(hitOpenSeaCell, openSeaCell.abstractWaterCellFactory());
  }

  @Test
  public void canPlaceShip() {
    Assert.assertEquals(true, openSeaCell.canPlaceShip());
  }

  @Test
  public void testToString() {
    String tempRef = "OpenSeaCell{"
            +
            "hit="
            + openSeaCell.isHit()
            +
            "} ";
    Assert.assertEquals(tempRef, openSeaCell.toString());
  }
}