package frc.robot.commands.ButtonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.ExampleSingleMotorSubsystem;
import frc.robot.subsystems.ExampleDoubleMotorSubsystem;
import.frc.robot.subsystems.ShooterSubsystem;

public class StopShooterCommand extends SequentialCommandGroup {
    private final ShooterSubsystem shooterSubsystem;

    public StopShooterCommand(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        addRequirements(shooterSubsystem);  // Requires shooter subsystem
    }

    @Override
    public void initialize() {
        
        shooterSubsystem.stopShooter();  // Stop the shooter motor
    }

    @Override
    public boolean isFinished() {
        return true;  // Command finishes immediately after stopping the shooter
    }
}
}