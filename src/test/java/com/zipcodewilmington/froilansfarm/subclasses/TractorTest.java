package com.zipcodewilmington.froilansfarm.subclasses;

import com.zipcodewilmington.froilansfarm.collections.CropRow;
import com.zipcodewilmington.froilansfarm.collections.Field;
import com.zipcodewilmington.froilansfarm.superclasses.Edible;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TractorTest {

    @Test
    public void createTractorTest(){

        //Given
        String name = "Tonka";
        Tractor truck = new Tractor(name);

        //When
        truck.getName();

        //Then
        Assert.assertEquals(name, truck.getName());

    }

    @Test
    public void rideTractorTest(){

        //Given
        Farmer farmerJoe = new Farmer("Joe");
        Tractor tractorTonka = new Tractor("Tonka");

        //When
        farmerJoe.mountVehicle(tractorTonka);

        //Then
        tractorTonka.ridersList();

        Assert.assertTrue(tractorTonka.ridersList().contains(farmerJoe));

    }

    @Test
    public void mountStatusCheck(){

        //Given
        Farmer farmerJoe = new Farmer("Joe");
        Tractor tractorTonka = new Tractor("Tonka");

        //When
        farmerJoe.mountVehicle(tractorTonka);

        //Then
        Assert.assertTrue(tractorTonka.getMountStatus());
        Assert.assertTrue( tractorTonka.ridersList().contains(farmerJoe));

    }

    @Test
    public void disMountTest(){

        //Given
        Farmer farmerJoe = new Farmer("Joe");
        Tractor tractorTonka = new Tractor("Tonka");

        //When
        farmerJoe.mountVehicle(tractorTonka);
        farmerJoe.dismountVehicle(tractorTonka);

        //Then
        Assert.assertTrue(tractorTonka.ridersList().isEmpty());
    }

    @Test
    public void harvestFieldTest(){

        //Give
        Farmer bob = new Farmer("Bob");
        CropDuster dust1 = new CropDuster("dustie");
        Tractor tonka = new Tractor("Tonka");

        Field cropField = new Field();
        CropRow cornstalkCropRow = new CropRow<>();
        Cornstalk corn1 = new Cornstalk();
        Cornstalk corn2 = new Cornstalk();
        cornstalkCropRow.add(corn1);
        cornstalkCropRow.add(corn2);
        cropField.add(cornstalkCropRow);

        //When
        bob.mountVehicle(dust1);
        dust1.flyTakeoff();
        dust1.fertalize(cropField);

        tonka.harvestCrop(cropField.getCropRow(0));
        cropField.getCropRow(0).harvestCropRow();

        //Then
        Assert.assertEquals(cropField.getCropRow(0).size(), 0);

    }

    @Test
    public void harvestEdibles(){

        //Give
        Farmer bob = new Farmer("Bob");
        Farmer joe = new Farmer("Joe");
        CropDuster dust1 = new CropDuster("dustie");
        Tractor tonka = new Tractor("Tonka");
        ArrayList<Edible> harvestBasket = new ArrayList<>();

        Field cropField = new Field();
        CropRow cornstalkCropRow = new CropRow<>();
        Cornstalk corn1 = new Cornstalk();
        Cornstalk corn2 = new Cornstalk();
        cornstalkCropRow.add(corn1);
        cornstalkCropRow.add(corn2);
        cropField.add(cornstalkCropRow);

        //When
        bob.mountVehicle(dust1);
        joe.mountVehicle(tonka);
        dust1.flyTakeoff();
        dust1.fertalize(cropField);
        tonka.harvestCrop(cropField.getCropRow(0));

        //Then
        Assert.assertEquals(2, tonka.trunk.size());


    }

    @Test
    public void truckMakeNoiseTest(){
        Tractor tonka = new Tractor("Tonka");
        String expected = "Tractor go Beep Beep";
        System.out.println(tonka.makeNoise());

        Assert.assertEquals(expected,tonka.makeNoise());
    }

}


//Given

//When

//Then