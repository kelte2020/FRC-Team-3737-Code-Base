package frc.robot.auto.Routines;

/*  Follow the same steps as making a button command. But set up the constructor slightly different.  */

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ExampleSingleMotorSubsystem;
import frc.robot.utils.SubsystemList;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleDoubleMotorSubsystem;

import frc.robot.commands.CompositeCommands.ExampleAutoCommand;
import frc.robot.commands.CompositeCommands.ExampleIntermediateCommand;
import frc.robot.commands.DriveCommands.AutoMoveCommand;

public class ExampleAutoRoutine extends SequentialCommandGroup {

    /*  And example auto routine is series of commands, like a button command, but made for full autonomous action, with higher softlock prevention.
        Unfortunately, this does sometimes lead to misses or errors in the autonomous routine.  */

    public ExampleAutoRoutine(SubsystemList subsystems) {

        setName("Example Auto");

        /*  The following 3 lines of code will be deprecated as they will be added into the lower base subsystems later on, meaning we only need the subsystems param.  */

        DriveSubsystem drive = (DriveSubsystem) subsystems.getSubsystem("drive");
        ExampleSingleMotorSubsystem singleMotorSubsystem = (ExampleSingleMotorSubsystem) subsystems.getSubsystem("singleMotor");
        ExampleDoubleMotorSubsystem doubleMotorSubsystem = (ExampleDoubleMotorSubsystem) subsystems.getSubsystem("doubleMotor");

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
