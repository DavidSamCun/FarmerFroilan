package com.zipcodewilmington.froilansfarm.subclasses;

import com.zipcodewilmington.froilansfarm.collections.Farm;
import com.zipcodewilmington.froilansfarm.collections.Shelter;
import com.zipcodewilmington.froilansfarm.interfaces.*;
import com.zipcodewilmington.froilansfarm.superclasses.*;

import java.util.Locale;

public class Farmer extends Person implements Botanist, Rider {

    private Boolean riding = false;

    public Farmer(){
    }

    public Farmer(String name) {
        super(name);
    }


    @Override
    public Crop plant(String typeOfCrop) {

        if (typeOfCrop.toLowerCase(Locale.ROOT).equals("corn")||typeOfCrop.toLowerCase(Locale.ROOT).equals("cornstalk")){
            return new Cornstalk();
        } else if (typeOfCrop.toLowerCase(Locale.ROOT).equals("tomato")||typeOfCrop.toLowerCase(Locale.ROOT).equals("tomatoplant")){
            return new TomatoPlant();
        } else {
            return new PotatoPlant();
        }

    }

//    public <T extends Crop> Boolean plant(T typeOfCrop) {
//
//        return null;
//    }


//    @Override
//    public void eat(Edible food) {
//
//    }

    @Override
    public String makeNoise() {

        return "Waking up real earlivee these days";
    }


    @Override
    public void mountAnimal(Horse horse) {
        riding = true;
        horse.ride(this);
    }

    @Override
    public void mountVehicle(Vehicle vehicle) {
        riding = true;
        vehicle.ride(this);
    }

    @Override
    public void dismountAnimal(Horse horse) {
        horse.unride(this);
        riding = false;
    }

    @Override
    public void dismountVehicle(Vehicle vehicle) {
        vehicle.unride(this);
        riding = false;

    }


    @Override
    public <T extends Edible> void eat(T food) {
        this.eatenMealsList().add(food);
    }

}

