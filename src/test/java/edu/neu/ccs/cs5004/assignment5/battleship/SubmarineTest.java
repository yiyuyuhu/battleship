package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubmarineTest {
  private Submarine submarine;
  private Submarine sameStateSubmarine;
  private Submarine yetAnotherSubmarine;
  private Cruiser cruiser;
  private Submarine hitSubmarine;
  private Submarine nullSubmarine = null;

  @Before
  public void setUp() throws Exception {
    submarine = new Submarine(1);
    sameStateSubmarine = new Submarine(1);
    yetAnotherSubmarine = new Submarine(1);
    cruiser = new Cruiser(1);
    hitSubmarine = new Submarine(2);
  }

  @Test
  public void hitThisShipAbstractFactory() {
    Assert.assertEquals(hitSubmarine, submarine.hitThisShipAbstractFactory(2));
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(submarine.equals(submarine));// reflexivity
    Assert.assertTrue(submarine.equals(sameStateSubmarine)); // both objects should have the same state
    Assert.assertEquals(submarine.equals(sameStateSubmarine),
            sameStateSubmarine.equals(submarine));//symmetry
    Assert.assertEquals(submarine.equals(sameStateSubmarine) &&
                    sameStateSubmarine.equals(yetAnotherSubmarine),
            yetAnotherSubmarine.equals(submarine)); //transitivity
    Assert.assertFalse(submarine.equals(hitSubmarine)); //objects have different state
    Assert.assertFalse(submarine.equals(nullSubmarine)); // specificShipCell is NOT null
    Assert.assertFalse(submarine.equals(cruiser)); // different object
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(submarine.equals(sameStateSubmarine),
            submarine.hashCode() == sameStateSubmarine.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {
    String tempRes = "Submarine{" +
            "size=" + submarine.getSize() +
            ", numberOfHitCells=" + submarine.getNumberOfHitCells() +
            '}';
    Assert.assertEquals(tempRes, submarine.toString());
  }
}