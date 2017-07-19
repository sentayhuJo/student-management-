/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formPackages.classPackages;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JOptionPane;

public class BarcodeReader {

private static final long THRESHOLD = 100;
private static final int MIN_BARCODE_LENGTH = 8;

public interface BarcodeListener {

    void onBarcodeRead(String barcode);
}

private final StringBuffer barcode = new StringBuffer();
private final List<BarcodeListener> listeners = new CopyOnWriteArrayList<BarcodeListener>();
private long lastEventTimeStamp = 0L;

public BarcodeReader() {

    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() != KeyEvent.KEY_RELEASED) {
                return false;
            }

            if (e.getWhen() - lastEventTimeStamp > THRESHOLD) {
                barcode.delete(0, barcode.length());
            }

            lastEventTimeStamp = e.getWhen();

            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (barcode.length() >= MIN_BARCODE_LENGTH) {
                    fireBarcode(barcode.toString());
                    //JOptionPane.showMessageDialog(null,"code : " + barcode);
                    utility.refnu=barcode.toString();
                }
                barcode.delete(0, barcode.length());
            } else {
                barcode.append(e.getKeyChar());
            }
            return false;
        }
    });

}

protected void fireBarcode(String barcode) {
    for (BarcodeListener listener : listeners) {
        listener.onBarcodeRead(barcode);
    }
}

public void addBarcodeListener(BarcodeListener listener) {
    listeners.add(listener);
}

public void removeBarcodeListener(BarcodeListener listener) {
    listeners.remove(listener);
}
}
