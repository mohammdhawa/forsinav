# Open Shortest Path First (OSPF)

- **Open Standard Protocol.**
- **Administrative Distance (AD) of 110.**
- **Uses Dijkstra's Shortest Path First (SPF) algorithm to determine the best path for a remote network.**
- **OSPF Versions**:
  - **OSPFv2**: Used for IPv4.
  - **OSPFv3**: Used for IPv6.

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\57.png)

## Link State Protocols:

- Routers exchange information about their interfaces (directly connected networks) so that each router builds a map of the entire network topology.
- OSPF uses **Link State Advertisement (LSA)** and **Link State Database (LSDB)** for building the map.
  - **LSA**: An OSPF message contains routing information (it will be reflooded every 30min by default. However, when an LSA changes, it will be flooded immediately).
  - **LSDB**: A database consists of LSAs, located on each router.

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\71.png)

## OSPF Areas

- Large networks can have the following problems:
  - Large link-state database (LSDB), which requires more memory on each router.
  - Frequent SPF calculations, which requires processing power.
- OSPF supports a hierarchical design "**Areas**" to break large networks with one large LSDB into smaller areas with smaller separate LSDBs.
- **Areas** is a group of links and routers that share the same LSDB
  - **Single-area OSPF:** One area with the same LSDB.
  - **Multiarea OSPF:** Multiple areas have separate LSDBs.

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\72.png)

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\73.png)

## Area Terminologies

- **Backbone Area (Area 0)**: A special area that all other areas must connect to.
- **Area Border Router (ABR)**: A router with interfaces connected to the backbone area and at least one other areas
  - Has a LSDB for each area.
  - Creates summary information about each subnet in an area to advertise it into other areas, "**Summary LSA**".
  - It is recommended to connect ABR with two areas only (Backbone and other area).
- **Backbone Router**: A router connected to the backbone area (includes ABRs).
- **Internal Router**: A router connected to one area (not backbone area).
- **Autonomous System boundary Router (ASBR)**: A router with at least one interface connected to an external network.
- **Intera-area Route**: A route to a destination in the same area.
- **Interarea Route**: A route to a destination in a different area.

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\74.png)

## Area Rules

1. Area should be contiguous.
2. Interfaces in the same subnet must be in the same area.
3. All nonbackbone areas must connect to the backbone area by having at least one ABR.

---

## 1. OSPF Activation - Process ID

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\75.png)

**Process ID**: A value <1-65535> which identifies an OSPF instance (An OSPF instance is a collection of OSPF configuration), different OSPF routers do not have to use the same process ID (locally significant).

## 2. Enabling OSPF on Interface:

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\76.png)

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\77.png)

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\78.png)

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\79.png)

**Network command does the following**:

- Enable OSPF on any interface that has an IP address within the specified range in the specified area.
- Send & Listen for hello messages through OSPF-enabled interfaces.
- Advertise networks configured on OSPF-enabled interfaces.

## Neighbor Adjacency - Loopback Interface

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\80.png)

## Neighbor Adjacency - Router ID (RID)

**Router ID (RID)**: An IP address which uniquely identifies each router on the OSPF network.

1. The Router ID can be configured manually on each router:
   ![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\81.png)

2. If the **Router ID** is not configured, the router automatically chooses the highest IP address of any of its loopback interfaces.
3. If no loopback interfaces are configured, the router automatically chooses the highest IP address of any of its active physical interfaces.

## Neighbor Adjacency - Packet Types

- **Hello Packets**: Establish and maintain neighbor adjacency (neighbor relationship).
-  **Database Description (DBD) Packet**: A summary list of a Link State Database (LSDB).
- **Link State Request (LSR) Packet**: Used to request any information in the DBD.
- **Link State Update (LSU) Packet**: A packet contains LSAs, used as a reply to LSRs.
- **Link State Acknowledgement (LSAck) Packet**: Used to confirm a receipt of the LSU.

These packets are sent using the multicast address: 224.0.0.5 or 224.0.0.6

## SPF Calculation - Hos SPF Works

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\82.png)

- OSPF metric is called **cost**.
- SPF algorithm creates an **SPF Tree** that contains all the possible routes to each destination network with the cost of each route.
  - **The cost of a Route (Metric): The sum of the OSPF interface costs for all outgoing/exit interfaces in the route**. 
- The route with the lowest cost will be chosen.
- **Cost** = OSPF Reference Bandwidth (100Mps by default)/Interface Bandwidth.

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\83.png)

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\84.png)

---

## OSPF Configuration

R1:

```sh
Router(config)#router ospf 5
Router(config-router)#network 200.1.1.0 0.0.0.127 area 0
Router(config-router)#network 200.1.1.172 0.0.0.3 area 0
Router(config-router)#network 200.1.1.176 0.0.0.3 area 0
```

R2:

```sh
Router(config)#router ospf 6
Router(config-router)#network 200.1.1.128 0.0.0.31 area 0
Router(config-router)#network 200.1.1.180 0.0.0.3 area 0
Router(config-router)#network 200.1.1.172 0.0.0.3 area 0
Router(config-router)#network 200.1.1.168 0.0.0.3 area 0
```

R3:

```sh
Router(config)#router ospf 7
Router(config-router)#network 200.1.1.176 0.0.0.3 area 0
Router(config-router)#network 200.1.1.184 0.0.0.3 area 0
Router(config-router)#network 200.1.1.160 0.0.0.7 area 0
```

ABR-100 Router:

```sh
Router(config)#router ospf 5
Router(config-router)#network 200.1.1.180 0.0.0.3 area 0
Router(config-router)#network 205.5.5.128 0.0.0.3 area 100
```

R5:

```sh
Router(config)#router ospf 4
Router(config-router)#network 205.5.5.128 0.0.0.3 area 100
Router(config-router)#network 205.5.5.0 0.0.0.127 area 100
```

ABR-200 Router:

```sh
Router(config)#router ospf 8
Router(config-router)#network 200.1.1.184 0.0.0.3 area 0
Router(config-router)#network 177.7.4.0 0.0.0.3 area 200
```

R6:

```sh
Router(config)#router ospf 5
Router(config-router)#network 177.7.4.0 0.0.0.3 area 200
Router(config-router)#network 177.7.0.0 0.0.3.255 area 200
```

To see all what we did:

```sh
Router#sh ip ospf neighbor
```

```sh
Router#sh ip ospf interface brief
```

To delete all OSPF config in the router:

```sh
Router#clear ip ospf database 
```

