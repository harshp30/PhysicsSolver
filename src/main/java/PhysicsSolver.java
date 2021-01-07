
import java.util.Scanner;

public class PhysicsSolver {

    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);

    public static void main(String[] args) {

        boolean runMode = true;

        System.out.println();
        System.out.println("PHYSICS WORKBOOK PORTAL");
        System.out.println();

        System.out.print("What mode would you like to enter? Homeowrk, Test, or Teacher: ");
        String mode = wordscan.nextLine();

        while (runMode == true) {

            if (mode.equalsIgnoreCase("Homework")) {
                System.out.print("please enter your studnet ID number: ");
                int studentID = numscan.nextInt();
                System.out.println();
                System.out.println("Which unit are you working on right now? Kinematics, Dynamics, Work-Energy, Oscillatory Motion, Circular Motion and Gravitation, or Mechanical Waves");
                System.out.println();
                String unit = wordscan.nextLine();
                if (unit.equalsIgnoreCase("Kinematics")) {
                    Kinematics();
                } else if (unit.equalsIgnoreCase("Dynamics")) {
                    Dynamics();
                } else if (unit.equalsIgnoreCase("Work-Energy")) {
                    WorkEnergy();
                } else if (unit.equalsIgnoreCase("Oscillatory Motion")) {
                    OscillatoryMotion();
                } else if (unit.equalsIgnoreCase("Circular Motion and Gravitation")) {
                    CMG();
                } else if (unit.equalsIgnoreCase("Mechanical Waves")) {
                    MechanicalWaves();
                } else {
                    System.out.println("This is not a valid unit. Please try again.");
                }
            } else if (mode.equalsIgnoreCase("Test")) {
                Test();
            } else if (mode.equalsIgnoreCase("Teacher")) {
                System.out.print("Please enter your password: ");
                String teacherPass = wordscan.nextLine();
                if (teacherPass.contains("ADMIN")) {
                    Teacher();
                } else {
                    System.out.println("Wrong Password. Please try again");
                }
            } else {
                System.out.println("This is not a valid mode please try again.");
                System.out.println();
            }                                                                                                                             
        }//end while loop
    }// end main

    public static void Kinematics() {
        System.out.println("You chose Kinematics.");
        System.out.println("Please input values for the following variables. If that variable is not present eneter 0.");
        System.out.print("What is the velocity: ");
        double velocity = numscan.nextInt();
        System.out.print("What is the distance: ");
        double distance = numscan.nextInt();
        System.out.print("What is the time: ");
        double time = numscan.nextInt();
        System.out.print("What is the acceleration: ");
        double acceleration = numscan.nextInt();
        System.out.print("What is the velocity initial: ");
        double velocityI = numscan.nextInt();
        System.out.print("What is the velocity final: ");
        double velcoityF = numscan.nextInt();
        System.out.println();

        if (time > 0 && distance != 0) {
            System.out.println("You are solving for velcoity using... v = d/t");
            System.out.println("Velocity = " + distance / time);
            System.out.println();
        }
        if (velocityI != 0 && velcoityF != 0 && time > 0) {
            System.out.println("You are solving for acceleration using... a = (vf - vi)/t");
            System.out.println("Accelration = " + (velcoityF - velocityI) / (time));
            System.out.println();
        }
        if (velocityI != 0 && acceleration != 0 && time > 0) {
            System.out.println("You are solving for distance using... d = (vi)(t) + (1/2)(a)(t^2)");
            System.out.println("Distance = " + ((velocityI * time) + (0.5 * acceleration * (time * time))));
            System.out.println();
        }
        if (velocityI != 0 && velcoityF != 0 && time > 0) {
            System.out.println("You are solving for distance using... d = ((vf + vi)/2)t");
            System.out.println("Distance = " + ((velcoityF + velocityI) / 2) * (time));
            System.out.println();
        }
        if (velocityI != 0 && velcoityF != 0 && acceleration != 0 && distance != 0) {
            System.out.println("You are solving for distance using... vf^2 = vi^2 + 2ad");
            System.out.println("Velocity Final Squared = " + ((velocityI) * (velocityI) + 2 * distance * acceleration));
            System.out.println();
        }

    }//end kinematics

    public static void Dynamics() {
        System.out.println("You chose Dynamics.");
        System.out.println("Please input values for the following variables. If that variable is not present eneter 0.");
        System.out.print("What is the mass: ");
        double mass = numscan.nextInt();
        System.out.print("What is the acceleration: ");
        double acceleration = numscan.nextInt();
        System.out.print("What is the time: ");
        double gravitation = numscan.nextInt();
        System.out.print("What is the Force Net: ");
        double forceNet = numscan.nextInt();
        System.out.print("What is the Coeffecient of Friction: ");
        double frictionalcoeffecient = numscan.nextInt();

        if (mass > 0 && acceleration != 0) {
            System.out.println("You are solving for Force net using... Fn = m*a");
            System.out.println("Force net = " + mass * acceleration);
            System.out.println();
        }
        if (mass > 0 && gravitation != 0) {
            System.out.println("You are solving for Force gravitational using... Fg = m*g");
            System.out.println("Force gravitational = " + (mass * gravitation));
            System.out.println();
        }
        if (forceNet != 0 && frictionalcoeffecient != 0) {
            System.out.println("You are solving for Force Frictional using... Ff = U*Fn");
            System.out.println("Force Frictional = " + (frictionalcoeffecient * forceNet));
            System.out.println();
        }
    }//end Dynamics

    public static void WorkEnergy() {
        System.out.println("You chose Work-Energy.");
        System.out.println("Please input values for the following variables. If that variable is not present eneter 0.");
        System.out.print("What is the mass: ");
        double mass = numscan.nextInt();
        System.out.print("What is the height: ");
        double height = numscan.nextInt();
        System.out.print("What is the Gravitation: ");
        double gravitation = numscan.nextInt();
        System.out.print("What is the Force: ");
        double force = numscan.nextInt();
        System.out.print("What is the distance: ");
        double distance = numscan.nextInt();
        System.out.print("What is the velocity: ");
        double velocity = numscan.nextInt();
        System.out.print("What is the time: ");
        double time = numscan.nextInt();
        System.out.print("What is the Change in Energy: ");
        double energy = numscan.nextInt();
        System.out.print("What is the Spring constant: ");
        double spring = numscan.nextInt();
        System.out.print("What is the Spring stretch or compression: ");
        double stretchcompress = numscan.nextInt();

        if (mass > 0 && gravitation != 0 && height != 0) {
            System.out.println("You are solving for Potential Energy using... Ep = m*g*h");
            System.out.println("Potential Energy = " + mass * gravitation * height);
            System.out.println();
        }
        if (force != 0 && distance != 0) {
            System.out.println("You are solving for Work using... W = F*d");
            System.out.println("Work = " + force * distance);
            System.out.println();
        }
        if (mass > 0 && velocity != 0) {
            System.out.println("You are solving for Kinetic Energy using... Ek = 0.5*m*v^2");
            System.out.println("Kinetic Energy = " + (0.5 * mass * velocity * velocity));
            System.out.println();
        }
        if (time > 0 && energy != 0) {
            System.out.println("You are solving for Power... P = ΔE / t");
            System.out.println("Power = " + (energy / time));
            System.out.println();
        }
        if (spring != 0 && stretchcompress != 0) {
            System.out.println("You are solving for  to Spring Potential Energy... Ep = 0.5*k*x^2");
            System.out.println("Spring Potential Energy = " + (0.5 * spring * (stretchcompress * stretchcompress)));
            System.out.println();
        }

    }//end WorkEnergy

    public static void OscillatoryMotion() {
        System.out.println("You chose Oscillatory Motion.");
        System.out.println("Please input values for the following variables. If that variable is not present eneter 0.");
        System.out.print("What is the radius: ");
        double radius = numscan.nextInt();
        System.out.print("What is pi (π): ");
        double pi = numscan.nextInt();
        System.out.print("What is the period in seconds: ");
        double period = numscan.nextInt();
        System.out.print("What is the mass: ");
        double mass = numscan.nextInt();
        System.out.print("What is the velocity: ");
        double velocity = numscan.nextInt();
        System.out.print("What is the spring constant: ");
        double spring = numscan.nextInt();
        System.out.print("What is the Spring stretch or compression: ");
        double stretchcompress = numscan.nextInt();
        System.out.print("What is the regular frequency: ");
        double frequency = numscan.nextInt();
        System.out.print("What is the length: ");
        double length = numscan.nextInt();
        System.out.print("What is the gravitational acceleration: ");
        double gravitationalacceleration = numscan.nextInt();
        
        if (pi > 0 && radius > 0 && period != 0) {
            System.out.println("You are solving for  to Centripetal Velocity... Vc = (2πr) / (T)");                                  //CHECK IS THIS WHAT Vc STANDS FOR
            System.out.println("Centripetal Velocity = " + (2 * pi * radius)/(period));
            System.out.println();
        }
        if (pi > 0 && radius > 0 && period != 0 && mass > 0) {
            System.out.println("You are solving for  to Centripetal Force... Fc = (4π^2rm)/(T^2)");
            System.out.println("Centripetal Force = " + ((4*pi*pi*radius*mass)/(period*period)));
            System.out.println();
        }
        if (spring != 0 && stretchcompress != 0) {
            System.out.println("You are solving for  to Spring Force... F = -kx");
            System.out.println("Spring Force = " + (-1*spring*stretchcompress));
            System.out.println();
        }
        if (pi > 0 && mass > 0 && spring != 0) {
            System.out.println("You are solving for  to Period... T = 2π√m/k");
            //EQUATION WITH SQUARE ROOT 
            System.out.println("Period = " + ((2*pi) * Math. sqrt(mass / spring)));
            System.out.println();
        }
        if (velocity != 0 && radius > 0) {
            System.out.println("You are solving for  to Centripetal Acceleration... ac = v^2 / r");
            System.out.println("Centripetal Acceleration = " + ((velocity*velocity)/(radius)));
            System.out.println();
        }
        if (velocity != 0 && mass > 0 && radius > 0) {
            System.out.println("You are solving for  to Centripetal Force... Fc = mv^2 / r");
            System.out.println("Centripetal Force = " + (mass * velocity * velocity) / radius);
            System.out.println();
        }
        if (frequency != 0) {
            System.out.println("You are solving for  to Period... T = 1 / f");
            System.out.println("Period = " + (1 / frequency));
            System.out.println();
        }
        if (pi > 0 && length > 0 && gravitationalacceleration != 0) {
            System.out.println("You are solving for  to Period... T = 2π√l/g");
            //EQUATION WITH SQUARE ROOT
            System.out.println("Period = " + ((2*pi) * Math. sqrt(length / gravitationalacceleration)));
            System.out.println();
        }
    }//end OscillatoryMotion

    public static void CMG() {
        System.out.println("You chose Circular Motion and Gravitation.");
        System.out.println("Please input values for the following variables. If that variable is not present eneter 0.");
        System.out.print("What is the Gravitational Constant: ");
        double GravitationalConstant = numscan.nextInt();
        System.out.print("What is mass 1: ");
        double mass1 = numscan.nextInt();
        System.out.print("What is mass 2: ");
        double mass2 = numscan.nextInt();
        System.out.print("What is the radius: ");
        double radius = numscan.nextInt();
        System.out.print("What is the distance: ");

        if (GravitationalConstant != 0 && mass1 > 0 && mass2 > 0 && radius > 0) {
            System.out.println("You are solving for Force Gravitational using... Fg = (G*m1*m2)/(r^2)");
            System.out.println("Force Gravitational = " + (GravitationalConstant * mass1 * mass2) / (radius * radius));
            System.out.println();
        }
        if (GravitationalConstant != 0 && mass1 > 0 && radius > 0) {
            System.out.println("You are solving for Gravitational Acceleration using... g = (Gm1)/(r^2)");
            System.out.println("Gravitational Acceleration = " + (GravitationalConstant * mass1) / (radius * radius));
            System.out.println();
        }
    }//end CMG

    public static void MechanicalWaves() {
        System.out.println("You chose Mechanical Waves.");
        System.out.println("Please input values for the following variables. If that variable is not present eneter 0.");
        System.out.print("What is the regular frequency: ");
        double frequency = numscan.nextInt();
        System.out.print("What is the regular velocity: ");
        double velocity = numscan.nextInt();
        System.out.print("What is lambda: ");
        double lambda = numscan.nextInt();
        System.out.print("What is frequency of source: ");
        double frequencysource = numscan.nextInt();
        System.out.print("What is the velocity of source: ");
        double velocitysource = numscan.nextInt();

        if (lambda != 0 && frequency != 0) {
            System.out.println("You are solving for regular velocity using... v = f*λ");
            System.out.println("velocity = " + frequency * lambda);
            System.out.println();
        }
        if (lambda != 0) {
            System.out.println("You are solving for Length of open tubes using... L = λ/2");
            System.out.println("Open Length = " + lambda/2);
            System.out.println();
        }
        if (lambda != 0) {
            System.out.println("You are solving for Length of closed tubes using... L = λ/4");
            System.out.println("Closed Length = " + lambda/4);
            System.out.println();
        }
        if (frequencysource != 0 && velocity != 0 && velocitysource != 0) {
            System.out.println("You are solving for frequency of moving towards object... f = fs(v / v - vs)");
            System.out.println("Frequency moving towards the object = " + (frequencysource*(velocity / (velocity - velocitysource))));
            System.out.println();
        }
        if (frequencysource != 0 && velocity != 0 && velocitysource != 0) {
            System.out.println("You are solving for frequency of moving away from object... f = fs(v / v + vs)");
            System.out.println("Frequency moving away from the object = " + (frequencysource*(velocity / (velocity + velocitysource))));
            System.out.println();
        }
    }//end MechanicalWaves
    
    public static void Teacher(){
        //CODE fucntion so that all test marks appear here
    }//end Tecaher
    
    
    public static void Test(){
        //CODE random test bank presenting 5 questiosn and auto marks it right or wrong
    }//end Test
    
    public static void DynamicsTest(){
        
    }//end DynamicsTest
    
}// end class