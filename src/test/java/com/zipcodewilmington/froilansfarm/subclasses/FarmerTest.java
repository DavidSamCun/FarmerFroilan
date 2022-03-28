package com.zipcodewilmington.froilansfarm.subclasses;



import com.zipcodewilmington.froilansfarm.collections.ChickenCoop;
import com.zipcodewilmington.froilansfarm.collections.CropRow;
import com.zipcodewilmington.froilansfarm.collections.Farm;
import com.zipcodewilmington.froilansfarm.collections.Field;

import com.zipcodewilmington.froilansfarm.collections.*;
import com.zipcodewilmington.froilansfarm.superclasses.Vehicle;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FarmerTest {

    @Test
    void createFarmerTest(){

        //Given
        String name = "bobbie";

        //
        Farmer farmer1 = new Farmer();
        farmer1.setName(name);
        String actual = farmer1.getName();

        //
        assertEquals(name, actual);

    }

    @Test
    public void eaterTest(){

        //Given
        Egg eggie = new Egg();
        Farmer farmer1 = new Farmer("Bob");
        int expected = 1;
        //When
        farmer1.eat(eggie);

        //Then

        assertEquals(expected, farmer1.getMealsEaten());

    }

    @Test
    public void eaterTest2(){

        //Given
        Egg eggie = new Egg();
        Tomato ketchup = new Tomato();
        Farmer farmer1 = new Farmer("Bob");
        int expected = 2;
        //When
        farmer1.eat(eggie);
        farmer1.eat(ketchup);

        //Then
        assertEquals(expected, farmer1.getMealsEaten());
    }

    @Test
    void plantTest() {

        //Given
        Farmer farmer1 = new Farmer("Joe");
        Cornstalk cornie = new Cornstalk();
        String choice = "corn";
        CropRow row1 = new CropRow();


        //When
        //row1.add(cornie);
        row1.add(farmer1.plant(choice));

        //Then
        int expected = 1;
        Assert.assertEquals(row1.size(),expected);

    }

    @Test
    void plantTest2() {

        //Given
        Farmer farmer1 = new Farmer("Joe");
        Cornstalk cornie = new Cornstalk();
        String choice = "tomato";
        CropRow row1 = new CropRow();


        //When
        //row1.add(cornie);
        for(int i = 0; i<2; i++) {
            row1.add(farmer1.plant(choice));
        }
        int expected = 2;

        //Then

        Assert.assertEquals(row1.size(),expected);

    }

    @Test
    void makeNoise() {

        Farmer joe = new Farmer("Joe");
        String speak = joe.makeNoise();

        System.out.println(joe.makeNoise());

        Assert.assertEquals(speak, joe.makeNoise());
    }

    @Test
    void mountTest() {

        Farmer roger = new Farmer("Roger");
        Horse horsejack = new Horse("Jack");

        roger.mountAnimal(horsejack);

        Assert.assertTrue(horsejack.riderList.contains(roger));

    }

    @Test
    void dismount() {
        //Given
        Farmer roger = new Farmer("Roger");
        Horse horsejack = new Horse("Jack");

        //When
        roger.mountAnimal(horsejack);
        roger.dismountAnimal(horsejack);

        Assert.assertFalse(horsejack.getMountStatus());

    }

    @Test
    void establishingThePlotTest(){

        //Given
        Farmer froilan = new Farmer("Froilan");
        Farmer froilanda = new Farmer("Froilanda");
        Farm froilansFarm = new Farm();
        froilansFarm.setOwner(froilan);
        Field field = new Field();
        CropRow cropRow = new CropRow();
        Cornstalk cornRow1 = new Cornstalk();
        TomatoPlant tomatoRow2 = new TomatoPlant();
        Tractor tractor1 = new Tractor();
        Tractor tractor2 = new Tractor();
        CropDuster cropDuster = new CropDuster("Flyyy");

        froilanda.mountVehicle(cropDuster);


        Stable horseHouse1 = new Stable();
        for(int i = 1; i <=3; i++) {
            Horse horse = new Horse();
            horseHouse1.add(horse);
        }

        Stable horseHouse2 = new Stable();
        for(int i = 1; i <=3; i++) {
            Horse horse = new Horse();
            horseHouse2.add(horse);
        }

        Stable horseHouse3 = new Stable();
        for(int i = 1; i <=3; i++) {
            Horse horse = new Horse();
            horseHouse3.add(horse);
        }

        Stable horseHouse4 = new Stable();
            Horse horse = new Horse();
            horseHouse4.add(horse);


        ChickenCoop chickenHouse1 = new ChickenCoop();
        for(int i = 1; i <=4; i++) {
            Chicken chicken = new Chicken();
            chickenHouse1.add(chicken);
        }

        ChickenCoop chickenHouse2 = new ChickenCoop();
        for(int i = 1; i <=4; i++){
            Chicken chicken = new Chicken();
            chickenHouse2.add(chicken);
        }

        ChickenCoop chickenHouse3 = new ChickenCoop();
        for(int i = 1; i <=4; i++){
            Chicken chicken = new Chicken();
            chickenHouse3.add(chicken);
        }

        ChickenCoop chickenHouse4 = new ChickenCoop();
        for(int i = 1; i <=3; i++){
            Chicken chicken = new Chicken();
            chickenHouse4.add(chicken);
        }







        //

        froilansFarm.add(field);
        cropRow.add(cornRow1);
        cropRow.add(tomatoRow2);
        field.add(cropRow);


        //
        Assert.assertTrue(cropDuster.ridersList().contains(froilanda));
        Assert.assertEquals(horseHouse1.size(), 3);
        Assert.assertEquals(horseHouse2.size(), 3);
        Assert.assertEquals(horseHouse3.size(), 3);
        Assert.assertEquals(horseHouse4.size(), 1);
        Assert.assertEquals(chickenHouse1.size(), 4);
        Assert.assertEquals(chickenHouse2.size(), 4);
        Assert.assertEquals(chickenHouse3.size(), 4);
        Assert.assertEquals(chickenHouse4.size(), 3);
        Assert.assertEquals(cropRow.size(), 2);
        Assert.assertEquals(froilansFarm.getOwner(),froilan);

    }
}