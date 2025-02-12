package tr.com.nuritiras.parcelableuygulama

import android.os.Parcel
import android.os.Parcelable

data class Bilgiler(val adiSoyadi: String?, val telefonNo: String?, val eMail: String?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(adiSoyadi)
        parcel.writeString(telefonNo)
        parcel.writeString(eMail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Bilgiler> {
        override fun createFromParcel(parcel: Parcel): Bilgiler {
            return Bilgiler(parcel)
        }

        override fun newArray(size: Int): Array<Bilgiler?> {
            return arrayOfNulls(size)
        }
    }
}
