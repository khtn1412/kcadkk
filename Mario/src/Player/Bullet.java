package Player;

import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import Game.SoundsManager;
import Game.SoundsManager.Sounds;
import Sprite.DynamicSprite;
import Sprite.MySprite;

public class Bullet extends DynamicSprite {

	public Bullet(float pX, float pY, float pWidth, float pHeight,
			ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pWidth, pHeight, pTiledTextureRegion,
				pVertexBufferObjectManager);
		animate(new long[] { 100, 100, 100, 100 }, 0, 3, true);
		mGravity = 0.32f;
		mSpeedMove = 6f;
		mForward = true;
	}

	@Override
	protected void handlerVerticalCollisionWithMap() {
		mVelocityY = -3;
	}

	@Override
	protected void handlerHorizontalCollisionWithMap() {
		destroy();
	}

	public void destroy() {
		SoundsManager.playSound(Sounds.Bumping);
		setVisible(false);
		mAlive = false;
		mEnable = false;
		setIgnoreUpdate(true);
	}

	@Override
	public MySprite clone() {
		return new Bullet(0, 0, mWidth, mHeight, getTiledTextureRegion(),
				getVertexBufferObjectManager());
	}

	@Override
	public String className() {
		return "Bullet";
	}

}
