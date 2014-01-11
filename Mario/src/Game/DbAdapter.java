package Game;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbAdapter {
	private Context mContext;
	private SQLiteDatabase mDb;
	private DbHelper mDbHelper;

	private static final String DATABASE_TABLE = "HigtScore";
	private static final String DATABASE_NAME = "DATABASE_HighScore";
	private static final int DATABASE_VERSION = 2;
	private static final String DATABASE_CREATE = "CREATE TABLE "
			+ DATABASE_TABLE
			+ "("
			+ "_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, score INTEGER)";

	public class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context, String name, CursorFactory fatory,
				int version) {
			super(context, name, fatory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
	}

	public DbAdapter(Context context) {
		this.mContext = context;
	}

	public DbAdapter open() {
		this.mDbHelper = new DbHelper(this.mContext, DATABASE_NAME, null,
				DATABASE_VERSION);
		this.mDb = mDbHelper.getWritableDatabase();

		return this;
	}

	public void close() {
		this.mDb.close();
	}

	public Cursor getTopHighScore(int number) {
		String mySQL = "SELECT name, score " + " FROM " + DATABASE_TABLE + " "
				+ " ORDER BY score DESC LIMIT ?";

		String[] args = { Integer.toString(number) };
		Cursor c = mDb.rawQuery(mySQL, args);

		return c;
	}

	public void insertHighScore(HighScore score) {
		ContentValues initialValues = new ContentValues();
		initialValues.put("name", score.Name);
		initialValues.put("score", score.Score);
		mDb.insert(DATABASE_TABLE, null, initialValues);
	}
}
