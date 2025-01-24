package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PivotSubsystem;

//simple command that would be used if pivot needed to be stopped manually (like in auto or something)

public class StopPivotCommand extends Command {
     private final PivotSubsystem pivotSubsystem;

    public StopPivotCommand(PivotSubsystem pivotSubsystem) {
        this.pivotSubsystem = pivotSubsystem;
        addRequirements(pivotSubsystem);  // Declare subsystem dependencies
    }

    @Override
    public void initialize() {
        pivotSubsystem.stopPivot();  // Stop the pivot immediately
    }

    @Override
    public boolean isFinished() {
        return true;  // Command finishes immediately
    }
}
