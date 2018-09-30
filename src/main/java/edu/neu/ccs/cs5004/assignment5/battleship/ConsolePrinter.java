package edu.neu.ccs.cs5004.assignment5.battleship;

/**
 * Represents a console printer.
 */
public class ConsolePrinter {

  /**
   * Create a console printer.
   */
  public ConsolePrinter() {
  }

  /**
   * Print the map to the console while open sea water cells are represented with "`",
   * and other cells are represented with "O".
   */
  public void toConsole(Map map) {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append("   ");
    for (Map.ColIndex ci : Map.ColIndex.values()) {
      stringBuilder.append(ci.toString());
      stringBuilder.append(" ");
    }
    System.out.println(stringBuilder.toString());

    for (Map.RowIndex ri : Map.RowIndex.values()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(ri.ordinal() + 1);
      if (stringBuilder.length() == 1) {
        stringBuilder.append("  ");
      } else if (stringBuilder.length() == 2) {
        stringBuilder.append(" ");
      }
      for (Map.ColIndex ci : Map.ColIndex.values()) {
        if (map.getCell(ri, ci) instanceof OpenSeaCell) {
          stringBuilder.append("` ");
        } else {
          stringBuilder.append("O ");
        }
      }
      System.out.println(stringBuilder.toString());
    }
  }
}
