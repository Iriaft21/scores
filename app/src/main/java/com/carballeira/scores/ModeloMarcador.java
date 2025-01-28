package com.carballeira.scores;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ModeloMarcador extends ViewModel {

    private MutableLiveData<Integer> puntosA;
    private MutableLiveData<Integer> puntosB;

    public ModeloMarcador (){
        this.puntosA = new MutableLiveData<>(0);
        this.puntosB = new MutableLiveData<>(0);
    }

    public LiveData<Integer> getPuntosA() {
        return puntosA;
    }

    public void setPuntosA(int puntosA) {
        MutableLiveData<Integer> pA = new MutableLiveData<>(puntosA);
        pA.setValue(getPuntosA());

    }

    public LiveData<Integer> getPuntosB() {
        return puntosB;
    }

    public void setPuntosB(int puntosB) {
        this.puntosB = puntosB;
    }

    @Override
    public String toString() {
        return "ModeloMarcador{" +
                "puntosA=" + puntosA +
                ", puntosB=" + puntosB +
                '}';
    }
}
