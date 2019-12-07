package ti.radiorecorder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiFileProxy;

import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

public class RecorderNotification {
	private static final String NOTIFICATION_SERVICE = "608677";
	private Context ctx;

	public RecorderNotification(KrollDict opts) {
		String title = opts.getString("title");
		String subtitle = opts.getString("subtitle");
		Object obj = opts.get("icon");
		if (obj instanceof String) {
			try {
				URL dummy = new URL((String) obj);
				String url = (String) obj;
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else if (obj instanceof TiFileProxy) {
			File file = new File(Uri.parse(((TiFileProxy) obj).getNativePath())
					.getPath());

		}
		ctx = TiApplication.getInstance().getApplicationContext();
		NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx)//
				.setContentTitle(title)//
				.setContentText(subtitle);
		((NotificationManager) ctx.getSystemService(NOTIFICATION_SERVICE))
				.notify(123, builder.build());

	}
}
