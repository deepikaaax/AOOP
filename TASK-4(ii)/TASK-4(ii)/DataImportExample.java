import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

abstract class DataImporter {

    public final void importData(String filePath) throws IOException {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            String data = new String(bytes);
            List<String> parsedData = parseData(data);
            List<String> validatedData = validateData(parsedData);
            saveData(validatedData);
        } catch (java.nio.file.NoSuchFileException e) {
            System.err.println("Error: File not found: " + filePath);
            // Handle the exception appropriately, e.g., exit or prompt for a new file.
            // For now, we'll just print the error and exit.
            System.exit(1); // Or you could return from the importData method.
        }
    }

    protected abstract List<String> parseData(String data);

    protected abstract List<String> validateData(List<String> parsedData);

    protected abstract void saveData(List<String> validatedData) throws IOException;
}

class CSVImporter extends DataImporter {

    @Override
    protected List<String> parseData(String data) {
        List<String> parsedData = new ArrayList<>();
        String[] lines = data.split("\n");
        for (String line : lines) {
            parsedData.add(line); 
        }
        return parsedData;
    }

    @Override
    protected List<String> validateData(List<String> parsedData) {
        List<String> validatedData = new ArrayList<>();
        for (String row : parsedData) {
            String[] values = row.split(",");
            if (values.length >= 2) {
                validatedData.add(row);
            }
        }
        return validatedData;
    }

    @Override
    protected void saveData(List<String> validatedData) throws IOException {
        Files.write(Paths.get("output.csv"), validatedData); 
    }
}

public class DataImportExample {

    public static void main(String[] args) throws IOException {
        String filePath = "data.csv"; // Or specify the path via command-line arguments (see below)

        CSVImporter csvImporter = new CSVImporter();
        csvImporter.importData(filePath); 
    }
}