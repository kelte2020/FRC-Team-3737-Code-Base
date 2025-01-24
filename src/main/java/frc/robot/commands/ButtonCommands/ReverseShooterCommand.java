package frc.robot.commands.ButtonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.ExampleSingleMotorSubsystem;
import frc.robot.subsystems.ExampleDoubleMotorSubsystem;
import.frc.robot.subsystems.ShooterSubsystem;

public class ReverseShooterCommand extends SequentialCommandGroup {
    public class ReverseShooterCommand extends CommandBase {
    private final ShooterSubsystem shooterSubsystem;

    public ReverseShooterCommand(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        addRequirements(shooterSubsystem);  // Requires shooter subsystem
    }

    @Override
    public void initialize() {
        setShooterSpeed(0.5) // .5 is a placeholder value
        shooterSubsystem.reverseShooter();  // Reverse the motor
    }

    @Override
    public boolean isFinished() {
        return true;  // Command finishes immediately after reversing
    }
}

}