public class NBody {
    public static double readRadius(String filename) {
        try {
            In in = new In(filename);
            double radius = in.readDouble();
            return radius;
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
            return -1.0;
        }
    }
    public static Planet[] readPlanets(String filename) {
        try {
            In in = new In(filename);
            int num = in.readInt();
            in.readDouble();
            Planet[] planets = new Planet[num];
            for(int i = 0; i < num; i++){
                planets[i] = new Planet(
                        in.readDouble(),
                        in.readDouble(),
                        in.readDouble(),
                        in.readDouble(),
                        in.readDouble(),
                        in.readString()
                );
            }
            return planets;
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

}

