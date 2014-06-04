package oo.interfaces;

/**
 * Created by Alessandro on 24/03/2014.
 */
public abstract class BuildingLight extends BuildingAsset {
    public BuildingLight(int room) { super(room); }

    @Override
    public String toString() { return "Light" + " " + room; }
}
