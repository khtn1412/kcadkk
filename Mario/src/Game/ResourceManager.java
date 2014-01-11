package Game;

import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;

import android.content.Context;

public class ResourceManager 
{	
	//Source for Sprites
	private BitmapTextureAtlas mPlayerLargeTexture;
	public ITiledTextureRegion mPlayerLargeTextureRegion;
	
	private BitmapTextureAtlas mPlayerSmallTexture;
	public ITiledTextureRegion mPlayerSmallTextureRegion;
	
	private BitmapTextureAtlas mPlayerHasGunTexture;
	public ITiledTextureRegion mPlayerHasGunTextureRegion;
	
	private BitmapTextureAtlas mGoombaTexture;
	public ITiledTextureRegion mGoombaTextureRegion;
	
	private BitmapTextureAtlas mKoopaTexture;
	public ITiledTextureRegion mKoopaTextureRegion;
	
	private BitmapTextureAtlas mPirhanaTexture;
	public ITiledTextureRegion mPirhanaTextureRegion;
	
	private BitmapTextureAtlas mQuestionTexture;
	public ITiledTextureRegion mQuestionTextureRegion;
	
	private BitmapTextureAtlas mMoneyTexture;
	public ITiledTextureRegion mMoneyTextureRegion;
	
	private BitmapTextureAtlas mBrickTexture;
	public ITiledTextureRegion mBrickTextureRegion;
	
	private BitmapTextureAtlas mMushroomTexture;
	public ITiledTextureRegion mMushroomTextureRegion;
	
	private BitmapTextureAtlas mMushroomUpTexture;
	public ITiledTextureRegion mMushroomUpTextureRegion;
	
	private BitmapTextureAtlas mFlowerTexture;
	public ITiledTextureRegion mFlowerTextureRegion;
	
	private BitmapTextureAtlas mStarTexture;
	public ITiledTextureRegion mStarTextureRegion;
	
	private BitmapTextureAtlas mSpieceBrickTexture;
	public ITiledTextureRegion mSpieceBrickTextureRegion;
	
	private BitmapTextureAtlas mEffectMoneyTexture;
	public ITiledTextureRegion mEffectMoneyTextureRegion;
	
	private BitmapTextureAtlas mBulletTexture;
	public ITiledTextureRegion mBulletTextureRegion;
	
	
	// Source for Controls	
	private BitmapTextureAtlas mOnScreenControlTexture;
	public ITextureRegion mOnScreenControlBaseTextureRegion;
	public ITextureRegion mOnScreenControlKnobTextureRegion;	
	
	private BitmapTextureAtlas mJumpButtonTexture;
	public ITextureRegion mJumpButtonTextureRegion;
	public ITextureRegion mJumpPressButtonTextureRegion;
	
	private BitmapTextureAtlas mFireButtonTexture;
	public ITextureRegion mFireButtonTextureRegion;
	public ITextureRegion mFirePressButtonTextureRegion;
	
	private BitmapTextureAtlas mResumeButtonTexture;
	public ITextureRegion mResumeButtonTextureRegion;
	public ITextureRegion mResumePressButtonTextureRegion;
	
	private BitmapTextureAtlas mPauseButtonTexture;
	public ITextureRegion mPauseButtonTextureRegion;
	public ITextureRegion mPausePressButtonTextureRegion;
	
	private BitmapTextureAtlas mMenuButtonTexture;
	public ITextureRegion mMenuButtonTextureRegion;
	public ITextureRegion mMenuPressButtonTextureRegion;
	
	private BitmapTextureAtlas mSoundButtonTexture;
	public ITextureRegion mSoundButtonTextureRegion;
	public ITextureRegion mSoundPressButtonTextureRegion;
	
	private BitmapTextureAtlas mSoundDisableButtonTexture;
	public ITextureRegion mSoundDisableButtonTextureRegion;
	
	private BitmapTextureAtlas mNextButtonTexture;
	public ITextureRegion mNextButtonTextureRegion;
	public ITextureRegion mNextPressButtonTextureRegion;
	
	private BitmapTextureAtlas mPausePanelTexture;
	public ITextureRegion mPausePanelTextureRegion;
	
	private BitmapTextureAtlas mCompletePanelTexture;
	public ITextureRegion mCompletePanelTextureRegion;
	
	private BitmapTextureAtlas mGameOverPanelTexture;
	public ITextureRegion mGameOverPanelTextureRegion;
	
	private BitmapTextureAtlas mSaveButtonTexture;
	public ITextureRegion mSaveButtonTextureRegion;
	public ITextureRegion mSavePressButtonTextureRegion;
	
	
	public void loadResource(Context context, TextureManager textManager)
	{
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("Images/");
		
		mPlayerLargeTexture = new BitmapTextureAtlas(textManager, 192, 128, TextureOptions.DEFAULT);
		mPlayerLargeTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mPlayerLargeTexture, context, "Mario_Large.png", 0, 0, 6, 2);
		mPlayerLargeTexture.load();
		
		mPlayerSmallTexture = new BitmapTextureAtlas(textManager, 192, 64);
		mPlayerSmallTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mPlayerSmallTexture, context, "Mario_Small.png", 0, 0, 6, 2);
		mPlayerSmallTexture.load();
		
		mPlayerHasGunTexture = new BitmapTextureAtlas(textManager, 192, 128, TextureOptions.DEFAULT);
		mPlayerHasGunTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mPlayerHasGunTexture, context, "Mario_HasGun.png", 0, 0, 6, 2);
		mPlayerHasGunTexture.load();
		
		mGoombaTexture = new BitmapTextureAtlas(textManager, 352, 64, TextureOptions.DEFAULT);
		mGoombaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mGoombaTexture, context, "Goomba.png", 0, 0, 11, 2);
		mGoombaTexture.load();
		
		mKoopaTexture = new BitmapTextureAtlas(textManager, 288, 64, TextureOptions.DEFAULT);
		mKoopaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mKoopaTexture, context, "Koopa.png", 0, 0, 9, 1);
		mKoopaTexture.load();
		
		mPirhanaTexture = new BitmapTextureAtlas(textManager, 288, 64, TextureOptions.DEFAULT);
		mPirhanaTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mPirhanaTexture, context, "Pirhana.png", 0, 0, 3, 1);
		mPirhanaTexture.load();
		
		mQuestionTexture = new BitmapTextureAtlas(textManager, 224, 32, TextureOptions.DEFAULT);
		mQuestionTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mQuestionTexture, context, "Question.png", 0, 0, 7, 1);
		mQuestionTexture.load();
		
		mMoneyTexture = new BitmapTextureAtlas(textManager, 160, 64, TextureOptions.DEFAULT);
		mMoneyTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mMoneyTexture, context, "Money.png", 0, 0, 5, 2);
		mMoneyTexture.load();
		
		mEffectMoneyTexture = new BitmapTextureAtlas(textManager, 160, 32, TextureOptions.DEFAULT);
		mEffectMoneyTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mEffectMoneyTexture, context, "EffectMoney.png", 0, 0, 5, 1);
		mEffectMoneyTexture.load();
		
		mBulletTexture = new BitmapTextureAtlas(textManager, 64, 16, TextureOptions.DEFAULT);
		mBulletTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBulletTexture, context, "Bullet.png", 0, 0, 4, 1);
		mBulletTexture.load();
		
		mBrickTexture = new BitmapTextureAtlas(textManager, 32, 32, TextureOptions.DEFAULT);
		mBrickTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBrickTexture, context, "Brick.png", 0, 0, 1, 1);
		mBrickTexture.load();
		
		mMushroomTexture = new BitmapTextureAtlas(textManager, 32, 32, TextureOptions.DEFAULT);
		mMushroomTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mMushroomTexture, context, "Mushroom.png", 0, 0, 1, 1);
		mMushroomTexture.load();
		
		mMushroomUpTexture = new BitmapTextureAtlas(textManager, 32, 32, TextureOptions.DEFAULT);
		mMushroomUpTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mMushroomUpTexture, context, "MushroomUp.png", 0, 0, 1, 1);
		mMushroomUpTexture.load();
		
		mFlowerTexture = new BitmapTextureAtlas(textManager, 32, 32, TextureOptions.DEFAULT);
		mFlowerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mFlowerTexture, context, "Flower.png", 0, 0, 1, 1);
		mFlowerTexture.load();
		
		mStarTexture = new BitmapTextureAtlas(textManager, 32, 32, TextureOptions.DEFAULT);
		mStarTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mStarTexture, context, "Star.png", 0, 0, 1, 1);
		mStarTexture.load();
		
		mSpieceBrickTexture = new BitmapTextureAtlas(textManager, 16, 16, TextureOptions.DEFAULT);
		mSpieceBrickTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mSpieceBrickTexture, context, "SpieceBrick.png", 0, 0, 1, 1);
		mSpieceBrickTexture.load();		

		mOnScreenControlTexture = new BitmapTextureAtlas(textManager, 256, 128, TextureOptions.BILINEAR);
		mOnScreenControlBaseTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mOnScreenControlTexture, context, "onscreen_control_base.png", 0, 0);
		mOnScreenControlKnobTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mOnScreenControlTexture, context, "onscreen_control_knob.png", 128, 0);
		mOnScreenControlTexture.load();
		
		mJumpButtonTexture = new BitmapTextureAtlas(textManager, 128, 64);
		mJumpButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mJumpButtonTexture, context, "jump.png", 0, 0);
		mJumpPressButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mJumpButtonTexture, context, "btnormal.png", 64, 0);
		mJumpButtonTexture.load();
		
		mFireButtonTexture = new BitmapTextureAtlas(textManager, 128, 64);
		mFireButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mFireButtonTexture, context, "fire.png", 0, 0);
		mFirePressButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mFireButtonTexture, context, "btnormal.png", 64, 0);
		mFireButtonTexture.load();
		
		mResumeButtonTexture = new BitmapTextureAtlas(textManager, 200, 100);
		mResumeButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mResumeButtonTexture, context, "resume_icon.png", 0, 0);
		mResumePressButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mResumeButtonTexture, context, "resume_icon_press.png", 100, 0);
		mResumeButtonTexture.load();
		
		mPauseButtonTexture = new BitmapTextureAtlas(textManager, 128, 64);
		mPauseButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mPauseButtonTexture, context, "pause_icon.png", 0, 0);
		mPausePressButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mPauseButtonTexture, context, "pause_icon_press.png", 64, 0);		
		mPauseButtonTexture.load();
		
		mMenuButtonTexture = new BitmapTextureAtlas(textManager, 200, 100);
		mMenuButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mMenuButtonTexture, context, "menu_icon.png", 0, 0);
		mMenuPressButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mMenuButtonTexture, context, "menu_icon_press.png", 100, 0);
		mMenuButtonTexture.load();
		
		mSoundButtonTexture = new BitmapTextureAtlas(textManager, 128, 64);
		mSoundButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mSoundButtonTexture, context, "sound_icon.png", 0, 0);
		mSoundPressButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mSoundButtonTexture, context, "sound_icon_press.png", 64, 0);
		mSoundButtonTexture.load();
		
		mSoundDisableButtonTexture = new BitmapTextureAtlas(textManager, 64, 64);
		mSoundDisableButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mSoundDisableButtonTexture, context, "sound_disable_icon.png", 0, 0);
		mSoundDisableButtonTexture.load();
		
		mNextButtonTexture = new BitmapTextureAtlas(textManager, 200, 100);
		mNextButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mNextButtonTexture, context, "next_icon.png", 0, 0);
		mNextPressButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mNextButtonTexture, context, "next_icon_press.png", 100, 0);
		mNextButtonTexture.load();
		
		mSaveButtonTexture = new BitmapTextureAtlas(textManager, 200, 100);
		mSaveButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mSaveButtonTexture, context, "save_icon.png", 0, 0);
		mSavePressButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mSaveButtonTexture, context, "save_icon_press.png", 100, 0);
		mSaveButtonTexture.load();
		
		mPausePanelTexture = new BitmapTextureAtlas(textManager, 250, 100);
		mPausePanelTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mPausePanelTexture, context, "pause_panel.png", 0, 0);
		mPausePanelTexture.load();
		
		mCompletePanelTexture = new BitmapTextureAtlas(textManager, 400, 250);
		mCompletePanelTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mCompletePanelTexture, context, "complete_panel.png", 0, 0);
		mCompletePanelTexture.load();
		
		mGameOverPanelTexture = new BitmapTextureAtlas(textManager, 400, 250);
		mGameOverPanelTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mGameOverPanelTexture, context, "gameover_panel.png", 0, 0);
		mGameOverPanelTexture.load();
	}
}
