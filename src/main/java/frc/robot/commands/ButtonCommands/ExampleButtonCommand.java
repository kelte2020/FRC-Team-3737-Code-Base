package frc.robot.commands.ButtonCommands;

/*  Before you start, add the sequential command group import.  */

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/*  Then, add your subsystem imports that will be needed for the operation of your commands.  */

import frc.robot.subsystems.ExampleSingleMotorSubsystem;
import frc.robot.subsystems.ExampleDoubleMotorSubsystem;

/*  Finally, add your command imports for all the command you need for the operation of the button.  */

import frc.robot.commands.ExampleSingleMotorCommands.ExampleMovePositiveCommand;
import frc.robot.commands.ExampleSingleMotorCommands.ExampleStopCommand;
import frc.robot.commands.ExampleDoubleMotorCommands.ExampleRotationCommand;
import frc.robot.commands.ExampleDoubleMotorCommands.ExampleRotationStopCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class ExampleButtonCommand extends SequentialCommandGroup {

    public ExampleButtonCommand(ExampleSingleMotorSubsystem singleMotorSubsystem, ExampleDoubleMotorSubsystem doubleMotorSubsystem) {

        addCommands(
            new ExampleMovePositiveCommand(singleMotorSubsystem, 0.5).alongWith(new ExampleRotationCommand(doubleMotorSubsystem, 90, 0.5).raceWith(new WaitCommand(0.5))),
            new ExampleStopCommand(singleMotorSubsystem).alongWith(new ExampleRotationStopCommand(doubleMotorSubsystem)),
            new ExampleStopCommand(singleMotorSubsystem)
        );

        addRequirements(singleMotorSubsystem, doubleMotorSubsystem);

    }
    
}
