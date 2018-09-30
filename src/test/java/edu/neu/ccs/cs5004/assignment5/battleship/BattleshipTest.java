package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BattleshipTest {
  private Battleship battleShip;
  private Battleship hitBattleShip;
  private Battleship sameRefBattleShip;
  private Battleship sameStateBattleShip;
  private Battleship yetAnotherBattleShip;
  private Cruiser cruiser;
  private Battleship nullSubmarine = null;


  @Before
  public void setUp() throws Exception {
    battleShip = new Battleship(1);
    hitBattleShip = new Battleship(2);
    sameRefBattleShip = battleShip;
    sameStateBattleShip = new Battleship(1);
    yetAnotherBattleShip = new Battleship(1);
    cruiser = new Cruiser(1);

  }

  @Test
  public void hitThisShipAbstractFactory() {
    Assert.assertEquals(hitBattleShip, battleShip.hitThisShipAbstractFactory(2));
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(battleShip.equals(battleShip));// reflexivity
    Assert.assertTrue(battleShip.equals(sameRefBattleShip));
    // trivial condition both reference the same object
    Assert.assertTrue(battleShip.equals(sameStateBattleShip));
    // both objects should have the same state
    Assert.assertEquals(battleShip.equals(sameStateBattleShip),
            sameStateBattleShip.equals(battleShip));//symmetry
    Assert.assertEquals(battleShip.equals(sameStateBattleShip) &&
                    sameStateBattleShip.equals(yetAnotherBattleShip),
            yetAnotherBattleShip.equals(battleShip)); //transitivity
    Assert.assertFalse(battleShip.equals(hitBattleShip)); //objects have different state
    Assert.assertFalse(battleShip.equals(nullSubmarine)); // specificShipCell is NOT null
    Assert.assertFalse(battleShip.equals(cruiser)); // different object
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(battleShip.equals(sameStateBattleShip),
            battleShip.hashCode() == sameStateBattleShip.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {
    String tempRes = "Battleship{" +
            "size=" + battleShip.getSize() +
            ", numberOfHitCells=" + battleShip.getNumberOfHitCells() +
            '}';
    Assert.assertEquals(tempRes, battleShip.toString());
  }
}