package frc.robot.commands.ButtonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.ExampleSingleMotorSubsystem;
import frc.robot.subsystems.ExampleDoubleMotorSubsystem;
import.frc.robot.subsystems.ShooterSubsystem;

public class StartShooterCommand extends SequentialCommandGroup {


    private final ShooterSubsystem shooterSubsystem;
    private final double speed;

    public StartShooterCommand(ShooterSubsystem shooterSubsystem, double speed) {
        this.shooterSubsystem = shooterSubsystem;
        this.speed = speed;
        addRequirements(shooterSubsystem);  // Requires shooter subsystem
    }

    @Override
    public void initialize() {
        shooterSubsystem.setShooterSpeed(speed);  // Set the motor to the specified speed
        shooterSubsystem.startShooter();  // Start the motor
    }

    @Override
    public boolean isFinished() {
        return true;  // Command finishes immediately after starting the motor
    }
}