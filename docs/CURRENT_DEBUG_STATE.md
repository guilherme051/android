# Current Debug State — Farol

Status: **IN PROGRESS**

## Reproducible failure
SIGSEGV / signal 11 / SEGV_MAPERR / null fault.

## Proven path
```text
startup
→ prober local_scan
→ ARP probes
→ analyzer + sniffer
→ packet queued
→ analyzer queue_get non-null
→ pktlen=60, caplen=60, EtherType 0x0806
→ dispatch ARP
→ SIGSEGV
```

## Active fault domain
`analyze_arp → on_host_found → get_host/create_host/sortedarray_ins → lookup state → DNS/NBNS → add_event`

## Already fixed
`sortedarray_get()` now returns NULL for NULL/empty arrays. Crash persists.

## Exact next experiment
Add BEFORE/AFTER trace markers around:
1. analyze_arp entry and decoded ARP fields
2. each on_host_found call
3. on_host_found entry
4. get_host
5. create_host
6. sortedarray_ins
7. timeout and lookup-state writes
8. begin_dns_lookup
9. begin_nbns_lookup
10. add_event

The first missing AFTER marker is the next fault boundary.

After ARP stability, harden IPv4/UDP/NBNS packet-length validation.
