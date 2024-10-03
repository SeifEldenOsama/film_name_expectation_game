package FilmGame;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicAndSound 
{

	private static Clip clip1,clip2,clip3,clip4,clip5,clip6;
		
	public static void playMusic(String Path) throws LineUnavailableException
	{
		File file=new File(Path);
		try {
			AudioInputStream audio=AudioSystem.getAudioInputStream(file);
			clip1=AudioSystem.getClip();
			clip1.open(audio);
			clip1.loop(Clip.LOOP_CONTINUOUSLY);
			clip1.start();
			
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	} 
	
	
	public static void enter(String Path) throws LineUnavailableException
	{
		File file=new File(Path);
		try {
			AudioInputStream audio=AudioSystem.getAudioInputStream(file);
			clip2=AudioSystem.getClip();
			clip2.open(audio);			
			clip2.start();
			
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void click(String Path) throws LineUnavailableException
	{
		File file=new File(Path);
		try {
			AudioInputStream audio=AudioSystem.getAudioInputStream(file);
			clip2=AudioSystem.getClip();
			clip2.open(audio);			
			clip2.start();
			
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void goobjob(String Path) throws LineUnavailableException
	{
		File file=new File(Path);
		try {
			AudioInputStream audio=AudioSystem.getAudioInputStream(file);
			clip3=AudioSystem.getClip();
			clip3.open(audio);
			clip3.start();
			
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void collect(String Path) throws LineUnavailableException
	{
		File file=new File(Path);
		try {
			AudioInputStream audio=AudioSystem.getAudioInputStream(file);
			clip4=AudioSystem.getClip();
			clip4.open(audio);
			clip4.start();
			
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void victory(String Path) throws LineUnavailableException
	{
		File file=new File(Path);
		try {
			AudioInputStream audio=AudioSystem.getAudioInputStream(file);
			clip5=AudioSystem.getClip();
			clip5.open(audio);
			clip5.start();
			
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void next(String Path) throws LineUnavailableException
	{
		File file=new File(Path);
		try {
			AudioInputStream audio=AudioSystem.getAudioInputStream(file);
			clip6=AudioSystem.getClip();
			clip6.open(audio);
			clip6.start();
			
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	  public static Clip GetClip()
	    {
	    	return clip1;
	    }
		
	
}
