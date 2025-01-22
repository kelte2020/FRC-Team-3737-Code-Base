package frc.robot.auto.Routines;

/*  Follow the same steps as making a button command. But set up the constructor slightly different.  */

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.utils.SubsystemList;

import frc.robot.commands.CompositeCommands.ExampleAutoCommand;
import frc.robot.commands.CompositeCommands.ExampleIntermediateCommand;
import frc.robot.commands.DriveCommands.AutoMoveCommand;

public class ExampleAutoRoutine extends SequentialCommandGroup {

    /*  And example auto routine is series of commands, like a button command, but made for full autonomous action, with higher softlock prevention.
        Unfortunately, this does sometimes lead to misses or errors in the autonomous routine.  */

    public ExampleAutoRoutine(SubsystemList subsystems) {

        setName("Example Auto");

        addCommands(
            new ExampleAutoCommand(subsystems),
            new AutoMoveCommand(subsystems, 0, 0, 0, 0, 0)
                .alongWith(new ExampleIntermediateCommand(subsystems)),
            new ExampleAutoCommand(subsystems),
            new AutoMoveCommand(subsystems, 0, 0, 0, 0, 0)
                .alongWith(new ExampleIntermediateCommand(subsystems))
        );

    }
    
}
