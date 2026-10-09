# cSploit Modern — Documentation & Continuity Index
Checkpoint: 2026-10-09
Target: OnePlus 7T / HD1901 / hotdogb — Android 16 / API 36 — crDroid 12.11
Branch: `csploit-modern-next`
Official baseline: `8a5548fa1f8447a04f16782f61edaecbc24aee13`
Tag: `android16-portable-v3-baseline`
Development identity: `Ariranha`

## Purpose
This directory is the permanent technical memory of the project, intended for both humans and AI systems.

## Reading order
1. README.md
2. PROJECT_CHECKPOINT.md
3. ARCHITECTURE.md
4. DEVELOPMENT_HISTORY.md
5. CURRENT_DEBUG_STATE.md
6. DO_NOT_REPEAT.md
7. ROADMAP.md
8. RECOVERY.md

## Current state
The Android application builds and runs on Android 16. Build migration, ARM64-host AAPT2, removal of obsolete ACCESS_SUPERUSER, bundled portable core, ARM64 JNI, ARM64 cSploitd, authentication, handler enumeration and Nmap command/event transport have been demonstrated.

The current blocker is **Farol** (`network-radar`): its ARM64 port reaches live ARP processing and then crashes with SIGSEGV.

## AI handoff
Read every document in this directory before proposing changes. Do not restart solved investigations. Treat CURRENT_DEBUG_STATE.md as the active debugging boundary and DO_NOT_REPEAT.md as a hard constraint.

## AI continuation protocol

For every new AI development session, read these files in this order:

1. `docs/README.md`
2. `docs/AI_HANDOFF.md`
3. `docs/AI_OPERATING_PROTOCOL.md`
4. `docs/PROJECT_CHECKPOINT.md`
5. `docs/ARCHITECTURE.md`
6. `docs/DEVELOPMENT_HISTORY.md`
7. `docs/CURRENT_DEBUG_STATE.md`
8. `docs/DO_NOT_REPEAT.md`
9. `docs/ROADMAP.md`
10. `docs/RECOVERY.md`

The AI must recover project context from Git and these documents before asking the user to explain previous work. The current working boundary is always recorded in `AI_HANDOFF.md`.

## User interaction profile

Before giving development commands, the AI must also read `docs/USER_OPERATING_PROFILE.md`. It defines the laboratory context, user technical profile, explanation requirements, copy/paste command workflow, large-output TXT rule, safety procedure and session-continuity responsibilities.
