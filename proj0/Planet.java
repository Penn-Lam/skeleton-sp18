public class Planet {
    private double xxPos;
    private double yyPos;
    private double xxVel;
    private double yyVel;
    private double mass;
    private String imgFileName;
    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        return G * this.mass * p.mass / (r * r);
    }

    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        return calcForceExertedBy(p) * dx / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        return calcForceExertedBy(p) * dy / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double netForce = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i].equals(this)) {
                continue;
            }
            netForce += calcForceExertedByX(p[i]);
        }
        return netForce;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double netForce = 0;
        for (Planet a : p) {
            if (a.equals(this)) {
                continue;
            }
            netForce += calcForceExertedByY(a);
        }
        return netForce;
    }

    public void update(double dt, double fX, double fY) {
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += xxVel * dt;
        this.yyPos += yyVel * dt;
    }

    public void draw() {
        String imagePath = "images/" + this.imgFileName;
        double scaledX = xxPos;
        double scaledY = yyPos;
        StdDraw.picture(scaledX, scaledY, imagePath);
    }

    public double getXxPos() {
        return xxPos;
    }

    public void setXxPos(double xxPos) {
        this.xxPos = xxPos;
    }

    public double getYyPos() {
        return yyPos;
    }

    public void setYyPos(double yyPos) {
        this.yyPos = yyPos;
    }

    public double getXxVel() {
        return xxVel;
    }

    public void setXxVel(double xxVel) {
        this.xxVel = xxVel;
    }

    public double getYyVel() {
        return yyVel;
    }

    public void setYyVel(double yyVel) {
        this.yyVel = yyVel;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }
}
