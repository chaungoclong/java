package inClass;
import basic.Execute;

public class AnimationConsole extends Execute {
	public AnimationConsole() {}
	
	public void printTextSlow(String text, int time) {
		for (int i = 0; i < text.length(); ++i) {
			echo (text.charAt(i));
			try {
				Thread.sleep(time);
			} catch (Exception e) {
				echo (e.getMessage());
			}
		}
	}
}
