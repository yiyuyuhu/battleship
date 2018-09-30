package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractCellTest {
  private edu.neu.ccs.cs5004.assignment5.battleship.Cruiser Cruiser;
  private Cruiser sunkCruiser;
  private EnemyShipCell enemyShipCell;
  private SpecificShipCell specificShipCell;
  private OpenSeaCell openSeaCell;
  private GapCell gapCell;
  private SpecificShipCell sameStateSpecificShipCell;
  private SpecificShipCell yetAnotherSpecificShipCell;
  private SpecificShipCell sunkSpecificShipCell;
  private SpecificShipCell nullShipCell = null;


  @Before
  public void setUp() throws Exception {
    Cruiser = new Cruiser(2);
    sunkCruiser = new Cruiser(3);
    enemyShipCell = new EnemyShipCell(false, false, false);
    specificShipCell = new SpecificShipCell(false, false, Cruiser);
    openSeaCell = new OpenSeaCell(false);
    gapCell = new GapCell(false);
    sunkSpecificShipCell = new SpecificShipCell(false, true, sunkCruiser);
    sameStateSpecificShipCell = new SpecificShipCell(false, false, Cruiser);
    yetAnotherSpecificShipCell = new SpecificShipCell(false, false, Cruiser);
    sunkSpecificShipCell = new SpecificShipCell(false, true, sunkCruiser);
  }

  @Test
  public void canPlaceShip() {
    Assert.assertTrue(openSeaCell.canPlaceShip());
    Assert.assertFalse(enemyShipCell.canPlaceShip());
    Assert.assertFalse(specificShipCell.canPlaceShip());
    Assert.assertFalse(gapCell.canPlaceShip());
  }

  @Test
  public void getIsHit() {
    Assert.assertFalse(enemyShipCell.isHit());
  }

  @Test
  public void getAttackResult() {
    Assert.assertTrue(new Miss().
            equals(openSeaCell.getAttackResult()));
    Assert.assertTrue(new Miss().
            equals(gapCell.getAttackResult()));
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
    Assert.assertFalse(specificShipCell.equals(gapCell)); // specificShipCell is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(specificShipCell.equals(sameStateSpecificShipCell),
            specificShipCell.hashCode() == sameStateSpecificShipCell.hashCode()); //equal objects have
    // the same hashCode
  }
}