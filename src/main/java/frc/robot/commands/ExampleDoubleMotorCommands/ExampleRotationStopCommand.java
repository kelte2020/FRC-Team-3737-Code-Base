package frc.robot.commands.ExampleDoubleMotorCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.utils.SubsystemList;
import frc.robot.subsystems.ExampleDoubleMotorSubsystem;

/*  Look at frc.robot.commands.ExampleSingleMotorCommands.ExampleStopCommand  */

public class ExampleRotationStopCommand extends Command {

    final ExampleDoubleMotorSubsystem doubleMotorSubsystem;

    public ExampleRotationStopCommand(SubsystemList subsystems) {

        doubleMotorSubsystem = (ExampleDoubleMotorSubsystem) subsystems.getSubsystem("doubleMotor");

        addRequirements(doubleMotorSubsystem);

    }

    @Override
    public void initialize() {

        doubleMotorSubsystem.Stop();

    }

    @Override
    public boolean isFinished() {

        return true;

    }
    
}
