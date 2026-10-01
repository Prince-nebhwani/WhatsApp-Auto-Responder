package com.example.ui;

import com.example.BuildConfig;
import com.example.data.WhatsAppMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WhatsAppDashboard.kt */
/* JADX INFO: loaded from: /tmp/dex_files/classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/example/ui/LatestChatSummary;", "", "sender", "", "latestMessage", "Lcom/example/data/WhatsAppMessage;", "totalCount", "", "<init>", "(Ljava/lang/String;Lcom/example/data/WhatsAppMessage;I)V", "getSender", "()Ljava/lang/String;", "getLatestMessage", "()Lcom/example/data/WhatsAppMessage;", "getTotalCount", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LatestChatSummary {
    public static final int $stable = 0;
    private final WhatsAppMessage latestMessage;
    private final String sender;
    private final int totalCount;

    public static /* synthetic */ LatestChatSummary copy$default(LatestChatSummary latestChatSummary, String str, WhatsAppMessage whatsAppMessage, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = latestChatSummary.sender;
        }
        if ((i2 & 2) != 0) {
            whatsAppMessage = latestChatSummary.latestMessage;
        }
        if ((i2 & 4) != 0) {
            i = latestChatSummary.totalCount;
        }
        return latestChatSummary.copy(str, whatsAppMessage, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSender() {
        return this.sender;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WhatsAppMessage getLatestMessage() {
        return this.latestMessage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    public final LatestChatSummary copy(String sender, WhatsAppMessage latestMessage, int totalCount) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(latestMessage, "latestMessage");
        return new LatestChatSummary(sender, latestMessage, totalCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LatestChatSummary)) {
            return false;
        }
        LatestChatSummary latestChatSummary = (LatestChatSummary) other;
        return Intrinsics.areEqual(this.sender, latestChatSummary.sender) && Intrinsics.areEqual(this.latestMessage, latestChatSummary.latestMessage) && this.totalCount == latestChatSummary.totalCount;
    }

    public int hashCode() {
        return (((this.sender.hashCode() * 31) + this.latestMessage.hashCode()) * 31) + Integer.hashCode(this.totalCount);
    }

    public String toString() {
        return "LatestChatSummary(sender=" + this.sender + ", latestMessage=" + this.latestMessage + ", totalCount=" + this.totalCount + ")";
    }

    public LatestChatSummary(String sender, WhatsAppMessage latestMessage, int totalCount) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(latestMessage, "latestMessage");
        this.sender = sender;
        this.latestMessage = latestMessage;
        this.totalCount = totalCount;
    }

    public final String getSender() {
        return this.sender;
    }

    public final WhatsAppMessage getLatestMessage() {
        return this.latestMessage;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }
}
