package kevin.com.hcetest.services;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import kevin.com.hcetest.MainActivity;
import kevin.com.hcetest.R;

/**
 * Created by klam on 3/22/15.
 */
public class MyHostApduService extends HostApduService {

    @Override
    public byte[] processCommandApdu(byte[] commandApdu, Bundle extras) {
        StringBuilder command = new StringBuilder();

        for(byte b : commandApdu) {
            command.append(Integer.toHexString(b));
            command.append(" ");
        }

        Log.d("HCE Service", "Received APDU: " + command);
        return "Hello World!!! -Kevin".getBytes();
    }

    @Override
    public void onDeactivated(int reason) {
        Toast.makeText(getApplicationContext(), "NFC connection changed or broken.",
                Toast.LENGTH_LONG).show();

    }
}
