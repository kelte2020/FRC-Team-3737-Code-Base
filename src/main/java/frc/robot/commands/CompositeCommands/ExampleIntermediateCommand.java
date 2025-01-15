package frc.robot.commands.CompositeCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.ExampleSingleMotorSubsystem;
import frc.robot.subsystems.ExampleDoubleMotorSubsystem;

import frc.robot.commands.ExampleSingleMotorCommands.ExampleMoveNegativeCommand;
import frc.robot.commands.ExampleSingleMotorCommands.ExampleCheckCommand;

public class ExampleIntermediateCommand extends SequentialCommandGroup {

    public ExampleIntermediateCommand(ExampleSingleMotorSubsystem singleMotorSubsystem, ExampleDoubleMotorSubsystem doubleMotorSubsystem) {

        double target = 10;
        double speed = 0.5;

        addCommands(
            new ExampleMoveNegativeCommand(singleMotorSubsystem, speed).raceWith(new ExampleCheckCommand(singleMotorSubsystem, target))
        );

        addRequirements(singleMotorSubsystem, doubleMotorSubsystem);

    }
    
}
