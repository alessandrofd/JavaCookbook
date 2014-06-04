package oo.interfaces;

/**
 * Created by Alessandro on 24/03/2014.
 */
public class ComputerMonitor extends ComputerAsset implements PowerSwitchable {
    public ComputerMonitor(int deskNumber) { super(deskNumber); }

    public void powerUp() { System.out.println("Warming up monitor at desk " + deskNumber); }
    public void powerDown() { System.out.println("Dousing monitor at desk " + deskNumber); }

    @Override
    public String toString() { return "Monitor " + deskNumber; }
}
