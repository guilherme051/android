# AI Handoff — Current Working State

**Updated:** 2026-10-09

## Project
cSploit modernization for Android 16 / crDroid / NetHunter.

## Repository
`/root/csploit-modern`

## Branch
`csploit-modern-next`

## Continuity checkpoint
`12ce7427` — `docs: add Android 16 project continuity checkpoint`

## Technical baseline
`8a5548fa` — tag `android16-portable-v3-baseline`

## Current phase
Farol / `network-radar` ARM64 stabilization.

## Current blocker
Reproducible SIGSEGV in ARM64 `network-radar` after a valid ARP frame reaches analyzer ARP dispatch.

## Last proven boundary

```text
local ARP scan
 -> sniffer
 -> packet queue
 -> analyzer
 -> pktlen=60 / caplen=60
 -> EtherType 0x0806
 -> dispatch ARP
 -> SIGSEGV
```

## Current fault domain
`analyze_arp -> on_host_found -> host lookup/create/insert -> DNS/NBNS/event path`

## Next experiment
Instrument `analyze_arp` and `on_host_found` with BEFORE/AFTER markers, then continue inward until the first missing AFTER marker identifies the crashing operation.

## Do not restart
- Gradle migration;
- ARM64 AAPT2 diagnosis;
- ACCESS_SUPERUSER diagnosis;
- basic JNI loading;
- basic cSploitd startup;
- authentication;
- handler enumeration;
- basic Nmap command/event transport;
- empty-array `sortedarray_get()` diagnosis.

## Mandatory reading for a new AI session
1. `docs/README.md`
2. `docs/AI_OPERATING_PROTOCOL.md`
3. `docs/PROJECT_CHECKPOINT.md`
4. `docs/ARCHITECTURE.md`
5. `docs/DEVELOPMENT_HISTORY.md`
6. `docs/CURRENT_DEBUG_STATE.md`
7. `docs/DO_NOT_REPEAT.md`
8. `docs/ROADMAP.md`
9. `docs/RECOVERY.md`

## Instruction to the next AI

Do not ask the user to explain the project again.
Recover context from Git and `docs/` first.
State the recovered branch, checkpoint, current blocker and next experiment before proposing a change.
Work one experiment at a time and update this handoff whenever the proven boundary moves.

## User operating instructions

Before issuing commands or asking the user to perform development work, read `docs/USER_OPERATING_PROFILE.md` and follow it as the interaction protocol for this project.
