package com.zipcodewilmington.froilansfarm.subclasses;

import com.zipcodewilmington.froilansfarm.collections.CropRow;
import com.zipcodewilmington.froilansfarm.interfaces.Harvest;

import com.zipcodewilmington.froilansfarm.superclasses.Crop;

import com.zipcodewilmington.froilansfarm.superclasses.Edible;
import com.zipcodewilmington.froilansfarm.superclasses.Person;

import com.zipcodewilmington.froilansfarm.superclasses.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Tractor extends Vehicle implements Harvest {

    private Boolean mounted = false;
    List<Crop> tractorTrailer = new ArrayList<>();
    List<Edible> trunk = new ArrayList<>();

    public Tractor(){

    }

    public Tractor(String name) {
        super(name);
    }

//    public void harvestCrop(CropRow<Crop> cropRow){
//
//        for(int i = 0; i<cropRow.size(); i++){
//            tractorTrailer.add(cropRow.get(i));
//            cropRow.get(i).setHarvested(true);
//        }
//
//    }

//    public void harvestEdible(){
//
//        for (int i = 0; i<tractorTrailer.size(); i++){
//            trunk.add(tractorTrailer.get(i).yield());
//            tractorTrailer.get(i).setHarvested(true);
//        }
//    }

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



//    public <T extends Crop> T harvestCrop2(List<T> crops) {
//
//        for (int i = 0; i<tractorTrailer.size(); i++){
//            trunk.add(crops.get(i).yield());
//            crops.get(i).setHarvested(true);
//        }
//
//        return null;
//    }

    @Override
    public void harvestCrop(CropRow<Crop> cropRow) {

        if(mounted){
            for (int i = 0; i<cropRow.size(); i++){
                trunk.add(cropRow.get(i).yield());
                cropRow.get(i).setHarvested(true);
            }
        }
        else{
            System.out.println("No one in vehicle. Can't Harvest");
        }
    }
}

