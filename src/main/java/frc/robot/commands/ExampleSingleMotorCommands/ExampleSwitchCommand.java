package frc.robot.commands.ExampleSingleMotorCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.utils.SubsystemList;
import frc.robot.subsystems.ExampleSingleMotorSubsystem;

public class ExampleSwitchCommand extends Command {

    final ExampleSingleMotorSubsystem singleMotorSubsystem;

    public ExampleSwitchCommand(SubsystemList subsystems) {

        singleMotorSubsystem = (ExampleSingleMotorSubsystem) subsystems.getSubsystem("singleMotor");

    }

    @Override
    public boolean isFinished() {

        /*  Will simply return true when the switch detects and object.  */

        return singleMotorSubsystem.SwitchObjectIn();

    }
    
}
