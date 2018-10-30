package com.mobiquityinc;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.Packer;

/**
 * Main class that requires one argument - absolute path of input file.
 */
public class Main {

    public static void main(String[] args) throws APIException {
        if(args.length < 1) {
            throw new APIException("Absolute path of input file required.");
        }
        System.out.println(Packer.pack(args[0]));
    }
}
