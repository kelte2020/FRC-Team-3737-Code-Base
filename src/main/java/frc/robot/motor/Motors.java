package frc.robot.motor;

import frc.robot.motor.Motor.encoderType;

public class Motors {
    
    public final Motor motor;
    
    public Motors(MotorInfo motor, encoderType encoder) {

        this.motor = new Motor(motor, encoder);

    }

    public void SetRampRate(double rate) {

        motor.motorConfig.closedLoopRampRate(rate);

    }

    public double GetTemperature() {

        return motor.motor.getMotorTemperature();

    }

    public double GetCurrent() {

        return motor.motor.getOutputCurrent();

    }

    public double GetVelocity() {

        return motor.inBuiltEncoder.getVelocity();

    }

    public String[] GetDebuggingInformation() {

        String[] info = {
            String.valueOf(motor.motor.getDeviceId()), 
            String.valueOf(motor.motor.getMotorType()), 
            String.valueOf(motor.motor.getFirmwareVersion()), 
            String.valueOf(motor.motor.getBusVoltage()), 
            String.valueOf(motor.motor.getAbsoluteEncoder()), 
            String.valueOf(motor.motor.getAnalog()), 
            String.valueOf(motor.motor.getStickyFaults()), 
            String.valueOf(motor.motor.getFaults()), 
            String.valueOf(motor.motor.getStickyWarnings()), 
            String.valueOf(motor.motor.getWarnings())
        };

        return info;

    }

    public void Spin(double speed) {

        motor.motor.set(speed);

    }

}
