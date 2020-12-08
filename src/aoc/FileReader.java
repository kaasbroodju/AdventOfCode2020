package aoc;

import java.io.File;

public interface FileReader<ReturnType> {
    ReturnType readFile(File file);
}
