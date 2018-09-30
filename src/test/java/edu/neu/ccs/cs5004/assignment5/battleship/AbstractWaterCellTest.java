package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractWaterCellTest {
  private OpenSeaCell openSeaCell;
  private OpenSeaCell hitOpenSeaCell;
  private GapCell gapCell;
  private OpenSeaCell sameStateAsOpenSeaCell;
  private OpenSeaCell yetAnotherOpenSeaCell;
  private OpenSeaCell nullOpenSeaCell = null;

  @Before
  public void setUp() throws Exception {
    openSeaCell = new OpenSeaCell(false);
    hitOpenSeaCell = new OpenSeaCell(true);
    gapCell = new GapCell(false);
    sameStateAsOpenSeaCell = new OpenSeaCell(false);
    yetAnotherOpenSeaCell = new OpenSeaCell(false);
  }

  @Test
  public void attackCell() {
    Assert.assertTrue(hitOpenSeaCell.equals(openSeaCell.attackCell()));
  }

  @Test
  public void getAttackResult() {
    Assert.assertTrue(new Miss().
            equals(openSeaCell.getAttackResult()));
    Assert.assertTrue(new Miss().
            equals(gapCell.getAttackResult()));
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(openSeaCell.equals(openSeaCell));// reflexivity
    Assert.assertTrue(openSeaCell.equals(sameStateAsOpenSeaCell)); // both objects should
    // have the same state
    Assert.assertEquals(openSeaCell.equals(sameStateAsOpenSeaCell),
            sameStateAsOpenSeaCell.equals(openSeaCell));//symmetry
    Assert.assertEquals(openSeaCell.equals(sameStateAsOpenSeaCell) &&
                    sameStateAsOpenSeaCell.equals(yetAnotherOpenSeaCell),
            yetAnotherOpenSeaCell.equals(openSeaCell)); //transitivity
    Assert.assertFalse(openSeaCell.equals(gapCell)); //objects have different state
    Assert.assertFalse(openSeaCell.equals(nullOpenSeaCell)); // specificShipCell is NOT null

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(openSeaCell.equals(sameStateAsOpenSeaCell),
            openSeaCell.hashCode() == sameStateAsOpenSeaCell.hashCode()); //equal objects have
    // the same hashCode
  }
}