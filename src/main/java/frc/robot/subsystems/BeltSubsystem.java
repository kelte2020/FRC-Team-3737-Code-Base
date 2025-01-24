package frc.robot.subsystems;

// import stuff and things
import edu.wpi.first.wpilibj2.command.SubsystemBase;   


public class beltSubsystem extends SubsystemBase {

    // Declare motor and encoder
    private final Motors beltMotor;
    private double motorSpeed;

    public beltSubsystem(int motorPort) {

       beltMotor = motor ; // insert whatever I need for motors    
       }

// methods are generally the same as the last subsystems

    //method 1: set belt speed
    public void setBeltSpeed(double speed) {
        motorSpeed = Math.abs(speed);
    }

    method 2: stop the belt
    public void stopBelt() {
        beltMotor.set(0);
    }

    //method 3: start belt
    public void beltStart () {
        beltMotor.set(MotorSpeed);
    }

    //method 4: reverse belt
    public void reverse () {
        beltMotor.set(-motorSpeed);
    }
}