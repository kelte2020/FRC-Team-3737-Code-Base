package frc.robot.commands.ExampleDoubleMotorCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.ExampleDoubleMotorSubsystem;

public class ExampleRotationCommand extends Command{

    final ExampleDoubleMotorSubsystem doubleMotorSubsystem;
    private final double target;
    private final double deadzone;

    public ExampleRotationCommand(ExampleDoubleMotorSubsystem m_doubleMotorSubsystem, double m_target, double m_deadzone) {

        doubleMotorSubsystem = m_doubleMotorSubsystem;

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