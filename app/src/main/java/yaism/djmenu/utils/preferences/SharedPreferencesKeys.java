package yaism.djmenu.utils.preferences;

/**
 * Created by a105225 on 24/03/2017.
 */

public enum SharedPreferencesKeys {
    /** Prefs to destroy at user logout **/
    IsUserLoggedIn(PreferencesUtils.PREF_PREFIX + "IS_USER_LOGGED_IN",
                   SharedPreferencesClearStrategy.DELETE_ON_LOGOUT),

    UserPassword(PreferencesUtils.PREF_PREFIX + "USER_PASSWORD",
                 SharedPreferencesClearStrategy.DELETE_ON_LOGOUT),

    IsAccountActivated(PreferencesUtils.PREF_PREFIX + "IS_ACCOUNT_ACTIVATED",
                       SharedPreferencesClearStrategy.DELETE_ON_LOGOUT),

    UserCivilityName(PreferencesUtils.PREF_PREFIX + "USER_CIVILITY_NAME",
                     SharedPreferencesClearStrategy.DELETE_ON_LOGOUT),

    /** Prefs to destroy at user login **/
    UserLogin(PreferencesUtils.PREF_PREFIX + "USER_LOGIN",
              SharedPreferencesClearStrategy.DELETE_ON_LOGIN),

    PreviousUserLogin(PreferencesUtils.PREF_PREFIX + "PREVIOUS_USER_LOGIN",
                      SharedPreferencesClearStrategy.DELETE_ON_LOGIN),

    LogoutRequiresSynchronization(PreferencesUtils.PREF_PREFIX + "LOGOUT_REQUIRES_SYNCHRONIZATION",
                                  SharedPreferencesClearStrategy.DELETE_ON_LOGIN),

    /** Prefs to destroy at user login with a different ID **/

    NotifEnabled(PreferencesUtils.PREF_PREFIX + "NOTIF_ENABLED",
                 SharedPreferencesClearStrategy.DELETE_ON_NEW_USER_LOGIN),


    /** Prefs to always keep **/
    DeviceRegisteredAtGCM(PreferencesUtils.PREF_PREFIX + "DEVICE_REGISTERED_AT_GCM",
                          SharedPreferencesClearStrategy.KEEP_ALWAYS),

    DeviceGCMId(PreferencesUtils.PREF_PREFIX + "DEVICE_GCM_ID",
                SharedPreferencesClearStrategy.KEEP_ALWAYS),

    GCMRegisteredAppVersion(PreferencesUtils.PREF_PREFIX + "GCM_REGISTERED_APP_VERSION",
                            SharedPreferencesClearStrategy.KEEP_ALWAYS),

    CheckUpdate(PreferencesUtils.PREF_PREFIX + "CHECK_UPDATE",
                SharedPreferencesClearStrategy.KEEP_ALWAYS),

    /** DEBUG - Prefs to always keep **/
    Environment(PreferencesUtils.PREF_PREFIX + "DEBUG_ENVIRONMENT",
                     SharedPreferencesClearStrategy.KEEP_ALWAYS),

    DebugForceUpdate(PreferencesUtils.PREF_PREFIX + "DEBUG_FORCE_UPDATE",
                     SharedPreferencesClearStrategy.KEEP_ALWAYS);

    private String key;
    private SharedPreferencesClearStrategy clearStrategy;

    SharedPreferencesKeys(String key, SharedPreferencesClearStrategy clearStrategy) {
        this.key = key;
        this.clearStrategy = clearStrategy;
    }

    public String getKey(){
        return key;
    }

    @Override
    public String toString() {
        return this.name() + "{key=" + key + ", clearStrategy="
                + clearStrategy + "}";
    }

    public boolean isDeletedOnClear(SharedPreferencesClearAction action) {
        if (action == SharedPreferencesClearAction.LOGOUT){
            if(clearStrategy == SharedPreferencesClearStrategy.DELETE_ON_LOGOUT){
                return true;
            }
        }
        if (action == SharedPreferencesClearAction.LOGIN){
            if(clearStrategy == SharedPreferencesClearStrategy.DELETE_ON_LOGIN){
                return true;
            }
        }
        if (action == SharedPreferencesClearAction.LOGIN_WITH_ANOTHER_ID){
            if(clearStrategy == SharedPreferencesClearStrategy.DELETE_ON_NEW_USER_LOGIN){
                return true;
            }
        }
        return false;
    }
}
