package day3.part2;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {

  public String myInput;


  public void run() {

    String[] myLines = myInput.split("\n");

    boolean oFinished = false;
    String o = "";
    boolean coFinished = false;
    String co = "";

    for (int i = 0; i < myLines[0].length(); i++) {

      if (!(oFinished)) {

        String[] oLines = filterLines(myLines, o);

        if (oLines.length == 1) {
          o = oLines[0];
          oFinished = true;
        } else {

          HashMap<String, Integer> oHm = getHm(oLines, i);

          if (oHm.get("0") > oHm.get("1")) {
            o += "0";
          } else {
            o += "1";
          }

        }
      }

      if (!(coFinished)) {

        String[] coLines = filterLines(myLines, co);

        if (coLines.length == 1) {
          co = coLines[0];
          coFinished = true;
        } else {

          HashMap<String, Integer> coHm = getHm(coLines, i);

          if (coHm.get("0") > coHm.get("1")) {
            co += "1";
          } else {
            co += "0";
          }

        }

      }

    }

    System.out.println(stringToBinary(o) * stringToBinary(co));

  }

  public String[] filterLines(String[] myLines, String filter) {

    if (filter.length() == 0) {
      return myLines;
    }

    LinkedList<String> myFiltered = new LinkedList<String>();

    for (String line : myLines) {
      boolean passed = true;
      for (int i = 0; i < filter.length(); i++) {
        if (!(line.charAt(i) == filter.charAt(i))) {
          passed = false;
        }
      }
      if (passed) {
        myFiltered.add(line);
      }
    }

    String[] output = new String[myFiltered.size()];

    for (int i = 0; i < output.length; i++) {
      output[i] = myFiltered.get(i);
    }

    return output;
  }

  public HashMap<String, Integer> getHm(String[] myLines, int pos) {

    HashMap<String, Integer> data = new HashMap<String, Integer>();

    data.put("0", 0);
    data.put("1", 0);

    for (String line : myLines) {
      data.put("" + line.charAt(pos), data.get("" + line.charAt(pos)) + 1);
    }

    return data;
  }

  public int stringToBinary(String string) {
    int output = 0;

    for (int i = 0; i < string.length(); i ++) {
      if (string.charAt(i) == '1') {
        output += Math.pow(2, string.length() - 1 - i);
      }
    }

    return output;
  }

  public Main(String myInput) {
    this.myInput = myInput;
  }

  public static void main(String[] args) {
    new Main("000011001000\n"
        + "001111100100\n"
        + "110101011111\n"
        + "010100001101\n"
        + "110001001000\n"
        + "010000110100\n"
        + "010011010010\n"
        + "110101000011\n"
        + "100111001001\n"
        + "001101110011\n"
        + "001101011010\n"
        + "000010111000\n"
        + "111001101010\n"
        + "001010011011\n"
        + "000101101100\n"
        + "010011011101\n"
        + "111100101001\n"
        + "110110100011\n"
        + "001100000110\n"
        + "111010110110\n"
        + "110110011100\n"
        + "110000011111\n"
        + "010101111110\n"
        + "011001111010\n"
        + "110101100111\n"
        + "101111010011\n"
        + "001111000011\n"
        + "001110011100\n"
        + "000011001001\n"
        + "100101101100\n"
        + "010110000101\n"
        + "000001110001\n"
        + "000100011101\n"
        + "011110001101\n"
        + "000111000110\n"
        + "000111011001\n"
        + "110111110100\n"
        + "101110010000\n"
        + "111010000000\n"
        + "000111001001\n"
        + "010101010001\n"
        + "111100100000\n"
        + "100000000101\n"
        + "100111010111\n"
        + "000111110110\n"
        + "000000101010\n"
        + "010010001011\n"
        + "000100100000\n"
        + "111101011100\n"
        + "001100110000\n"
        + "001101010100\n"
        + "001011100101\n"
        + "010011000101\n"
        + "000001000101\n"
        + "010101110110\n"
        + "101110101101\n"
        + "011011110011\n"
        + "110101111101\n"
        + "110101011000\n"
        + "001001110100\n"
        + "001001110111\n"
        + "110100100100\n"
        + "110110110111\n"
        + "111001001100\n"
        + "010101101010\n"
        + "010101110010\n"
        + "110100011101\n"
        + "011111100110\n"
        + "001011010011\n"
        + "010100010100\n"
        + "010111101000\n"
        + "111000000101\n"
        + "110101110101\n"
        + "111010111111\n"
        + "101000110011\n"
        + "011111000011\n"
        + "001011010100\n"
        + "000001101001\n"
        + "011110010010\n"
        + "000001100111\n"
        + "111010110010\n"
        + "000111100110\n"
        + "010001000101\n"
        + "101010100001\n"
        + "110011000101\n"
        + "010101010110\n"
        + "111110111000\n"
        + "000100110001\n"
        + "100011100111\n"
        + "000110011010\n"
        + "001110100111\n"
        + "110001111000\n"
        + "101000010111\n"
        + "110000010011\n"
        + "111101111011\n"
        + "010001011010\n"
        + "011110000111\n"
        + "010011101100\n"
        + "011101010010\n"
        + "100111110011\n"
        + "100010100010\n"
        + "010000011100\n"
        + "001111010011\n"
        + "111000111111\n"
        + "000100111100\n"
        + "001100101110\n"
        + "001000011110\n"
        + "001101101000\n"
        + "100101000011\n"
        + "011001010011\n"
        + "111001100101\n"
        + "111110011111\n"
        + "011010111010\n"
        + "001100101101\n"
        + "111100110011\n"
        + "111001000100\n"
        + "100111111101\n"
        + "101101101111\n"
        + "110011100111\n"
        + "010000111101\n"
        + "001100111101\n"
        + "011110101000\n"
        + "001110010001\n"
        + "011010001110\n"
        + "110110110010\n"
        + "001010111101\n"
        + "110110011110\n"
        + "011110111111\n"
        + "001000011010\n"
        + "001011000010\n"
        + "110011111001\n"
        + "010110110000\n"
        + "101011111111\n"
        + "110100111001\n"
        + "100110000011\n"
        + "101010011100\n"
        + "011100011100\n"
        + "101011001011\n"
        + "001010100011\n"
        + "001110100011\n"
        + "000100000001\n"
        + "111011101000\n"
        + "000010011111\n"
        + "010101101110\n"
        + "001101010110\n"
        + "110100101101\n"
        + "101101010001\n"
        + "100110010111\n"
        + "100101010010\n"
        + "011000101101\n"
        + "010001100000\n"
        + "110100110010\n"
        + "001011101001\n"
        + "110100111000\n"
        + "111000111000\n"
        + "100011001001\n"
        + "011010100110\n"
        + "001110011110\n"
        + "101011110001\n"
        + "000100101010\n"
        + "001111101001\n"
        + "111011101010\n"
        + "001001010000\n"
        + "111000011000\n"
        + "001110100110\n"
        + "001111011100\n"
        + "000000111111\n"
        + "000100110111\n"
        + "010010111101\n"
        + "100011000110\n"
        + "001110011011\n"
        + "001011011000\n"
        + "000100101110\n"
        + "100001010100\n"
        + "110101010111\n"
        + "110110101011\n"
        + "111110011100\n"
        + "100001111101\n"
        + "001001001010\n"
        + "100101111001\n"
        + "101111010101\n"
        + "100110110000\n"
        + "101110010110\n"
        + "101000000111\n"
        + "100000110001\n"
        + "001111110100\n"
        + "011111010101\n"
        + "010100110111\n"
        + "010110101110\n"
        + "100001010010\n"
        + "101011100110\n"
        + "100001001010\n"
        + "001110101000\n"
        + "100010110010\n"
        + "100101100011\n"
        + "111000000010\n"
        + "101110110110\n"
        + "011110001011\n"
        + "101101111000\n"
        + "001111001000\n"
        + "010111000101\n"
        + "111111111100\n"
        + "000000011010\n"
        + "001000010110\n"
        + "111110000110\n"
        + "110001110010\n"
        + "101110001000\n"
        + "010100011110\n"
        + "111110001001\n"
        + "010111111100\n"
        + "111100100001\n"
        + "001000010101\n"
        + "010000001011\n"
        + "011000101000\n"
        + "001000010011\n"
        + "111100000111\n"
        + "100110101010\n"
        + "011001011111\n"
        + "101110100111\n"
        + "111011100010\n"
        + "010111110100\n"
        + "010111110110\n"
        + "111010101001\n"
        + "100110100111\n"
        + "100000001000\n"
        + "111001110100\n"
        + "000010101011\n"
        + "101000001111\n"
        + "001000011111\n"
        + "000010010000\n"
        + "110010000001\n"
        + "111110111010\n"
        + "111100101010\n"
        + "101000100111\n"
        + "110101011110\n"
        + "000010001010\n"
        + "100101111000\n"
        + "011001000011\n"
        + "101001000011\n"
        + "010101001000\n"
        + "111111101000\n"
        + "101001001101\n"
        + "010101000101\n"
        + "010010011100\n"
        + "011011011100\n"
        + "100010001111\n"
        + "100000000100\n"
        + "101111101001\n"
        + "011110001110\n"
        + "010110011000\n"
        + "111110110101\n"
        + "010101000010\n"
        + "001100110011\n"
        + "111110100001\n"
        + "110110111100\n"
        + "110101011101\n"
        + "100010111111\n"
        + "101111000111\n"
        + "001100011000\n"
        + "011001001110\n"
        + "101110111111\n"
        + "010110111100\n"
        + "111000001100\n"
        + "000001111110\n"
        + "101001011010\n"
        + "000001101100\n"
        + "110111111110\n"
        + "101010000101\n"
        + "010101001100\n"
        + "011101111001\n"
        + "110101100001\n"
        + "111000010110\n"
        + "100001101101\n"
        + "000000011110\n"
        + "011101001011\n"
        + "011111111000\n"
        + "011001001100\n"
        + "010011001100\n"
        + "001111010000\n"
        + "111111000001\n"
        + "010000010000\n"
        + "010000101001\n"
        + "111001110111\n"
        + "100100000101\n"
        + "100011010011\n"
        + "110111100010\n"
        + "111100110001\n"
        + "000000111000\n"
        + "000101101101\n"
        + "101110001010\n"
        + "011101111100\n"
        + "110000100101\n"
        + "010010111001\n"
        + "011011010111\n"
        + "011111101001\n"
        + "010001100001\n"
        + "110011100011\n"
        + "111010110011\n"
        + "011000101001\n"
        + "000011101001\n"
        + "001000110111\n"
        + "011010010001\n"
        + "101111111111\n"
        + "110011110101\n"
        + "000000100000\n"
        + "101111110010\n"
        + "011100010001\n"
        + "000001100001\n"
        + "000010000001\n"
        + "110110000100\n"
        + "011011001101\n"
        + "101001011111\n"
        + "000111100101\n"
        + "110101111010\n"
        + "100101100100\n"
        + "100001110111\n"
        + "101110001001\n"
        + "110110010110\n"
        + "111000000011\n"
        + "001101110010\n"
        + "010000001000\n"
        + "101001010101\n"
        + "000101111000\n"
        + "110011101110\n"
        + "010010001000\n"
        + "110010010000\n"
        + "011001110111\n"
        + "000010110000\n"
        + "000110100101\n"
        + "000101101001\n"
        + "000110101110\n"
        + "011101100001\n"
        + "100111110010\n"
        + "010100111001\n"
        + "110111111100\n"
        + "110110000001\n"
        + "001011000100\n"
        + "101010101010\n"
        + "011100000001\n"
        + "100001001000\n"
        + "010110110110\n"
        + "011000100001\n"
        + "100001001100\n"
        + "010000110000\n"
        + "111111101100\n"
        + "000101101110\n"
        + "111010101010\n"
        + "101001111100\n"
        + "010011100001\n"
        + "001011001001\n"
        + "100111110110\n"
        + "010111001000\n"
        + "101110000101\n"
        + "110110001110\n"
        + "010000000101\n"
        + "110010010110\n"
        + "011100100011\n"
        + "001111101000\n"
        + "111111011001\n"
        + "010100100010\n"
        + "001111000110\n"
        + "001110000110\n"
        + "110101010001\n"
        + "001100011100\n"
        + "010001101101\n"
        + "011110010100\n"
        + "110000101101\n"
        + "011110011110\n"
        + "110101001100\n"
        + "101011101000\n"
        + "101000001100\n"
        + "101000000010\n"
        + "011010100100\n"
        + "110000000101\n"
        + "000010001001\n"
        + "111010010110\n"
        + "000110110010\n"
        + "101000111001\n"
        + "101001011000\n"
        + "010111011111\n"
        + "000110111101\n"
        + "000100011001\n"
        + "010101110100\n"
        + "101010010111\n"
        + "001010100111\n"
        + "111010101101\n"
        + "101011011101\n"
        + "010011101110\n"
        + "000111111000\n"
        + "111000111011\n"
        + "011101110100\n"
        + "100100111110\n"
        + "011100000101\n"
        + "100011111010\n"
        + "010010010000\n"
        + "001011101111\n"
        + "110011001011\n"
        + "100011111100\n"
        + "000010011101\n"
        + "110010000000\n"
        + "001011010110\n"
        + "010110111110\n"
        + "101011010101\n"
        + "011111111111\n"
        + "001011001011\n"
        + "010101011001\n"
        + "110011110100\n"
        + "111001001111\n"
        + "111001110110\n"
        + "001000000111\n"
        + "111011111110\n"
        + "100100100111\n"
        + "110001110101\n"
        + "011001111110\n"
        + "001101000100\n"
        + "101011000100\n"
        + "110111101000\n"
        + "100100001100\n"
        + "011001011010\n"
        + "001000010001\n"
        + "011001111011\n"
        + "111010011000\n"
        + "111001001110\n"
        + "111100010000\n"
        + "111101100001\n"
        + "001000111110\n"
        + "011111001100\n"
        + "101001111001\n"
        + "010010000110\n"
        + "001010000011\n"
        + "100011100000\n"
        + "111101110110\n"
        + "100111010001\n"
        + "111000011111\n"
        + "100100010110\n"
        + "010100000101\n"
        + "101110001011\n"
        + "101100100011\n"
        + "010000101010\n"
        + "110110101001\n"
        + "010110100101\n"
        + "100000110111\n"
        + "010010000010\n"
        + "101000010001\n"
        + "110001111101\n"
        + "011001011100\n"
        + "011111100011\n"
        + "010100100000\n"
        + "001110011101\n"
        + "100011010001\n"
        + "000111010101\n"
        + "001111000100\n"
        + "001111101011\n"
        + "001001011101\n"
        + "110110101100\n"
        + "011101111010\n"
        + "011110001000\n"
        + "000111001100\n"
        + "010100111000\n"
        + "100100110000\n"
        + "110100001111\n"
        + "010010010110\n"
        + "110111101011\n"
        + "111011011001\n"
        + "011001101010\n"
        + "011011001010\n"
        + "111001101100\n"
        + "000011110001\n"
        + "111111001011\n"
        + "110111100110\n"
        + "110111110011\n"
        + "101010111011\n"
        + "111010110111\n"
        + "000100000010\n"
        + "110011011110\n"
        + "101010111101\n"
        + "000110111000\n"
        + "111011011111\n"
        + "010001110110\n"
        + "000011000100\n"
        + "100001010101\n"
        + "000111001101\n"
        + "111011000011\n"
        + "001110110000\n"
        + "110101111011\n"
        + "011011010100\n"
        + "001100100000\n"
        + "100011101001\n"
        + "010101100110\n"
        + "001101000000\n"
        + "011110100001\n"
        + "000110110011\n"
        + "000000000100\n"
        + "110110111010\n"
        + "000100001101\n"
        + "110101111000\n"
        + "010100101011\n"
        + "000011011011\n"
        + "011011100001\n"
        + "011011001100\n"
        + "000101111100\n"
        + "101010011110\n"
        + "011111100000\n"
        + "100011000101\n"
        + "010111101110\n"
        + "100000110101\n"
        + "001101111100\n"
        + "010111100010\n"
        + "011000000001\n"
        + "101001101111\n"
        + "001011000001\n"
        + "111000110101\n"
        + "000000110100\n"
        + "100001110001\n"
        + "001000101100\n"
        + "001011101100\n"
        + "110010101000\n"
        + "010011001011\n"
        + "001111011000\n"
        + "110001100100\n"
        + "110010100001\n"
        + "100101010100\n"
        + "010000101100\n"
        + "111010101111\n"
        + "000010000100\n"
        + "000101000010\n"
        + "110000101110\n"
        + "010001000110\n"
        + "110001011100\n"
        + "101000111101\n"
        + "111011111100\n"
        + "011100101111\n"
        + "010111100111\n"
        + "110111011001\n"
        + "010100000000\n"
        + "010100101101\n"
        + "101010111001\n"
        + "001010100001\n"
        + "011010010011\n"
        + "111011100101\n"
        + "010110110101\n"
        + "110010101100\n"
        + "000101010111\n"
        + "100010001110\n"
        + "100111101100\n"
        + "001000100001\n"
        + "110111110001\n"
        + "101100011100\n"
        + "100101101001\n"
        + "110010101111\n"
        + "000010001100\n"
        + "011111110010\n"
        + "011111011011\n"
        + "110101010010\n"
        + "001110101100\n"
        + "101111101100\n"
        + "101001101001\n"
        + "011010101010\n"
        + "111110100111\n"
        + "000110001111\n"
        + "100110110100\n"
        + "111011100100\n"
        + "100100101001\n"
        + "000011101100\n"
        + "100001000011\n"
        + "101100001011\n"
        + "000101011011\n"
        + "110001010000\n"
        + "111111011110\n"
        + "000100110100\n"
        + "011110110010\n"
        + "101111100111\n"
        + "010010110100\n"
        + "001001000001\n"
        + "111101101111\n"
        + "000010010001\n"
        + "001011001100\n"
        + "110110010000\n"
        + "101000100110\n"
        + "111100001010\n"
        + "011010101101\n"
        + "011101101110\n"
        + "010101000110\n"
        + "100110011110\n"
        + "011001000100\n"
        + "101111111010\n"
        + "011001101000\n"
        + "001010100100\n"
        + "000101111101\n"
        + "111010110001\n"
        + "001100111110\n"
        + "100000100000\n"
        + "101011101011\n"
        + "011101011110\n"
        + "110011111101\n"
        + "001111000111\n"
        + "101110111011\n"
        + "001110111011\n"
        + "001010100101\n"
        + "111011110111\n"
        + "011011000100\n"
        + "111000001101\n"
        + "111110011101\n"
        + "101001001000\n"
        + "111110001011\n"
        + "100000000110\n"
        + "011100010101\n"
        + "000111101001\n"
        + "110101001000\n"
        + "011000000011\n"
        + "100000001001\n"
        + "111010000100\n"
        + "111110010111\n"
        + "110000010001\n"
        + "100001000110\n"
        + "000100000000\n"
        + "101000100010\n"
        + "011011010011\n"
        + "001000111000\n"
        + "001101101010\n"
        + "000010010100\n"
        + "100101111100\n"
        + "101110110101\n"
        + "101110100010\n"
        + "010100000010\n"
        + "011110001001\n"
        + "111111010011\n"
        + "111111101001\n"
        + "001010000001\n"
        + "100100111000\n"
        + "000011001011\n"
        + "010111000010\n"
        + "000000001101\n"
        + "010100011111\n"
        + "101001010100\n"
        + "001110111111\n"
        + "111110111100\n"
        + "010010101011\n"
        + "100010000001\n"
        + "101001111010\n"
        + "111101000010\n"
        + "100100011101\n"
        + "011111010001\n"
        + "111111011000\n"
        + "110101010110\n"
        + "110101011011\n"
        + "010011110000\n"
        + "010000011001\n"
        + "011000111101\n"
        + "101011011000\n"
        + "110111101101\n"
        + "101010000000\n"
        + "101100100010\n"
        + "111001010111\n"
        + "100101010111\n"
        + "011101101011\n"
        + "011000011010\n"
        + "111010011101\n"
        + "000100011000\n"
        + "110111100011\n"
        + "001100010111\n"
        + "000111100100\n"
        + "011010000000\n"
        + "101010000001\n"
        + "010100011100\n"
        + "110001111001\n"
        + "011111010111\n"
        + "101111110011\n"
        + "101100001000\n"
        + "111011101001\n"
        + "010011001101\n"
        + "100001111110\n"
        + "000111011101\n"
        + "011110100010\n"
        + "010110010010\n"
        + "001110101001\n"
        + "001000100000\n"
        + "000110111110\n"
        + "111110011010\n"
        + "111100100100\n"
        + "010100110000\n"
        + "001101100100\n"
        + "100010111010\n"
        + "010000101111\n"
        + "100001011000\n"
        + "010100101100\n"
        + "101010011001\n"
        + "100111111000\n"
        + "001100001011\n"
        + "111111010000\n"
        + "100001111000\n"
        + "110010000111\n"
        + "000000110101\n"
        + "000101000100\n"
        + "100000101011\n"
        + "101100010100\n"
        + "100111101000\n"
        + "100111100001\n"
        + "100001100111\n"
        + "110001110000\n"
        + "001010100010\n"
        + "110000011010\n"
        + "111010111000\n"
        + "111100111001\n"
        + "011011001111\n"
        + "101011110111\n"
        + "001001010100\n"
        + "111110010011\n"
        + "111000110100\n"
        + "100111110101\n"
        + "001001001110\n"
        + "111000101111\n"
        + "011001110100\n"
        + "011100000110\n"
        + "000111010010\n"
        + "000111000010\n"
        + "111000111010\n"
        + "111100001110\n"
        + "000011111100\n"
        + "000111100001\n"
        + "110111001111\n"
        + "011111000100\n"
        + "101001000001\n"
        + "010001101111\n"
        + "001101001010\n"
        + "001100001100\n"
        + "000111001010\n"
        + "011010011101\n"
        + "000111111100\n"
        + "001011111110\n"
        + "101100101111\n"
        + "100010110001\n"
        + "101100001110\n"
        + "111000011001\n"
        + "010010000011\n"
        + "110000000000\n"
        + "111111011100\n"
        + "100011101010\n"
        + "101000000110\n"
        + "111111101101\n"
        + "001010101101\n"
        + "100101110011\n"
        + "001010111111\n"
        + "101001101000\n"
        + "100100000110\n"
        + "011011000011\n"
        + "000010110110\n"
        + "110110011111\n"
        + "100011100001\n"
        + "010011111100\n"
        + "011001101011\n"
        + "111001110001\n"
        + "111100111000\n"
        + "101010011111\n"
        + "010101111011\n"
        + "000001000100\n"
        + "110010111101\n"
        + "110101010101\n"
        + "100100100010\n"
        + "011000010000\n"
        + "111101011000\n"
        + "111111110101\n"
        + "111010100011\n"
        + "000100100010\n"
        + "001110110101\n"
        + "100001100110\n"
        + "001011000000\n"
        + "001110010101\n"
        + "010101100111\n"
        + "111101100111\n"
        + "000011110111\n"
        + "101000010101\n"
        + "000000101011\n"
        + "100101000111\n"
        + "110011001000\n"
        + "111101101101\n"
        + "111100001101\n"
        + "010101010100\n"
        + "011111001111\n"
        + "011010011011\n"
        + "001100011110\n"
        + "001111110101\n"
        + "010001010010\n"
        + "011010100000\n"
        + "100110100010\n"
        + "110110110001\n"
        + "100101000101\n"
        + "011101101100\n"
        + "111000100001\n"
        + "101011011010\n"
        + "101001100111\n"
        + "100000110110\n"
        + "101101011101\n"
        + "011000101110\n"
        + "000011011100\n"
        + "001010010101\n"
        + "010001010110\n"
        + "010100000100\n"
        + "001101100011\n"
        + "011110110000\n"
        + "101101100110\n"
        + "101011110000\n"
        + "111100111010\n"
        + "001101111010\n"
        + "011011011101\n"
        + "011111000111\n"
        + "001011000110\n"
        + "001110010110\n"
        + "110100101001\n"
        + "111010010010\n"
        + "011100101000\n"
        + "110100110011\n"
        + "111011111101\n"
        + "011011001011\n"
        + "011101101001\n"
        + "000101110110\n"
        + "111010101100\n"
        + "100100011001\n"
        + "111011101110\n"
        + "010001101110\n"
        + "010101011011\n"
        + "111010000110\n"
        + "111111111001\n"
        + "011011001000\n"
        + "110000110011\n"
        + "100010101001\n"
        + "010101100011\n"
        + "010011111010\n"
        + "101111011101\n"
        + "100110000111\n"
        + "110100100101\n"
        + "001000001100\n"
        + "001101100110\n"
        + "110110101111\n"
        + "111001011100\n"
        + "110110001001\n"
        + "010111110011\n"
        + "010000001010\n"
        + "000101100110\n"
        + "001011101101\n"
        + "001010110001\n"
        + "111100011111\n"
        + "110110100100\n"
        + "001001111011\n"
        + "010100010011\n"
        + "000100010011\n"
        + "010011010100\n"
        + "100011000100\n"
        + "001000101111\n"
        + "000011010001\n"
        + "111111001101\n"
        + "101011010001\n"
        + "011101100100\n"
        + "101110110100\n"
        + "100101100101\n"
        + "111000110010\n"
        + "010000010011\n"
        + "011011000010\n"
        + "011010011110\n"
        + "001000110101\n"
        + "011011101010\n"
        + "001101010101\n"
        + "001110110010\n"
        + "111100111100\n"
        + "011011100111\n"
        + "011101001101\n"
        + "010011011001\n"
        + "110100100000\n"
        + "110011010111\n"
        + "010111001100\n"
        + "101110101011\n"
        + "111001001010\n"
        + "010011101011\n"
        + "100000001010\n"
        + "000010101010\n"
        + "001110101011\n"
        + "000100111001\n"
        + "010011111011\n"
        + "110001001110\n"
        + "111111001100\n"
        + "011010100101\n"
        + "101001100010\n"
        + "100110000010\n"
        + "010001001000\n"
        + "111111010001\n"
        + "000110011110\n"
        + "001011011110\n"
        + "000111101100\n"
        + "000001110000\n"
        + "111011011010\n"
        + "110001001010\n"
        + "011110011001\n"
        + "001110100010\n"
        + "001101110110\n"
        + "100011011010\n"
        + "101000111010\n"
        + "010010101101\n"
        + "011100111000\n"
        + "011001100001\n"
        + "011100110110\n"
        + "111101011001\n"
        + "100100010000\n"
        + "101000001001\n"
        + "000000101110\n"
        + "001001000000\n"
        + "111110011000\n"
        + "101110100101\n"
        + "110010001100\n"
        + "110010001001\n"
        + "101110100110\n"
        + "100101000100\n"
        + "001010110110\n"
        + "000001011110\n"
        + "001001011111\n"
        + "011000001001\n"
        + "101001100001\n"
        + "100011011100\n"
        + "010000111111\n"
        + "001001010101\n"
        + "110011010011\n"
        + "010110111011\n"
        + "000010101001\n"
        + "110101101101\n"
        + "110101000111\n"
        + "111110010010\n"
        + "001110111101\n"
        + "100011110101\n"
        + "111000101011\n"
        + "110011101000\n"
        + "111111001000\n"
        + "010010111110\n"
        + "111001111001\n"
        + "100101111111\n"
        + "010011011000\n"
        + "100010010011\n"
        + "111110111001\n"
        + "100000011011\n"
        + "000110000100\n"
        + "101001001100\n"
        + "110101110010\n"
        + "010101101111\n"
        + "101010011010\n"
        + "110110110000\n"
        + "101100110100\n"
        + "110111010001\n"
        + "011011101111\n"
        + "000111110111\n"
        + "011000101010\n"
        + "001011110001\n"
        + "001010010001\n"
        + "110100110110\n"
        + "000101010101\n"
        + "101100101011\n"
        + "001010000110\n"
        + "111101010111\n"
        + "011011111000\n"
        + "011010010010\n"
        + "110010001110\n"
        + "001111100101\n"
        + "101101001111\n"
        + "011110110110\n"
        + "011011011011\n"
        + "101001100100\n"
        + "111001000000\n"
        + "010001101011\n"
        + "010011110101\n"
        + "101011000011\n"
        + "100010100111\n"
        + "100110111010\n"
        + "000010110101\n"
        + "111101010101\n"
        + "100100000100\n"
        + "101111111011\n"
        + "010101000111\n"
        + "000110001101\n"
        + "001101101110\n"
        + "011011011010\n"
        + "010100100001\n"
        + "101101110001\n"
        + "010010100001\n"
        + "011100100101\n"
        + "001110000011\n"
        + "010011011110\n"
        + "000100100011\n"
        + "110101100000\n"
        + "111011010110\n"
        + "110100111111\n"
        + "000101110101\n"
        + "110000000011\n"
        + "010110101101\n"
        + "100001011110\n"
        + "110110101101\n"
        + "001101000010\n"
        + "101110101000\n"
        + "010100101000\n"
        + "110001000010\n"
        + "111111000010\n"
        + "001000111101\n"
        + "001111111001\n"
        + "010100010000").run();
  }

}
