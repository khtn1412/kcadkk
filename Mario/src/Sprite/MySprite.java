package Sprite;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class MySprite extends AnimatedSprite {
	public static final int STATIC_SPRITE = 0;
	public static final int DYNAMIC_SPRITE = 1;

	protected boolean mAlive;
	protected boolean mEnable;
	protected boolean mIsAdded = false;
	protected int mID;

	protected int mScore;

	public MySprite(float pX, float pY, float pWidth, float pHeight,
			ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pWidth, pHeight, pTiledTextureRegion,
				pVertexBufferObjectManager);
		mAlive = true;
		mEnable = true;
		mIsAdded = false;

	}

	public boolean isAlive() {
		return mAlive;
	}

	public boolean isAdded() {
		return mIsAdded;
	}

	public void setAdded() {
		mIsAdded = true;
	}

	public int getTypeSprite() {
		return STATIC_SPRITE;
	}

	public boolean isEnalbe() {
		return mEnable;
	}

	public void setEnable(boolean value) {
		mEnable = value;
	}

	public int getID() {
		return mID;
	}

	public void setID(int id) {
		mID = id;
	}

	public void onTopCollision(MySprite collider) {

	}

	public void onBottomCollision(MySprite collider) {

	}

	public void onLeftCollision(MySprite collider) {

	}

	public void onRightCollision(MySprite collider) {

	}

	public float getOldX() {
		return mX;
	}

	public float getOldY() {
		return mY;
	}

	public MySprite clone() {
		return null;
	}

	public String className() {
		return "MySprite";
	}

}
