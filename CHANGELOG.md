# CHANGELOG

## 2.1.0.0 — NeoForge 1.21.1
### Changed
- Ported from Forge 1.20.1 to NeoForge 1.21.1
- Migrated build system to NeoForge (net.neoforged.moddev plugin 2.0.140)
- Updated to Minecraft 1.21.1, Java 21, Parchment 2024.07.28
- All integration mod dependencies via curse maven
- Updated access transformers for NeoForge 1.21.1

### Added
- Bronze material (nugget, ingot, block)
- ModerateModifier — temperature-based mining speed boost
- ProjectE EMC conversion provider
- Twilight Forest integrations (Twilit, Precipitate modifiers)
- Deeper and Darker integration (Sculking modifier)
- Aquaculture 2 integrations (WaterPowered, Poseidon, Siren modifiers)
- The Undergarden integrations (Masticate, Utherium, Froststeel, Forgotten modifiers)
- Create integrations (EngineersGoggles, MechanicalArm modifiers)
- Alex's Mobs integrations (7 modifiers: Roadrunner, FrontierCap, TurtleShell, BisonFur, ShieldOfTheDeep, Mosquito, Crocodile)
- Mekanism integrations (Kinetic, GlowUp modifiers)
- Immersive Engineering integration (MultiVision modifier)
- Extended ModIntegration helper with location methods

### Removed
- Botania, MythicBotany, Beyond Earth, Ad Astra, Consecration integrations (per CSV)

### Pending (not yet ported)
- Ars Nouveau integration
- Ice and Fire Dragons CE integration (package rename required)
- Malum SoulStained modifier (capability→attachment)
- Apotheosis Capturing modifier
- Data generation providers (recipe API changes in 1.21.1)
- Networking layer (NeoForge CustomPacketPayload system)
