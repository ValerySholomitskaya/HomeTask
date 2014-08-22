package utils;

import utils.Sound;

public class SoundCreator {
	public void playSound(String nameOfSong) {
		Sound.playSound(nameOfSong).join();
	}
}
