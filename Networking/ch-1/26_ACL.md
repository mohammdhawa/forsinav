# Access Control List



![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\85.png)

## ACL Configuration

```sh
R2(config)#access-list 10 remark ACL_TO_PINK_LAN
```

remark is not mandatory .. but here we use it just to add comment

To permit PC-C to to connect with this LAN:

```sh
R2(config)#access-list 10 permit host 192.168.2.50
```

Now we want to permit the first half of yellow network: so we will subnet this network and then writing the command to permit the first half of this network:
```sh
R2(config)#access-list 10 permit 192.168.1.0 0.0.0.127
```

Now we want to permit all network of blue LAN:

```sh
R2(config)#access-list 10 permit 172.16.1.0 0.0.0.255
```

To see our access list:

```sh
R2#sh access-lists 10
```

### Now we have to configure interfaces (IN - OUT):

```sh
R2(config)#int g0/1
R2(config-if)#ip access-group 10 out
```

### To allow all networks:

```sh
R2(config)#access-list 20 permit any
```

### To deny a network:

```sh
R2(config)#access-list 20 deny 192.168.1.0 0.0.0.255
```

---

## Configuration of Named Standard ACL



```sh
R1(config)#ip access-list standard ADMIN_VTY
```

Here "ADMIN_VTY" is the name

Now permit PC-C to enter to the router:

```sh
R1(config-std-nacl)#permit host 192.168.2.50

R1(config-std-nacl)#ex
R1(config)#
R1(config)#line vty 0 4
R1(config-line)#access-class ADMIN_VTY in
```

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\86.png)