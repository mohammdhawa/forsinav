# RIP

- **Routing Information Protocol** (Industry standard).
- Distance vector IGP (uses routing-by-rumor logic to learn/share routes).
- Uses hop count as its metric. One router = one hop (bandwidth is irrelevant!).
- The maximum hop count is 15 (anything more than that is considered unreachable).
- Has three versions:
  - **RIPv1** and **RIPv2**, used for IPv4
  - **RIPng** (RIP Next Generation), used for IPv6.

- Uses two messages types:
  **Request**: to ask RIP-enabled neighbor routers to send their routing table.

  **Response**: to send the local router's routing table no neighboring routers.

- By default RIP-enabled routers will share their routing table every 30 seconds.

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\59.png)

---

## RIPv1 Configuration

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\60.png)

R0

```sh
Router# debug ip rip 
```

```sh
Router(config)# router rip
Router(config)# network 1.0.0.0
Router(config)# network 2.0.0.0
Router(config)# network 3.0.0.0
```

R1

```sh
Router(config)# network 5.0.0.0
Router(config)# network 6.0.0.0
```

---

## RIPv2 Configuration

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\61.png)

First we have to enable rip:

R1

```sh
R1(config)#
R1(config)#router rip
R1(config-router)#version 2
R1(config-router)#
```

second I will prevent it from summarizing my networks (Router 1 connected networks).

```sh
R1(config-router)#no auto-summary 
```

Finally I have to make router (R1) to advertise his networks.

```sh
R1(config-router)#network 10.0.0.0
R1(config-router)#network 20.0.0.0
```

```sh
R1#sh ip protocols 
```

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\62.png)

R2: 

```sh
R2(config)#
R2(config)#router rip
R2(config-router)#version 2
R2(config-router)#no auto-summary
R2(config-router)#network 20.0.0.0
R2(config-router)#network 30.0.0.0
R2(config-router)#
```

So now R1 and R2 become a neighbors so R1 can share networks with R2 and vice versa.

R3:

```sh
![63](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\63.png)R3(config)#
R3(config)#router rip
R3(config-router)#version 2
R3(config-router)#network 30.0.0.0
R3(config-router)#network 40.0.0.0
R3(config-router)#
```

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\63.png)
