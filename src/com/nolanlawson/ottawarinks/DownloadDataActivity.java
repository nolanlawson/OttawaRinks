package com.nolanlawson.ottawarinks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import com.nolanlawson.ottawarinks.data.EventResponsePage;
import com.nolanlawson.ottawarinks.helper.HttpHelper;
import com.nolanlawson.ottawarinks.helper.XmlHelper;
import com.nolanlawson.ottawarinks.util.UtilLogger;

public class DownloadDataActivity extends Activity {

	private static UtilLogger log = new UtilLogger(DownloadDataActivity.class);
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Waiting");
        dialog.setMessage("Patience...");
        dialog.show();
        
        new AsyncTask<Void, Void, EventResponsePage>() {
			
			@Override
			protected EventResponsePage doInBackground(Void... params) {
				String xml = HttpHelper.fetchPageOfData(DownloadDataActivity.this, 0);
				return XmlHelper.parseEventResponsePage(xml);
			}

			@Override
			protected void onPostExecute(EventResponsePage result) {
				super.onPostExecute(result);
				log.i(result.toString());
				dialog.dismiss();
			}
			
		}.execute((Void)null);
    }
}