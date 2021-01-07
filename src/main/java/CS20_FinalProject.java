import java.io.*;
import java.util.Scanner;

public class CS20_FinalProject {

    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);

    public static void main(String[] args) {
        int[] id = new int[5];
        int[] dynMarks = new int[5];
        int[] kineMarks = new int[5];
        int[] cmgMarks = new int[5];
        int[] workMarks = new int[5];
        int[] osiMarks = new int[5];
        int[] mechMarks = new int[5];
        int index = 0;
        String mode = "";
        String userAns = "";
        int tempID;

        boolean play = true;
        boolean playTest = true;
        boolean playHomework = true;
        boolean playTeacher = true;

        while (play == true) {
            System.out.println();
            System.out.println("PHYSICS WORKBOOK PORTAL");
            System.out.println();

            //Login system created by Mann H.
            System.out.println("Please enter your Login ID. Or type '9999' to exit.");
            tempID = numscan.nextInt();
            System.out.println();
            if (tempID == 1111) {
                System.out.println("What mode would you like to enter? Homework, Test, or Teacher: ");
                mode = wordscan.nextLine().toLowerCase();
                System.out.println();
                playTest = true;
                playHomework = true;
                playTeacher = true;
            } else if (tempID == 9999) {
                play = false;

            } else {
                id[index] = tempID;
                System.out.println("What mode would you like to enter? Homework or Test: ");
                mode = wordscan.nextLine().toLowerCase();
                saveFile("Data/marks/id.txt", id);
                System.out.println();
                playTest = true;
                playHomework = true;
                playTeacher = true;
            }

            if (mode.equalsIgnoreCase("test")) { //Created by Mann H.
                while (playTest == true) {
                    System.out.println("What unit do you want to be tested on? Please enter the index number.");
                    System.out.println("1. Dynamics");
                    System.out.println("2. Kinematics");
                    System.out.println("3. Circular Motion and Gravitation");
                    System.out.println("4. Work and Energy");
                    System.out.println("5. Oscillatory Motion");
                    System.out.println("6. Mechanical Waves");
                    int choice = numscan.nextInt();
                    System.out.println();
                    switch (choice) {
                        case 1:
                            int dynamicsScore = dynamicsTest();
                            dynMarks[index] = dynamicsScore;
                            saveFile("Data/marks/dynMarks.txt", dynMarks);
                            break;
                        case 2:
                            int kinematicsScore = kinematicsTest();
                            kineMarks[index] = kinematicsScore;
                            saveFile("Data/marks/kineMarks.txt", kineMarks);
                            break;
                        case 3:
                            int cmgScore = cmgTest();
                            cmgMarks[index] = cmgScore;
                            saveFile("Data/marks/cmgMarks.txt", cmgMarks);
                            break;
                        case 4:
                            int workEnergyScore = workEnergyTest();
                            workMarks[index] = workEnergyScore;
                            saveFile("Data/marks/workMarks.txt", workMarks);
                            break;
                        case 5:
                            int oscillatoryMotionScore = oscillatoryMotionTest();
                            osiMarks[index] = oscillatoryMotionScore;
                            saveFile("Data/marks/osiMarks.txt", osiMarks);
                            break;
                        case 6:
                            int mechWavesScore = mechWavesTest();
                            mechMarks[index] = mechWavesScore;
                            saveFile("Data/marks/mechMarks.txt", mechMarks);
                            break;
                    }//end switch
                    System.out.println();
                    System.out.println("Would you like to test again? Or type 'logout' to logout.");
                    userAns = wordscan.nextLine();
                    if (userAns.equalsIgnoreCase("logout")) {
                        playTest = false;
                        System.out.println();
                        System.out.println("Goodbye!");
                        if (!(tempID == 1111)){
                        index++;
                        }
                    }
                }//end while for Test
            } else if (mode.equalsIgnoreCase("teacher")) { //Created by Harsh P.
                while (playTeacher == true) {
                    System.out.println("All tests are graded out of 5.");
                    System.out.println("ID Num.         Kinematics          Dynamics            CMG         Work-Energy         Mechanical Waves            Osicillatory Motion");
                    for (int i = 0; i < id.length; i++) {
                        System.out.println(id[i] + "            " + kineMarks[i] + "                   " + dynMarks[i] + "                   " + cmgMarks[i] + "           " + workMarks[i] + "                   " + mechMarks[i] + "                           " + osiMarks[i]);
                    }
                    System.out.println("Would you like to stay on this screen? Or type 'logout' to logout.");
                    userAns = wordscan.nextLine();
                    if (userAns.equalsIgnoreCase("logout")) {
                        playTeacher = false;
                        System.out.println();
                        System.out.println("Goodbye!");
                    }
                }//end while for Teacher
            } else if (mode.equalsIgnoreCase("Homework")) { //Created by Harsh P.
                while (playHomework == true) {
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
                    System.out.println("Would you like to stay on Homework mode? Or type 'logout' to logout.");
                    userAns = wordscan.nextLine();
                    if (userAns.equalsIgnoreCase("logout")) {
                        playHomework = false;
                        System.out.println("Goodbye!");
                    }
                }//end playHomework while loop
            }//end if for modes
        }//end play while loop
    }//end main

    /************************** The Test Mode and Data Files associated with it are created by Mann H. *************************/
    public static int dynamicsTest() {
        String[] questions;
        String[] answers;
        int score = 0;
        String useAns;
        questions = loadStringArr("Data/dynamics/questions/question1.txt");
        answers = loadStringArr("Data/dynamics/answers/answer1.txt");
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println("Answer: ");
            useAns = wordscan.nextLine();
            if (useAns.equals(answers[i])) {
                score++;
            }
            System.out.println();
        }
        System.out.println("Score: " + score + "/5");
        return score;
    }//end dynamicsTest

    public static int kinematicsTest() {
        String[] questions;
        String[] answers;
        int score = 0;
        String useAns;
        questions = loadStringArr("Data/kinematics/questions/question1.txt");
        answers = loadStringArr("Data/kinematics/answers/answer1.txt");
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println("Answer: ");
            useAns = wordscan.nextLine();
            if (useAns.equals(answers[i])) {
                score++;
            }
            System.out.println();
        }
        System.out.println("Score: " + score + "/5");
        return score;
    }//end kinematicsTest

    public static int cmgTest() {
        String[] questions;
        String[] answers;
        int score = 0;
        String useAns;
        questions = loadStringArr("Data/cmg/questions.txt");
        answers = loadStringArr("Data/cmg/answers.txt");
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println("Answer: ");
            useAns = wordscan.nextLine();
            if (useAns.equals(answers[i])) {
                score++;
            }
            System.out.println();
        }
        System.out.println("Score: " + score + "/5");
        return score;
    }//end cmgTest

    public static int workEnergyTest() {
        String[] questions;
        String[] answers;
        int score = 0;
        String useAns;
        questions = loadStringArr("Data/work-energy/questions/question1.txt");
        answers = loadStringArr("Data/work-energy/answers/answer1.txt");
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println("Answer: ");
            useAns = wordscan.nextLine();
            if (useAns.equals(answers[i])) {
                score++;
            }
            System.out.println();
        }
        System.out.println("Score: " + score + "/5");
        return score;
    }//end workEnergyTest

    public static int oscillatoryMotionTest() {
        String[] questions;
        String[] answers;
        int score = 0;
        String useAns;
        questions = loadStringArr("Data/oscillatory motion/questions.txt");
        answers = loadStringArr("Data/oscillatory motion/answers.txt");
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println("Answer: ");
            useAns = wordscan.nextLine();
            if (useAns.equals(answers[i])) {
                score++;
            }
            System.out.println();
        }
        System.out.println("Score: " + score + "/5");
        return score;
    }//end oscillatoryMotionTest

    public static int mechWavesTest() {
        String[] questions;
        String[] answers;
        int score = 0;
        String useAns;
        questions = loadStringArr("Data/mechwaves/questions.txt");
        answers = loadStringArr("Data/mechwaves/answers.txt");
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println("Answer: ");
            useAns = wordscan.nextLine();
            if (useAns.equals(answers[i])) {
                score++;
            }
            System.out.println();
        }
        System.out.println("Score: " + score + "/5");
        return score;
    }//end mechWavesTest

    /************************** Login Functions taken by Mann H. from the Files code on D2L **************************/
    public static String[] loadStringArr(String filename) {

        String addLines = "";
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            while (file.ready()) {
                addLines += file.readLine() + ",";
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return addLines.split(",");
    }//end loadStringArr

    public static void saveFile(String filename, int[] array) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));
            for (int i = 0; i < array.length; i++) {
                file.println("" + array[i]);
            }

            file.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }//end saveFile
    
    /************************** The Homework Mode is created by Harsh P. *************************/
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
            System.out.println("Centripetal Velocity = " + (2 * pi * radius) / (period));
            System.out.println();
        }
        if (pi > 0 && radius > 0 && period != 0 && mass > 0) {
            System.out.println("You are solving for  to Centripetal Force... Fc = (4π^2rm)/(T^2)");
            System.out.println("Centripetal Force = " + ((4 * pi * pi * radius * mass) / (period * period)));
            System.out.println();
        }
        if (spring != 0 && stretchcompress != 0) {
            System.out.println("You are solving for  to Spring Force... F = -kx");
            System.out.println("Spring Force = " + (-1 * spring * stretchcompress));
            System.out.println();
        }
        if (pi > 0 && mass > 0 && spring != 0) {
            System.out.println("You are solving for  to Period... T = 2π√m/k");
            //EQUATION WITH SQUARE ROOT 
            System.out.println("Period = " + ((2 * pi) * Math.sqrt(mass / spring)));
            System.out.println();
        }
        if (velocity != 0 && radius > 0) {
            System.out.println("You are solving for  to Centripetal Acceleration... ac = v^2 / r");
            System.out.println("Centripetal Acceleration = " + ((velocity * velocity) / (radius)));
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
            System.out.println("Period = " + ((2 * pi) * Math.sqrt(length / gravitationalacceleration)));
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
            System.out.println("Open Length = " + lambda / 2);
            System.out.println();
        }
        if (lambda != 0) {
            System.out.println("You are solving for Length of closed tubes using... L = λ/4");
            System.out.println("Closed Length = " + lambda / 4);
            System.out.println();
        }
        if (frequencysource != 0 && velocity != 0 && velocitysource != 0) {
            System.out.println("You are solving for frequency of moving towards object... f = fs(v / v - vs)");
            System.out.println("Frequency moving towards the object = " + (frequencysource * (velocity / (velocity - velocitysource))));
            System.out.println();
        }
        if (frequencysource != 0 && velocity != 0 && velocitysource != 0) {
            System.out.println("You are solving for frequency of moving away from object... f = fs(v / v + vs)");
            System.out.println("Frequency moving away from the object = " + (frequencysource * (velocity / (velocity + velocitysource))));
            System.out.println();
        }
    }//end MechanicalWaves
}//end class