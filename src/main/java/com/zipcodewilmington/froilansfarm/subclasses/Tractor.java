package com.zipcodewilmington.froilansfarm.subclasses;

import com.zipcodewilmington.froilansfarm.interfaces.Harvest;
<
import com.zipcodewilmington.froilansfarm.superclasses.Crop;

import com.zipcodewilmington.froilansfarm.superclasses.Person;

import com.zipcodewilmington.froilansfarm.superclasses.Vehicle;

import java.util.List;

public class Tractor extends Vehicle implements Harvest {

    private Boolean mounted = false;


    public Tractor(String name) {
        super(name);
    }

    @Override
    public String makeNoise() {
        return "Tractor go Beep Beep";
    }

    @Override
    public void ride(Person person) {
        ridersList().add(person);
        mounted = true;
    }

    @Override
    public void unride(Person person) {
        ridersList().remove(person);
        if(ridersList().isEmpty()){
            mounted = false;
        }
    }

    @Override
    public Boolean getMountStatus() {
        return mounted;
    }


    @Override
    public <T extends Crop> T harvestCrop(List<T> crops) {
        return null;
    }
}

