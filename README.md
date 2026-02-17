<div align="center">

# 🛡️ ARMobEntryAddon

### Proteção Inteligente contra Mobs e Animais

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Paper](https://img.shields.io/badge/Paper-1.21.10-F7CF0D?style=for-the-badge&logo=minecraft&logoColor=black)
![WorldGuard](https://img.shields.io/badge/WorldGuard-7.0-blue?style=for-the-badge)
![Softcode](https://img.shields.io/badge/Config-100%25_Softcode-green?style=for-the-badge)

<p align="center">
  <strong>ARMobEntryAddon</strong> estende as funcionalidades do WorldGuard para Paper 1.21.10.
  <br>
  Bloqueia fisicamente a entrada de mobs e protege entidades contra dano em zonas de spawn negado.
</p>

<a href="[#](https://discord.gg/TnuXWbdeVN)">
  <img src="https://img.shields.io/badge/Suporte_e_Bugs-AR_%7C_Soluções_para_Minecraft-7289DA?style=for-the-badge&logo=discord&logoColor=white" alt="AR Soluções para Minecraft">
</a>

</div>

---

## ✨ Funcionalidades Principais

### 🚧 Barreira Física Automática
* **Bloqueio de Entrada:** Impede que mobs e animais atravessem as bordas de regiões que possuem a flag `mob-spawning deny`.
* **Sincronia com WorldGuard:** Não requer configuração manual de novas flags; o plugin detecta o estado da região em tempo real.

### ⚔️ Proteção de Dano por Zona
* **Invulnerabilidade Condicional:** Jogadores localizados dentro de áreas seguras (spawn negado) são impedidos de causar dano a qualquer mob, prevenindo exploits de combate à distância.
* **Foco no Player:** A proteção é aplicada com base na localização do atacante, garantindo que "zonas de paz" sejam respeitadas.

### 📋 Whitelist de Mobs
* **Exceções Inteligentes:** Permite que mobs específicos (como a **Lhama de Pinhata** ou Pets VIP) ignorem as restrições de entrada e dano.
* **Customização Total:** Adicione ou remova qualquer `EntityType` via configuração sem reiniciar o servidor.

### ⚙️ 100% Soft-code
* **Mensagens Personalizáveis:** Suporte total a códigos de cores para prefixos e avisos de negação.
* **Sistema de Reload:** Atualize a whitelist e as mensagens instantaneamente com o comando de recarregamento.

---

## 📦 Instalação

1. Certifique-se de usar **Java 21** e servidor **Paper 1.21.10**.
2. Instale o **WorldGuard 7.0** (v7.0.12 ou superior).
3. Coloque o `ARMobEntryAddon.jar` na pasta `/plugins`.
4. Reinicie o servidor para gerar a `config.yml`.

---

## 🎮 Comandos e Permissões

Alias principal: `/armob`

| Comando | Descrição | Permissão |
| :--- | :--- | :--- |
| `/armob reload` | Recarrega as configurações e a whitelist. | `armob.admin` |
| **Uso Geral** | Bloqueio de entrada e dano (Automático). | *N/A* |

---

## ⚙️ Configuração

O arquivo de configuração permite o ajuste fino do comportamento do addon.

<details>
  <summary>📄 <b>config.yml (Clique para expandir)</b></summary>

```yaml
# ARMobEntryAddon - Configuração
# Desenvolvido por Alisson Ryan

# Mobs nesta lista PODEM entrar em áreas protegidas e PODEM receber dano.
# Use nomes oficiais da Spigot/Paper (ex: LLAMA, TRADER_LLAMA, IRON_GOLEM)
whitelist:
  - LLAMA
  - TRADER_LLAMA
  - IRON_GOLEM

messages:
  prefix: "&8[&bAR-MobEntry&8] "
  denied-entry: "&cEste mob foi impedido de entrar nesta zona protegida!"
  denied-damage: "&cVocê não pode causar dano a mobs enquanto estiver em uma zona segura!"
  reload: "&aConfiguração recarregada com sucesso!"
  no-permission: "&cVocê não tem permissão para usar este comando."
```
</details>

## 🛠️ Tecnologias Utilizadas

1. Java 21 (OpenJDK)
2. Paper API 1.21.10
3. WorldGuard API 7.0 (EngineHub)
