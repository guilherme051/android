# Roadmap — Usable Android 16 Version

## Remaining milestones: 6

### M1 — Stabilize Farol ARP/host processing
Current blocker. Pass: sustained ARP processing without SIGSEGV.

### M2 — Verify host-event propagation
Pass: native host event → handler → JNI Host/HostLost → Java receiver → Target list.

### M3 — Integrate stable ARM64 Farol into portable core
Pass: clean binary, updated core, hashes recorded, fresh extraction installs it.

### M4 — Clean-install end-to-end test
Pass: clear data → APK → permissions → bundled core → daemon → JNI auth → handlers → Farol → Nmap, with no manual copying.

### M5 — Essential feature smoke test
Pass: target selection, discovery, port scan, service inspection where supported, controlled restart and essential persistence without blocking crashes.

### M6 — Release hardening
Pass: remove diagnostic noise, reproducible build instructions, artifact hashes, reboot regression, preserved baseline and release-candidate tag.

## Definition of Done
All six milestones pass on the OnePlus 7T without undocumented manual intervention.
