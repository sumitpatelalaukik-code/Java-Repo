import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor implements Runnable {
    private Path filePath;

    public FileProcessor(Path filePath) {
        this.filePath = filePath;
    }
    @Override
    public void run() {
        try {
            System.out.println(
                Thread.currentThread().getName()
                + " is processing: " + filePath.getFileName()
            );

            String content = Files.readString(filePath);

            int wordCount = content.trim().isEmpty()
                    ? 0
                    : content.trim().split("\\s+").length;

            System.out.println(
                filePath.getFileName()
                + " | Word Count: " + wordCount
            );

            System.out.println(
                Thread.currentThread().getName()
                + " completed: " + filePath.getFileName()
            );

        } catch (IOException e) {
            System.out.println(
                "Error processing " + filePath.getFileName()
            );
            e.printStackTrace();
        }
    }
}
