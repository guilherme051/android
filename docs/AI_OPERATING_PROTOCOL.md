# AI Operating Protocol — cSploit Modern

> Mandatory operating rules for any AI continuing this project.

## 1. Source of truth

Git and the files under `docs/` are the persistent technical memory.
Chat history is secondary and may be incomplete, redacted or unavailable.

At the beginning of every new development session:

1. read `docs/AI_HANDOFF.md`;
2. read `docs/PROJECT_CHECKPOINT.md`;
3. read `docs/CURRENT_DEBUG_STATE.md`;
4. read `docs/DO_NOT_REPEAT.md`;
5. inspect `git status --short --branch`;
6. inspect the current HEAD;
7. inspect submodule state when native work is involved.

Never ask the user to reconstruct project history manually when the repository documentation contains it.

## 2. Development method

Work incrementally:

`state -> hypothesis -> one experiment -> evidence -> conclusion -> decision -> checkpoint`

Do not change several unrelated layers in one experiment.
Do not change Java, JNI, daemon, handler and native tool simultaneously unless the evidence requires a coordinated interface change.

## 3. Evidence rules

Compilation success is not runtime success.
Installation success is not integration success.
Process startup is not functional success.

A fix is PROVEN only after the relevant runtime boundary passes.

Distinguish explicitly between:
- fact;
- runtime evidence;
- hypothesis;
- experiment;
- failed attempt;
- provisional workaround;
- validated fix.

## 4. Debugging rules

Always debug the narrowest proven failing boundary.
Read `DO_NOT_REPEAT.md` before proposing a new hypothesis.
Do not restart broad diagnosis when a narrower boundary has already been established.

Prefer BEFORE/AFTER instrumentation around one function boundary.
The first missing AFTER marker normally defines the next investigation boundary.

## 5. Commands and user interaction

The user works primarily from a phone terminal.

Therefore:
- commands must be copy/paste friendly;
- avoid huge heredocs;
- never send an incomplete shell block;
- large diagnostic output must be redirected to one TXT file;
- ask the user to upload that TXT instead of sending many screenshots;
- keep direct terminal output small when possible.

## 6. Git safety

Never use `git add .` for project checkpoints.
Stage explicit paths.

Before committing:
- inspect `git status`;
- inspect `git diff --cached --name-status`;
- ensure experimental directories are not staged;
- preserve submodule state intentionally.

Before destructive cleanup:
- inventory files;
- preserve valuable artifacts;
- calculate SHA-256;
- verify that another known-good copy exists.

## 7. Baseline policy

Never overwrite the last known-good artifact without preserving it.

Instrumented/debug binaries are EXPERIMENTAL until rebuilt cleanly and retested.
A diagnostic success does not automatically promote an artifact to BASELINE.

## 8. Native/submodule policy

Before changing native code, identify the repository/submodule and commit that owns the source.
Do not accidentally commit temporary build trees into the parent repository.

After a native fix is proven:
1. apply it to the canonical source;
2. remove temporary instrumentation;
3. rebuild cleanly;
4. retest;
5. record hashes;
6. update documentation;
7. commit the correct repository/submodule;
8. update the parent submodule pointer if required.

## 9. Session checkpoint rule

Before ending a significant development session, determine whether project state changed.

If it changed:
- update `AI_HANDOFF.md`;
- update the relevant detailed document;
- record the last proven boundary;
- record the next experiment;
- record new DO-NOT-REPEAT conclusions;
- commit documentation when appropriate.

## 10. Conflict rule

If chat memory conflicts with repository documentation, prefer the newest documented Git evidence unless newer runtime evidence proves otherwise.

## 11. Completion rule

Never say a subsystem is solved merely because it compiled.
A subsystem is solved only when its documented pass criterion succeeds at runtime.

## 12. Current project-specific instruction

Do not restart investigation of Gradle, AAPT2, ACCESS_SUPERUSER, basic JNI loading, cSploitd startup, authentication, handler enumeration or basic Nmap transport unless new evidence demonstrates a regression.

Current priority is Farol (`network-radar`) ARM64 stabilization.
