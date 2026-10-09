# Development History

1. Legacy cSploit used targetSdk 22, old support libraries, Gradle 2.x/AGP 1.5-era build and ARM32 native cores.
2. Build was bridged to Java 11 / Gradle 6.9.4 / AGP 4.2.2.
3. AAPT2 failure was identified as x86-64 tooling on AArch64 host; Debian ARM64 AAPT2 solved it.
4. Obsolete ACCESS_SUPERUSER manifest permission was removed while preserving real su access.
5. Bundled portable-core installer was introduced because historical remote core selection does not cover Android 16 arm64.
6. Portable cores V1→V2→V3 progressively restored layout, daemon, auth, handlers and tools.
7. ARM64 Bionic JNI libraries were rebuilt and loaded successfully.
8. ARM64 cSploitd was built; handler dlopen initially failed until daemon symbols were exported dynamically.
9. Ten handlers loaded and authentication succeeded.
10. Nmap command/event transport succeeded end-to-end.
11. ARM64 Farol was built. Modern compiler issues were corrected incrementally.
12. Runtime instrumentation narrowed Farol SIGSEGV to ARP/host processing after analyzer receives the first valid ARP frame.
