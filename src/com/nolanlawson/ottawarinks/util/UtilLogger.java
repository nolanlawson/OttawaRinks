package com.nolanlawson.ottawarinks.util;

import java.util.Arrays;

import android.util.Log;

/**
 * Easier way to interact with logcat.
 * @author nolan
 */
public class UtilLogger {

	public static final boolean DEBUG_MODE = false;
	
	private String tag;
	
	public UtilLogger(String tag) {
		this.tag = tag;
	}
	
	public UtilLogger(Class<?> clazz) {
		this.tag = clazz.getSimpleName();
	}
	
	public void i(String format, Object... more) {
		if (more.length ==0) {
			Log.i(tag, format);
		} else {
			Log.i(tag, String.format(format, more));
		}
	}
	
	public void i(Exception e, String format, Object... more) {
		if (more.length ==0) {
			Log.i(tag, format, e);
		}
		Log.i(tag, String.format(format, more), e);
	}
	
	public void w(Exception e, String format, Object... more) {
		if (more.length ==0) {
			Log.w(tag, format, e);
		} else {
			Log.w(tag, String.format(format, more), e);
		}
	}
	
	public void w(String format, Object... more) {
		if (more.length ==0) {
			Log.i(tag, format);
		} else {
			Log.w(tag, String.format(format, more));
		}
	}	
	
	public void e(String format, Object... more) {
		if (more.length ==0) {
			Log.e(tag, format);
		} else {
			Log.e(tag, String.format(format, more));
		}
	}	
	
	public void e(Exception e, String format, Object... more) {
		if (more.length ==0) {
			Log.e(tag, format, e);
		} else {
			Log.e(tag, String.format(format, more), e);
		}
	}
	
	public void d(String format, Object... more) {	
		if (DEBUG_MODE) {
			for (int i = 0; i < more.length; i++) {
				if (more[i] instanceof int[]) {
					more[i] = Arrays.toString((int[])more[i]);
				}
			}
			if (more.length ==0) {
				Log.d(tag, format);
			} else {
				Log.d(tag, String.format(format, more));
			}
		}
	}	
	
	public void d(Exception e, String format, Object... more) {
		if (DEBUG_MODE) {
			for (int i = 0; i < more.length; i++) {
				if (more[i] instanceof int[]) {
					more[i] = Arrays.toString((int[])more[i]);
				}
			}
			if (more.length == 0) {
				Log.d(tag, format, e);
			} else {
				Log.d(tag, String.format(format, more), e);
			}
		}
	}	
}
