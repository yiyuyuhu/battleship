package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractShipCellTest {
  private edu.neu.ccs.cs5004.assignment5.battleship.Cruiser Cruiser;
  private Cruiser sunkCruiser;
  private SpecificShipCell specificShipCell;
  private SpecificShipCell sameStateSpecificShipCell;
  private SpecificShipCell yetAnotherSpecificShipCell;
  private SpecificShipCell sunkSpecificShipCell;
  private SpecificShipCell nullShipCell = null;
  private SpecificShipCell markSunkSpecificShipCell;

  @Before
  public void setUp() throws Exception {
    Cruiser = new Cruiser(2);
    sunkCruiser = new Cruiser(3);
    specificShipCell = new SpecificShipCell(false, false, Cruiser);
    sameStateSpecificShipCell = new SpecificShipCell(false, false, Cruiser);
    yetAnotherSpecificShipCell = new SpecificShipCell(false, false, Cruiser);
    specificShipCell = new SpecificShipCell(false, false, Cruiser);
    sunkSpecificShipCell = new SpecificShipCell(false, true, sunkCruiser);
    markSunkSpecificShipCell = new SpecificShipCell(false, true, Cruiser);
  }


  @Test
  public void markShipCellAsSunk() {
    Assert.assertEquals(markSunkSpecificShipCell, specificShipCell.markShipCellAsSunk());
  }

  @Test
  public void markShipCellAsSunkFactory() {
    Assert.assertEquals(markSunkSpecificShipCell, specificShipCell.markShipCellAsSunkFactory());
  }

  @Test
  public void isShipCellSunk() {
    Assert.assertFalse(specificShipCell.isShipCellSunk());
  }

  @Test
  public void getAttackResult() {
    Assert.assertTrue(new Hit().
            equals(specificShipCell.getAttackResult()));
    Assert.assertTrue(new Sunk().
            equals(sunkSpecificShipCell.getAttackResult()));
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(specificShipCell.equals(specificShipCell));// reflexivity
    Assert.assertTrue(specificShipCell.equals(sameStateSpecificShipCell)); // both objects should
    // have the same state
    Assert.assertEquals(specificShipCell.equals(sameStateSpecificShipCell),
            sameStateSpecificShipCell.equals(specificShipCell));//symmetry
    Assert.assertEquals(specificShipCell.equals(sameStateSpecificShipCell) &&
                    sameStateSpecificShipCell.equals(yetAnotherSpecificShipCell),
            yetAnotherSpecificShipCell.equals(specificShipCell)); //transitivity
    Assert.assertFalse(specificShipCell.equals(sunkSpecificShipCell)); //objects have different state
    Assert.assertFalse(specificShipCell.equals(nullShipCell)); // specificShipCell is NOT null
    Assert.assertFalse(specificShipCell.equals(new Cruiser(1)));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(specificShipCell.equals(sameStateSpecificShipCell),
            specificShipCell.hashCode() == sameStateSpecificShipCell.hashCode()); //equal objects have
    // the same hashCode
    Assert.assertEquals(sunkSpecificShipCell.equals(markSunkSpecificShipCell),
            sunkSpecificShipCell.hashCode() == markSunkSpecificShipCell.hashCode()); //equal objects have
  }
}