package io.github.turskyi.customspinner.presentation.model

import android.os.Parcel
import android.os.Parcelable

data class Language(
    val language: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(String::class.java.classLoader) as? String
    )

    companion object CREATOR : Parcelable.Creator<Language> {
        override fun createFromParcel(parcel: Parcel) =
            Language(parcel)
        override fun newArray(size: Int) = arrayOfNulls<Language?>(size)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) = parcel.writeValue(language)

    override fun describeContents() = 0
}