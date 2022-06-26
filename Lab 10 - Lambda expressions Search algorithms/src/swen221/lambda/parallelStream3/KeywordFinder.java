package swen221.lambda.parallelStream3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class KeywordFinder {
    public static long count1(String keyword, Path file) {
        // record the position where each occurrence
        // appears in the file
        try (Stream<String> stream = Files.lines(file).parallel()) {
            return stream.reduce(/*FixME*/9999L,
                (count, line) -> {
                  List<String> words = Arrays.asList(line.split(" "));
                  return /*FIXME*/0L;
            } ,
            /*FIXME*/null);
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    public static long count2(String keyword, Path file) {
        // record the position where each occurrence
        // appears in the file
        try (Stream<String> stream = Files.lines(file).parallel()) {
            Stream<String> s = stream.flatMap(l -> Stream.of(l.split(" ")));
            return s.reduce(/*FixME*/9999L,
              /*FIXME*/null,
              /*FIXME*/null
              );
        } catch (IOException e) {
            throw new Error(e);
        }
    }
}
