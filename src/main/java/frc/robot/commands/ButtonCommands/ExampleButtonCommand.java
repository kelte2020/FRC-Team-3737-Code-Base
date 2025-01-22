package frc.robot.commands.ButtonCommands;

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

public class ExampleButtonCommand extends SequentialCommandGroup {

    /*  The following is a button command. It is a mix of base commands and intermediate commands in order to run a series of operations on the robot.
        As you can see, this rotates and shoots in this case along with a wait command to prevent softlocking. Then it goes into a set of stops followed by another stop.
        The second stop was added because in the training, we had the rookies imagine that the other example move on the same line as the stops was a different system.
        The reason that wouldn't work was the add requirements, as stated in an earlier file.  */

    public ExampleButtonCommand(SubsystemList subsystems) {

        addCommands(
            new ExampleMovePositiveCommand(subsystems, 0.5).alongWith(new ExampleRotationCommand(subsystems, 90, 0.5).raceWith(new WaitCommand(0.5))),
            new ExampleStopCommand(subsystems).alongWith(new ExampleRotationStopCommand(subsystems)),
            new ExampleStopCommand(subsystems)
        );

    }
    
}
