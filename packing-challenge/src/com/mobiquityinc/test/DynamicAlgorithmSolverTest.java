package com.mobiquityinc.test;

import com.mobiquityinc.model.Pack;
import com.mobiquityinc.packer.DynamicAlgorithmSolver;
import com.mobiquityinc.parser.PackParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicAlgorithmSolverTest {

  @Test
  public void shouldSelectMaxWeight() {

    String packStr1 = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";
    String packStr2 = "8 : (1,15.3,€34) ";
    String packStr3 = "75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) " +
            "(6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)";
    String packStr4 = "56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) " +
            "(6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)";

    Pack pack1 = new PackParser().parsePack(packStr1);
    Pack pack2 = new PackParser().parsePack(packStr2);
    Pack pack3 = new PackParser().parsePack(packStr3);
    Pack pack4 = new PackParser().parsePack(packStr4);

    assertEquals("4", new DynamicAlgorithmSolver().solve(pack1));
    assertEquals("-", new DynamicAlgorithmSolver().solve(pack2));
    assertEquals("2,7", new DynamicAlgorithmSolver().solve(pack3));
    assertEquals("8,9", new DynamicAlgorithmSolver().solve(pack4));

  }

}
