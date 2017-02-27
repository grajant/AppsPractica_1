package com.example.glego.resistorsapp;

import java.util.ArrayList;

/**
 * Created by HOME-I on 19/02/2017.
 */

public class ResistorCode {
    public String color;
    public String band;
    public int imageId;

    public ResistorCode(String color, String band, int imageId){
        this.color = color;
        this.band = band;
        this.imageId = imageId;
    }

    public static ArrayList<ResistorCode> defaultValues() {
        ArrayList<ResistorCode> users = new ArrayList<>();
        users.add(new ResistorCode("Marrón", "Primera banda", R.drawable.brown_color));
        users.add(new ResistorCode("Negro", "Segunda banda", R.drawable.black_color));
        users.add(new ResistorCode("Rojo", "Multiplicador", R.drawable.red_color));
        users.add(new ResistorCode("Dorado", "Tolerancia", R.drawable.golden_color));
        return users;
    }

    public static ArrayList<ResistorCode> firstBandValues(){
        ArrayList<ResistorCode> bands = new ArrayList<>();
        bands.add(new ResistorCode("Marrón", "1", R.drawable.brown_color));
        bands.add(new ResistorCode("Rojo", "2", R.drawable.red_color));
        bands.add(new ResistorCode("Naranja", "3", R.drawable.orange_color));
        bands.add(new ResistorCode("Amarillo", "4", R.drawable.yellow_color));
        bands.add(new ResistorCode("Verde", "5", R.drawable.green_color));
        bands.add(new ResistorCode("Azul", "6", R.drawable.blue_color));
        bands.add(new ResistorCode("Violeta", "7", R.drawable.violet_color));
        bands.add(new ResistorCode("Gris", "8", R.drawable.gray_color));
        bands.add(new ResistorCode("Blanco", "9", R.drawable.white_color));
        return bands;
    }

    public static ArrayList<ResistorCode> secondBandValues(){
        ArrayList<ResistorCode> bands = new ArrayList<>();
        bands.add(new ResistorCode("Negro", "0", R.drawable.black_color));
        bands.add(new ResistorCode("Marrón", "1", R.drawable.brown_color));
        bands.add(new ResistorCode("Rojo", "2", R.drawable.red_color));
        bands.add(new ResistorCode("Naranja", "3", R.drawable.orange_color));
        bands.add(new ResistorCode("Amarillo", "4", R.drawable.yellow_color));
        bands.add(new ResistorCode("Verde", "5", R.drawable.green_color));
        bands.add(new ResistorCode("Azul", "6", R.drawable.blue_color));
        bands.add(new ResistorCode("Violeta", "7", R.drawable.violet_color));
        bands.add(new ResistorCode("Gris", "8", R.drawable.gray_color));
        bands.add(new ResistorCode("Blanco", "9", R.drawable.white_color));
        return bands;
    }

    public static ArrayList<ResistorCode> multiplierBand(){
        ArrayList<ResistorCode> bands = new ArrayList<>();
        bands.add(new ResistorCode("Plateado", "x0.01", R.drawable.silver_color));
        bands.add(new ResistorCode("Dorado", "x0.1", R.drawable.golden_color));
        bands.add(new ResistorCode("Negro", "x1", R.drawable.black_color));
        bands.add(new ResistorCode("Marrón", "x10", R.drawable.brown_color));
        bands.add(new ResistorCode("Rojo", "x100", R.drawable.red_color));
        bands.add(new ResistorCode("Naranja", "x1000", R.drawable.orange_color));
        bands.add(new ResistorCode("Amarillo", "x10000", R.drawable.yellow_color));
        bands.add(new ResistorCode("Verde", "x100000", R.drawable.green_color));
        bands.add(new ResistorCode("Azul", "x1000000", R.drawable.blue_color));
        bands.add(new ResistorCode("Violeta", "x10000000", R.drawable.violet_color));
        return bands;
    }

    public static ArrayList<ResistorCode> toleranceBand(){
        ArrayList<ResistorCode> bands = new ArrayList<>();
        bands.add(new ResistorCode("Dorado", "±5%", R.drawable.golden_color));
        bands.add(new ResistorCode("Plateado", "±10%", R.drawable.silver_color));
        return bands;
    }
}
