import java.io.IOException;

public class NBody {
    private static final String BACKGROUND_IMAGE_PATH = "images/starfield.jpg";

    public static double readRadius(String filename) {
        In in = new In(filename);
        in.readInt();
        return in.readDouble();

    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int num = in.readInt();
            in.readDouble();
            Planet[] planets = new Planet[num];
            for (int i = 0; i < num; i++) {
                planets[i] = new Planet(
                        in.readDouble(),
                        in.readDouble(),
                        in.readDouble(),
                        in.readDouble(),
                        in.readDouble(),
                        in.readString());
            }
            return planets;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java NBody <T> <dt> <filename>");
            return;
        }

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
            Planet[] planets = readPlanets(filename);
            StdDraw.setScale(-radius, radius);


            StdDraw.picture(0, 0, BACKGROUND_IMAGE_PATH);


            for (int i = 0; i < 5; i++) {
                 planets[i].draw();
            }
            StdDraw.enableDoubleBuffering();

            double time = 0;
            while (time <= T) {
                double xForces[] = new double[planets.length];
                double yForces[] = new double[planets.length];
                for (int i = 0; i < planets.length; i++) {
                    xForces[i] = planets[i].calcNetForceExertedByX(planets);
                    yForces[i] = planets[i].calcNetForceExertedByY(planets);
                }
                for (int i = 0; i < planets.length; i++) {
                    planets[i].update(dt, xForces[i], yForces[i]);
                }
                StdDraw.clear();
                StdDraw.picture(0, 0, BACKGROUND_IMAGE_PATH);
                for (int i = 0; i < planets.length; i++) {
                    planets[i].draw();
                }
                StdDraw.show();
                StdDraw.pause(10);
                time += dt;

            }
            StdDraw.show();
            System.out.printf("%d\n", planets.length);
            System.out.printf("%.2e\n", radius);
            for (int i = 0; i < planets.length; i++) {
                StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
            }
    }
}
