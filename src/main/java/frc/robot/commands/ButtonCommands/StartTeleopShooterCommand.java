package frc.robot.commands.ButtonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.ExampleSingleMotorSubsystem;
import frc.robot.subsystems.ExampleDoubleMotorSubsystem;
import.frc.robot.subsystems.ShooterSubsystem;

public class StartTeleopShooterCommand extends SequentialCommandGroup {

      private final ShooterSubsystem shooterSubsystem;
    private final XboxController controller;
    private double shooterSpeed;

    // Constructor takes the shooter subsystem and Xbox controller
    public StartHardShooterCommand(ShooterSubsystem shooterSubsystem, XboxController controller, double shooterSpeed) {
        this.shooterSubsystem = shooterSubsystem;
        this.controller = controller;
        addRequirements(shooterSubsystem);  // Requires the shooter subsystem
    }

    @Override
    public void initialize() {
        // Set initial shooter speed to a default value (e.g., 2.0)
        shooterSpeed = 2.0;  // Default speed when Y button is not pressed
        shooterSubsystem.setShooterSpeed(shooterSpeed);  // Set initial speed
        
    }

    @Override
    public void execute() {
        // Check if the Y button is held down
        if (controller.getYButton()) {
            // If Y button is pressed, increase shooter speed (e.g., 3.0)
            shooterSpeed = 3.0;  // Faster speed when Y is pressed
        } else {
            // Default shooter speed when Y button is not pressed
            shooterSpeed = 2.0;  // Normal speed
        }

        // Update the shooter speed dynamically
        shooterSubsystem.setShooterSpeed(shooterSpeed);  // Update speed based on Y button state

        shooterSubsystem.startShooter();  // Start the shooter at the preset speed
    }

    @Override
    public boolean isFinished() {
        return false;  // Continue running indefinitely (until interrupted)
    }

    @Override
    public void end(boolean interrupted) {
        // Ensure shooter is stopped when the command ends or is interrupted
        shooterSubsystem.stopShooter();
    }
}