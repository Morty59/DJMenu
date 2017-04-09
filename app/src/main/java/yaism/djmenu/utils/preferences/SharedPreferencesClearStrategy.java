package yaism.djmenu.utils.preferences;

/**
 * Created by a105225 on 24/03/2017.
 */

public enum SharedPreferencesClearStrategy {
    /**
     * Shared preference is removed when user is logged in
     */
    DELETE_ON_LOGIN,
    /**
     * Shared preference is removed when user has changed
     */
    DELETE_ON_NEW_USER_LOGIN,
    /**
     * Shared preference is always kept
     */
    KEEP_ALWAYS,
    /**
     * Shared preference is delete when user is logged out
     */
    DELETE_ON_LOGOUT
}
