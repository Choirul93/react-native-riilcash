
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.reactlibrary.RiilcashDbHelper;
import com.reactlibrary.Riilcash;
import org.json.JSONObject;
import java.util.List;
import android.widget.Toast;
import android.database.sqlite.SQLiteException;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;
import org.json.JSONException;
import org.json.JSONObject;


public class RNRiilcashOfflineModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNRiilcashOfflineModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNRiilcashOffline";
  }

  @ReactMethod
  public void insert(Double amount, String currency, String dest_account_id, Double method, String unique_code, String source_account_pub, Promise promise){
    try {
      Riilcash riilcash = new Riilcash(amount,currency,dest_account_id, method, unique_code, source_account_pub);
      long id = riilcash.insert(this.reactContext.getApplicationContext());
      WritableMap map = Arguments.createMap();
      map.putInt("data",Integer.valueOf(String.valueOf(id)));
      promise.resolve(map);
    } catch (SQLiteException e) {
      promise.reject("error",e);
    }

  }

  @ReactMethod
  public void delete(int id,Promise promise){
    try {
      Riilcash riilcash = new Riilcash();
      int deleteId = riilcash.delete(this.reactContext.getApplicationContext(),id);
      WritableMap map = Arguments.createMap();
      map.putInt("data",deleteId);
      promise.resolve(map);
    } catch (SQLiteException e) {
      promise.reject("error",e);
    }

  }

  @ReactMethod
  public void getAll(Promise promise)throws JSONException {
    try {
      Riilcash riilcash = new Riilcash();
      String list = riilcash.getAll(this.reactContext.getApplicationContext());
      WritableMap map = Arguments.createMap();
      map.putString("data",list);
      promise.resolve(map);
    } catch (SQLiteException e) {
      promise.reject("error",e);
    }

  }



}