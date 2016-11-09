import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;

public class assignment
{
  private LightSensor light;
  private UltrasonicSensor usonic;
  private TouchSensor touch;
  
  public assignment()
  {
    this.light = new LightSensor(SensorPort.S4);
    this.usonic = new UltrasonicSensor(SensorPort.S3);
    this.touch = new TouchSensor(SensorPort.S1);
    
    run();
  }
  
  private void run()
  {
    int i = 1;
    while (i != 0)
    {
      if (this.usonic.getDistance() < 5)
      {
        Motor.B.stop();
        Motor.A.rotate(1080);
      }
      if (this.light.getLightValue() > 80)
      {
        Motor.A.stop();
        Motor.B.stop();
        i = 0;
      }
      Motor.A.forward();
      Motor.B.forward();
    }
  }
  
  private static void main(String[] paramArrayOfString)
  {
    new assignment();
  }
}
