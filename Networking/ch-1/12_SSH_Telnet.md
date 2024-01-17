# Telnet & SHH

## Console Port Security

- By default, no password is needed to access the CLI of a cisco IOS device via the console port.

- You can configure a password on the console line:
  => A user will have to enter a password to access the CLI via the console port.

  ```sh
  Switch>
  Switch>enable
  Switch#conf t
  Enter configuration commands, one per line.  End with CNTL/Z.
  Switch(config)#line console 0
  Switch(config-line)#password root5
  Switch(config-line)#login
  Switch(config-line)#end
  Switch#
  %SYS-5-CONFIG_I: Configured from console by console
  
  Switch# exit
  
  Switch con0 is now available
  
  Press RETURN to get started.
  
  User Access Verification
  
  Password: 
  ```

- Alternatively, you can configure the console line to require users to login one of the configured usernames on the device.
  ```sh
  Switch>
  Switch>enable
  Switch#conf t
  Enter configuration commands, one per line.  End with CNTL/Z.
  Switch(config)#username mohammad secret root5
  Switch(config)#line console 0
  Switch(config-line)#login local
  Switch(config-line)#end
  Switch#
  %SYS-5-CONFIG_I: Configured from console by console
  
  Switch#eixt
  
  Press RETURN to get started!
  
  User Access Verification
  
  Username: mohammad
  
  Password: 
  ```

---

## Layer 2 Switch - Management IP

A layer 2 switch is a device that operates at the data link layer of the OSI model and forwards frames based on the MAC addresses of the devices. A layer 2 switch does not need an IP address to perform its basic functions, but it can have an IP address assigned to a virtual interface for management or remote access purposes. This IP address is not associated with any physical port on the switch, but rather with a logical entity called a switch virtual interface . [An SVI can also be used to enable inter-VLAN routing on a layer 3 switch, which is a device that can perform both layer 2 and layer 3 functions.

To assign an IP address to a layer 2 switch, you need to create an SVI for the VLAN that you want to use for management. For example, if you want to use VLAN 10 as the management VLAN, you can use the following commands on the switch:

```sh
switch# configure terminal
switch(config)# vlan 10
switch(config-vlan)# name management
switch(config-vlan)# exit
switch(config)# interface vlan 10
switch(config-if)# ip address 192.168.1.1 255.255.255.0
switch(config-if)# no shutdown
switch(config-if)# exit
switch(config)# ip default-gateway 192.168.1.254
switch(config)# end
```

The above commands will create VLAN 10, name it as management, create an SVI for VLAN 10, assign an IP address of 192.168.1.1/24 to the SVI, enable the SVI, and set the default gateway as 192.168.1.254. After that, you can use a third-party tool like PuTTY to access the switch remotely using the IP address 192.168.1.1. You can also monitor the switch using SNMP or other protocols.



- Layer 2 switches don't perform packet routing and don't build a routing table. They aren't IP routing aware.
- However, you can assign an IP address to an SVI to allow remote connections to the CLI of the switch (using Telnet or SSH).

```sh
Enter configuration commands, one per line.  End with CNTL/Z.
Switch(config)#int vlan1
Switch(config-if)#ip add 192.168.1.253 255.255.255.0
Switch(config-if)#no shutdown

Switch(config-if)#
%LINK-5-CHANGED: Interface Vlan1, changed state to up
```

This configure the IP address on the SVI n the same way as on a multiplayer switch. Enable the interface if necessary.

```sh
Switch(config-if)#ip default-gateway 192.168.1.254
Switch(config)#
```

This configure the switch's default gateway.

---

## Telnet 

Telnet (Teletype Network) is a protocol used to remotely access the CLI of a remote host.

Telnet has been largely replaced by SSH, which is more secure.

Telnet sends data in plain text. No encryption!

Telnet uses **TCP port 23**.

Telnet and SSH access are configured on the VTY lines.

### Configuration:

```sh
Switch(config)#enable secret root5
Switch(config)#username mohammad secret root5
```

If an enable password/secret isn't configured, you won't be able to access privilege exec mode when connecting via Telnet.

```sh
Switch(config)#access-list 1 permit host 192.168.2.1
```

Configure an ACL to limit which devices can connect to the VTY line.

```sh
Switch(config)#line vty 0 15
Switch(config-line)#login local
```

Telnet/SSH access is configured on the VTY lines. There are 16 lines available, so up to 16 users can be connected at once.

```sh
Switch(config-line)#transport input telnet
```

- *transport input telnet*  => This line allows only Telnet connections.
- *transport input ssh*  =>  allows only SSH connections.
- *transport input telnet ssh*  ==> allows both
- *transport input all*  ==> allows all connections.
- *transport input none*  ==>  allows no connections.

```sh
Switch(config-line)#access-class 1 in 
```

Apply the ACL to the VTY lines. 

- *access-class* applies an ACL to the VTY lines
- *ip access-group* applies an ACL to an interface.

---

## SSH (Secure Shell)

SSH (Secure Shell) was developed in 1995 to replace less secure protocols like Telnet.

- SSH uses **TCP port 22**.
- Provides security features such as data encryption and authentication.

### Steps:

1. Configure host name.
2. Configure DNS domain name.
3. Generate RSA key pairs.
4. Configure enable password, username/password.
5. Configure VTY lines.

- To enable and use SSH, you must generate an RSA public and private pair.

- The keys are used for data encryption / decryption, authentication, etc.
  ```sh
  Switch(config)#ip domain-name mohammad.com
  ```

  The *FQDN* of the device is used to name the RSA keys.

  FQDN = Fully Qualified Domain Name (host name + domain name).

  ```sh
  sw(config)#crypto key generate rsa
  The name for the keys will be: sw.mohammad.com
  Choose the size of the key modulus in the range of 360 to 4096 for your
    General Purpose Keys. Choosing a key modulus greater than 512 may take
    a few minutes.
  
  How many bits in the modulus [512]: 1024
  % Generating 1024 bit RSA keys, keys will be non-exportable...[OK]
  
  sw(config)#
  *Mar 1 0:3:4.870: %SSH-5-ENABLED: SSH 1.99 has been enabled
  sw(config)#
  ```

  Now we generated rsa keys (Note: we cannot generate rsa keys with default name of the switch).

### Configuration:

```sh
sw(config)#enable secret bnm543
sw(config)#username mohammad secret bnm543
sw(config)#access-list 1 permit host 192.168.2.1
```

```sh
sw(config)#line vty 0 15
```

Configure all VTY lines.

```sh
sw(config-line)#login local
```

Enable local user authentication. (You cannot use *login* for SSH, only *login local*).

```sh
sw(config-line)#transport input ssh
```

Best practice is limit VTY line connections to SSH only.

```sh
sw(config-line)#access-class 1 in
```

(Optional) Apply the ACL to restrict VTY line connections.