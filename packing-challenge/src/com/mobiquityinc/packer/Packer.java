package com.mobiquityinc.packer;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.Pack;
import com.mobiquityinc.parser.InputFileParser;

import java.util.List;

/**
 * The Packer class that solves knapsack problem.
 * Dynamic programming algorithm bottom-up used since time complexity: O(nW).
 */
public class Packer {

  /**
   * Pack string.
   *
   * @param path the absolute path of input file
   * @return the solution string
   * @throws APIException the api exception
   */
  public static String pack(String path) throws APIException {
      InputFileParser inputParser = new InputFileParser();
      List<Pack> packs = inputParser.parseFile(path);

      StringBuilder resultBuilder = new StringBuilder();
      Solver dynamicAlgorithmSolver = new DynamicAlgorithmSolver();

      for(Pack pack : packs) {
            resultBuilder.append(dynamicAlgorithmSolver.solve(pack));
            resultBuilder.append("\n");
      }

      return resultBuilder.toString();
    }
}
