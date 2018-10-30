package com.mobiquityinc.parser;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.Pack;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * The type Input file parser.
 */
public class InputFileParser {

    /**
     * Parse file list.
     *
     * @param path the path
     * @return the list
     * @throws APIException the api exception
     */
    public List<Pack> parseFile(String path) throws APIException {

        if (!new File(path).isFile()) {
            throw new APIException("File not found.");
        }

        List<Pack> packs = new LinkedList<>(); // LinkedList used since only iterating packs
        PackParser packParser = new PackParser();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(line -> packs.add(packParser.parsePack(line)));
        } catch (IOException e) {
            throw new APIException(String.format("I/O exception while opening file. %s", e.getMessage()));
        }

        return packs;
    }

}
