package com.example.data;

import com.example.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Entities.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/example/data/PersonalityTone;", "", "id", "", "name", "", "description", "promptInstructions", "isDefault", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getDescription", "getPromptInstructions", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PersonalityTone {
    public static final int $stable = 0;
    private final String description;
    private final int id;
    private final boolean isDefault;
    private final String name;
    private final String promptInstructions;

    public static /* synthetic */ PersonalityTone copy$default(PersonalityTone personalityTone, int i, String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = personalityTone.id;
        }
        if ((i2 & 2) != 0) {
            str = personalityTone.name;
        }
        if ((i2 & 4) != 0) {
            str2 = personalityTone.description;
        }
        if ((i2 & 8) != 0) {
            str3 = personalityTone.promptInstructions;
        }
        if ((i2 & 16) != 0) {
            z = personalityTone.isDefault;
        }
        boolean z2 = z;
        String str4 = str2;
        return personalityTone.copy(i, str, str4, str3, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPromptInstructions() {
        return this.promptInstructions;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    public final PersonalityTone copy(int id, String name, String description, String promptInstructions, boolean isDefault) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(promptInstructions, "promptInstructions");
        return new PersonalityTone(id, name, description, promptInstructions, isDefault);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersonalityTone)) {
            return false;
        }
        PersonalityTone personalityTone = (PersonalityTone) other;
        return this.id == personalityTone.id && Intrinsics.areEqual(this.name, personalityTone.name) && Intrinsics.areEqual(this.description, personalityTone.description) && Intrinsics.areEqual(this.promptInstructions, personalityTone.promptInstructions) && this.isDefault == personalityTone.isDefault;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.promptInstructions.hashCode()) * 31) + Boolean.hashCode(this.isDefault);
    }

    public String toString() {
        return "PersonalityTone(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", promptInstructions=" + this.promptInstructions + ", isDefault=" + this.isDefault + ")";
    }

    public PersonalityTone(int id, String name, String description, String promptInstructions, boolean isDefault) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(promptInstructions, "promptInstructions");
        this.id = id;
        this.name = name;
        this.description = description;
        this.promptInstructions = promptInstructions;
        this.isDefault = isDefault;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PersonalityTone(int i, String str, String str2, String str3, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z2;
        i = (i2 & 1) != 0 ? 0 : i;
        if ((i2 & 16) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        this(i, str, str2, str3, z2);
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getPromptInstructions() {
        return this.promptInstructions;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }
}
