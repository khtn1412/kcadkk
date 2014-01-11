package Game;
import java.io.IOException;
import java.util.Hashtable;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.audio.music.MusicManager;
import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.audio.sound.SoundManager;
import android.content.Context;

public class SoundsManager 
{
	public enum Sounds
	{
		PlayerJump,
		GetMoney,
		DestroyBrick,
		Small,
		Shoot,
		EnemyDie,
		Bumping,
		Kick,
		OneUp,
		Pause,
		PowerUp_Appears,
		PowerUp,
		Stomp,
		WarningTime,
		PlayerDie,
		GameOver,
	}
	
	public enum Musics
	{
		Background,
		Complete,
		Starman,
	}	
	
	private static boolean mIsMute;
	private static Musics mCurrentMusic = Musics.Background;
	private static Hashtable<Sounds, Sound> mSounds = new Hashtable<Sounds, Sound>();
	private static Hashtable<Musics, Music> mMusics = new Hashtable<SoundsManager.Musics, Music>();
	
	public static void loadMusic(MusicManager pMusicManager, Context pContext)
	{
		try 
		{
			MusicFactory.setAssetBasePath("Sounds/");
			
			Music Backgound = MusicFactory.createMusicFromAsset(pMusicManager, pContext, "background.mp3");
			Backgound.setLooping(true);
			mMusics.put(Musics.Background, Backgound);
			
			Music Complete = MusicFactory.createMusicFromAsset(pMusicManager, pContext, "complete.mp3");
			mMusics.put(Musics.Complete, Complete);
			
			Music Starman = MusicFactory.createMusicFromAsset(pMusicManager, pContext, "starman.mp3");
			mMusics.put(Musics.Starman, Starman);
		} 
		catch (IOException e) 
		{	
			e.printStackTrace();
		}
	}
	
	public static void loadSound(SoundManager pSoundManager, Context pContext)
	{
		try 
		{
			SoundFactory.setAssetBasePath("Sounds/");
			
			Sound PlayerJump = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "Jump.wav");
			mSounds.put(Sounds.PlayerJump, PlayerJump);
			
			Sound GetMoney = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "GetMoney.wav");
			mSounds.put(Sounds.GetMoney, GetMoney);
			
			Sound DestroyBrick = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "DestroyBrick.wav");
			mSounds.put(Sounds.DestroyBrick, DestroyBrick);
			
			Sound Small = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "Small.wav");
			mSounds.put(Sounds.Small, Small);
			
			Sound Shoot = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "Shoot.wav");
			mSounds.put(Sounds.Shoot, Shoot);
			
			Sound Bumping = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "Bumping.wav");
			mSounds.put(Sounds.Bumping, Bumping);
			
			Sound Kick = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "EnemyDie.wav");
			mSounds.put(Sounds.Kick, Kick);
			
			Sound OneUp = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "OneUp.wav");
			mSounds.put(Sounds.OneUp, OneUp);
			
			Sound Pause = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "Pause.wav");
			mSounds.put(Sounds.Pause, Pause);
			
			Sound PowerUp_Appears = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "PowerUp_Appears.wav");
			mSounds.put(Sounds.PowerUp_Appears, PowerUp_Appears);
			
			Sound PowerUp = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "PowerUp.wav");
			mSounds.put(Sounds.PowerUp, PowerUp);
			
			Sound Stomp = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "Stomp.wav");
			mSounds.put(Sounds.Stomp, Stomp);
			
			Sound WarningTime = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "WarningTime.wav");
			mSounds.put(Sounds.WarningTime, WarningTime);		
			
			Sound PlayerDie = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "MarioDie.wav");
			mSounds.put(Sounds.PlayerDie, PlayerDie);
			
			Sound GameOver = SoundFactory.createSoundFromAsset(pSoundManager, pContext, "GameOver.wav");
			mSounds.put(Sounds.GameOver, GameOver);
		} 
		catch (IOException e) 
		{	
			e.printStackTrace();
		}
	}
	
	public static void setMute(boolean isOff)
	{
		mIsMute = isOff;
		if (isOff)
		{
			pauseAllMusic();
		}
		else
		{
			mMusics.get(mCurrentMusic).play();
		}
	}
	
	public static void playMusic(Musics music)
	{
		mCurrentMusic = music;
		if (mIsMute) return;
		for (Musics key : mMusics.keySet())
		{
			Music ms = mMusics.get(key);
			if (music == key)
			{
				ms.play();
			}
			else if (ms.isPlaying())
			{
				ms.pause();
			}				
		}
	}	
	
	public static void pauseAllMusic()
	{
		for (Musics key : mMusics.keySet())
		{
			Music ms = mMusics.get(key);
			if (ms.isPlaying())
			{
				ms.pause();
			}
		}
	}
	
	public static void stopMusic(Musics music)
	{
		if (mIsMute) return;
		if (mMusics.containsKey(music))
		{
			Music ms = (Music)mMusics.get(music);
			if (ms.isPlaying())
			{
				ms.stop();
			}
		}
	}
	
	public static void pauseMusic(Musics music)
	{
		if (mIsMute) return;
		if (mMusics.containsKey(music))
		{
			Music ms = (Music)mMusics.get(music);
			if (ms.isPlaying())
			{
				ms.pause();
			}
		}
	}
	
	public static void playSound(Sounds sound)
	{
		if (mIsMute) return;
		if (mSounds.containsKey(sound))
		{
			((Sound)mSounds.get(sound)).play();
		}
	}
	
	public static void resumeMusic()
	{
		mMusics.get(mCurrentMusic).play();
	}
	
	public static void shutdown()
	{
		if (mSounds != null)
		{
			mSounds.clear();
			mSounds = null;
		}
		if (mMusics != null)
		{
			mMusics.clear();
			mMusics = null;
		}
	}
	
}
