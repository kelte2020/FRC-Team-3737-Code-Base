package.frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;   

import frc.robot.motor.Motors;
improt frc.robot.Constants;


public class IntakeSubsystem extends SubsystemBase {
    
    private final Motors motor;
    private double motorSpeed;

   
    public IntakeSubsystem(int motorPort) {

       motor = new Motors(Constants.EXAMPLE_ALTERNATE_INFO);
    }


    // Method 1: Set speed of the intake
    public void SetIntakeSpeed(double speed) {
        motorSpeed = Math.abs(speed);
    }

    public void startIntake() {
        motor.Spin(motorSpeed);
    }

    // Method 2: Stop intake (stop the motor to release the game pieces or idle)
    public void Reverse() {
        motor.Spin(-motorSpeed);
    }

    // Method 3: Reverse intake (run the motor in reverse to eject game pieces)
    public void stopIntake() {
        motorSpeed = 0;
    }
