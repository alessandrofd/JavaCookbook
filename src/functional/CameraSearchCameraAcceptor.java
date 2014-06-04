package functional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alessandro.Dantas on 25/03/2014.
 */
public class CameraSearchCameraAcceptor {

    List<Camera> privateListOfCameras = CameraUtils.getList();

    public List<Camera> search(CameraAcceptor acceptor) {
        List<Camera> results = new ArrayList<>();
        for (Camera c : privateListOfCameras) {
            if (acceptor.choose(c))
                results.add(c);
        }
        return results;
    }

    public static void main(String[] args) {
        CameraSearchCameraAcceptor searchApp = new CameraSearchCameraAcceptor();

        List<Camera> results = searchApp.search(new MyIlcPriceAcceptor());
        System.out.println("Concrete class: " + results);

        results = searchApp.search(new CameraAcceptor() {
            @Override
            public boolean choose(Camera c) {
                return c.isIlc() && c.getPrice() < 500;
            }
        });
        System.out.println("Inner class: " + results);

        results = searchApp.search((c) -> { return c.isIlc() && c.getPrice() < 500; });
        System.out.println(results);

        // Writing it as a Lambda expression:
        results = searchApp.search(c -> c.isIlc() && c.getPrice() < 500);
        System.out.println("Lambda: " + results);
    }



}
