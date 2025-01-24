package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.BeltSubsystem;

public class StopBeltCommand extends Command {
    private final BeltSubsystem beltSubsystem;

    public StopBeltCommand(BeltSubsystem beltSubsystem) {
        this.beltSubsystem = beltSubsystem;
        addRequirements(beltSubsystem);  // Declare subsystem dependencies
    }

    @Override
    public void initialize() {
        beltSubsystem.stopBelt();  // Stop the belt motor
    }

    @Override
    public boolean isFinished() {
        return true;  // Command finishes immediately after stopping
    }
}

