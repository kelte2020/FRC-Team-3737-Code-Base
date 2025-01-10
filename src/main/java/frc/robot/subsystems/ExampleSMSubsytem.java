package frc.robot.subsystems;

import edu.wpi.first.units.measure.Current;
import frc.robot.Constants;
import frc.robot.motor.Motors;
import frc.robot.motor.Motor.encoderType;

public class ExampleSMSubsytem {

    /*  This is what a single motor subsystem will look like, in other words, a system with not secondary motor to depend on.
        This is also what a transitional based subsystem not rotational based subsytem will look like.
        Below is where the variables are made, which can be declared directly, in the constructor, or later in the code.  
        Above is where the imports and the class are. A class is always "public class {filename} {}" and can optionally have extensions.
        Imports are from other libraries or files and allow you to use methods under those classes.  */

    private final Motors motor;
    private double motorSpeed;
    private double desiredPosition;
    
    public ExampleSMSubsytem() {

        /*  Here, the constructor, is where you declare any final variables, or other variables you wish to start with a specified value.
            Variables can be declared here or with the variable itself instead of the constructor.
            The constructor will always be "public {filename}() {}"  */

        motor = new Motors(Constants.EXAMPLE_INFO, encoderType.None);
        motorSpeed = 0;
        desiredPosition = 0;

    }

    /*  Below are the private methods, only able to be used in this file, we keep these above the public methods for ease of access.
        The below are an example of a deadzone where movement stops and a current position for other files to use.  */

    private double CurrentPosition() {

        /*  The in built encoder only get the amount of rotations the motor makes. It is useless for continuous movements, such as an intake.  */

        return motor.motor.inBuiltEncoder.getPosition();

    }

    private boolean IsInDesiredZone(double deadzone) {

        /*  This is a way to create a deadzone that can say for the arm to stop, or say slow down. This can be used to define a safezone.
            This creates an allowed leeway point, because we know that an angle can never be perfect. This is done by adding a zone of acceptance.
            Example 20 > 21 - 4 && 20 < 21 + 4 returns true, because it is within the 8 unit acceptence zone.  */

        return desiredPosition > this.CurrentPosition() - deadzone && desiredPosition < this.CurrentPosition() + deadzone;

    }

    /*  Below are the public methods, our practice is to put Stop() at the bottom of the public pile and Move() or similar methods above it.
        Any other public method, such as a set, get, or other method, will go above both Stop() and Move() or similar methods  */

    public void SetSpeed(double speed) {

        /*  This sets the motor speed variable to whatever was inputted.  */

        motorSpeed = Math.abs(speed);

    }

    public void SetTargetPosition(double target) {

        /*  This sets the desired position variable to whatever was inputted.  */

        desiredPosition = target;

    }

    public void Move(double target, double speed) {

        /*  The code below used class variables, but could easily be replaced with method variables.
            If you don't want to set target and speed every time, then you can make it an input.
            Below is an example of variables being declared and used within a method.  */

        double minPosition = 10;
        double maxPosition = 50;

        /*  The following select ladder is an example of a safety check. This is to ensure that the robot does not break itself.
            There is no need for two seperate if statements, because you should never surpass the max and min at the same time.
            A safety check should be placed before the code that makes the arm move or be wrap around the move select ladder.  */

        if (CurrentPosition() > maxPosition) {
            motor.Spin(-motorSpeed);
            return;
        } else if (CurrentPosition() < minPosition) {
            motor.Spin(motorSpeed);
            return;
        }

        /*  The following select ladder is an example of an automated move, no need to make a move one way and move the other way.
            It is generally better to do a split when available, but some subsystems require them to both be in the same method.
            This is what allows the system to move to a desired postition to move to where it needs to be, and stop when at its desired position.
            You could also make the desired position public and let the command handle the stop instead of the method.  */

        if (IsInDesiredZone(4)) {
            this.Stop();
        } else if (CurrentPosition() < desiredPosition) {
            motor.Spin(motorSpeed);
        } else if (CurrentPosition() > desiredPosition) {
            motor.Spin(-motorSpeed);
        }

    }

    public void Stop() {

        /*  This is very self explanatory, when this is called it stops the motor.  */

        motor.Spin(0);

    }

}
