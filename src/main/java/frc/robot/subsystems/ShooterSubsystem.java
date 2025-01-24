package frc.robot.subsystems;

//import stuff and things
import edu.wpi.first.wpilibj2.command.SubsystemBase;   

public class ShooterSubsystem extends SubsystemBase {

    // Declare motor and encoder
    private final Motors shooterMotor;
    private double motorSpeed;


    public ShooterSubsystem () {
         // Initialize motor 
        shooterMotor = Motors(Constants.EXAMPLE_ALTERNATE_INFO);
    
    }

    // Method 1: set shooter speed
    public void setShooterSpeed(double speed) {
        motorSpeed = Math.abs(speed);
    }

    // Method 2: stop the shooter
    public void stopShooter() {
        shooterMotor.set(0);
    }

    // Method 3: start the shooter
    public double startShooter () {
        shooterMotor.set(motorSpeed);
    }

    // Method 4:  reverse the shooter 
    public boolean reverseShooter () {
        shooterMotor.set(-motorSpeed);
     
    }