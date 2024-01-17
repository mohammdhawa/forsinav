# VLAN

VLAN is a way of grouping devices from different physical networks into a single logical network.

![](https://cdn.ttgtmedia.com/rms/onlineimages/how_a_virtual_lan_works-f_mobile.png)

- By default, all ports on switches belong to VLAN1.
- **Access (Untagged)** links are connections that belong to a single VLAN.
- **Trunk (tagged)** links can carry multiple VLANs and are used for communication between switches or for transporting multiple VLANs.

## Purpose:

- Provides more security by preventing guests from accessing sensitive resources.
- Improves network performance by reducing broadcast traffic.
- Makes managing the network easier.

## Broadcast Domain:

A broadcast domain is a part of a network where devices can directly receive broadcast messages. Devices in the same broadcast domain can communicate via broadcasts, while devices in different domains need a router

## Collision Domain:

A collision domain is a network segment where packets can collide with each other. This can reduce network performance and efficiency.

Switches can be used to reduce or eliminate collision domains by creating separate collision domains for each port on the switch.

---

## Telnet & SHH

1. **Telnet**: (Teletype Network) is a protocol used to remotely access the CLI of a remote host.
   - Telnet was developed in 1969.
   - Telnet sends data in plain text. No encryption!
   - 
2. **SHH (Secure Shell)**: was developed in 1995 to replace less secure protocols like Telnet.
   - Provides security features such as data encryption and authentication.

Telnet is network for remote access that transmits data in plain text, while **SHH** is a more secure alternative that encrypts data, providing enhanced security for remote connections.