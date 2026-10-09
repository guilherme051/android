# Recovery & Continuity

## First commands
```bash
cd /root/csploit-modern
git status --short --branch
git log --oneline --decorate -15
git submodule status --recursive
```

Expected checkpoint:
- branch `csploit-modern-next`
- baseline `8a5548fa1f8447a04f16782f61edaecbc24aee13`
- tag `android16-portable-v3-baseline`
- author alias `Ariranha`

Experimental Farol directories may be untracked and `cSploit/jni` may show native experiment changes.

## Before cleanup
```bash
git status --short
git diff --submodule=log
find network-radar-* -maxdepth 2 -type f -ls 2>/dev/null
```

Preserve useful artifacts and SHA-256 before destructive cleanup.

## AI handoff prompt
> Continue the cSploit Android 16 modernization from the repository documentation. Read docs/ in order. Do not repeat solved work. The active blocker is Farol/network-radar ARM64 SIGSEGV after ARP reaches analyzer dispatch.
