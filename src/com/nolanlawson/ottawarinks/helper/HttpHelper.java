package com.nolanlawson.ottawarinks.helper;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;

import com.nolanlawson.ottawarinks.R.string;
import com.nolanlawson.ottawarinks.util.UtilLogger;

public class HttpHelper {

	private static UtilLogger log = new UtilLogger(HttpHelper.class);

	private static final String OTTAWA_RINKS_URL = "http://ottawa.ca/cgi-bin/schedulesearch/"
			+ "searchschedule.pl?"
			+ "stylesheet=http%3A%2F%2Fottawa.ca%2Ftemplates%2Fxslt%2Fpublic_skating_results_en.xsl;"
			+ "sq_event=Skating;"
			+ "sq_lang=en;"
			+ "sort=location%20asc%2CdayNo%20asc%2Cstart_date%20asc%2Cstart_time%20asc%2Csession_type%20asc;"
			+ "notfound_stylesheet=http%3A%2F%2Fottawa.ca%2Ftemplates%2Fxslt%2Fresults_notfound_skating_en.xsl;"
			+ "sq_location=;"
			+ "sq_session_type=;"
			+ "sq_keywords1=;"
			+ "start=%s";
	
	private static String fetchPageOfData(Context context, int start) {
		String url = String.format(OTTAWA_RINKS_URL, start + 1); // 1-based
		return postRequestAndGetResponse(context, url);
	}

	private static String postRequestAndGetResponse(Context context, String url) {

		HttpClient httpClient = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		ResponseHandler<String> handler = new BasicResponseHandler();
		String result = null;
		try {
			result = httpClient.execute(request, handler);
		} catch (ClientProtocolException e) {
			log.e(e, "");
		} catch (IOException e) {
			log.e(e, "");
		}
		httpClient.getConnectionManager().shutdown();
		log.i(result);
		return result;
	}

}
