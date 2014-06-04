package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Alessandro on 25/03/2014.
 */
public class CameraSearchPredicate {
    List<Camera> privateListOfCameras = CameraUtils.getList();

    public List<Camera> search(Predicate<Camera> tester) {
        List<Camera> result = new ArrayList<>();
        privateListOfCameras.forEach(c -> {
            if (tester.test(c))
                result.add(c);
        });
        return result;
    }

    public static void main(String[] args) {
        CameraSearchPredicate searchApp = new CameraSearchPredicate();
        List<Camera> results = searchApp.search(c -> c.isIlc() && c.getPrice() < 500);
        System.out.println(results);
    }
}
