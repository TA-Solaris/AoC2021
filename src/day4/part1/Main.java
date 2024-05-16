package day4.part1;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {

  private InputHandler myInputHandler;

  public Integer[] numbers;
  public int currentNumber;
  public LinkedList<Integer[][]> bingoSheets = new LinkedList<Integer[][]>();
  public LinkedList<boolean[][]> bingoValidation = new LinkedList<boolean[][]>();

  public void run() {

    this.build();

    while(!(anyWon())) {

      updateSheets(numbers[currentNumber]);

      currentNumber += 1;

    }

    for (int index = 0; index < bingoSheets.size(); index++) {
      if (thisWon(bingoValidation.get(index))) {
        int total = 0;

        for (int x = 0; x < 5; x++) {
          for (int y = 0; y < 5; y++) {
            if (!(bingoValidation.get(index)[x][y])){
              total += bingoSheets.get(index)[x][y];
            }
          }
        }

        System.out.println(total + " " + numbers[currentNumber - 1]);
      }
    }

  }

  public void updateSheets(int num) {
    for (int index = 0; index < bingoSheets.size(); index++) {
      for (int x = 0; x < 5; x++) {
        for (int y = 0; y < 5; y++) {
          if (bingoSheets.get(index)[x][y] == num) {
            bingoValidation.get(index)[x][y] = true;
          }
        }
      }
    }
  }

  public boolean anyWon() {
    boolean won = false;
    for (boolean[][] sheet : bingoValidation) {
      if (thisWon(sheet)) {
        won = true;
      }
    }
    return won;
  }

  public boolean thisWon(boolean[][] sheet) {
    boolean won = false;

    boolean[] hozWon = new boolean[5];

    for (int x = 0; x < 5; x++) {
      hozWon[x] = true;
    }

    for (int x = 0; x < 5; x++) {
      boolean vertWon = true;
      for (int y = 0; y < 5; y++) {
        if (!(sheet[x][y])) {
          vertWon = false;
          hozWon[y] = false;
        }
      }
      if (vertWon) {
        won = true;
      }
    }

    for (int x = 0; x < 5; x++) {
      if (hozWon[x]) {
        won = true;
      }
    }

    return won;
  }

  public void build() {

    String myLine;
    boolean firstLine = true;
    boolean secondLine = true;

    Integer[][] currentBingo = new Integer[5][5];
    int bingoLine = 0;

    while (myInputHandler.fileIsReady()) {

      myLine = myInputHandler.getLine();

      if (firstLine) {

        String[] data = myLine.split(",");

        numbers = new Integer[data.length];

        for (int i = 0; i < data.length; i++) {
          numbers[i] = Integer.parseInt(data[i]);
        }

        firstLine = false;
      } else if (secondLine) {

        secondLine = false;
      } else {

        if (myLine.equals("")) {
          bingoSheets.add(currentBingo);
          currentBingo = new Integer[5][5];
          bingoLine = 0;
        } else {
          myLine = myLine.replaceAll("( )+", " ");

          myLine = myLine.trim();

          String[] data = myLine.split(" ");

          for (int i = 0; i < data.length; i++) {
            currentBingo[i][bingoLine] = Integer.parseInt(data[i]);
          }

          bingoLine += 1;
        }

      }

    }

    for (int i = 0; i < bingoSheets.size(); i++) {

      boolean[][] temp = new boolean[5][5];

      for (int x = 0; x < 5; x++) {
        for (int y = 0; y < 5; y++) {
          temp[x][y] = false;
        }
      }

      bingoValidation.add(temp);

    }

    currentNumber = 0;

  }

  public Main() {
    this.myInputHandler = new InputHandler();
  }

  public static void main(String[] args) {
    new Main().run();
  }

}
