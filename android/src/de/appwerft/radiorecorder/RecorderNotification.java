package de.appwerft.radiorecorder;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.titanium.TiApplication;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

public class RecorderNotification {
	private static final String NOTIFICATION_SERVICE = "608677";
	private Context ctx;

	public RecorderNotification(KrollDict opts) {
		ctx = TiApplication.getInstance().getApplicationContext();
		NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx)//
				.setContentTitle(opts.getString("title"))//
				.setContentText(opts.getString("subtitle"));
		((NotificationManager) ctx.getSystemService(NOTIFICATION_SERVICE))
				.notify(123, builder.build());

	}

}
