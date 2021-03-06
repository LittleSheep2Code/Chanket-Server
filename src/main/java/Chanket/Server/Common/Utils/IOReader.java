package Chanket.Server.Common.Utils;

import lombok.SneakyThrows;

import java.io.*;
import java.util.Arrays;
import java.util.Vector;

public class IOReader {

    @SneakyThrows
    public static String read(InputStream inputStream) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String readingLine;
            while ((readingLine = reader.readLine()) != null) {
                result.append(readingLine).append("\n");
            }
        }
        return result.toString();
    }

    @SneakyThrows
    public static InputStream merge(InputStream[] targets) {
        Vector<InputStream> inputList = new Vector<>(Arrays.asList(targets));

        SequenceInputStream sequenceInputStream = new SequenceInputStream(inputList.elements());
        return new ByteArrayInputStream(sequenceInputStream.readAllBytes());
    }
}
