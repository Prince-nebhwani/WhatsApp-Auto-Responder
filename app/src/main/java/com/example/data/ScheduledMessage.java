package com.example.data;

import com.example.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Entities.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006\""}, d2 = {"Lcom/example/data/ScheduledMessage;", "", "id", "", "recipient", "", "messageText", "scheduledTime", "", "isSent", "", "type", "<init>", "(ILjava/lang/String;Ljava/lang/String;JZLjava/lang/String;)V", "getId", "()I", "getRecipient", "()Ljava/lang/String;", "getMessageText", "getScheduledTime", "()J", "()Z", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ScheduledMessage {
    public static final int $stable = 0;
    private final int id;
    private final boolean isSent;
    private final String messageText;
    private final String recipient;
    private final long scheduledTime;
    private final String type;

    public static /* synthetic */ ScheduledMessage copy$default(ScheduledMessage scheduledMessage, int i, String str, String str2, long j, boolean z, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = scheduledMessage.id;
        }
        if ((i2 & 2) != 0) {
            str = scheduledMessage.recipient;
        }
        if ((i2 & 4) != 0) {
            str2 = scheduledMessage.messageText;
        }
        if ((i2 & 8) != 0) {
            j = scheduledMessage.scheduledTime;
        }
        if ((i2 & 16) != 0) {
            z = scheduledMessage.isSent;
        }
        if ((i2 & 32) != 0) {
            str3 = scheduledMessage.type;
        }
        long j2 = j;
        String str4 = str2;
        return scheduledMessage.copy(i, str, str4, j2, z, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRecipient() {
        return this.recipient;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessageText() {
        return this.messageText;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getScheduledTime() {
        return this.scheduledTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsSent() {
        return this.isSent;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final ScheduledMessage copy(int id, String recipient, String messageText, long scheduledTime, boolean isSent, String type) {
        Intrinsics.checkNotNullParameter(recipient, "recipient");
        Intrinsics.checkNotNullParameter(messageText, "messageText");
        Intrinsics.checkNotNullParameter(type, "type");
        return new ScheduledMessage(id, recipient, messageText, scheduledTime, isSent, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScheduledMessage)) {
            return false;
        }
        ScheduledMessage scheduledMessage = (ScheduledMessage) other;
        return this.id == scheduledMessage.id && Intrinsics.areEqual(this.recipient, scheduledMessage.recipient) && Intrinsics.areEqual(this.messageText, scheduledMessage.messageText) && this.scheduledTime == scheduledMessage.scheduledTime && this.isSent == scheduledMessage.isSent && Intrinsics.areEqual(this.type, scheduledMessage.type);
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.id) * 31) + this.recipient.hashCode()) * 31) + this.messageText.hashCode()) * 31) + Long.hashCode(this.scheduledTime)) * 31) + Boolean.hashCode(this.isSent)) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "ScheduledMessage(id=" + this.id + ", recipient=" + this.recipient + ", messageText=" + this.messageText + ", scheduledTime=" + this.scheduledTime + ", isSent=" + this.isSent + ", type=" + this.type + ")";
    }

    public ScheduledMessage(int id, String recipient, String messageText, long scheduledTime, boolean isSent, String type) {
        Intrinsics.checkNotNullParameter(recipient, "recipient");
        Intrinsics.checkNotNullParameter(messageText, "messageText");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.recipient = recipient;
        this.messageText = messageText;
        this.scheduledTime = scheduledTime;
        this.isSent = isSent;
        this.type = type;
    }

    public /* synthetic */ ScheduledMessage(int i, String str, String str2, long j, boolean z, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, str, str2, j, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? "ON_NOTIFICATION" : str3);
    }

    public final int getId() {
        return this.id;
    }

    public final String getRecipient() {
        return this.recipient;
    }

    public final String getMessageText() {
        return this.messageText;
    }

    public final long getScheduledTime() {
        return this.scheduledTime;
    }

    public final boolean isSent() {
        return this.isSent;
    }

    public final String getType() {
        return this.type;
    }
}
