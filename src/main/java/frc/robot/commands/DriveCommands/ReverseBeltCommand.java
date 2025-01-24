package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.BeltSubsystem;

public class ReverseBeltCommand extends Command {
    private final BeltSubsystem beltSubsystem;

    public ReverseBeltCommand(BeltSubsystem beltSubsystem) {
        this.beltSubsystem = beltSubsystem;
        addRequirements(beltSubsystem);  // Declare subsystem dependencies
    }

    @Override
    public void initialize() {
        setBeltSpeed(0.5) // .5 is a placeholder value

        beltSubsystem.reverse();  // Reverse the belt motor
    }

    @Override
    public boolean isFinished() {
        return false;  // could run untill manually stopped
    }
}
