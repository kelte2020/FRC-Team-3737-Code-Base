package frc.robot.commands.ExampleSingleMotorCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.ExampleSingleMotorSubsystem;

public class ExampleSwitchCommand extends Command {

    final ExampleSingleMotorSubsystem singleMotorSubsystem;

    public ExampleSwitchCommand(ExampleSingleMotorSubsystem m_singleMotorSubsystem) {

        singleMotorSubsystem = m_singleMotorSubsystem;

    }

    @Override
    public boolean isFinished() {

        return singleMotorSubsystem.SwitchObjectIn();

    }
    
}
