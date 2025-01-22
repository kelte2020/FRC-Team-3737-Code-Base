package frc.robot.commands.ExampleSingleMotorCommands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.utils.SubsystemList;
import frc.robot.subsystems.ExampleSingleMotorSubsystem;

/*  Look at frc.robot.commands.ExampleSingleMotorCommands.ExampleMovePositiveCommand  */

public class ExampleMoveNegativeCommand extends Command {

    final ExampleSingleMotorSubsystem singleMotorSubsystem;
    private final double motorSpeed;

    public ExampleMoveNegativeCommand(SubsystemList subsystems, double speed) {

        singleMotorSubsystem = (ExampleSingleMotorSubsystem) subsystems.getSubsystem("singleMotor");

        motorSpeed = speed;

        addRequirements(singleMotorSubsystem);

    }

    @Override
    public void initialize() {

        singleMotorSubsystem.SetSpeed(motorSpeed);
        singleMotorSubsystem.NegativeMove();

    }

    @Override
    public void end(boolean interrupted) {

        singleMotorSubsystem.Stop();

    }
    
}
