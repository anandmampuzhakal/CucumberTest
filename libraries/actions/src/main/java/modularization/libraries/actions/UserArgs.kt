package modularization.libraries.actions

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

const val EXTRA_USER = "com.nz.anand.modularization.dashboard.extra.user"

@Parcelize
data class UserArgs(val userId: String) : Parcelable