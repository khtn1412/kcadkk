package Sprite;

import java.util.ArrayList;

import org.andengine.engine.Engine.EngineLock;
import org.andengine.engine.camera.BoundCamera;
import org.andengine.entity.scene.Scene;

import EffectSprite.Effect;
import Game.GameActivity;
import Game.LevelManager;
import Player.Player;

public class SpriteManager {
	private static GameActivity mGame;
	private static LevelManager mLevelManager;
	private static Player mPlayer;
	private static BoundCamera mCamera;
	private static Scene mScene;
	private static Effect mEffect;
	private static ArrayList<MySprite> mObjects;
	private static ArrayList<Integer> mPositionsLevel;

	
	public static Player getPlayer() {
		return mPlayer;
	}

	public static int getIndexPlayerInListObjects() {
		int index = -1;
		int n = mObjects.size();
		for (int i = 0; i < n; i++) {
			if (mObjects.get(i).className().equalsIgnoreCase("Player")) {
				index = i;
				break;
			}
		}

		return index;
	}

	public static void checkCollisionFor(MySprite sprite) {
		int n = mObjects.size();
		for (int i = 0; i < n; i++) {
			MySprite other = mObjects.get(i);
			if (!other.isAdded() || !other.isAlive() || other.equals(sprite)) {
				continue;
			}
			if (sprite.collidesWith(other)) {
				if (sprite.getOldY() + sprite.getHeight() < other.getOldY()) {
					sprite.onBottomCollision(other);
					if (other.getTypeSprite() == MySprite.STATIC_SPRITE) {
						other.onTopCollision(sprite);
					}
				} else if (sprite.getOldY() > other.getOldY()
						+ other.getHeight()) {
					sprite.onTopCollision(other);
					if (other.getTypeSprite() == MySprite.STATIC_SPRITE) {
						other.onBottomCollision(sprite);
					}
				} else if (sprite.getOldX() > other.getOldX()
						+ other.getWidth()) {
					sprite.onLeftCollision(other);
					if (other.getTypeSprite() == MySprite.STATIC_SPRITE) {
						other.onLeftCollision(sprite);
					}
				} else if (sprite.getOldX() + sprite.getWidth() < other
						.getOldX()) {
					sprite.onRightCollision(other);
					if (other.getTypeSprite() == MySprite.STATIC_SPRITE) {
						other.onRightCollision(sprite);
					}
				}
			}
		}
	}

	public static void update() {
		
	}

	

	public static int getPositionCurrentLevel() {
		int pos = 0;
		for (int i = 0; i < mPositionsLevel.size(); i++) {
			if (mPlayer.getX() > mPositionsLevel.get(i)) {
				pos = mPositionsLevel.get(i);
			}
		}

		return pos;
	}

	
	public static void shutdown() {
		mEffect = null;
		if (mObjects != null) {
			mObjects.clear();
			mObjects = null;
		}
		if (mPositionsLevel != null) {
			mPositionsLevel.clear();
			mPositionsLevel = null;
		}
	}
}
