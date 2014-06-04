package functional;

/**
 * Created by Alessandro.Dantas on 25/03/2014.
 */
public class MyIlcPriceAcceptor implements CameraAcceptor {
    public boolean choose(Camera c) { return c.isIlc() && c.getPrice() < 500; }
}
