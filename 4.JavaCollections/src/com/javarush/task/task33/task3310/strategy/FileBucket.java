package com.javarush.task.task33.task3310.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

public class FileBucket implements Serializable{
    Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("temp", "");
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
        }
        path.toFile().deleteOnExit();

    }

    public long getFileSize() {
        long ans = 0;
        try {
            ans = Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(Files.newOutputStream(path))) {
                oos.writeObject(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Entry getEntry() {
        Entry e = null;
        if (getFileSize() <= 0) return null;
        try (ObjectInputStream ois =
                new ObjectInputStream(Files.newInputStream(path))) {
            e = (Entry) ois.readObject();
        } catch (IOException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        return e;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
