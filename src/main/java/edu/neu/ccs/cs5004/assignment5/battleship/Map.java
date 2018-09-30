package edu.neu.ccs.cs5004.assignment5.battleship;

import java.util.Arrays;

/**
 * Represents the map(battlefield) of the game.
 */
public class Map {
  public static enum RowIndex {
    one, two, three, four, five, six, seven, eight, nine, ten
  }

  public static enum ColIndex {
    A, B, C, D, E, F, G, H, I, J
  }

  private AbstractCell[][] battleField;

  /**
   * Create a new map.
   */
  public Map() {
    battleField = new AbstractCell[RowIndex.values().length][ColIndex.values().length];

    for (RowIndex ri : RowIndex.values()) {
      for (ColIndex ci : ColIndex.values()) {
        battleField[ri.ordinal()][ci.ordinal()] = new OpenSeaCell(false);
      }
    }
  }

  /**
   * getter for the property "battleField".
   *
   * @return the property "battleField".
   */
  public AbstractCell[][] getBattleField() {
    AbstractCell[][] grid = battleField.clone();
    return grid;
  }


  /**
   * get the cell one the position with given row and column index.
   *
   * @param row the row index of the wanted cell.
   * @param col the column index of the wanted cell.
   */
  public AbstractCell getCell(RowIndex row, ColIndex col) {
    return this.battleField[row.ordinal()][col.ordinal()];
  }

  /**
   * set the cell on given position to the given new cell.
   *
   * @param row  the row index of the wanted cell.
   * @param col  the row index of the wanted cell.
   * @param cell the cell to change the original cell to.
   */
  public void setCell(RowIndex row, ColIndex col, AbstractCell cell) {
    this.battleField[row.ordinal()][col.ordinal()] = cell;
  }

  /**
   * Print the map to the console.
   *
   * @param printer the helper class for printing out the map to the console.
   */
  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Map map = (Map) obj;

    return Arrays.deepEquals(getBattleField(), map.getBattleField());
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    return Arrays.deepHashCode(getBattleField());
  }

//    public static void main(String []args){
//    Map map = new Map();
//    ConsolePrinter cp = new ConsolePrinter();
//    map.prettyPrint(cp);
//    map.setCell(RowIndex.one, ColIndex.C.C, new SpecificShipCell(false, false, new Cruiser(0)));
//    map.prettyPrint(cp);
//  }

}
