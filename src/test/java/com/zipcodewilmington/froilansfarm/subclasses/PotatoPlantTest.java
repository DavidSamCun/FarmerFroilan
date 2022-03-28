package com.zipcodewilmington.froilansfarm.subclasses;

import com.zipcodewilmington.froilansfarm.superclasses.Crop;
import com.zipcodewilmington.froilansfarm.superclasses.Edible;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotatoPlantTest {

    @Test
    void yieldNotHarvestedTest() {
        Crop testPotatoPlant = new PotatoPlant();
        testPotatoPlant.setHarvested(false);
        Edible actual = testPotatoPlant.yield();
        Assert.assertTrue(actual instanceof Potato);
    }

    @Test
    void yieldWhenHarvestedTest() {
        Crop testPotatoPlant = new PotatoPlant();
        testPotatoPlant.setHarvested(true);
        Edible actual = testPotatoPlant.yield();
        Assert.assertFalse(actual instanceof Potato);
    }

}