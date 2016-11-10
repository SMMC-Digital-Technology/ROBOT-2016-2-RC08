import lejos.nxt.*;

public class assignment
{
  private LightSensor light;
  private UltrasonicSensor usonic;
  private TouchSensor touch;
  
  public assignment()
  {
    light = new LightSensor(SensorPort.S4);
    usonic = new UltrasonicSensor(SensorPort.S3);
    touch = new TouchSensor(SensorPort.S1);
    
	while (Button.ENTER.isDown()) {
		// wait
	}
	
    run();
  }
  
  private void run()
  {
    boolean end = false;
    while (!end) {
		if (usonic.getDistance() < 5){
			Motor.B.stop();
			Motor.A.rotate(1080);
		} else if (light.getLightValue() > 80) {
			Motor.A.stop();
			Motor.B.stop();
			end = true;
		} else if (touch.isPressed()) {
			Motor.A.stop();
			Motor.B.rotate(1080);
		} else {
			Motor.A.forward();
			Motor.B.forward();
		}		
		
		end = Button.ENTER.isDown();
	 
    }
  }
  
  public static void main(String[] args) {
    new assignment();
  }
}