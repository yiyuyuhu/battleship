package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DestroyerTest {
  private Destroyer destroyer;
  private Destroyer hitDestroyer;
  private Destroyer sameStateDestroyer;
  private Destroyer yetAnotherDestroyer;
  private Cruiser cruiser;
  private Destroyer nullDestroyer = null;

  @Before
  public void setUp() throws Exception {
    destroyer = new Destroyer(0);
    hitDestroyer = new Destroyer(1);
    sameStateDestroyer = new Destroyer(0);
    yetAnotherDestroyer = new Destroyer(0);
    cruiser = new Cruiser(1);
  }

  @Test
  public void hitThisShipAbstractFactory() {
    Assert.assertEquals(hitDestroyer, destroyer.hitThisShipAbstractFactory(1));
  }
  @Test
  public void testEquals() {
    Assert.assertTrue(destroyer.equals(destroyer));// reflexivity
    Assert.assertTrue(destroyer.equals(sameStateDestroyer)); // both objects should have the same state
    Assert.assertEquals(destroyer.equals(sameStateDestroyer),
            sameStateDestroyer.equals(destroyer));//symmetry
    Assert.assertEquals(destroyer.equals(sameStateDestroyer) &&
                    sameStateDestroyer.equals(yetAnotherDestroyer),
            yetAnotherDestroyer.equals(destroyer)); //transitivity
    Assert.assertFalse(destroyer.equals(hitDestroyer)); //objects have different state
    Assert.assertFalse(destroyer.equals(nullDestroyer)); // specificShipCell is NOT null
    Assert.assertFalse(destroyer.equals(cruiser)); // different object
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(destroyer.equals(sameStateDestroyer),
            destroyer.hashCode() == sameStateDestroyer.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {
    String tempRes = "Destroyer{" +
            "size=" + destroyer.getSize() +
            ", numberOfHitCells=" + destroyer.getNumberOfHitCells() +
            '}';
    Assert.assertEquals(tempRes, destroyer.toString());
  }
}