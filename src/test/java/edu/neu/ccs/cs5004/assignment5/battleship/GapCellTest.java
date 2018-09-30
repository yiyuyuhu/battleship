package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GapCellTest {
  private GapCell gapCell;
  private GapCell gapCellHit;
  private GapCell sameStategapCell;
  private GapCell yetAnothergapCell;
  private GapCell nullGapCell = null;
  private OpenSeaCell openSeaCell;

  @Before
  public void setUp() throws Exception {
    gapCell = new GapCell(false);
    gapCellHit = new GapCell(true);
    sameStategapCell = new GapCell(false);
    yetAnothergapCell = new GapCell(false);
    openSeaCell = new OpenSeaCell(false);
  }


  @Test
  public void abstractWaterCellFactory() {
    Assert.assertEquals(gapCellHit, gapCell.abstractWaterCellFactory());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(gapCell.equals(gapCell));// reflexivity
    Assert.assertTrue(gapCell.equals(sameStategapCell)); // both objects should
    // have the same state
    Assert.assertEquals(gapCell.equals(sameStategapCell),
            sameStategapCell.equals(gapCell));//symmetry
    Assert.assertEquals(gapCell.equals(sameStategapCell) &&
                    sameStategapCell.equals(yetAnothergapCell),
            yetAnothergapCell.equals(gapCell)); //transitivity
    Assert.assertFalse(gapCell.equals(openSeaCell)); //objects have different state
    Assert.assertFalse(gapCell.equals(nullGapCell)); // GapCell is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(gapCell.equals(sameStategapCell),
            gapCell.hashCode() == sameStategapCell.hashCode()); //equal objects have
    // the same hashCode
  }

  @Test
  public void testToString() {
    String tempRes = "GapCell{"
            +
            "hit="
            + gapCell.hit
            +
            "}";
    Assert.assertEquals(tempRes, gapCell.toString());
  }
}