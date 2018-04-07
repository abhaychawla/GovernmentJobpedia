package com.example.android.governmentjobpedia;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {
    String ministryName;
    String organisation;
    String aboutJob;
    String position;
    String applyBy;
    String location;
    String eligibility;

    public Model(String ministryName, String organisation, String aboutJob, String position, String applyBy, String location, String eligibility) {
        this.ministryName = ministryName;
        this.organisation = organisation;
        this.aboutJob = aboutJob;
        this.position = position;
        this.applyBy = applyBy;
        this.location = location;
        this.eligibility = eligibility;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(ministryName);
        parcel.writeString(organisation);
        parcel.writeString(aboutJob);
        parcel.writeString(position);
        parcel.writeString(applyBy);
        parcel.writeString(location);
        parcel.writeString(eligibility);
    }

    protected Model(Parcel in) {
        ministryName = in.readString();
        organisation = in.readString();
        aboutJob = in.readString();
        position = in.readString();
        applyBy = in.readString();
        location = in.readString();
        eligibility = in.readString();
    }

    public String getMinistryName() {
        return ministryName;
    }

    public void setMinistryName(String ministryName) {
        this.ministryName = ministryName;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getAboutJob() {
        return aboutJob;
    }

    public void setAboutJob(String aboutJob) {
        this.aboutJob = aboutJob;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getApplyBy() {
        return applyBy;
    }

    public void setApplyBy(String applyBy) {
        this.applyBy = applyBy;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }


    public static final Parcelable.Creator<Model> CREATOR = new Parcelable.Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[0];
        }
    };
}
