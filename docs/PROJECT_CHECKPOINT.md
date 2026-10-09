# Project Checkpoint

## Git state
Repository: `/root/csploit-modern`
Origin: `git@github.com:guilherme051/android.git`
Upstream: `https://github.com/cSploit/android.git`
Branch: `csploit-modern-next`
Baseline commit: `8a5548fa1f8447a04f16782f61edaecbc24aee13`
Baseline tag: `android16-portable-v3-baseline`
Author: `Ariranha <43829165+guilherme051@users.noreply.github.com>`

## Modernization commits
- 8a5548fa — Android 16 portable v3 functional baseline
- b645e921 — select bundled portable core on first install
- 35bfe2c1 — remove obsolete ACCESS_SUPERUSER
- 7e90b7e9 — bundled portable core installer
- 509f27df — Gradle 6.9.4 / AGP 4.2.2 migration
- 9749298d — ChildManager / NetworkRadar diagnostics
- 0ff18836 — historical v1.6.6-rc.2

## Device
OnePlus 7T HD1901/hotdogb, Qualcomm SM8150, Android 16 API 36, crDroid 12.11, kernel 4.14.357-perf, rooted/NetHunter, ARM64 primary userspace with ARM32 compatibility.

## Completed and proven
### Build
Java 11 + Gradle 6.9.4 + AGP 4.2.2 works. AAPT2 host mismatch was solved using `/usr/lib/android-sdk/build-tools/debian/aapt2`.

### Root
Legacy `android.permission.ACCESS_SUPERUSER` was removed. Real root remains through `su`.

### Portable core
Bundled-core architecture replaces unavailable historical Android-16/arm64 remote assets. V1 proved extraction, V2 corrected layout, V3 restored daemon/auth/users/handlers/tools.

### JNI
ARM64/Bionic `libcSploitCommon.so` and `libcSploitClient.so` are packaged and load successfully.

### Daemon
ARM64 cSploitd works. Dynamic symbol export was required for dlopen-loaded handlers.

### Authentication / handlers
`android:DEADBEEF` authentication has succeeded. Ten handlers have been enumerated: arpspoof, blind, ettercap, fusemounts, hydra, msfrpcd, network-radar, nmap, raw, tcpdump.

### Nmap
Java → JNI → cSploitd → handler → Nmap → parsed event → Java has been proven with live port events.

## Preserved APK baselines
- build01
- build02-portable-core
- build03-no-legacy-superuser
- build04-bundled-core
- build05-arm64-jni
- build06-portable-v3

See repository `baseline/` for exact artifacts.

## Current blocker
Farol/network-radar ARM64 SIGSEGV after a valid ARP frame reaches analyzer dispatch.
