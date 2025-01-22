package frc.robot.commands.ExampleSingleMotorCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.utils.SubsystemList;
import frc.robot.subsystems.ExampleSingleMotorSubsystem;

/*  Import Command and the necessary subsystem for a base command. Command is then extended so we can use its methods.
    Here you see we use initialize and end. Initialize runs once when the command starts and end is ran when the interrupted boolean is true.
    Interrupted is determined inside of the Command superclass and is set by an is finished method. More on that later.  */

public class ExampleMovePositiveCommand extends Command {

    /*  Because this is not the final command (aka a button/composite command), we make all variables params.
        This is why our subsystem is imported from a command later down the line that ends up inside of robot container.
        We initialize the subsystem once inside of the container as multiple would end up crashing the code.  */

    final ExampleSingleMotorSubsystem singleMotorSubsystem;
    private final double motorSpeed;

    public ExampleMovePositiveCommand(SubsystemList subsystems, double speed) {

        singleMotorSubsystem = (ExampleSingleMotorSubsystem) subsystems.getSubsystem("singleMotor");

        motorSpeed = speed;

        /*  Requirements are added to prevent 2 commands on the same subsystem from running at the same time to prevent breakage.  */

        addRequirements(singleMotorSubsystem);

    }

    @Override
    public void initialize() {

        /*  Positive Move can be here because it doesn't stop until told to stop. Keep that in mind when making commands.  */

        singleMotorSubsystem.SetSpeed(motorSpeed);
        singleMotorSubsystem.PositiveMove();

    }

    @Override
    public void end(boolean interrupted) {

        singleMotorSubsystem.Stop();

    }
    
}
