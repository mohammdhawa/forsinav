# Dynamic Routing Protocols

Dynamic Routing Protocols are used to automatically provide the best route for a remote network.

## Main Categories of Dynamic Routing Protocols:

- Interior Gateway Protocols (IGP): used for routing within an Autonomous System (AS), (for example, organization, ISP ...etc).
- Exterior Gateway Protocols (EGP): used for routing between different autonomous systems.

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\54.png)

---

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\55.png)

## Distance Vector

- Distance = Metrics / **Vector (Direction)** = the next hop router or exit interface.
- Routers communicate only with their <u>directly connected neighbors (Routing by rumor); each router advertises all its **known networks** with its **own metrics**.
- Routers only know about themselves and their directly connected neighbors; they don't know the entire network topology.
- No neighborship required.
- Routers send periodic updates of the entire routing table.
- Use an algorithm called Bellman-Ford.
- Examples: Routing Information Protocol (RIP), Interior Gateway Routing Protocol (IGRP).

## Link State

- Each router communicates with <u>all other routers</u>; routers exchange **link state information** in order to build a map of the entire network topology.

- Each router has a full picture of the entire network topology.
- Neighborships are required.
- Routers send periodic updated (Link State Information) as well as immediate updates that contain the new changes only.
- Use an algorithm called Shortest Path First (SPF).
- Examples: Open Shortest Path First (OSPF), Intermediate System To Intermediate System (Is-IS).

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\56.png)

## Advanced Distance Vector (Hybrid)

Is a combination of Distance Vector and Link State characteristics.

Examples: Enhanced Interior Gateway Routing Protocol (EIGRP).

## Summary

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\58.png)

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\57.png)