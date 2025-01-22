package frc.robot.commands.CompositeCommands;

/*  Before you start, add the sequential command group import.  */

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/*  Then, add your subsystem imports that will be needed for the operation of your commands.  */

import frc.robot.utils.SubsystemList;

/*  Finally, add your command imports for all the command you need for the operation of the button.  */

import frc.robot.commands.ExampleSingleMotorCommands.ExampleMovePositiveCommand;
import frc.robot.commands.ExampleSingleMotorCommands.ExampleStopCommand;
import frc.robot.commands.ExampleDoubleMotorCommands.ExampleRotationCommand;
import frc.robot.commands.ExampleDoubleMotorCommands.ExampleRotationStopCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class ExampleAutoCommand extends SequentialCommandGroup {

    /*  Another one that wasn't able to be replicated great from past code. An auto command is basically a button command with softlock prevention for auto.  */

    public ExampleAutoCommand(SubsystemList subsystems) {

        addCommands(
            new ExampleMovePositiveCommand(subsystems, 0.5).alongWith(new ExampleRotationCommand(subsystems, 90, 0.5).raceWith(new WaitCommand(0.5))),
            new ExampleStopCommand(subsystems).alongWith(new ExampleRotationStopCommand(subsystems)),
            new ExampleStopCommand(subsystems)
        );

    }
    
}
