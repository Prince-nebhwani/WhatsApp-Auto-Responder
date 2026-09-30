# 🚀 Free Advertisement & Launch Kit

Copy-paste-ready posts, threads, and directory submission guides to drive organic users, downloads, and GitHub stars.

---

## 📌 Links to Share
- **Landing Page (GitHub Pages):** `https://prince-nebhwani.github.io/WhatsApp-Auto-Responder/`
- **GitHub Repository:** `https://github.com/Prince-nebhwani/WhatsApp-Auto-Responder`
- **Direct APK Download:** `https://github.com/Prince-nebhwani/WhatsApp-Auto-Responder/releases/download/v1.0.0/WhatsApp-Auto-Responder.apk`

---

## 1. Reddit Promotion Strategy

### Post 1: For `r/androidapps` (Post on Friday or weekend)
**Title:** `I built a free WhatsApp Auto-Responder powered by Google Gemini AI (No subscriptions, runs locally via native Android APIs)`

**Body:**
```markdown
Hey r/androidapps!

Most WhatsApp auto-reply apps on the Play Store either cost $5-$10/month, spam ads, rely on basic keyword matching ("hi" -> "hello"), or risk getting your account banned by reverse-engineering WhatsApp Web.

I wanted something intelligent, private, and free, so I built **WhatsApp Auto-Responder** with Jetpack Compose:

✨ **What makes it different:**
- **Google Gemini AI Integration:** Understands context and replies naturally like a real human.
- **Customizable Personalities:** Choose between *Professional & Direct* (for clients), *Friendly & Warm*, *Chill & Casual*, or *Witty & Sarcastic*. You can also write your own custom system prompt.
- **Scheduled Messages:** Queue messages to contacts with exact Android alarm triggers.
- **100% Privacy & Zero Middleman:** Your phone talks directly to Google's official Gemini API using your free API key. All chat history stays strictly on your device in a local SQLite Room database.
- **Safe from Bans:** Operates using Android's native Notification Listener and RemoteInput action API (the exact same mechanism smartwatches and Android Auto use).

The APK is free and open-source under the MIT license:
- **Landing Page:** https://prince-nebhwani.github.io/WhatsApp-Auto-Responder/
- **GitHub Repo & APK:** https://github.com/Prince-nebhwani/WhatsApp-Auto-Responder

Would love your feedback, bug reports, and ideas for new features!
```

---

### Post 2: For `r/SideProject` & `r/indiehackers`
**Title:** `Show SideProject: Free, local WhatsApp auto-responder with Gemini AI & Jetpack Compose`

**Body:**
```markdown
Hey everyone!

I recently completed building an open-source Android app: **WhatsApp Auto-Responder**.

### Why I built it:
Every popular auto-responder app charges a monthly subscription and only does rigid keyword regex matching. I wanted an auto-responder that actually understands what people are asking—whether it's a client asking about pricing or a friend asking what I'm up to.

### Tech Stack & Architecture:
- **UI:** 100% Jetpack Compose (Material 3)
- **Database:** Android Room (SQLite) for local state, message logs, and personality tables
- **AI Backend:** Google Gemini API (BYOK - Bring Your Own Key from Google AI Studio)
- **Service:** Android NotificationListenerService with RemoteInput inline replies

Check out the live landing page and GitHub repo here:
- Web: https://prince-nebhwani.github.io/WhatsApp-Auto-Responder/
- GitHub: https://github.com/Prince-nebhwani/WhatsApp-Auto-Responder

Any questions on the implementation or feedback on the APK? Happy to answer!
```

---

### Post 3: For `r/fossdroid` & `r/privacy`
**Title:** `[FOSS] WhatsApp Auto-Responder with Google Gemini AI — Local storage, zero middleman servers`

**Body:**
```markdown
Hi all!

For those looking for an open-source auto-responder for WhatsApp:
I've open-sourced **WhatsApp Auto-Responder** (MIT License).

### Privacy & Security Highlights:
- **No intermediary backend:** Connects directly from your device to `generativelanguage.googleapis.com` via your own Gemini API key.
- **Local persistence only:** All logs and rules are stored on-device in a local SQLite database.
- **Permissions transparency:** Only requests `BIND_NOTIFICATION_LISTENER_SERVICE` (to reply to WhatsApp notifications) and `INTERNET` (for Gemini API calls). No contacts read permission, no storage scanning.
- **Cryptographic Hashes:** Release APK SHA-256 is published directly in the README for verification.

Repo & Releases: https://github.com/Prince-nebhwani/WhatsApp-Auto-Responder
```

---

## 2. Twitter / X Viral Launch Thread

**Tweet 1 (Hook):**
> Most WhatsApp auto-responders charge \$10/month and use rigid keyword matching from 2012.
>
> So I built a 100% free, privacy-first Android app powered by Google Gemini AI. 🤖✨
>
> It actually understands context and replies like a human.
>
> Here’s how it works & how to get it for free 👇🧵

**Tweet 2 (Features):**
> 1/ Pick your AI Persona 🎭
>
> You can choose:
> • 👔 Professional & Direct (for clients & work)
> • 😊 Friendly & Warm (for community)
> • ☕ Chill & Casual (for everyday texting)
> • 😈 Witty & Sarcastic (for friends)
> • 🛠️ Or write your own custom system prompt!

**Tweet 3 (Privacy & Safety):**
> 2/ Zero Risk of Account Bans & 100% Private 🛡️
>
> Unlike bots that scrape WhatsApp Web, this uses Android's official Notification Action API (`RemoteInput`), exactly like a Wear OS smartwatch or Android Auto.
>
> All chat logs stay locally in an SQLite database on your device. Zero middleman servers.

**Tweet 4 (BYOK Free Model):**
> 3/ Free Forever (Bring Your Own Key) 🔑
>
> Uses your free personal Gemini API key from Google AI Studio. No monthly subscriptions, no ads, no paywalls.

**Tweet 5 (CTA & Link):**
> 4/ Download the APK & star the repo on GitHub:
>
> 🌐 Landing Page: https://prince-nebhwani.github.io/WhatsApp-Auto-Responder/
> 📦 GitHub & APK: https://github.com/Prince-nebhwani/WhatsApp-Auto-Responder
>
> Retweet to share with someone who needs auto-replies! 🔁

---

## 3. Directory Submissions

### 1. IzzyOnDroid (F-Droid Third-Party Repo)
- **URL:** https://gitlab.com/IzzyOnDroid/repo/-/issues
- **Steps:** Click "New Issue", select the "Inclusion Request" template, and submit:
  - App Name: WhatsApp Auto-Responder
  - Package ID: `com.aistudio.whatsappautoresponder.zkympl`
  - GitHub Repo: `https://github.com/Prince-nebhwani/WhatsApp-Auto-Responder`
  - License: MIT
  - Release Tag: `v1.0.0`

### 2. AlternativeTo.net
- **URL:** https://alternativeto.net/software/create/
- **Submit as an alternative to:** "AutoResponder for WhatsApp", "WhatsAuto", "Auto-Reply for WhatsApp"
- **Cost:** Free & Open Source

### 3. Product Hunt
- **Name:** WhatsApp Auto-Responder
- **Tagline:** Smart, privacy-first WhatsApp auto-replies powered by Gemini AI
- **Category:** Artificial Intelligence, Productivity, Android
