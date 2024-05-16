package day4.part1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputHandler {

  private BufferedReader reader;

  public InputHandler() {
    try {
      reader = new BufferedReader(new FileReader("src/day4/part1/input.txt"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public String getLine() {
    String output;

    if (reader == null) {
      output = "";
    } else {
      try {
        output = reader.readLine();
      } catch (IOException e) {
        output = "";
        e.printStackTrace();
      }
    }

    return output;
  }

  public boolean fileIsReady() {
    boolean output;

    if (reader == null) {
      output = false;
    } else {
      try {
        output = reader.ready();
      } catch (IOException e) {
        output = false;
        e.printStackTrace();
      }
    }

    return output;
  }

}
