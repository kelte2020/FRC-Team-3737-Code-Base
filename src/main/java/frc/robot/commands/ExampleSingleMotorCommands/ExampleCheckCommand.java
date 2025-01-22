package frc.robot.commands.ExampleSingleMotorCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.utils.SubsystemList;
import frc.robot.subsystems.ExampleSingleMotorSubsystem;

public class ExampleCheckCommand extends Command {

    /*  Here we see an example of where we use the initialize and isFinished in a unique way.
        We use the initialize to grab the current position of our motor, then compare it to the same encoder later.
        This is possible because of how initialize only runs once, while is finished runs indefinitely.  */

    final ExampleSingleMotorSubsystem singleMotorSubsystem;
    private final double target;

    private double initialDistance;
    private double currentDistance;

    public ExampleCheckCommand(SubsystemList subsystems, double m_target) {

        singleMotorSubsystem = (ExampleSingleMotorSubsystem) subsystems.getSubsystem("singleMotor");

        target = m_target;

    }

    @Override
    public void initialize() {

        initialDistance = singleMotorSubsystem.GetCurrentPosition();

    }

    @Override
    public boolean isFinished() {

        currentDistance = singleMotorSubsystem.GetCurrentPosition();

        /*  Return the absolute so its always the same value no matter which way the motor moves, assuming it moves in one direction more thant he other.  */

        return (target <= Math.abs(currentDistance - initialDistance));

    }
    
}
