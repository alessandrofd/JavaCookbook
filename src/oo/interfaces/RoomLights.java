package oo.interfaces;

/**
 * Created by Alessandro on 24/03/2014.
 */
public class RoomLights extends BuildingLight implements PowerSwitchable {
    public RoomLights(int roomNumber) { super(roomNumber); }
    public void powerDown() { System.out.println("Dousing lights in room " + room); }
    public void powerUp() { System.out.println("Lighting lights in room " + room); }
}
