# Networking Commands

```sh
ipconfig
```

To see the IP configuration details (IP address, subnet mask, default gateway: the IP address of the first router it is hitting, ...)

```sh
ipconfig /all
```

To the MAC address of the computer (IP address, name)

```sh
ping ip_address
```

To know if our computer and the system or ... is reachable.

```sh
tracert ip_address
```

To trace the route that packets take from your computer to destination host or IP address network.                                   

---

```sh
Switch> 
```

User exec mode 

```sh
Switch#
```

Privileged Exec mode

```sh
Switch(config)#
```

Global configuration mode

```sh
Switch(config-line)#
```

Line configuration mode

```sh
Switch(config-if)#
```

Interface configuration mode.

Let's start:

```sh
Switch> enable
Switch# configure terminal
Switch(config)# hostname s1
s1(config)# line console 0
s1(config-line)# password cisco
s1(config-line)# login
s1(config-line)# exit
				end
				ctrl+c
				ctrl+z
```

1. `Switch> enable`: This command is used to enter privileged EXEC mode, allowing you to access higher-level configuration commands. In this mode, you can configure and manage the switch at an advanced level.

2. `Switch# configure terminal`: This command is used to enter global configuration mode, where you can configure various global settings for the switch. It is often abbreviated as "config t." 

3. `Switch(config)# hostname s1`: This command is used to set the hostname of the switch to "s1." The hostname is used to identify the switch in the network and typically appears in the system prompt.

4. `s1(config)# line console 0`: This command enters configuration mode for the console line. The console line refers to the physical console port on the switch where you can connect directly for configuration and management.

5. `s1(config-line)# password cisco`: This command is used to set the password for the console line. In this case, the password is set to "cisco." Users who want to access the console line must enter this password.

6. `s1(config-line)# login`: This command enables the requirement for login authentication on the console line. When someone connects to the console port, they will be prompted for the configured password ("cisco" in this example) before gaining access to the switch.

```sh
s1(config)# enable secret class12345
s1(config)# line vty 0 15
s1(config-line)# password cisco
s1(config-line)# login
s1(config-line)# exit
s1(config)# service password encryption
s1(config)# interface vlan 1
s1(config-if)# ip address 192.168.0.2 255.255.255.0
s1(config-if)# no shutdown
s1(config)# end
```

1. `s1(config)# enable secret class12345`: This command sets the secret password for privileged EXEC mode. The password "class12345" will be required to enter privileged EXEC mode when accessing the switch.

2. `s1(config)# line vty 0 15`: This command enters the configuration mode for virtual terminal (VTY) lines. VTY lines are used for remote management and configuration access to the switch.

3. `s1(config-line)# password cisco`: This command sets the password "cisco" for accessing the VTY lines. Users connecting remotely to the switch will need to enter this password.

4. `s1(config-line)# login`: This command enables the requirement for login authentication on the VTY lines. Remote users must provide the correct password to access the switch.

5. `s1(config-line)# exit`: This command exits the configuration mode for VTY lines and returns to global configuration mode.

6. `s1(config)# service password encryption`: This command enables password encryption for the switch's configuration. It helps to protect sensitive information by encrypting passwords in the configuration.

7. `s1(config)# interface vlan 1`: This command enters the configuration mode for VLAN 1 interface. VLAN 1 is the default VLAN and is often used for managing the switch.

8. `s1(config-if)# ip address 192.168.0.2 255.255.255.0`: This command assigns the IP address 192.168.0.2 to the VLAN 1 interface with a subnet mask of 255.255.255.0. This allows the switch to be managed on the network using this IP address.

9. `s1(config-if)# no shutdown`: This command ensures that the VLAN 1 interface is in an "up" state and operational.

10. `s1(config)# end`: This command exits the configuration mode and returns to privileged EXEC mode.

```sh
end or exit or ctrl+c or ctrl+z
```

```sh
s1# copy running-config startup-config
s1# show running-config
s1# show startup-config
s1# show ip interface brief
s1# show ip interface brief
s1# show version
```

1. `s1# copy running-config startup-config`: This command copies the current running configuration of the switch to the startup configuration. The running configuration is the active configuration in memory, while the startup configuration is the saved configuration that is loaded at startup.

2. `s1# show running-config`: This command displays the current running configuration of the switch. It allows you to view the configuration settings currently in use.

3. `s1# show startup-config`: This command displays the saved startup configuration of the switch. It shows the configuration settings that will be loaded when the switch is restarted.

4. `s1# show ip interface brief`: This command provides a summary of the IP addresses assigned to the interfaces on the switch. It is a quick way to see the IP address and status of each interface.
