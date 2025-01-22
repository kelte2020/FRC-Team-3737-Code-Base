package frc.robot.commands.ExampleDoubleMotorCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.utils.SubsystemList;
import frc.robot.subsystems.ExampleDoubleMotorSubsystem;

public class ExampleRotationCommand extends Command{

    /*  Contrary to previous systems, this uses an execute. This is because of how the PivotToTarget is set up.
        The pivot to target constantly checks the variables within to update it's values on how much power to give.
        This is why it is not able to go into the initialize like other moves. The activate rotation is just a safety.
        Remember, in systems that can break the robot, add extra redundancies for protection.  */

    final ExampleDoubleMotorSubsystem doubleMotorSubsystem;
    private final double target;
    private final double deadzone;

    public ExampleRotationCommand(SubsystemList subsystems, double m_target, double m_deadzone) {

        doubleMotorSubsystem = (ExampleDoubleMotorSubsystem) subsystems.getSubsystem("doubleMotor");

        target = m_target;
        deadzone = m_deadzone;

        addRequirements(doubleMotorSubsystem);

    }

    @Override
    public void initialize() {

        doubleMotorSubsystem.SetDesiredAngle(target);
        doubleMotorSubsystem.ActivateRotation();

    }

    @Override
    public void execute() {

        doubleMotorSubsystem.PivotToTarget();

    }

    @Override
    public boolean isFinished() {

        return doubleMotorSubsystem.IsReady(deadzone);

    }

}