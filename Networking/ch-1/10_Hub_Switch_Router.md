# Hub & Switch & Router

## Hub

A hub is device that connects multiple devices in a local area network (LAN) and forwards data to all connected devices.

- Used to setup LAN.
- Has multiple ports.

## Switch

A switch is a networking hardware that connects devices on a computer network to establish a local area network (LAN).

- Unlike hub, switch has memory.
- Stores MAC address table.

```sh
EN --> to enable 
show mac-address-table --> to see MAC address table of the switch
```

| Hub                       | Switch                                    |
| ------------------------- | ----------------------------------------- |
| - Work at physical layer. | - Works at data link layer.               |
| - Has no memory           | - Has memory and stores MAC address table |
| - Security risk high      | - Security risk low                       |

---

## Router

A router is a networking device that forward data packets between computer networks.

Commonly two LANs or WANs or a LAN and its ISPs networking.

It's a layer 3 (network layer) device.

| Switch                                                       | Router                                                       |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| - A network switch is a computer networking device that is used to connect many devices to gather on computer network. (Devices to other). | - A router is a networking device that connects a local network to other local network (LAN to LAN). |
| - At data link layer.                                        | - At network layer.                                          |
| - Stores MAC address table.                                  | - Stores routing table.                                      |
| - Decisions are taken based on MAC address.                  | - Decisions are taken based on IP address.                   |
| - LAN                                                        | - LAN, MAN, and WAN                                          |

## Repeater

The data signals generally become too weak or corrupted if they travel a long distance.

- Repeater regenerates the signal over the same network.
- It operates at physical layer.
- It is a 2 port deice.