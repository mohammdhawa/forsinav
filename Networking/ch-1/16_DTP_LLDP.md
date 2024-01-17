# Cisco Discovery Protocol

CDP is a Cisco proprietary Layer 2 network protocol that allows Cisco devices to discover and share information about each each other. It operates at the Data Link Layer (Layer2) of the OSI model and helps in network management by providing details about neighboring devices, such as device type platform, and connected interface .

```sh
Switch#cdp enable
Switch#no cdp enable
```

Enable and disable cdp

```sh
Switch#sh cdp neighbors
```

Lists information about directly connected neighbors. Including their device ID, local interface and capabilities.

```sh
Switch#sh cdp neighbors detail 
```

Lists information about directly connected neighbors in details.

---

# Link Layer Discovery Protocol

LLDP the same as CDP but this protocol is not specific for Cisco devices it work with all devices.

```sh
Switch(config)#do sh lldp neighbor
% LLDP is not enabled
Switch(config)#lldp run
Switch(config)#do sh lldp neighbor
Capability codes:
    (R) Router, (B) Bridge, (T) Telephone, (C) DOCSIS Cable Device
    (W) WLAN Access Point, (P) Repeater, (S) Station, (O) Other
Device ID           Local Intf     Hold-time  Capability      Port ID

Total entries displayed: 0
Switch(config)#
```

