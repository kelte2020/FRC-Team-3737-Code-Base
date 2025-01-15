package frc.robot.commands.ExampleSingleMotorCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.ExampleSingleMotorSubsystem;

public class ExampleStopCommand extends Command {

    final ExampleSingleMotorSubsystem singleMotorSubsystem;

    public ExampleStopCommand(ExampleSingleMotorSubsystem m_singleMotorSubsystem) {

        singleMotorSubsystem = m_singleMotorSubsystem;

        addRequirements(singleMotorSubsystem);

    }

    @Override
    public void initialize() {

        singleMotorSubsystem.Stop();

    }

    @Override
    public boolean isFinished() {

        return true;

    }
    
}
