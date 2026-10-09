# Architecture

```text
Android UI / Java
 ↓
libcSploitClient.so
 ↓
cSploitd.sock
 ↓
cSploitd (root)
 ↓
handlers/*.so
 ↓
native tools
 ↓
Android/Linux networking
```

## Core layout
Required logical content:
`VERSION`, `start_daemon.sh`, `cSploitd`, `known-issues`, `users`, `handlers/`, `tools/`.

Important Java-expected paths:
- tools/nmap/nmap
- tools/nmap/nmap-services
- tools/nmap/nmap-mac-prefixes
- tools/network-radar/network-radar
- tools/ettercap/share/

## Farol
Farol is the internal project name for network-radar; source/class/binary names remain unchanged.

```text
local_scan → ARP probes
sniffer → packet capture
analyzer → ARP/NBNS processing
host table → state
event queue → notifier
handler → cSploit protocol
JNI → Host/HostLost
Java → Target list
```
