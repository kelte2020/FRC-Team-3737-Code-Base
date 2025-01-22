package frc.robot.commands.ExampleSingleMotorCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.ExampleSingleMotorSubsystem;

public class ExampleStopCommand extends Command {

    /*  Unlike the moves, this ends with an is finished. This is a redundancy to make sure the motor stops.
        In reality, initialize is not needed nor is the end in the move commands, but you need one or the other.
        Which method you choose is up to you, but the redundancy is a sort of safety to make sure it stops like it should.  */

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
