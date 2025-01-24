package.frc.robot.commands.ButtonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.ExampleSingleMotorSubsystem;
import frc.robot.subsystems.ExampleDoubleMotorSubsystem;
import.frc.robot.subsystems.IntakeSubsystem;

import frc.robot.commands.ExampleSingleMotorCommands.ExampleMovePositiveCommand;
import frc.robot.commands.ExampleSingleMotorCommands.ExampleStopCommand;
import frc.robot.commands.ExampleDoubleMotorCommands.ExampleRotationCommand;
import frc.robot.commands.ExampleDoubleMotorCommands.ExampleRotationStopCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class IntakeReverseCommand extends SequentialCommandGroup {
    private final IntakeSubsystem intakeSubsystem;

    public IntakeReverseCommand(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {
         SetIntakeSpeed(0.5); // .5 is a placeholder value
        intakeSubsystem.reverseIntake();
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.stopIntake();
    }

    @Override
    public boolean isFinished() {
        return false; // Runs until explicitly stopped
    }
}
