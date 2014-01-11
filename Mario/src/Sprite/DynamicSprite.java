package Sprite;

import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import Game.TileMap;

public class DynamicSprite extends MySprite {
	protected float mVelocityX;
	protected float mVelocityY;
	protected float mSpeedMove;
	protected float mGravity;
	protected float mHighJump;
	protected boolean onGround;
	protected boolean mForward;
	protected float mOldX;
	protected float mOldY;

	public DynamicSprite(float pX, float pY, float pWidth, float pHeight,
			ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pWidth, pHeight, pTiledTextureRegion,
				pVertexBufferObjectManager);
		mVelocityX = 0f;
		mVelocityY = 0f;
	}

	@Override
	protected void onManagedUpdate(float pSecondsElapsed) {
		if (mEnable) {
			move();
			testCollisionWithMap();
			if (mVelocityY != 0) {
				onGround = false;
			}
			mOldX = mX;
			mOldY = mY;
			updatePosition();
			if (mAlive) {
				updateAnimation();
				SpriteManager.checkCollisionFor(this);
			}
			mVelocityX = 0;
			super.onManagedUpdate(pSecondsElapsed);
		}
	}

	protected void move() {
		mVelocityX = (mForward) ? mSpeedMove : -mSpeedMove;
		mVelocityY += mGravity;
	}

	protected void testCollisionWithMap() {

	}

	protected void updateAnimation() {
	};

	protected void updatePosition() {
		setPosition(mX + mVelocityX, mY + mVelocityY);
	};

	protected void handlerHorizontalCollisionWithMap() {
		mForward = !mForward;
	}

	protected void handlerVerticalCollisionWithMap() {
	};

	public void setVelocityX(float x) {
		mVelocityX = x;
	}

	public void setVelocityY(float y) {
		mVelocityY = y;
	}

	public void setVelocity(float x, float y) {
		mVelocityX = x;
		mVelocityY = y;
	}

	@Override
	public int getTypeSprite() {
		return DYNAMIC_SPRITE;
	}

	@Override
	public float getOldX() {
		return mOldX;
	}

	@Override
	public float getOldY() {
		return mOldY;
	}

	public void setDirection(boolean isForward) {
		mForward = isForward;
	}

	protected void killByFall() {
		setVisible(false);
		mEnable = false;
		mAlive = false;
		setIgnoreUpdate(true);
	}
}
