package com.ardev.heroapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProgrammingLanguage(
    val languageName: String,
    val description: String,
    val photo: Int
) : Parcelable
