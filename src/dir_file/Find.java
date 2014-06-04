package dir_file;

import environ.GetOpt;

import java.io.File;

public class Find {
    public static void main(String[] args) {
        Find finder = new Find();
        GetOpt argHandler = new GetOpt("n:s:");
        int c;
        while ((c = argHandler.getopt(args)) != GetOpt.DONE) {
            switch (c) {
                case 'n':
                    finder.filter.setNameFilter(argHandler.optarg());
                    break;
                case 's':
                    finder.filter.setSizeFilter(argHandler.optarg());
                    break;
                default:
                    System.out.println("Got: " + c);
                    usage();
            }
        }
        if (args.length == 0 || argHandler.getOptind() == args.length) {
            finder.doName(".");
        } else {
            for (int i = argHandler.getOptind(); i < args.length; i++) {
                finder.doName(args[i]);
            }
        }
    }

    protected FindFilter filter = new FindFilter();

    public static void usage() {
        System.err.println("Usage: Find [-n nameFilter][-s sizeFilter][dir...]");
        System.exit(1);
    }

    /** doName - handle one filesystem object by name */
    private void doName(String s) {
        File f = new File(s);
        if (!f.exists()) {
            System.out.println(s + " does not exist");
            return;
        }
        if (f.isFile()) {
            doFile(f);
        } else if (f.isDirectory()) {
            String[] objects = f.list(filter);
            for (String o : objects) {
                doName(s + File.separator + o);
            }
        } else {
            System.err.println("Unknown type: " + s);
        }
    }

    /** doFile - process one regular file */
    private void doFile(File f) {
        System.out.println("f " + f.getPath());
    }
}
