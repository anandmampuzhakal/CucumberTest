package modularization.libraries.actions

import android.content.Context
import android.content.Intent

object Actions {

    fun openOnBoardIntent(context: Context): Intent = internalIntent(context, "com.nz.anand.modularization.onboarding.open")
    fun openDashBoardIntent(context: Context, userId: String): Intent =
        internalIntent(context, "com.nz.anand.modularization.dashboard.open")
            .putExtra(EXTRA_USER, UserArgs(userId))

    fun openSharingIntent(context: Context): Intent = internalIntent(context,"com.nz.anand.modularization.sharing.open")

    private fun internalIntent(context: Context, action: String) = Intent(action).setPackage(context.packageName)
}