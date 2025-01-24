package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PivotSubsystem;

public class MovePivotCommand extends Command {
    
    private final PivotSubsystem pivotSubsystem;
    private final XboxController controller;
    private final int axis;

    public MovePivotCommand(PivotSubsystem pivotSubsystem, XboxController controller, int axis) {
        this.pivotSubsystem = pivotSubsystem;
        this.controller = controller;
        this.axis = axis;
        addRequirements(pivotSubsystem); // Declare subsystem dependencies
    }

    //periodic would be used but i dont know where

    @Override
    public void execute() {
        // Move the pivot based on controller input
        double speed = controller.getRawAxis(axis);
       startPuvot(speed);  
    }

    @Override
    public boolean isFinished() {
        return false;  // Keep running until interrupted (this could be a continuous command)
    }

    @Override
    public void end(boolean interrupted) {
        // Optionally stop the pivot if the command ends
        pivotSubsystem.stopPivot();
    }
}