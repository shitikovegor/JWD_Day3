package com.shitikov.read;

import com.shitikov.exception.ProgramException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class BallReader {

    public String readFile(String filename) throws ProgramException {
        String data = "";
        Path path = Paths.get(filename);
        if(Files.exists(path) && !Files.isDirectory(path) && Files.isReadable(path)) {
            try(Stream<String> dataStream = Files.lines(path)) {
                data = dataStream.reduce((s1, s2) -> s1 + "\n" + s2).orElse("");
            } catch (Exception e) {
                throw new ProgramException("Program error: " + e.getMessage());
            }
        }
        return data;
    }

}
