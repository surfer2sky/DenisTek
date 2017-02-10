import java.awt.Robot;
import java.awt.MouseInfo;
import java.awt.event.InputEvent;
import java.util.Calendar;
import java.util.Date;

public class Active {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long end = start + 24 * 60 * 60 * 1000l;
        if (args.length >= 1 ) {
	        System.out.println("   Started     at: " + Calendar.getInstance().getTime());
            end = start + Long.valueOf(args[0]) * 1000l * 60;
			System.out.println("   To be ended at: " + new Date(end));
			System.out.println("   To be ended in minutes (default 24 hours): " + args[0]);
        }
        while (System.currentTimeMillis() < end) {
            try {
				Date date = Calendar.getInstance().getTime();
				System.out.println("Time: " + date + ", started: " + (System.currentTimeMillis()-start)/60/1000 +  " mins and to be ended in:" + (end - System.currentTimeMillis())/60/1000 + " mins");
                Robot robot = new Robot();
				int xx = MouseInfo.getPointerInfo().getLocation().x;
				int yy = MouseInfo.getPointerInfo().getLocation().y;
				robot.mouseMove(1000, 1077);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
				robot.mouseMove(xx, yy);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                Thread.sleep(4 * 60 * 1000l);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nEnded at: " + Calendar.getInstance().getTime());
    }
}
