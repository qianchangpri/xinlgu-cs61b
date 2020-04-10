public class Planet {
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;
  private static final double G=6.67e-11;
  public Planet(double xP, double yP,double xV,
                double yV, double m, String img){
    xxPos=xP;
    yyPos=yP;
    xxVel=xV;
    yyVel=yV;
    mass=m;
    imgFileName=img;
  }
  public Planet(Planet p){
    xxPos=p.xxPos;
    yyPos=p.yyPos;
    xxVel=p.xxVel;
    yyVel=p.yyVel;
    mass=p.mass;
    imgFileName=p.imgFileName;
  }

  public double calcDistance(Planet p){
    return Math.sqrt(Math.pow(p.xxPos-this.xxPos,2)+Math.pow(p.yyPos-this.yyPos,2));
  }

  public double calcForceExertedBy(Planet p){
    return G*this.mass*p.mass/Math.pow(calcDistance(p),2);
  }

  public double calcForceExertedByX(Planet p){
    return (p.xxPos-this.xxPos)/calcDistance(p)*calcForceExertedBy(p);
  }

  public double calcForceExertedByY(Planet p){
    return (p.yyPos-this.yyPos)/calcDistance(p)*calcForceExertedBy(p);
  }

  public double calcNetForceExertedByX(Planet[] ps){
    double NetForceX=0;
    for (Planet element : ps){
      if(equals(element)){
        continue;
      }
      NetForceX=NetForceX+calcForceExertedByX(element);
    }
    return NetForceX;
  }

  public double calcNetForceExertedByY(Planet[] ps){
    double NetForceY=0;
    for (int i=0;i<ps.length;i+=1){
      if(equals(ps[i])){
        continue;
      }
      NetForceY=NetForceY+calcForceExertedByY(ps[i]);
    }
    return NetForceY;
  }

  public void update(double dt, double fX, double fY){
    double aX = fX / this.mass;
    double aY = fY / this.mass;
    this.xxVel = this.xxVel + dt*aX;
    this.yyVel = this.yyVel + dt*aY;
    this.xxPos = this.xxPos + dt*this.xxVel;
    this.yyPos = this.yyPos + dt*this.yyVel;
  }

  public void draw(){
    StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
  }
}
