package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CruiserTest {
  private Cruiser cruiser;
  private Cruiser hitCruiser;
  private Cruiser sameRefCruiser;
  private Cruiser sameStateCruiser;
  private Cruiser yetAnotherCruiser;
  private Cruiser nullCruiser = null;
  private Destroyer destroyer;

  @Before
  public void setUp() throws Exception {
    cruiser = new Cruiser(1);
    hitCruiser = new Cruiser(2);
    sameRefCruiser = cruiser;
    sameStateCruiser = new Cruiser(1);
    yetAnotherCruiser = new Cruiser(1);
    destroyer = new Destroyer(1);
  }

  @Test
  public void hitThisShipAbstractFactory() {
    Assert.assertEquals(hitCruiser, cruiser.hitThisShipAbstractFactory(2));
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
    Assert.assertFalse(cruiser.equals(hitCruiser)); //objects have different state
    Assert.assertFalse(cruiser.equals(nullCruiser)); // cruiser is NOT null
    Assert.assertFalse(cruiser.equals(destroyer)); // different object
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(cruiser.equals(sameStateCruiser),
            cruiser.hashCode() == sameStateCruiser.hashCode()); //equal objects have the same hashCode
  }


  @Test
  public void testToString() {
    String tempRes = "Cruiser{" +
            "size=" + cruiser.getSize() +
            ", numberOfHitCells=" + cruiser.getNumberOfHitCells() +
            '}';
    Assert.assertEquals(tempRes, cruiser.toString());
  }
}