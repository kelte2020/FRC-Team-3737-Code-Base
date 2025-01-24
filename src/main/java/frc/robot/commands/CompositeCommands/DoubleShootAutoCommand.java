package frc.robot.commands.CompositeCommands;

/*  Before you start, add the sequential command group import.  */

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/*  Then, add your subsystem imports that will be needed for the operation of your commands.  */

import frc.robot.subsystems.ExampleSingleMotorSubsystem;
import frc.robot.subsystems.ExampleDoubleMotorSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc. subsustems.IntakeSubsystem;

/*  Finally, add your command imports for all the command you need for the operation of the button.  */


import frc.robot.commands.StartShooterCommand;
import frc.robot.commands.IntakeCommand;



public class DoubleShootAutoCommand extends SequentialCommandGroup {

    add Commands {
        /* this is a very basic command, its assuming that the robot is already in position to shoot and intake */

        new StartShooterCommand(shooterSubsystem, controller, 0.8)  // Set the shooter speed to 0.8 (random placeholder value)
        new IntakeCommand(intakeSubsystem, true) // Start the intake
        new StartShooterCommand(shooterSubsystem, controller, 0.4)  // Set the shooter speed to 0.4
    
    }
}
