package oo.interfaces;

/**
 * Created by Alessandro on 24/03/2014.
 */
public class BuildingManagement {
    Asset[] things = new Asset[24];
    int numItems = 0;

    public void goodNight() {
        for (int i = 0; i < things.length; i++)
            if (things[i] instanceof PowerSwitchable)
                ((PowerSwitchable)things[i]).powerDown();
    }

    public void add(Asset thing) {
        System.out.println("Adding " + thing);
        things[numItems++] = thing;
    }

    public static void main(String[] args) {
        BuildingManagement bm = new BuildingManagement();
        bm.add(new RoomLights(101));
        bm.add(new EmergencyLight(101));
        bm.add(new ComputerCPU(10104));
        bm.add(new ComputerMonitor(10104));

        bm.goodNight();
    }
}
