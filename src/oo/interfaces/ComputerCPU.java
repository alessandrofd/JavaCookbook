package oo.interfaces;

/**
 * Created by Alessandro on 24/03/2014.
 */
public class ComputerCPU extends ComputerAsset {
    public ComputerCPU(int deskNumber) { super(deskNumber); }

    @Override
    public String toString() { return "CPU " + deskNumber; }
}
