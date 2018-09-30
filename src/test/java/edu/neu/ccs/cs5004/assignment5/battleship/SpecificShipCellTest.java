package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpecificShipCellTest {
  private edu.neu.ccs.cs5004.assignment5.battleship.Cruiser Cruiser;
  private Cruiser sunkCruiser;
  private SpecificShipCell specificShipCell;
  private SpecificShipCell sameStateSpecificShipCell;
  private SpecificShipCell yetAnotherSpecificShipCell;
  private SpecificShipCell sunkSpecificShipCell;
  private SpecificShipCell nullShipCell = null;
  private SpecificShipCell specificShipCellAfterAttack;

  @Before
  public void setUp() throws Exception {
    Cruiser = new Cruiser(2);
    sunkCruiser = new Cruiser(3);
    specificShipCell = new SpecificShipCell(false, false, Cruiser);
    sameStateSpecificShipCell = new SpecificShipCell(false, false, Cruiser);
    yetAnotherSpecificShipCell = new SpecificShipCell(false, false, Cruiser);
    sunkSpecificShipCell = new SpecificShipCell(false, true, Cruiser);
    specificShipCellAfterAttack = new SpecificShipCell(true, true, sunkCruiser);
  }


  @Test
  public void attackCell() {
    Assert.assertEquals(specificShipCellAfterAttack, specificShipCell.attackCell());
  }

  @Test
  public void markShipCellAsSunkFactory() {
    Assert.assertEquals(sunkSpecificShipCell, specificShipCell.markShipCellAsSunkFactory());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(specificShipCell.equals(specificShipCell));// reflexivity
    Assert.assertTrue(specificShipCell.equals(sameStateSpecificShipCell)); // both objects should have the same state
    Assert.assertEquals(specificShipCell.equals(sameStateSpecificShipCell),
            sameStateSpecificShipCell.equals(specificShipCell));//symmetry
    Assert.assertEquals(specificShipCell.equals(sameStateSpecificShipCell) &&
                    sameStateSpecificShipCell.equals(yetAnotherSpecificShipCell),
            yetAnotherSpecificShipCell.equals(specificShipCell)); //transitivity
    Assert.assertFalse(specificShipCell.equals(sunkSpecificShipCell)); //objects have different state
    Assert.assertFalse(specificShipCell.equals(nullShipCell)); // specificShipCell is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(specificShipCell.equals(sameStateSpecificShipCell),
            specificShipCell.hashCode() == sameStateSpecificShipCell.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {
    String tempRef = "SpecificShipCell{" +
            "absShip=" + specificShipCell.getAbsShip() +
            ", shipCellSunk=" + specificShipCell.isShipCellSunk() +
            ", hit=" + specificShipCell.isHit() +
            '}';
    Assert.assertEquals(tempRef, specificShipCell.toString());
  }

}