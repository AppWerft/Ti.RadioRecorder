# Ti.AndroidRadioRecorder
This module for Appcelerator Titanium framework realizes a recorder for streaming radio stations. In most cases it will started by Ben Bahrenburgs AlarmManager.

Inside your JS based service you can start recording with:

```javascript
var RR = require("de.appwerft.radiorecorder");

var Record = RR.createRecording({
	url : "http://dradio_mp3_dkultur_m.akacast.akamaistream.net/7/530/142684/v1/gnl.akacast.akamaistream.net/dradio_mp3_dkultur_m",
	file : Ti.Filesystem.getFile(Ti.Filesystem.externalStorageDirectory,"mysuperhörspiel"),
	duration : 1800, // 30 min.
	bitrate : 128, //optional for better calculation of recording time
	notification : {
		title : "Radio play downloaded",
		subtitle : "Die Verwirrungen des Zöglings Törleß von Robert Musil"
	}
});
Record.start();
```
