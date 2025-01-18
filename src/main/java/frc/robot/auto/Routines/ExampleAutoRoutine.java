package frc.robot.auto.Routines;

/*  Follow the same steps as making a button command. But set up the constructor slightly different.  */

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.ExampleSingleMotorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleDoubleMotorSubsystem;

import frc.robot.commands.CompositeCommands.ExampleAutoCommand;
import frc.robot.commands.CompositeCommands.ExampleIntermediateCommand;
import frc.robot.commands.DriveCommands.AutoMoveCommand;

public class ExampleAutoRoutine extends SequentialCommandGroup {

    public ExampleAutoRoutine(ExampleSingleMotorSubsystem singleMotorSubsystem, ExampleDoubleMotorSubsystem doubleMotorSubsystem, DriveSubsystem drive) {

        addCommands(
            new ExampleAutoCommand(singleMotorSubsystem, doubleMotorSubsystem),
            new AutoMoveCommand(drive, 0, 0, 0, 0, 0)
                .alongWith(new ExampleIntermediateCommand(singleMotorSubsystem)),
            new ExampleAutoCommand(singleMotorSubsystem, doubleMotorSubsystem),
            new AutoMoveCommand(drive, 0, 0, 0, 0, 0)
                .alongWith(new ExampleIntermediateCommand(singleMotorSubsystem))
        );

        addRequirements(singleMotorSubsystem, doubleMotorSubsystem);

    }
    
}
