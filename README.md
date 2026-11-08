# Despawn Tweaks — Modern Port for Minecraft 26.3 (Fabric)

![Mod loader: Fabric](https://img.shields.io/badge/modloader-Fabric-1976d2?style=for-the-badge)
![Minecraft: 26.3](https://img.shields.io/badge/Minecraft-26.3-green?style=for-the-badge)
![GitHub license](https://img.shields.io/github/license/Sekai0NI0itamio/DespawnTweaks263?style=for-the-badge)

**Fixes cases where mobs that picked up items stay around forever.**

Vanilla despawn logic can leave mobs that picked up equipment
permanently preventing correct despawning. Despawn Tweaks tracks
those mobs and keeps their despawn handling correct — their
no-action timer is reset instead of despawning while carrying items,
so loot-carrying mobs behave as intended.

Now with a **modern port for Minecraft 26.3 (Fabric)** — mechanism
only, no GUI.

### What it does

- Mobs that pick up an item are tagged and protected from despawning
  while carrying it
- Mobs marked `despawntweaks.shouldNotDespawn` are likewise protected

### Port changes vs. the original

- The original's structure/spawner tracking system and its Forge
  config API dependency are not ported
- The core despawn protection is preserved

### Modern port notes (26.3)

- Java 25 · Fabric Loader 0.20.1+ · Fabric API 0.165.0+26.3
- Built and verified in CI via GitHub Actions, including a headless
  runtime test that launches the client, joins a world, and quits cleanly

### Installation

1. Install Fabric Loader for Minecraft 26.3
2. Install Fabric API
3. Drop `despawntweaks263-*.jar` into your `mods` folder

### Original mod & credit

This is an unofficial modern port by **Itamio** of **Despawn Tweaks**
by **txnimc** — the original (3.9M downloads on Modrinth, last
updated for 1.21.1) has not been updated to 26.3.

- Original mod: https://modrinth.com/mod/despawn-tweaks
- Original source: https://github.com/txnimc/DespawnTweaks
- License: LGPL-3.0-only — see `LICENSE`

All credit for the original concept, design, and logic goes to
txnimc. This port exists to bring it to Minecraft 26.3. See `NOTICE`.
