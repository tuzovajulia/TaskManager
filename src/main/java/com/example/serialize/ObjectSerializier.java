package com.example.serialize;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public final class ObjectSerializier {
    private ObjectSerializier() {

    }

    private static final String DEFAULT_DIR = "data";

    public static void serialize(Object o, String fileName) {
        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            oos.writeObject(o);
            System.out.println("Object was serialize into the file " + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(String fileName) {
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fileName))) {
            Object o = ois.readObject();
            System.out.println("Object was deserialize from the file " + fileName);
            return o;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
