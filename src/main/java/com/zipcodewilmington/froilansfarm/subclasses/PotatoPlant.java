package com.zipcodewilmington.froilansfarm.subclasses;

import com.zipcodewilmington.froilansfarm.interfaces.Produce;
import com.zipcodewilmington.froilansfarm.superclasses.Crop;

public class PotatoPlant extends Crop implements Produce {
    public PotatoPlant() {}

    @Override
    public Potato yield() {
        if(!isHarvested()){
            return new Potato();
        }

        return null;
    }
}
