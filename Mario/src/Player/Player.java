package Player;

import org.andengine.engine.camera.BoundCamera;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.modifier.IModifier;

import Game.GameActivity;
import Game.SoundsManager;
import Game.SoundsManager.Musics;
import Game.SoundsManager.Sounds;
import Sprite.DynamicSprite;
import Sprite.MySprite;
import Sprite.SpriteManager;

public class Player extends DynamicSprite {
	private enum Animation {
		NONE, JUMP, SIT, LEFT, RIGHT
	}

	private enum Direction {
		FORWARD, BACKWARD
	}

	private enum PlayerState {
		Small, Large,
	}

	public static int LiveRemain;
	public static int Score;

	private Direction mCurDir;
	private Direction mOldDir;
	private Animation mCurAni;
	private Animation mOldAni;
	private float mSpeedJump;
	private GameActivity mGame;
	private BoundCamera mCamera;
	private PlayerState mState = PlayerState.Small;
	private boolean mIsHasStar = false;
	private boolean mIsHasGun = false;
	private float timerStar = 0;
	private float delayStar = 20;
	private boolean mIsDeathless = false;

	public Player(float pX, float pY, float pWidth, float pHeight,
			ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pWidth, pHeight, pTiledTextureRegion,
				pVertexBufferObjectManager);

		mGravity = 0.32f;
		mSpeedMove = 4f;
		mSpeedJump = 10f;
		mCurDir = Direction.FORWARD;
		onGround = false;
		mWidth = 26;
	}

	private float timerFrame = 0;
	private float timeDelayFrame = 0.2f;
	private boolean flag;

	@Override
	protected void onManagedUpdate(float pSecondsElapsed) {
		if (mIsHasStar) {
			timerStar += pSecondsElapsed;
			timerFrame += pSecondsElapsed;
			if (timerFrame > timeDelayFrame) {
				timerFrame = 0;
				if (flag) {
					setRed(0.3f);
					flag = false;
				} else {
					setRed(1f);
					flag = true;
				}
			}
			if (timerStar > delayStar) {
				timerStar = 0;
				//starTimeOut();
			}
		}
		super.onManagedUpdate(pSecondsElapsed);
	}

	public void setCamera(BoundCamera camera) {
		mCamera = camera;
	}

	public void setGame(GameActivity game) {
		mGame = game;
	}

	@Override
	protected void move() {
		
	}

	private void fire() {
	
	}

	@Override
	public void updateAnimation() {
		if (!onGround) {
			mCurAni = Animation.JUMP;
		}

		if (mCurAni != mOldAni || mCurDir != mOldDir) {
			switch (mCurAni) {
			case NONE:
				if (mCurDir == Direction.FORWARD) {
					stopAnimation(0);
				} else {
					stopAnimation(11);
				}
				break;
			case LEFT:
				animate(new long[] { 100, 100 }, 9, 10, true);
				break;
			case RIGHT:
				animate(new long[] { 100, 100 }, 1, 2, true);
				break;
			case JUMP:
				if (mCurDir == Direction.FORWARD) {
					stopAnimation(3);
				} else {
					stopAnimation(8);
				}
				break;
			case SIT:
				if (mCurDir == Direction.FORWARD) {
					stopAnimation(4);
				} else {
					stopAnimation(7);
				}
				break;
			}

			mOldAni = mCurAni;
			mOldDir = mCurDir;
		}
	}

	@Override
	public void updatePosition() {
		float posX = mX + mVelocityX;
		if (posX < mCamera.getBoundsXMin()) {
			posX = mX;
		}
		setPosition(posX, mY + mVelocityY);
		checkWin();

		// reposCamera
		float Xmin = mX - mCamera.getXMin();
		
	}

	private void checkWin() {
		
	}

	@Override
	public void onTopCollision(MySprite collider) {
		if (mIsHasStar) {
			onCollisionWhenHasStar(collider);
		}
	}

	@Override
	public void onBottomCollision(MySprite collider) {
		
	}

	@Override
	public void onLeftCollision(MySprite collider) {
		if (mIsHasStar) {
			onCollisionWhenHasStar(collider);
		}
	}

	@Override
	public void onRightCollision(MySprite collider) {
		if (mIsHasStar) {
			onCollisionWhenHasStar(collider);
		}
	}

	private void onCollisionWhenHasStar(MySprite collider) {
		
	}

	public void jump(float high) {
		mVelocityY = -high;
	}

	@Override
	public MySprite clone() {
		return new Player(0, 0, mWidth, mHeight, getTiledTextureRegion(),
				getVertexBufferObjectManager());
	}

	@Override
	public String className() {
		return "Player";
	}

	public boolean isSmall() {
		return mState == PlayerState.Small;
	}





}
