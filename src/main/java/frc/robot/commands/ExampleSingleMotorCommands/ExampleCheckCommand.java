package frc.robot.commands.ExampleSingleMotorCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.ExampleSingleMotorSubsystem;

public class ExampleCheckCommand extends Command {

    final ExampleSingleMotorSubsystem singleMotorSubsystem;
    private final double target;

    private double initialDistance;
    private double currentDistance;

    public ExampleCheckCommand(ExampleSingleMotorSubsystem m_singleMotorSubsystem, double m_target) {

        singleMotorSubsystem = m_singleMotorSubsystem;

        target = m_target;

    }

    @Override
    public void initialize() {

        initialDistance = singleMotorSubsystem.GetCurrentPosition();

    }

    @Override
    public boolean isFinished() {

        currentDistance = singleMotorSubsystem.GetCurrentPosition();

        return (target <= Math.abs(currentDistance - initialDistance));

    }
    
}
