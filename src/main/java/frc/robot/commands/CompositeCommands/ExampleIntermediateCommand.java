package frc.robot.commands.CompositeCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.ExampleSingleMotorSubsystem;

import frc.robot.commands.ExampleSingleMotorCommands.ExampleMoveNegativeCommand;
import frc.robot.commands.ExampleSingleMotorCommands.ExampleCheckCommand;

public class ExampleIntermediateCommand extends SequentialCommandGroup {

    /*  While not exampled great here, intermediate commands are commands that use more then one subsystem.
        Unfortunately, the system's this was based off of was a tranlational (Belt) and a translational (Shoot).
        We only have the single motor subsystem example as a translational subsystem we can use to example this.  */

    public ExampleIntermediateCommand(ExampleSingleMotorSubsystem singleMotorSubsystem) {

        double target = 10;
        double speed = 0.5;

        addCommands(
            new ExampleMoveNegativeCommand(singleMotorSubsystem, speed).raceWith(new ExampleCheckCommand(singleMotorSubsystem, target))
        );

        addRequirements(singleMotorSubsystem);

    }
    
}
