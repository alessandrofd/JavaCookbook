package functional;

import java.util.List;

/**
 * Created by Alessandro on 25/03/2014.
 */
public class CameraSearchParallelStream {

    static List<Camera> privateListOfCameras = CameraUtils.getList();

    public static void main(String[] args) {
        for (Object camera : privateListOfCameras.parallelStream()
                .filter(c -> c.isIlc() && c.getPrice() < 500)
                .toArray()) {
            System.out.println(camera);
        }
    }
}
