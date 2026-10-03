# 🤖 WhatsApp Auto-Responder (AI-Powered)

[![GitHub Release](https://img.shields.io/github/v/release/Prince-nebhwani/WhatsApp-Auto-Responder?color=25D366&logo=github&style=for-the-badge)](https://github.com/Prince-nebhwani/WhatsApp-Auto-Responder/releases/latest)
[![Obtainium](https://img.shields.io/badge/Obtainium-Add%20App-007AFF?logo=android&logoColor=white&style=for-the-badge)](obtainium://app/https%3A%2F%2Fgithub.com%2FPrince-nebhwani%2FWhatsApp-Auto-Responder)
[![Website](https://img.shields.io/badge/Website-Live%20Demo-25D366?logo=googlechrome&logoColor=white&style=for-the-badge)](https://prince-nebhwani.github.io/WhatsApp-Auto-Responder/)
[![Android](https://img.shields.io/badge/Platform-Android%208.0%2B-3DDC84?logo=android&logoColor=white&style=for-the-badge)](https://github.com/Prince-nebhwani/WhatsApp-Auto-Responder/releases)
[![AI Engine](https://img.shields.io/badge/AI%20Engine-Google%20Gemini-4285F4?logo=google&logoColor=white&style=for-the-badge)](https://ai.google.dev/)
[![UI](https://img.shields.io/badge/UI-Jetpack%20Compose-4285F4?logo=jetpackcompose&logoColor=white&style=for-the-badge)](https://developer.android.com/jetpack/compose)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](LICENSE)

A modern, privacy-first Android application that automatically replies to WhatsApp messages using **Google Gemini AI**. Customize personality tones, schedule future messages, and automate your communication without sacrificing privacy or paying monthly subscription fees.

---

### 🌐 [**Visit Official Landing Page**](https://prince-nebhwani.github.io/WhatsApp-Auto-Responder/) &nbsp;|&nbsp; 📥 [**Download Latest APK (v1.0.1)**](https://github.com/Prince-nebhwani/WhatsApp-Auto-Responder/releases/download/v1.0.1/WhatsApp-Auto-Responder.apk) &nbsp;|&nbsp; 📲 [**Add to Obtainium**](obtainium://app/https%3A%2F%2Fgithub.com%2FPrince-nebhwani%2FWhatsApp-Auto-Responder)
*Direct download • Verified Build • Size: ~18.8 MB • Works on Android 8.0+*

---

## ✨ Features

- **🧠 Google Gemini AI Replies:** Unlike standard auto-responders that use rigid keyword matching or regex, this app analyzes conversational context and crafts human-like, helpful responses.
- **🎭 Customizable Personality & Tones:** Choose how your auto-responder speaks or write your own custom prompt:
  - **Professional & Direct:** Polite, articulate, and business-ready.
  - **Friendly & Warm:** Enthusiastic, welcoming, and emoji-friendly.
  - **Chill & Casual:** Relaxed, lowercase, natural conversational flow.
  - **Witty & Sarcastic:** Fun, clever, and playful banter.
  - **Custom System Prompt:** Fully configure your own AI persona and instructions.
- **⏰ Smart Message Scheduler:** Schedule one-time or recurring messages for specific contacts with exact Android alarm triggers.
- **⚡ Native Notification Action Interception:** Uses Android's official `NotificationListenerService` and notification action replies (the same mechanism used by Wear OS smartwatches and Android Auto).
- **🎨 Modern Material 3 UI:** Clean, responsive user interface built 100% with Jetpack Compose.
- **🛡️ 100% Local & Privacy-First:** No middleman backend, no tracking, and no external analytics.

---

## 🥊 Why This App? (Comparison with Alternatives)

| Feature / Aspect | **This App (FOSS)** | Commercial Play Store Apps | Python / Web Scraper Bots |
| :--- | :--- | :--- | :--- |
| **Cost** | **100% Free forever** (BYOK Gemini API) | Paid subscription ($5–$15/mo) | Free, but requires 24/7 VPS hosting |
| **WhatsApp Ban Risk** | **0% Risk** (Uses official Android notification API) | 0% Risk (Uses same notification API) | **High Risk** (Scrapers get banned by WhatsApp) |
| **Privacy & Security** | **100% On-device Room DB**, No trackers | Closed-source, ads, unknown data harvesting | Depends on self-hosted script |
| **Setup Difficulty** | Install APK & paste Gemini API key | Install app, pay paywall | Complex (Node/Python, Docker, headless Chrome) |
| **Smartwatch Emulation** | Handled natively via `RemoteInput` | Supported | Unsupported |

---

## 🛡️ Privacy & Transparency: Why You Can Trust This App

Security and transparency are essential when dealing with messaging applications. Here is an honest breakdown of how this application works:

### 1. Zero Middleman Servers
This app does **NOT** route your messages through any third-party server or developer-owned backend. When an auto-reply is generated, your device communicates **directly and securely** with Google's official Gemini API endpoints (`generativelanguage.googleapis.com`) using your personal API key.

### 2. Bring Your Own Key (BYOK)
You supply your own free Google Gemini API key from [Google AI Studio](https://aistudio.google.com/app/apikey). Your key is stored securely in encrypted local Android application storage and is never transmitted anywhere else.

### 3. All Data Stored Locally
All reply logs, conversation history, and custom tone definitions are stored strictly inside a local SQLite database (powered by Android Jetpack Room) on your physical device:
- `personality_tones`
- `whatsapp_messages`
- `scheduled_messages`

Uninstalling or clearing app data wipes everything instantly.

### 4. Transparent Permissions Breakdown

| Permission | Android ID | Why It Is Needed |
|---|---|---|
| **Notification Access** | `BIND_NOTIFICATION_LISTENER_SERVICE` | Required to detect incoming notifications from WhatsApp and send inline replies via the notification's `RemoteInput` action. Does not read or store notifications from other apps. |
| **Exact Alarm** | `SCHEDULE_EXACT_ALARM` | Required to trigger scheduled messages at the exact time you specify. |
| **Post Notifications** | `POST_NOTIFICATIONS` | (Android 13+) Required to display active background service status and notification alerts. |
| **Internet Access** | `INTERNET` & `ACCESS_NETWORK_STATE` | Required exclusively to send prompts to Google's official Gemini API and receive generated responses. |

---

## 🔒 Cryptographic Integrity & Checksums

To verify that your downloaded file has not been altered or tampered with, compare its cryptographic hashes against the official release:

- **Filename:** `WhatsApp-Auto-Responder.apk`
- **Package Name:** `com.aistudio.whatsappautoresponder.zkympl`
- **Version:** `1.0.1` (Build 2) — *Security Hardened Release*
- **File Size:** `19,676,686 bytes (18.77 MiB)`

| Hash Algorithm | Checksum |
|---|---|
| **SHA-256** | `4f6473525a045145ba0520b4aee2b181449cd1720ab40612521af596d190fbee` |
| **SHA-1** | `aef4f65ac29ae31d2ee333859a3c07295256844a` |
| **MD5** | `bd5e7e66fa680988815def39fbcf81cc` |

### 🛡️ Security Patch v1.0.1 Changelog
- **Prompt Injection Defense:** Hardened AI system instruction to explicitly reject and ignore adversarial override commands inside incoming messages.
- **ADB Backup Disabled:** Explicitly set `android:allowBackup="false"` to prevent unauthorized data extractions via USB debugging.
- **Debug Mode Stripped:** Set `android:debuggable="false"` to secure app memory against debugger inspection.

### How to Verify Checksum

#### On Linux / macOS:
```bash
sha256sum WhatsApp-Auto-Responder.apk
# Expected output: 4f6473525a045145ba0520b4aee2b181449cd1720ab40612521af596d190fbee
```

#### On Windows (PowerShell):
```powershell
Get-FileHash .\WhatsApp-Auto-Responder.apk -Algorithm SHA256
```

---

## 🚀 Quick Setup Guide

### Step 1: Download & Install
1. Download [`WhatsApp-Auto-Responder.apk`](https://github.com/Prince-nebhwani/WhatsApp-Auto-Responder/releases/download/v1.0.0/WhatsApp-Auto-Responder.apk) on your Android device.
2. Tap the downloaded file. If prompted, enable **"Allow from this source"** in your browser/file manager settings to permit installation.
3. Tap **Install**.

### Step 2: Grant Notification Access
1. Open the app.
2. Follow the on-screen prompt to enable **Notification Access** for **WhatsApp Auto-Responder**.
3. *(This allows the app to detect incoming chat notifications and reply on your behalf).*

### Step 3: Configure Your Free Gemini API Key
1. Go to **[Google AI Studio](https://aistudio.google.com/app/apikey)** and click **Create API Key** (it is free).
2. Copy your key and paste it into the app's settings.
3. Tap **Test API Key** to verify connectivity.

### Step 4: Choose Your Tone & Turn On!
1. Select your preferred reply persona (e.g., *Professional*, *Friendly*, *Casual*, or create your own).
2. Toggle **Auto-Responder ON**.
3. You're all set! Incoming WhatsApp messages will now receive intelligent, automated replies.

---

## 🔋 Battery Optimization & Reliability Tips

Modern Android OEM skins (MIUI/HyperOS, ColorOS, OxygenOS, OneUI) aggressively kill background services. To ensure uninterrupted auto-replies:

1. **Disable Battery Optimization:** Go to `Settings` → `Apps` → `WhatsApp Auto-Responder` → `Battery` → Select **Unrestricted** / **Don't Optimize**.
2. **Enable Autostart (Xiaomi / Vivo / Oppo):** Enable **Autostart** in app permissions.
3. **Lock App in Recent Tasks:** Open Recent Apps, long press or swipe down on WhatsApp Auto-Responder, and tap the **Lock** icon.

---

## ❓ Frequently Asked Questions (FAQ)

### Can this get my WhatsApp account banned?
**No.** Unofficial WhatsApp bots that reverse-engineer the WhatsApp web protocol or modify the WhatsApp APK risk account bans. In contrast, this app **does not modify WhatsApp or connect to WhatsApp servers**. It operates entirely via Android's official system notification action API (`RemoteInput`), functioning identically to how Android Auto or a Galaxy Watch sends a quick reply.

### Does it work with WhatsApp Business?
**Yes.** As long as WhatsApp or WhatsApp Business posts standard Android notification alerts with reply actions, the listener service will detect and respond to them.

### What if I don't want to reply to every message?
You can pause the responder anytime from the main dashboard toggle or configure specific schedules.

---

## 📄 License

This project is licensed under the [MIT License](LICENSE) — free for personal and open-source use.
