package edu.neu.ccs.cs5004.assignment5.battleship;

import org.junit.Before;
import org.junit.Test;

public class ConsolePrinterTest {
  private Map initMap;
  private Map twoShipCellMap;
  private ConsolePrinter cp = new ConsolePrinter();


  @Before
  public void setUp() throws Exception {
    initMap = new Map();
    twoShipCellMap = new Map();
    twoShipCellMap.setCell(Map.RowIndex.five, Map.ColIndex.D,
            new SpecificShipCell(false, false, new Cruiser(0)));
    twoShipCellMap.setCell(Map.RowIndex.five, Map.ColIndex.E,
            new SpecificShipCell(false, false, new Cruiser(0)));
  }

  @Test
  public void toConsole() {
    cp.toConsole(initMap);
    cp.toConsole(twoShipCellMap);
  }
}