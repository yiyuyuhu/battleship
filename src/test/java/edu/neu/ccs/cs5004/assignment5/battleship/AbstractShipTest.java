package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractShipTest {
  private Cruiser cruiser;
  private Cruiser hitCruiser;
  private Cruiser sunkCruiser;
  private Cruiser sameStateCruiser;
  private Cruiser yetAnotherCruiser;
  private Cruiser nullCruiser = null;
  private Destroyer destroyer;
  private Submarine submarine;
  private Battleship battleship;
  private Cruiser sameRefCruiser;

  @Before
  public void setUp() throws Exception {
    cruiser = new Cruiser(1);
    sameRefCruiser = cruiser;
    hitCruiser = new Cruiser(2);
    sunkCruiser = new Cruiser(3);
    sameStateCruiser = new Cruiser(1);
    yetAnotherCruiser = new Cruiser(1);
    destroyer = new Destroyer(1);
    submarine = new Submarine(1);
    battleship = new Battleship(1);
  }

  @Test
  public void getSize() {
    Assert.assertEquals(new Integer(3), cruiser.getSize());
  }

  @Test
  public void getNumberOfHitCells() {
    Assert.assertEquals(new Integer(1), cruiser.getNumberOfHitCells());
  }

  @Test
  public void hitThisShip() {
    Assert.assertEquals(hitCruiser, cruiser.hitThisShip());
    Assert.assertEquals(sunkCruiser, sunkCruiser.hitThisShip());
  }

  @Test
  public void hitThisShipAbstractFactory() {
    Assert.assertEquals(hitCruiser, cruiser.hitThisShipAbstractFactory(2));
  }

  @Test
  public void isSunk() {
    Assert.assertTrue(sunkCruiser.isSunk());
    Assert.assertFalse(hitCruiser.isSunk());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(cruiser.equals(cruiser));// reflexivity
    Assert.assertTrue(cruiser.equals(sameRefCruiser)); // trivial condition both reference the same object
    Assert.assertTrue(cruiser.equals(sameStateCruiser)); // both objects should
    // have the same state
    Assert.assertEquals(cruiser.equals(sameStateCruiser),
            sameStateCruiser.equals(cruiser));//symmetry
    Assert.assertEquals(cruiser.equals(sameStateCruiser) &&
                    sameStateCruiser.equals(yetAnotherCruiser),
            yetAnotherCruiser.equals(cruiser)); //transitivity
    Assert.assertFalse(cruiser.equals(sunkCruiser)); //objects have different state
    Assert.assertFalse(cruiser.equals(nullCruiser)); // specificShipCell is NOT null
    Assert.assertFalse(cruiser.equals(destroyer));
    Assert.assertFalse(cruiser.equals(hitCruiser));
    Assert.assertTrue(destroyer.equals(destroyer));
    Assert.assertTrue(submarine.equals(submarine));
    Assert.assertTrue(battleship.equals(battleship));
    Assert.assertFalse(cruiser.equals(new SpecificShipCell(false, false, cruiser)));
  }

  @Test
  public void testHashCode() {
    Cruiser nullNumHitCruiser = new Cruiser(null);

    Assert.assertEquals(cruiser.equals(yetAnotherCruiser),
            cruiser.hashCode() == yetAnotherCruiser.hashCode()); //equal objects have
    // the same hashCode
    Assert.assertEquals(cruiser.equals(nullNumHitCruiser),
            cruiser.hashCode() == nullNumHitCruiser.hashCode());
  }
}