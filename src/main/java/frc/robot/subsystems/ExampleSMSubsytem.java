package frc.robot.subsystems;

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
        In a single motor transitional subsystem, there is normally no need for a private method, but I've exampled 2 below that could be used.  */

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
        The only exception is debugging information, that gets put at the very bottom and will be a get method, meaning it will return a value.
        Any other public method, such as a set, get, or other method, will go above both Stop() and Move() or similar methods.
        In the public organization, please do sets, then gets, than any other method, move methods, stop method, then debugging info.  */

    public void SetSpeed(double speed) {

        /*  This sets the motor speed variable to whatever was inputted.  */

        motorSpeed = Math.abs(speed);

    }

    public void SetTargetPosition(double target) {

        /*  This sets the desired position variable to whatever was inputted.  */

        desiredPosition = target;

    }

    /*  The following 2 methods are a replacement of Move() and splits it into two simple actions. Normally when moving there is no need for overcomplex move systems.
        The exception are in double motor rotational systems or even multi motor transtional and rotational systems. Those systems often use more complex move systems.
        Remember a positive motor value is not always a outwards/forwards/up movement, it depends on how the motor was put in. Same goes for negative, as you could guess.
        Note: you could use an input instead of a variable for the motorspeed, but it makes more sense normally to have a speed variable and not part of the move.  */

    public void PositiveMove() {

        /*  The motor will spin in the positive direction, at the given speed. (0 to 1)  */

        motor.Spin(motorSpeed);

    }

    public void NegativeMove() {

        /*  The motor will spin in the negative direction, at the given speed. (-1 to 0)  */

        motor.Spin(-motorSpeed);

    }

    public void Stop() {

        /*  This is very self explanatory, when this is called it stops the motor.  */

        motor.Spin(0);

    }

    public String[] GetDebuggingInfo() {

        return motor.GetDebuggingInformation();

    }

}
