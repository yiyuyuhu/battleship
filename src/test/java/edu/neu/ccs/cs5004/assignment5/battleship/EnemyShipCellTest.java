package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnemyShipCellTest {
  private EnemyShipCell enemyShipCell;
  private EnemyShipCell sameStateEnemyShipCell;
  private EnemyShipCell yetAnotherEnemyShipCell;
  private EnemyShipCell sunkCellEnemyShipCell;
  private EnemyShipCell nullShipCell = null;
  private EnemyShipCell attackedEnemyShipCell;
  private EnemyShipCell sunkShipEnemyShipCell;

  @Before
  public void setUp() throws Exception {
    enemyShipCell = new EnemyShipCell(false, false, false);
    sameStateEnemyShipCell = new EnemyShipCell(false, false, false);
    yetAnotherEnemyShipCell = new EnemyShipCell(false, false, false);
    sunkCellEnemyShipCell = new EnemyShipCell(false, true, false);
    attackedEnemyShipCell = new EnemyShipCell(true, false, false);
    sunkShipEnemyShipCell = new EnemyShipCell(true, true, true);
  }

  @Test
  public void isBelongsToSunkShip() {
    Assert.assertFalse(enemyShipCell.isBelongsToSunkShip());
  }

  @Test
  public void markShipCellAsSunkFactory() {
    Assert.assertEquals(sunkCellEnemyShipCell, enemyShipCell.markShipCellAsSunkFactory());
  }

  @Test
  public void getAttackResult() {
    Assert.assertEquals(new Hit(), enemyShipCell.getAttackResult());
    Assert.assertEquals(new Sunk(), sunkShipEnemyShipCell.getAttackResult());
  }

  @Test
  public void attackCell() {
    Assert.assertEquals(attackedEnemyShipCell, enemyShipCell.attackCell());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(enemyShipCell.equals(enemyShipCell));// reflexivity
    Assert.assertTrue(enemyShipCell.equals(sameStateEnemyShipCell)); // both objects should have the same state
    Assert.assertEquals(enemyShipCell.equals(sameStateEnemyShipCell),
            sameStateEnemyShipCell.equals(enemyShipCell));//symmetry
    Assert.assertEquals(enemyShipCell.equals(sameStateEnemyShipCell) &&
                    sameStateEnemyShipCell.equals(yetAnotherEnemyShipCell),
            yetAnotherEnemyShipCell.equals(enemyShipCell)); //transitivity
    Assert.assertFalse(enemyShipCell.equals(sunkCellEnemyShipCell)); //objects have different state
    Assert.assertFalse(enemyShipCell.equals(nullShipCell)); // specificShipCell is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(enemyShipCell.equals(sameStateEnemyShipCell),
            enemyShipCell.hashCode() == sameStateEnemyShipCell.hashCode()); //equal objects have the same hashCode
    Assert.assertEquals(enemyShipCell.equals(sunkShipEnemyShipCell),
            enemyShipCell.hashCode() == sunkShipEnemyShipCell.hashCode());
  }

  @Test
  public void testToString() {
    String tempRef = "EnemyShipCell{"
            +
            "belongsToSunkShip="
            + enemyShipCell.belongsToSunkShip
            +
            ", shipCellSunk="
            + enemyShipCell.shipCellSunk
            +
            ", hit="
            + enemyShipCell.hit
            +
            '}';
    Assert.assertEquals(tempRef, enemyShipCell.toString());
  }
}

