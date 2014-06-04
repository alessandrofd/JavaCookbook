package functional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alessandro.Dantas on 25/03/2014.
 */
public class CameraUtils {
    private static Camera[] list = {
            new Camera(CameraMake.Nikon, "D600", CameraType.DSLR, 2013, 1995, 24, CameraSensor.FullFrame),
            new Camera(CameraMake.Nikon, "1 S=1", CameraType.ILC, 2013, 499.95, 14.4, CameraSensor.Tiny),
            new Camera(CameraMake.Nikon, "P82", CameraType.P_S, 2013, 99.95, 14.4, CameraSensor.Tiny),
    };

    public static List<Camera> getList() { return Arrays.asList(list); }
}
