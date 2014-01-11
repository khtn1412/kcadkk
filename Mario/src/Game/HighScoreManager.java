package Game;
import java.util.ArrayList;


import android.content.Context;
import android.database.Cursor;

public class HighScoreManager 
{	
	private Context mContent;
	private DbAdapter mDbAdapter;
	
	public HighScoreManager(Context content)
	{
		mContent = content;		
		mDbAdapter = new DbAdapter(mContent);
	}
	
	public ArrayList<HighScore> getTopHighScore(int number)
	{
		ArrayList<HighScore> ListTop = new ArrayList<HighScore>();
		
		try 
		{
			mDbAdapter.open();
			Cursor cursor = mDbAdapter.getTopHighScore(number);
			
			int NameCol = cursor.getColumnIndex("name");
			int ScoreCol = cursor.getColumnIndex("score");		
			while(cursor.moveToNext())
			{
				HighScore score = new HighScore();
				score.Name = cursor.getString(NameCol);
				score.Score = cursor.getInt(ScoreCol);
				ListTop.add(score);
			}
			cursor.close();
			mDbAdapter.close();
			
		} 
		catch (Exception e) 
		{
			
		}
		
		return ListTop;
	}
	
	public void addHighScore(HighScore score)
	{
		try 
		{
			mDbAdapter.open();			
			mDbAdapter.insertHighScore(score);			
			mDbAdapter.close();
		} 
		catch (Exception e)
		{			
		}
	}
}
