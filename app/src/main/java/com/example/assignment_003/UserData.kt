package com.example.assignment_003

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserData(var name: String = "", var lastName: String = "", var email: String = "") :Parcelable
