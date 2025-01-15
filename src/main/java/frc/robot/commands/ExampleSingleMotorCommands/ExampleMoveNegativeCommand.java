package frc.robot.commands.ExampleSingleMotorCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.ExampleSingleMotorSubsystem;

public class ExampleMoveNegativeCommand extends Command {

    final ExampleSingleMotorSubsystem singleMotorSubsystem;
    private final double motorSpeed;

    public ExampleMoveNegativeCommand(ExampleSingleMotorSubsystem m_singleMotorSubsystem, double speed) {

        singleMotorSubsystem = m_singleMotorSubsystem;

        motorSpeed = speed;

        addRequirements(singleMotorSubsystem);

    }

    @Override
    public void initialize() {

        singleMotorSubsystem.SetSpeed(motorSpeed);

    }

    @Override
    public void execute() {

        singleMotorSubsystem.NegativeMove();

    }

    @Override
    public void end(boolean interrupted) {

        singleMotorSubsystem.Stop();

    }
    
}
