package classes.operationalHelpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public FileReader(){
    }

    public List<String> readLines(File file) {
        List<String> linesFmFile = new ArrayList<>();
        Path path = Paths.get(String.valueOf(file));

        try(Stream<String> linesStream = Files.lines(path)){
            linesFmFile = linesStream.collect(Collectors.toList());
        } catch (IOException e){
            System.out.println(e);
        }

        return linesFmFile;
    }
}
