package constant;

public enum namesOfSounds {
freighter_sound("2.wav"),aircraft_sound("1.wav");
String path;
namesOfSounds(String path){
	this.path=path;
}
public String getPath() {
	return path;
}


}
