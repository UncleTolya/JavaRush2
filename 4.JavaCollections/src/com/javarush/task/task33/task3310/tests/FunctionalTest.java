package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String firstString = Helper.generateRandomString();
        String secondString = Helper.generateRandomString();
        String thirdString = firstString;

        Long firstKey = shortener.getId(firstString);
        Long secondKey = shortener.getId(secondString);
        Long thirdKey = shortener.getId(thirdString);

        Assert.assertNotEquals(secondKey, firstKey);
        Assert.assertNotEquals(secondKey, thirdKey);
        Assert.assertEquals(firstKey, thirdKey);

        String getFirstString = shortener.getString(firstKey);
        String getSecondString = shortener.getString(secondKey);
        String getThirdString = shortener.getString(thirdKey);

        Assert.assertEquals(firstString, getFirstString);
        Assert.assertEquals(secondString, getSecondString);
        Assert.assertEquals(thirdString, getThirdString);
    }
    @Test
    public void testHashMapStorageStrategy() {
        HashMapStorageStrategy strategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        OurHashMapStorageStrategy strategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        FileStorageStrategy strategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        HashBiMapStorageStrategy strategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        DualHashBidiMapStorageStrategy strategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        OurHashBiMapStorageStrategy strategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
}
