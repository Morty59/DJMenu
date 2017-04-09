package yaism.djmenu.utils.preferences;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * Created by a105225 on 24/03/2017.
 */

public class PreferencesUtils {

    private static final String UTF8 = "utf-8";
    private SecureRandom random = new SecureRandom();
    private static char[] SEKRIT;
    private static String SALT_KEY;

    public static final String PREF_PREFIX = "fr.gouv.agriculture.telepac.utils.PreferencesUtils" ;
    private static final String PREF_FILE_NAME = PREF_PREFIX + "TELEPAC_PREFS";

    private final Context applicationContext;
    private final SharedPreferences sharedPreferences;

    public PreferencesUtils(Context applicationContext) {
        this.applicationContext = applicationContext;
        this.sharedPreferences = applicationContext.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SEKRIT = new BigInteger(130, random).toString(32).toCharArray();
        SALT_KEY = new BigInteger(130, random).toString(32);
    }

    public void putBoolean(SharedPreferencesKeys key, Boolean value) {
        sharedPreferences.edit().putBoolean(key.getKey(), value).apply();
    }

    public void putBoolean(String key, Boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public void putString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public void putString(SharedPreferencesKeys key, String value) {
        sharedPreferences.edit().putString(key.getKey(), value).apply();
    }

    public void putEncryptedString(String key, String value) {
        String encryptedValue = encrypt(value, applicationContext);
        putString(key, encryptedValue);
    }

    public void putEncryptedString(SharedPreferencesKeys key, String value) {
        String encryptedValue = encrypt(value, applicationContext);
        putString(key, encryptedValue);
    }

    public void putLong(String key, Long value) {
        sharedPreferences.edit().putLong(key, value).apply();
    }

    public void putLong(SharedPreferencesKeys key, Long value) {
        sharedPreferences.edit().putLong(key.getKey(), value).apply();
    }

    public void putDouble(SharedPreferencesKeys key, Double value) {
        Long longValue = Double.doubleToLongBits(value);
        putLong(key, longValue);
    }

    public Double getDouble(SharedPreferencesKeys key, Double defaultValue){
        Long longDefaultValue = Double.doubleToLongBits(defaultValue);
        Long longValue = getLong(key, longDefaultValue);
        return Double.longBitsToDouble(longValue);
    }

    public void putInt(String key, Integer value) {
        sharedPreferences.edit().putInt(key, value).apply();
    }

    public void putInt(SharedPreferencesKeys key, Integer value) {
        sharedPreferences.edit().putInt(key.getKey(), value).apply();
    }

    public String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);

    }

    public String getString(SharedPreferencesKeys key, String defaultValue) {
        return sharedPreferences.getString(key.getKey(), defaultValue);

    }

    public Boolean getBoolean(String key, Boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public Boolean getBoolean(SharedPreferencesKeys key, Boolean defaultValue) {
        return sharedPreferences.getBoolean(key.getKey(), defaultValue);
    }

    public Set<String> getStringSet(String key, Set<String> defaultValue) {
        return sharedPreferences.getStringSet(key, defaultValue);
    }

    public String getEncryptedString(String key, String defaultValue) {
        String cryptedValue = getString(key, defaultValue);
        if(cryptedValue.equals(defaultValue)) {
            return defaultValue;
        }
        return decrypt(cryptedValue, applicationContext);
    }

    public String getEncryptedString(SharedPreferencesKeys key, String defaultValue) {

        String cryptedValue = getString(key, defaultValue);
        if(cryptedValue.equals(defaultValue)) {
            return defaultValue;
        }
        return decrypt(cryptedValue, applicationContext);
    }

    public Long getLong(String key, Long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    public Long getLong(SharedPreferencesKeys key, Long defaultValue) {
        return sharedPreferences.getLong(key.getKey(), defaultValue);
    }

    /**
     * Get share pref integer value with key
     * @param key
     * @param defaultValue
     * @return
     */
    public Integer getInt(String key, Integer defaultValue) {
        if(defaultValue == null){
            Log.w("getInt", "defaultValue null");
            defaultValue = -1;
        }
        return sharedPreferences.getInt(key, defaultValue);
    }

    /**
     * Get share pref integer value
     * @param key
     * @param defaultValue
     * @return
     */
    public Integer getInt(SharedPreferencesKeys key, Integer defaultValue) {
        if(defaultValue == null){
            Log.w("getInt", "defaultValue null");
            defaultValue = -1;
        }
        return sharedPreferences.getInt(key.getKey(), defaultValue);
    }

    /**
     * Clear share pref
     */
    public void clear() {
        sharedPreferences.edit().clear().apply();
    }

    /**
     * remove share pref with key
     * @param key
     */
    public void remove(String key) {
        sharedPreferences.edit().remove(key).apply();
    }

    /**
     * Remove share pref
     * @param key
     */
    public void remove(SharedPreferencesKeys key) {
        sharedPreferences.edit().remove(key.getKey()).apply();
    }

    /**
     * True if contains key
     * @param key
     * @return
     */
    public boolean contains(String key) {
        return sharedPreferences.contains(key);
    }

    /**
     * True if contains SharedPreferencesKeys
     * @param key
     * @return
     */
    public boolean contains(SharedPreferencesKeys key) {
        return sharedPreferences.contains(key.getKey());
    }

    /**
     * Encrypt message
     * @param message
     * @param context
     * @return
     */
    private static String encrypt(String message, Context context){

        try {
            final byte[] bytes = message != null ? message.getBytes(UTF8) : new byte[0];
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(SEKRIT));
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");

            ContentResolver resolver = context.getContentResolver();
            String mystring = Settings.Secure.getString(resolver, Settings.Secure.ANDROID_ID);
            if (mystring == null) {
                mystring = SALT_KEY;
            }
            PBEParameterSpec pbeps = new PBEParameterSpec(mystring.getBytes(UTF8), 20);
            pbeCipher.init(Cipher.ENCRYPT_MODE, key, pbeps);

            return new String(Base64.encode(pbeCipher.doFinal(bytes), Base64.NO_WRAP), UTF8);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Decrypt message
     * @param message
     * @param context
     * @return
     */
    private static String decrypt(String message, Context context){
        try {
            final byte[] bytes = message != null ? Base64.decode(message, Base64.DEFAULT) : new byte[0];
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(SEKRIT));
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");

            ContentResolver resolver = context.getContentResolver();
            String mystring = Settings.Secure.getString(resolver, Settings.Secure.ANDROID_ID);
            if (mystring == null) {
                mystring = SALT_KEY;
            }
            PBEParameterSpec pbeps = new PBEParameterSpec(mystring.getBytes(UTF8), 20);
            pbeCipher.init(Cipher.DECRYPT_MODE, key, pbeps);
            return new String(pbeCipher.doFinal(bytes), UTF8);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
