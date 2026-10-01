package com.example.data;

import com.example.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Entities.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J]\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u0006("}, d2 = {"Lcom/example/data/WhatsAppMessage;", "", "id", "", "sender", "", "messageText", "timestamp", "", "isIncoming", "", "replyText", "status", "toneName", "<init>", "(ILjava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getSender", "()Ljava/lang/String;", "getMessageText", "getTimestamp", "()J", "()Z", "getReplyText", "getStatus", "getToneName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
public final /* data */ class WhatsAppMessage {
    public static final int $stable = 0;
    private final int id;
    private final boolean isIncoming;
    private final String messageText;
    private final String replyText;
    private final String sender;
    private final String status;
    private final long timestamp;
    private final String toneName;

    public static /* synthetic */ WhatsAppMessage copy$default(WhatsAppMessage whatsAppMessage, int i, String str, String str2, long j, boolean z, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = whatsAppMessage.id;
        }
        if ((i2 & 2) != 0) {
            str = whatsAppMessage.sender;
        }
        if ((i2 & 4) != 0) {
            str2 = whatsAppMessage.messageText;
        }
        if ((i2 & 8) != 0) {
            j = whatsAppMessage.timestamp;
        }
        if ((i2 & 16) != 0) {
            z = whatsAppMessage.isIncoming;
        }
        if ((i2 & 32) != 0) {
            str3 = whatsAppMessage.replyText;
        }
        if ((i2 & 64) != 0) {
            str4 = whatsAppMessage.status;
        }
        if ((i2 & 128) != 0) {
            str5 = whatsAppMessage.toneName;
        }
        long j2 = j;
        String str6 = str2;
        return whatsAppMessage.copy(i, str, str6, j2, z, str3, str4, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSender() {
        return this.sender;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMessageText() {
        return this.messageText;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsIncoming() {
        return this.isIncoming;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getReplyText() {
        return this.replyText;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getToneName() {
        return this.toneName;
    }

    public final WhatsAppMessage copy(int id, String sender, String messageText, long timestamp, boolean isIncoming, String replyText, String status, String toneName) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(messageText, "messageText");
        Intrinsics.checkNotNullParameter(status, "status");
        return new WhatsAppMessage(id, sender, messageText, timestamp, isIncoming, replyText, status, toneName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WhatsAppMessage)) {
            return false;
        }
        WhatsAppMessage whatsAppMessage = (WhatsAppMessage) other;
        return this.id == whatsAppMessage.id && Intrinsics.areEqual(this.sender, whatsAppMessage.sender) && Intrinsics.areEqual(this.messageText, whatsAppMessage.messageText) && this.timestamp == whatsAppMessage.timestamp && this.isIncoming == whatsAppMessage.isIncoming && Intrinsics.areEqual(this.replyText, whatsAppMessage.replyText) && Intrinsics.areEqual(this.status, whatsAppMessage.status) && Intrinsics.areEqual(this.toneName, whatsAppMessage.toneName);
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.id) * 31) + this.sender.hashCode()) * 31) + this.messageText.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + Boolean.hashCode(this.isIncoming)) * 31) + (this.replyText == null ? 0 : this.replyText.hashCode())) * 31) + this.status.hashCode()) * 31) + (this.toneName != null ? this.toneName.hashCode() : 0);
    }

    public String toString() {
        return "WhatsAppMessage(id=" + this.id + ", sender=" + this.sender + ", messageText=" + this.messageText + ", timestamp=" + this.timestamp + ", isIncoming=" + this.isIncoming + ", replyText=" + this.replyText + ", status=" + this.status + ", toneName=" + this.toneName + ")";
    }

    public WhatsAppMessage(int id, String sender, String messageText, long timestamp, boolean isIncoming, String replyText, String status, String toneName) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(messageText, "messageText");
        Intrinsics.checkNotNullParameter(status, "status");
        this.id = id;
        this.sender = sender;
        this.messageText = messageText;
        this.timestamp = timestamp;
        this.isIncoming = isIncoming;
        this.replyText = replyText;
        this.status = status;
        this.toneName = toneName;
    }

    public /* synthetic */ WhatsAppMessage(int i, String str, String str2, long j, boolean z, String str3, String str4, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, str, str2, (i2 & 8) != 0 ? System.currentTimeMillis() : j, z, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? "RECEIVED" : str4, (i2 & 128) != 0 ? null : str5);
    }

    public final int getId() {
        return this.id;
    }

    public final String getSender() {
        return this.sender;
    }

    public final String getMessageText() {
        return this.messageText;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final boolean isIncoming() {
        return this.isIncoming;
    }

    public final String getReplyText() {
        return this.replyText;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getToneName() {
        return this.toneName;
    }
}
