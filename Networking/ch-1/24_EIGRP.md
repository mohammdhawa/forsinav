# Enhanced Interior Gateway Routing Protocol (EIGRP)

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\57.png)

- Administrative Distance (AD) of 90.
- Has fast network convergence time.
- Uses the concept of neighbor relationship. 
- EIGRP calculates its metric by using *bandwidth*, *delay*, *reliability* and *load*. By default, only *bandwidth* and *delay* are used.
- Support Equal and Unequal-Cost Load Balancing.

---

## 1. Activating EIGRP on routers (globally):

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\64.png)

**Autonomous System Number**: A value <1-65535> which identifies an EIGRP routing domain, EIGRP routers in the same as must be configured with the same as number to be able to form neighbor relationships.

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\65.png)

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\66.png)

 ## 2. Enabling EIGRP on interfaces:

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\67.png)

**Wildcard Mask**: The inverse of a subnet mask (255.255.255.255 - Subnet Mask = Wildcard Mask).

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\68.png)

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\66.png)

---

## EIGRP Configuration

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\69.png)

R1:

```sh
R1(config)#router eigrp 50
R1(config-router)#network 200.1.1.0
R1(config-router)#network 200.1.1.172
R1(config-router)#network 200.1.1.180
```

R2:

```sh
R2(config)#router eigrp 50
R2(config-router)#network 200.1.1.172
R2(config-router)#
%DUAL-5-NBRCHANGE: IP-EIGRP 50: Neighbor 200.1.1.173 (GigabitEthernet0/0) is up: new adjacency

R2(config-router)#network 200.1.1.128
R2(config-router)#network 200.1.1.168
```

R3:

```sh
R3(config)#router eigrp 50
%DUAL-5-NBRCHANGE: IP-EIGRP 50: Neighbor 200.1.1.169 (GigabitEthernet0/0) is up: new adjacency

R3(config-router)#network 200.1.1.184
R3(config-router)#network 200.1.1.160
```

R4:

```sh
R4(config)#router eigrp 50
R4(config-router)#network 10.1.1.0
R4(config-router)#network 200.1.1.184
R4(config-router)#
%DUAL-5-NBRCHANGE: IP-EIGRP 50: Neighbor 200.1.1.185 (GigabitEthernet0/0) is up: new adjacency

%DUAL-5-NBRCHANGE: IP-EIGRP 50: Neighbor 200.1.1.181 (GigabitEthernet0/1) is up: new adjacency

R4(config-router)#network 200.1.1.180
```

To see EIGRP routes:

```sh
R1#sh ip eigrp int
```

```sh
R1#sh ip eigrp neighbors 
```

```sh
R1#sh ip eigrp topology
```

---

## Redistribution EIGRP with RIPv4

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\70.png)

```sh
Router(config)#router eigrp 34
Router(config-router)#redistribute connected 
Router(config-router)#redistribute rip 
Router(config-router)#redistribute rip metric 10000 0 255 1 1500
Router(config-router)#network 4.4.4.0 0.0.0.3
```

```sh
Router(config)#router rip
Router(config-router)#version 2
Router(config-router)#redistribute eigrp 34 metric 1
Router(config-router)#network 4.0.0.0
```

