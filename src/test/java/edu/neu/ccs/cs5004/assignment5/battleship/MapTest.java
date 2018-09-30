package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MapTest {

  private Map initMap;
  private Map sameStateInitMap;
  private Map yetAnotherInitMap;
  private Map nullMap = null;
  private Map oneShipCellMap;
  private AbstractCell[][] battleField;
  private AbstractCell[][] battleField2;


  @Before
  public void setUp() throws Exception {
    initMap = new Map();
    sameStateInitMap = new Map();
    yetAnotherInitMap = new Map();
    oneShipCellMap = new Map();
    oneShipCellMap.setCell(Map.RowIndex.three, Map.ColIndex.C,
            new SpecificShipCell(false, false, new Cruiser(0)));
  }

  @Test
  public void getMap() {
    battleField = new AbstractCell[Map.RowIndex.values().length][Map.ColIndex.values().length];
    for (Map.RowIndex ri : Map.RowIndex.values()) {
      for (Map.ColIndex ci : Map.ColIndex.values()) {
        battleField[ri.ordinal()][ci.ordinal()] = new OpenSeaCell(false);
      }
    }
    Assert.assertArrayEquals(battleField, initMap.getBattleField());
  }

  @Test
  public void getCell() {
    Assert.assertEquals(new OpenSeaCell(false), initMap.getCell(Map.RowIndex.three, Map.ColIndex.C));
  }

  @Test
  public void setCell() {
    battleField2 = new AbstractCell[Map.RowIndex.values().length][Map.ColIndex.values().length];
    for (Map.RowIndex ri : Map.RowIndex.values()) {
      for (Map.ColIndex ci : Map.ColIndex.values()) {
        if(ri.ordinal() == 2 && ci.ordinal() == 2){
          battleField2[ri.ordinal()][ci.ordinal()] = new SpecificShipCell(false, false, new Cruiser(0));
        }else {
          battleField2[ri.ordinal()][ci.ordinal()] = new OpenSeaCell(false);
        }
      }
    }

    Assert.assertArrayEquals(battleField2, oneShipCellMap.getBattleField());

  }

  @Test
  public void prettyPrint() {
    ConsolePrinter cp = new ConsolePrinter();
    initMap.prettyPrint(cp);
    oneShipCellMap.prettyPrint(cp);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(initMap.equals(initMap));// reflexivity
    Assert.assertTrue(initMap.equals(sameStateInitMap)); // both objects should have the same state
    Assert.assertEquals(initMap.equals(sameStateInitMap),
            sameStateInitMap.equals(initMap));//symmetry
    Assert.assertEquals(initMap.equals(sameStateInitMap) &&
                    sameStateInitMap.equals(yetAnotherInitMap),
            yetAnotherInitMap.equals(initMap)); //transitivity
    Assert.assertFalse(initMap.equals(oneShipCellMap)); //objects have different state
    Assert.assertFalse(initMap.equals(nullMap)); // specificShipCell is NOT null
    Assert.assertFalse(initMap.equals(battleField)); // different object
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(initMap.equals(sameStateInitMap),
            initMap.hashCode() == sameStateInitMap.hashCode()); //equal objects have
    // the same hashCode
    Assert.assertEquals(initMap.equals(oneShipCellMap),
            initMap.hashCode() == oneShipCellMap.hashCode());
  }

  @Test
  public void testValueOf() {
    Assert.assertEquals(Map.RowIndex.one, Map.RowIndex.valueOf("one"));
    Assert.assertEquals(Map.ColIndex.A, Map.ColIndex.valueOf("A"));
  }
}