package com.example.examen
import android.os.Parcel
import android.os.Parcelable

data class Agenda(val nombre: String, val noControl: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(noControl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Agenda> {
        override fun createFromParcel(parcel: Parcel): Agenda {
            return Agenda(parcel)
        }

        override fun newArray(size: Int): Array<Agenda?> {
            return arrayOfNulls(size)
        }
    }
}
