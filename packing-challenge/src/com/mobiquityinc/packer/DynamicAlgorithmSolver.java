package com.mobiquityinc.packer;

import com.mobiquityinc.model.Item;
import com.mobiquityinc.model.Pack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Dynamic algorithm solver.
 * Time Complexity: O(nW) where n is the number of items and W is the capacity of knapsack.
 */
public class DynamicAlgorithmSolver implements Solver {

  @Override
  public String solve(Pack pack) {

    int values[] = new int[pack.getItems().size()];
    for (int i = 0; i < pack.getItems().size(); i++) {
      values[i] = pack.getItems().get(i).getCost();
    }

    int weights[] = new int[pack.getItems().size()];
    for (int i = 0; i < pack.getItems().size(); i++) {
      weights[i] = (int) (pack.getItems().get(i).getWeight() * 100);
    }

    List<Integer> resultWeights = coreAlgorithm(pack.getMaxWeight() * 100, weights, values, pack.getItems().size());

    //select items based on weights
    List<Item> resultItems = pack.getItems().stream()
            .filter(itemModel -> resultWeights.contains((int) (itemModel.getWeight() * 100)))
            .collect(Collectors.toList());

    StringBuilder resultStr = new StringBuilder();

    //prefer	to	send	a	package	which	weights	less	in	case	there	is	more	than	one	package	with	the same	price
    resultItems.stream().forEach(resultItem -> {
      Optional<Item> itemToReplace = pack.getItems().stream()
              .filter(item -> !resultItems.contains(item)
                      && item.getCost() == resultItem.getCost()
                      && item.getWeight() < resultItem.getWeight())
              .min(Comparator.comparing(Item::getWeight));

      if(itemToReplace.isPresent()) {
        resultStr.append(itemToReplace.get().getIndex());
        resultStr.append(",");
      } else {
        resultStr.append(resultItem.getIndex());
        resultStr.append(",");
      }
    });

    if (resultStr.length() == 0) {
      resultStr.append("-");
    } else {
      resultStr.deleteCharAt(resultStr.length() - 1);
    }

    return resultStr.toString().trim();
  }

  private List<Integer> coreAlgorithm(int capacity, int weights[], int values[], int n) {

    int K[][] = new int[n + 1][capacity + 1];

    for (int i = 0; i <= n; i++) {
      for (int w = 0; w <= capacity; w++) {
        if (i == 0 || w == 0)
          K[i][w] = 0;
        else if (weights[i - 1] <= w)
          K[i][w] = Math.max(values[i - 1] + K[i - 1][w - weights[i - 1]], K[i - 1][w]);
        else
          K[i][w] = K[i - 1][w];
      }
    }

    List<Integer> itemsWeight = new LinkedList<>();

    int results = K[n][capacity];
    int w = capacity;

    for (int i = n; i > 0 && results > 0; i--)
      if (!(results == K[i - 1][w])) {
        // This item is included.
        itemsWeight.add(weights[i - 1]);
        // Since this weight is included its value is deducted
        results = results - values[i - 1];
        w = w - weights[i - 1];
      }

    return itemsWeight;
  }


}
