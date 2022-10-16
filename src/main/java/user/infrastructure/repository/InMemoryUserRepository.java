package user.infrastructure.repository;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

public class InMemoryUserRepository {
    private final String fileName;

    public InMemoryUserRepository(String fileName) {
        this.fileName = fileName;
    }

    public void writeInFile(String content) throws IOException {
        RandomAccessFile stream = new RandomAccessFile(fileName, "rw");
        FileChannel channel = stream.getChannel();

        FileLock lock = null;
        try {
            lock = channel.tryLock();
        } catch (final OverlappingFileLockException e) {
            stream.close();
            channel.close();
        }
        stream.writeChars(content);
        lock.release();

        stream.close();
        channel.close();
    }
}
