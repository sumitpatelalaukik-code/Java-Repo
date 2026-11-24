import java.nio.file.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        try {
            Path folder = Paths.get("Files");

            DirectoryStream<Path> files =
                    Files.newDirectoryStream(folder);

            for (Path file : files) {
                if (Files.isRegularFile(file)) {
                    executor.submit(new FileProcessor(file));
                }
            }
            files.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("\nAll file processing tasks finished!");
    }
}
